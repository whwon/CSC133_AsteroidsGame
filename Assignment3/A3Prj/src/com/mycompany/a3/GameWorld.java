package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Dialog;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.MoveAble.Asteroids;
import com.mycompany.MoveAble.FlyingSaucer;
import com.mycompany.MoveAble.Missiles;
import com.mycompany.MoveAble.Ship;
import com.mycompany.interfaces.ICollider;
import com.mycompany.interfaces.Iiterator;
import com.mycompany.sound.GameSound;
import com.mycompany.sound.Sound;
import com.mycompany.interfaces.IStatic;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.ObjectCollection;
import com.mycompany.interfaces.IGameWorld;

public class GameWorld extends Observable implements IGameWorld {
	private int lives;
	private ObjectCollection spaceObj;
	private Ship BattleCruiser;
	private SpaceStation station;
	private Missiles missile;
	private int id;
	private int clockTime;
	private int asteroidsDestroyed;
	private int missileColor;
	private int shipColor;
	private int stationColor;
	private int asteroidColor;
	private int flyingSaucerColor;
	private int missileCount;
	private GameSound gameSound;
	private int gameWidth;
	private int gameHeight;
	private int originOffset;
	private boolean paused;
	ObjectLocation theStart;
	ObjectLocation theStart1;


	public GameWorld() {
		spaceObj = new ObjectCollection();
		gameSound = new GameSound();
		paused = false;
		gameWidth = 1024;
		gameHeight = 768;
	}
	
	public void init() {
		lives = 3;
		missileCount = 10;
		id = 0;
		asteroidsDestroyed = 0;
		clockTime = 0;
		missileColor = ColorUtil.WHITE;							//missile color
		shipColor = ColorUtil.GREEN;							//ship color
		stationColor = ColorUtil.YELLOW;						//station color
		asteroidColor = ColorUtil.GRAY;
		flyingSaucerColor = ColorUtil.MAGENTA;
		
		addBlinkingSpaceStation();
		observerNotify();
	}
	
	public void setObserver(Observer observer) {
		this.addObserver(observer);
	}
	
	public void observerNotify() {
		GameWorldProxy gp = new GameWorldProxy(this);
		this.setChanged();
		this.notifyObservers(gp);
	}

	public void addAsteroid() {
		Asteroids a = new Asteroids();
		a.setColor(asteroidColor);
		a.setRandomLocation(0, 0, this.getWidth(), this.getHeight());
		spaceObj.add(a);
		observerNotify();
	}
	
	public void addFlyingSaucer() {
		FlyingSaucer saucer = new FlyingSaucer();
		saucer.setColor(flyingSaucerColor);
		saucer.setRandomLocation(0, 0, this.getWidth(), this.getHeight());
		spaceObj.add(saucer);
		observerNotify();
	}
	
	public void addBlinkingSpaceStation() {
		station = new SpaceStation();
		station.setColor(stationColor);
		station.setLocation(getStart1());
		station.setSize(30);
		spaceObj.add(station);
		observerNotify();
	}

	public void addShip() {
		BattleCruiser = new Ship();
		BattleCruiser.setColor(shipColor);
		BattleCruiser.setDirection(0);
		BattleCruiser.setSpeed(0);
		BattleCruiser.setLocation(getStart());
		BattleCruiser.setSize(30);
		spaceObj.add(BattleCruiser);
		missileCount = BattleCruiser.getMissiles();
		observerNotify();
	}
	
	public void increaseShipSpeed() {
		BattleCruiser.increaseSpeed();
	}

	public void decreaseShipSpeed() {
		BattleCruiser.decreaseSpeed();
	}
	
	public void turnShipLeft() {
		BattleCruiser.steerLeft();
	}
	
	public void turnShipRight() {
		BattleCruiser.steerRight();
	}
	
	public void fireMissile() {
		BattleCruiser.fire();
		gameSound.missileLaunchSound();
		missile = new Missiles();
		missile.setColor(missileColor);
		missile.setDirection(BattleCruiser.getDirection());
		missile.setSpeed(BattleCruiser.getSpeed() + 5);
		missile.setLocation(BattleCruiser.getLocation());
		missile.setSize(BattleCruiser.getSize()/3);
		spaceObj.add(missile);
		missileCount = BattleCruiser.getMissiles();
		observerNotify();
	}
	
	public void jumpThroughSpace() {
		BattleCruiser.setLocation(getStart());
		BattleCruiser.setDirection(0);
		BattleCruiser.setSpeed(0);
		observerNotify();
	}
	
	public void stockMissile() {
		BattleCruiser.setMissiles(10);
		missileCount = BattleCruiser.getMissiles();
		observerNotify();				
	}
	
	public void missileKillAsteroid() {
		clockTime++;
		timeEvents();
		collisionCheck();
		observerNotify();
	}
	
	public void tick() {
		clockTime++;
		timeEvents();
		collisionCheck();
		observerNotify();
	}
	
	public void timeEvents() {
		ObjectCollection garbage = new ObjectCollection();
		Iiterator anIterator = spaceObj.getIterator();
		Object currentObj = new Object();	
		while(anIterator.hasNext() ){
			currentObj = anIterator.getNext();
			if (currentObj instanceof IStatic) {
				((SpaceStation) currentObj).blink(clockTime);
			}
			if (currentObj instanceof Missiles) {
				if(!((Missiles) currentObj).hasFuel()) {
					garbage.add(currentObj);
				}
			}
		}
		garbageRemover(garbage);
	}
	
	public void collisionCheck() {
		//ObjectCollection garbage = new ObjectCollection();
		Iiterator colIterator = spaceObj.getIterator();
		while(colIterator.hasNext() ){
			ICollider curObj = (ICollider)colIterator.getNext();
			// get a collidable object 
			// check if this object collides with any OTHER object 
			Iiterator iter2 = spaceObj.getIterator(); 
			while(iter2.hasNext()){ 
				ICollider otherObj = (ICollider)iter2.getNext(); 
				// get a collidable object 
				// check for collision 
				if(otherObj!=curObj){
					// make sure it's not the SAME object 
					if(curObj.collidesWith(otherObj)){ 
						curObj.handleCollision(otherObj); 
						//missileCount = BattleCruiser.getMissiles();
					} 
				}
			}
		}
		removeCollided();
		observerNotify();
	}
	
	public void removeCollided() {
		ObjectCollection garbage = new ObjectCollection();
		Iiterator remIterator = spaceObj.getIterator();
		Object target = new Object();
		while(remIterator.hasNext()) {
			target = remIterator.getNext();
			if(((GameObject)target).getFlag() == true) {
				garbage.add(target);
			}
		}
		garbageRemover(garbage);
		observerNotify();
	}
	
	public void garbageRemover(ObjectCollection Garbage) {
		Iiterator garIterator = Garbage.getIterator();
		while(garIterator.hasNext()) {
			Object target = garIterator.getNext();
			if(target instanceof Asteroids) {
				//gameSound.genericSound();
				spaceObj.remove(target);
				asteroidsDestroyed++;
			}
			if(target instanceof FlyingSaucer) {
				//gameSound.genericSound();
				spaceObj.remove(target);
				asteroidsDestroyed++;
			}			
			if(target instanceof Missiles) {
				//gameSound.genericSound();
				spaceObj.remove(target);
			}
			if(target instanceof Ship) {
				//gameSound.shipCrashSound();
				spaceObj.remove(target);
				lives--;
				if(lives > 0) {
					System.out.println("player has lives: " + lives);
					addShip();
					}
					else {
						gameSound.gameOverSound();
						if(Dialog.show("Game Over", "Try again?", "Yes", "No")) {
							spaceObj = new ObjectCollection();								//check if this works
							init();
						}
						else {
							quit();
						}
				}
			}

		}
	}
	
	//checks for static objects and blinks them on a set schedule
	//schedule: if(clockTime % blinkRate = 0) then blink
	@Deprecated
	public void blinking() {
		Iiterator anIterator = spaceObj.getIterator();
		
		Object currentObj = new Object();
		
		while(anIterator.hasNext() ){
			currentObj = anIterator.getNext();
			if (currentObj instanceof IStatic) {
				((SpaceStation) currentObj).blink(clockTime);
			}
		}
	}
	
	//checks if all missiles have fuel if not send them to a collection to be removed.
	@Deprecated
	public void outOfFuel() {
		ObjectCollection fueledObject = new ObjectCollection();
		Iiterator anIterator = spaceObj.getIterator();
		
		Object currentObj = new Object();
		
		while(anIterator.hasNext() ){
			currentObj = anIterator.getNext();
			if (currentObj instanceof Missiles) {
				if(!((Missiles) currentObj).hasFuel()) {
					fueledObject.add(currentObj);
				}
			}
		}
		garbageRemover(fueledObject);		
	}
	
	public void quit() {
		System.exit(0);
	}
	
	public ObjectCollection getGameObjects() {
		return spaceObj;
	}

	public int getAsteroidCount() {
		return asteroidsDestroyed;
	}
	
	public int getMissileCount() {
		return missileCount;
	}
	
	public int getTime() {
		return clockTime;
	}
	
	public Integer getLives() {
		return lives;
	}
	
	public int getHeight() {
		return gameHeight;
	}
	
	public int getWidth() {
		return gameWidth;
	}
	
	public ObjectLocation getStart() {
		float x = this.getWidth();
		float y = this.getHeight();
		theStart = new ObjectLocation(x/2, y/2);
		return theStart;
	}
	
	public ObjectLocation getStart1() {
		float x = this.getWidth();
		float y = this.getHeight();
		theStart1 = new ObjectLocation(x-200, y-100);
		//theStart1 = new ObjectLocation(x/2, y/2);
		return theStart1;
	}
	
	public void setHeight(int height) {
		this.gameHeight = height;
	}
	
	public void setWidth(int width) {
		this.gameWidth = width;
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public void setPaused() {
		//From pause to play
		if(paused) {
			paused = false;
		}
		//from play to pause
		else {
			paused = true;
		}
	}
	
	public void setVolume(int V) {
		gameSound.setVol(V);
	}
	
	public void setBGVolume(int bVol) {
		gameSound.setBGVol(bVol);
	}

	public int getBGVolume() {
		return gameSound.getBGVol();
	}
	
	public int getVolume() {
		return gameSound.getVol();
	}

	public boolean getSoundOn() {
		return gameSound.getSound();
	}
	
	public void soundToggle() {
		gameSound.soundToggle();
	}

	public String getGameObjectInfo() {
		String s = "";
		Object target = new Object();
		Iiterator stringIter = spaceObj.getIterator();
		while(stringIter.hasNext()) {
			target = stringIter.getNext();
			s = s + target + "\n";
		}
		return s;
	}

}
