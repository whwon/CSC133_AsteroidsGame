package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Iterator;

public class GameWorld {
	private int score, clock, lives;
	private ArrayList<GameObject>spaceObjects;
	//Ship battleShip = Ship.getShip();
	
	public void init() {
		//code here to create the
		//initial game objects/setup
		score = 0;
		clock = 0;
		lives = 3; 
		spaceObjects = new ArrayList<GameObject>();
	}
	//additional methods here to
	//manipulate world objects and
	//related game state data
	public void addAsteroid() {
		spaceObjects.add(new Asteroids());
	}
	
	public void addFlyingSaucer() {
		spaceObjects.add(new FlyingSaucer());
	}
	
	public void addBlinkingSpaceStation() {
		SpaceStation orbitalcommand = SpaceStation.getSpaceStation();
		orbitalcommand.setBlinkRate(3);
		spaceObjects.add(orbitalcommand);
		
		for(int i=0; i<spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof FixedObject) {
				if((!spaceObjects.contains(orbitalcommand))) {
					spaceObjects.add(orbitalcommand);
					break;
				} else {
					System.out.println("Orbital Command Space Station active");
					orbitalcommand.toString();
					break;
				}
			}
		}
	}

	public void addShip() {
		Ship battleShip = Ship.getShip();
		
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if((!spaceObjects.contains(battleShip))) {
					spaceObjects.add(battleShip);
					System.out.println("You have added a BattleCruiser");
					break;
				} else {
					System.out.println("You can only have 1 BattleCruiser at a time");
					battleShip.toString();
					break;
				}
			}
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
					}
				}
			}
		}		
	}
	
	public void jumpThroughSpace() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				if(spaceObjects.get(i) instanceof Ship) {
					Ship shipObj = (Ship)spaceObjects.get(i);
					shipObj.setLocation(512,  384);
					System.out.println("Jumped to HyperSpace: " + shipObj.toString());
				}
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
				}
			}
		}
	}
	
	public void missileKillAsteroid() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				//if(spaceObjects.get(i) instanceof Missiles) {
					//spaceObjects.remove(i);
					//decreaseLife(); //should be score point
				//}
				
				if(spaceObjects.get(i) instanceof Asteroids) {
					spaceObjects.remove(i);
					//System.out.println("testA");
				}
				
				if(spaceObjects.get(i) instanceof Missiles) {
					spaceObjects.remove(i);
					Score(); //score point
					//System.out.println("testB");
				}
			}
		}		
	}
	
	public void eliminate() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				//if(spaceObjects.get(i) instanceof Missiles) {
					//spaceObjects.remove(i);
					//decreaseLife(); //should be score point
				//}
				
				if(spaceObjects.get(i) instanceof FlyingSaucer) {
					spaceObjects.remove(i);
					//System.out.println("Test1");
				}
				
				if(spaceObjects.get(i) instanceof Missiles) {
					spaceObjects.remove(i);
					Score(); //score point
					//System.out.println("Test2");
				}
			}
		}	
	}
	
	public void shipCrashedIntoAsteroid() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				/*if(spaceObjects.get(i) instanceof Ship) {
					spaceObjects.remove(i);
					//decreaseLife();
				}*/
				
				if(spaceObjects.get(i) instanceof Asteroids) {
					spaceObjects.remove(i);
				}
				if(spaceObjects.get(i) instanceof Ship) {
					spaceObjects.remove(i);
					decreaseLife();
				}
			}
		}
	}
	
	public void decreaseLife() {
		if(lives >= 0) {
			lives = 0;
		}
		lives--;
	}
	
	public void shipHitFlyingSaucer() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				//if(spaceObjects.get(i) instanceof Ship) {
					//spaceObjects.remove(i);
					//decreaseLife();
				//}
				
				if(spaceObjects.get(i) instanceof FlyingSaucer) {
					spaceObjects.remove(i);
				}
				if(spaceObjects.get(i) instanceof Ship) {
					spaceObjects.remove(i);
					decreaseLife();
				}
			}
		}	 		
	}
	
	public void asteroidCollided() {
		Asteroids rocks = Asteroids.getRocks();

		for (int i = 0; i < spaceObjects.size(); i++) {
			if (spaceObjects.get(i) instanceof Asteroids) {
				spaceObjects.remove(i);
				//break;
			}
			// System.out.println("start1");
			if (spaceObjects.get(i) instanceof Asteroids) {
				spaceObjects.remove(i);
				System.out.println("Two astroid have collided and have been destroyed");
				break;
			}
			//System.out.println("Two astroid have collided and have been destroyed");
			/*
			 * if(spaceObjects.contains(rocks)) { spaceObjects.remove(i);
			 * System.out.println("One Asteroid has been removed"); }
			 * if(spaceObjects.contains(rocks)) {
			 * 
			 * spaceObjects.remove(i); System.out.
			 * println("Two Asteroids have collided and have been destroyed"
			 * );//break; }
			 * 
			 * // System.out.println("end1"); if (spaceObjects.size() != 0 &&
			 * (spaceObjects.get(i) instanceof Asteroids)) {
			 * //System.out.println("end2"); spaceObjects.remove(i);
			 * //System.out.println("end3"); System.out.
			 * println("Two astroid have collided and have been destroyed"); }
			 */
		}
	}
	
	public void asteroidWhackedFlyingSaucer() {
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof MoveableObject) {
				//if(spaceObjects.get(i) instanceof FlyingSaucer) {
					//spaceObjects.remove(i);
				//}
				
				if(spaceObjects.get(i) instanceof Asteroids) {
					spaceObjects.remove(i);
				}
				
				if(spaceObjects.get(i) instanceof FlyingSaucer) {
					spaceObjects.remove(i);
				}
			}
		}		
	}
	
	public void tick() {
		System.out.println("Time: " + this.clock);
		clock++;
		System.out.println("Elapsed time: " + this.clock);
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
	}
	
	public void Score() {
		if(score <= 0) {
			score = 0;
		}
		score++;
	}
	
	public void print() {
		int missilecountatm = 0;
		for(int i = 0; i < spaceObjects.size(); i++) {
			if(spaceObjects.get(i) instanceof Ship) {
				Ship shipObj = (Ship) spaceObjects.get(i);
				missilecountatm = shipObj.getMissiles();
			}
		}
		System.out.println("Player Life: " + this.lives + "/3 Player Score: " + this.score + " " + "Elapsed time: " + this.clock + " Ship missile count: " + missilecountatm);
	}
	
	public void map() {
		Iterator<GameObject> itr = spaceObjects.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
	
	
	public void quit() {
		System.exit(0);
	}
}
