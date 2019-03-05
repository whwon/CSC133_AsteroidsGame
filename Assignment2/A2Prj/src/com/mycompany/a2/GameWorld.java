package com.mycompany.a2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import com.mycompany.Fixed.FixedObject;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.MoveAble.Asteroids;
import com.mycompany.MoveAble.FlyingSaucer;
import com.mycompany.MoveAble.Missiles;
import com.mycompany.MoveAble.MoveableObject;
import com.mycompany.MoveAble.Ship;
import com.mycompany.interfaces.IGameWorld;
import com.mycompany.interfaces.IObserver;

import java.util.Iterator;

public class GameWorld extends Observable implements IGameWorld {
	private int score, time, lives;
	private boolean sound = false;
	private ObjectCollection gameObj;
	private ArrayList<GameObject>spaceObjects;

	public GameWorld() {
		init();
	}
	
	public void init() {
		score = 0;
		time = 0;
		lives = 3; 
		gameObj = new ObjectCollection();
		spaceObjects = new ArrayList<GameObject>();
	}
	
	public void setObserver(Observer o) {
		this.addObserver(o);
	}
	
	public void observerNotify() {
		GameWorldProxy gp = new GameWorldProxy(this);
		this.setChanged();
		this.notifyObservers(gp);
	}

	public void addAsteroid() {
		if(spaceObjects.add(new Asteroids()));
		System.out.println("Asteroid have been created");
		observerNotify();
	}
	
	public void addFlyingSaucer() {
		spaceObjects.add(new FlyingSaucer());
		System.out.println("Enemy Flying Saucer has been created");
		observerNotify();
	}
	
	public void addBlinkingSpaceStation() {
		SpaceStation orbitalcommand = SpaceStation.getSpaceStation();
		orbitalcommand.setBlinkRate(3);
		spaceObjects.add(orbitalcommand);
		
		for(int i=0; i<spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof FixedObject) {
				if((!spaceObjects.contains(orbitalcommand))) {
					spaceObjects.add(orbitalcommand);
					System.out.println("Orbital Command Space Station Online");
					break;
				} else {
					System.out.println("Orbital Command Space Station is active");
					orbitalcommand.toString();
					break;
				}
			} observerNotify();
		}
	}

	public void addShip() {
		Ship battleShip = Ship.getShip();
		
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if((!spaceObjects.contains(battleShip))) {
					spaceObjects.add(battleShip);
					System.out.println("A BattleCruiser has been created");
					break;
				} else {
					System.out.println("You can only have 1 BattleCruiser at a time");
					battleShip.toString();
					break;
				}
			} observerNotify();
		}
	}
	
	public void increaseShipSpeed() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.increaseSpeed();
					System.out.println("Ship speed has increased: " + shipObj.toString());
				}
			}
		}
	}

	public void decreaseShipSpeed() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.decreaseSpeed();
					System.out.println("Ship speed has decreased: " + shipObj.toString());
				}
			}
		}
	}
	
	public void turnShipLeft() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.steerLeft();
					System.out.println("Ship has turned left: " + shipObj.toString());
				}
			}
		}
	}
	
	public void turnShipRight() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.steerRight();
					System.out.println("Ship has turned Right: " + shipObj.toString());
				} 
			}
		}
	}
	
	public void fireMissile() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.increaseSpeed();
					if(shipObj.getMissiles() > 0) {
						System.out.println("Firing");
					}
					spaceObjects.add(new Missiles(shipObj.getDirection(), shipObj.getSpeed(), shipObj.getX(), shipObj.getY()));
					shipObj.fire();
					
					if(shipObj.getMissiles() == 0) {
						System.out.println("You are out of missiles, reload at OrbitalCommand");
					} observerNotify();
				}
			}
		}
		observerNotify();
	}
	
	public void jumpThroughSpace() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.setLocation(512,  384);
					System.out.println("Jumped to HyperSpace: " + shipObj.toString());
				} observerNotify();
			}
		}
	}
	
	public void loadNewMissiles() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.reload();
					System.out.println("Reloading: " + shipObj.toString());
					observerNotify();				
				}		
			}
		}
	}
	
	public void missileKillAsteroid() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {				
				if(spaceObjects.get(i) instanceof Asteroids) {
					spaceObjects.remove(i);
				}
				
				if(spaceObjects.get(i) instanceof Missiles) {
					spaceObjects.remove(i);
				}
				System.out.println("Missile kill asteroid");
				score += 10;
				observerNotify();
			}
		}
	}
	
	public void eliminate() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof FlyingSaucer) {
					spaceObjects.remove(i);
				}
			
				if(spaceObjects.get(i) instanceof Missiles) {
					spaceObjects.remove(i);
				}
				System.out.println("Eliminate enemy Saucer");
				score += 50;
				observerNotify();
			}
		}
	}
	
	public void shipCrashedIntoAsteroid() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Asteroids) {
					spaceObjects.remove(i);
				}
				if(spaceObjects.get(i) instanceof Ship) {
					spaceObjects.remove(i);
				}
				System.out.println("Ship crashed into asteroid");
				if(lives > 0) {
					lives--;
				} observerNotify();
			}
		}
	}
	
	public void shipHitFlyingSaucer() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {		
				if(spaceObjects.get(i) instanceof FlyingSaucer) {
					spaceObjects.remove(i);
				}
				if(spaceObjects.get(i) instanceof Ship) {
					spaceObjects.remove(i);
				}
				System.out.println("Ship crashed into Saucer");
				if(lives > 0) {
					lives--;
				} observerNotify();
			}
		}
	}
	
	public void asteroidCollided() {
		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.get(i) instanceof Asteroids) {
				spaceObjects.remove(i);
				//break;
			}
			if (spaceObjects.get(i) instanceof Asteroids) {
				spaceObjects.remove(i);
				System.out.println("Two astroid have collided and have been destroyed");
				break;
			} observerNotify();
		}
	}
	
	public void asteroidWhackedFlyingSaucer() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Asteroids) {
					spaceObjects.remove(i);
				}
				
				if(spaceObjects.get(i) instanceof FlyingSaucer) {
					spaceObjects.remove(i);
				} 
				System.out.println("Asteroid whacked flying saucer");
				observerNotify();
			}
		}	
	}
	
	public void tick() {
		System.out.println("Time: " + this.time);
		time++;
		System.out.println("Elapsed time: " + this.time);
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof Ship) {
				Ship shipObj = (Ship)spaceObjects.get(i);
				shipObj.move();
				System.out.println("The ship is moving " + shipObj.toString());
			}
			
			if(spaceObjects.get(i) instanceof Asteroids) {
				Asteroids aObj = (Asteroids)spaceObjects.get(i);
				aObj.move();
				System.out.println("The object is moving " + aObj.toString());
			}
			
			if(spaceObjects.get(i) instanceof Missiles) {
				Missiles mObj = (Missiles)spaceObjects.get(i);
				if(mObj.getFuelLevel() > 0) {
					mObj.move();
					System.out.println("The Missile is moving " + mObj.toString());
				}
				if(mObj.getFuelLevel() == 0) {
					System.out.println("Missiles ran out of fuel" + mObj.toString());
					spaceObjects.remove(i);
				}
			}
		}
		observerNotify();
	}
	
	public void print() {
		int missilecountatm = 0;
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof Ship) {
				Ship shipObj = (Ship) spaceObjects.get(i);
				missilecountatm = shipObj.getMissiles();
			}
		}
		System.out.println("Player Life: " + this.lives + "/3 Player Score: " + this.score + " " + "Elapsed time: " + this.time + " Ship missile count: " + missilecountatm);
	}
	
	public void map() {
		Iterator<GameObject> itr = spaceObjects.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
		
	public int getLives() {
		return lives--;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
		observerNotify();
	}
	
	public int getScore() {
		return score++;
	}
	
	public void setScore(int score) {
		this.score = score;
		observerNotify();
	}
	
	public boolean getSound() {
		return sound;
	}
	
	public void toggleSound() {
		sound =! sound;
		observerNotify();
	}
	
	public void addAbout() {
		System.out.println("About: \n" + "Author - Woonghui Won \n" + "Class - CSC 133-02 Spring 2018");
	}
	
	public ObjectCollection getGameObjects() {
		return gameObj;
	}
	
	public void quit() {
		System.exit(0);
	}

	public void addObserver(IObserver obs) {
		// TODO Auto-generated method stub
		
	}
}
