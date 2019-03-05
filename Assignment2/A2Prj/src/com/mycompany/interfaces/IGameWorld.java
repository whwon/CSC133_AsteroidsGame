package com.mycompany.interfaces;

public interface IGameWorld {
	
	public void init();
	public void addAsteroid();
	public void addFlyingSaucer();
	public void addBlinkingSpaceStation();
	public void addShip();
	public void increaseShipSpeed();
	public void decreaseShipSpeed();
	public void turnShipLeft();
	public void turnShipRight();
	public void fireMissile();
	public void jumpThroughSpace();
	public void loadNewMissiles();
	public void missileKillAsteroid();
	public void eliminate();
	public void shipCrashedIntoAsteroid();
	public int getLives();
	public void shipHitFlyingSaucer();
	public void asteroidCollided();
	public void asteroidWhackedFlyingSaucer();
	public void tick();
	public int getScore();
	public boolean getSound(); 
	public void addObserver(IObserver obs);
	public void notifyObservers();

}
