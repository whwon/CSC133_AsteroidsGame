package com.mycompany.a3;

import java.util.Observable;
import com.mycompany.interfaces.IGameWorld;
import com.mycompany.interfaces.IObserver;

public class GameWorldProxy extends Observable implements IGameWorld {
	
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw1) {
		this.gw = gw1;
	}
	
	public int getAsteroidCount() {
		return gw.getAsteroidCount();
	}

	public boolean getSoundOn() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getGameObjectInfo() {
		return gw.getGameObjectInfo();
	}
	
	public Integer getLives() {
		return gw.getLives();
	}

	public int getTime() {
		// TODO Auto-generated method stub
		return gw.getTime();
	}

	public boolean addAsteroid() {
		// TODO Auto-generated method stub
		return false;	
	}

	public boolean addFlyingSaucer() {
		// TODO Auto-generated method stub
		return false;		
	}

	public boolean addBlinkingSpaceStation() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addShip() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean increaseShipSpeed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean decreaseShipSpeed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean turnShipLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean turnShipRight() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean fireMissile() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean jumpThroughSpace() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean stockMissile() {
		// TODO Auto-generated method stub
		return false;
	}

	/*public void missileKillAsteroid() {
		// TODO Auto-generated method stub
		gw.missileKillAsteroid();
	}

	public void eliminate() {
		// TODO Auto-generated method stub
		gw.eliminate();
	}

	public void shipCrashedIntoAsteroid() {
		// TODO Auto-generated method stub
		gw.shipCrashedIntoAsteroid();
	}

	public void shipHitFlyingSaucer() {
		// TODO Auto-generated method stub
		gw.shipHitFlyingSaucer();
	}

	public void asteroidCollided() {
		// TODO Auto-generated method stub
		gw.asteroidCollided();
	}

	public void asteroidWhackedFlyingSaucer() {
		// TODO Auto-generated method stub
		gw.asteroidWhackedFlyingSaucer();
	}*/

	public void tick() {
		// TODO Auto-generated method stub
		gw.tick();
	}
	
	public boolean quit(){
		return false;
	}

	public void addObserver(IObserver obs) {
		// TODO Auto-generated method stub	
	}
	
	public ObjectCollection getGameObjects() {
		return gw.getGameObjects();
	}

	public void init() {
		// TODO Auto-generated method stub
		gw.init();
	}
	
	public void observerNotify() {
		gw.observerNotify();
	}

	public int getMissileCount() {
		// TODO Auto-generated method stub
		return gw.getMissileCount();
	}

}
