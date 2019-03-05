package com.mycompany.a2;

import java.util.Observable;
import com.mycompany.interfaces.IGameWorld;
import com.mycompany.interfaces.IObserver;

public class GameWorldProxy extends Observable implements IGameWorld {
	
	private GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		this.gw = gw;
	}
	
	public int getScore() {
		return gw.getScore();
	}
	
	public int getLives() {
		return gw.getLives();
	}
	
	public boolean getSound() {
		return gw.getSound();
	}

	public void addAsteroid() {
		// TODO Auto-generated method stub
		gw.addAsteroid();		
	}

	public void addFlyingSaucer() {
		// TODO Auto-generated method stub
		gw.addFlyingSaucer();		
	}

	public void addBlinkingSpaceStation() {
		// TODO Auto-generated method stub
		gw.addBlinkingSpaceStation();
	}

	public void addShip() {
		// TODO Auto-generated method stub
		gw.addShip();
	}

	public void increaseShipSpeed() {
		// TODO Auto-generated method stub
		gw.increaseShipSpeed();
	}

	public void decreaseShipSpeed() {
		// TODO Auto-generated method stub
		gw.decreaseShipSpeed();
	}

	public void turnShipLeft() {
		// TODO Auto-generated method stub
		gw.turnShipLeft();
	}

	public void turnShipRight() {
		// TODO Auto-generated method stub
		gw.turnShipRight();
	}

	public void fireMissile() {
		// TODO Auto-generated method stub
		gw.fireMissile();
	}

	public void jumpThroughSpace() {
		// TODO Auto-generated method stub
		gw.jumpThroughSpace();
	}

	public void loadNewMissiles() {
		// TODO Auto-generated method stub
		gw.loadNewMissiles();
	}

	public void missileKillAsteroid() {
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
	}

	public void tick() {
		// TODO Auto-generated method stub
		gw.tick();
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

}
