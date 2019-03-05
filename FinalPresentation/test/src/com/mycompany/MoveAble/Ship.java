package com.mycompany.MoveAble;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;
import com.mycompany.MoveAble.Asteroids;
import com.mycompany.MoveAble.Missiles;
import com.mycompany.a4.GameObject;
import com.mycompany.a4.ObjectLocation;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.interfaces.ICollider;
import com.mycompany.interfaces.IMove;
import com.mycompany.interfaces.ISteerable;
import com.mycompany.sound.GameSound;
import com.mycompany.interfaces.IDrawable;

public class Ship extends MoveableObject implements IDrawable, ISteerable, IMove, ICollider {
	private int missileCount;
	private int maxSpeed;
	private boolean flag;
	
	public Ship() {
		missileCount = 10;
		maxSpeed = 10;
	}
	
	public boolean fire() {
		if(this.getMissiles() == 0) {
			return false;
		} else {
			setMissiles(getMissiles()-1);
			return true;
		}
	}
	
	public void setMissiles(int inMissiles) {
		if(inMissiles > 0) {
			this.missileCount = inMissiles;
		} else {
			missileCount = 0;
		}
	}
	
	public int getMissiles() {
		return this.missileCount;
	}
	
	public void increaseSpeed() {
		if (this.maxSpeed > this.getSpeed() + 2) {
			this.setSpeed(this.getSpeed() + 2);
		}
	}
	
	public void decreaseSpeed() {
		if(this.getSpeed()-2 > -1) {
			this.setSpeed(this.getSpeed()-2);
		}
	}
	
	public void steerLeft() {
		this.setDirection(this.getDirection()+10);
	}
	
	public void steerRight() {
		this.setDirection(this.getDirection()-10);
	}
	
	public void move() {
		int angle = 90 - getDirection();
		float deltaX = (((float)Math.cos(Math.toRadians(angle)))* getSpeed());	//computes X shift on speed
		float deltaY = (((float)Math.sin(Math.toRadians(angle)))* getSpeed());	//computes Y shift on speed
		float newX = Math.round(this.getLocation().getX() + deltaX);			//computes newX using the shiftX
		float newY = Math.round(this.getLocation().getY() + deltaY);			//computes newY using the shiftY
		ObjectLocation newLoc = new ObjectLocation(newX, newY);					//sets new location
		this.setLocation(newLoc);
	}
	
	public void draw(Graphics g, ObjectLocation pCmpRelPrnt) {
		// TODO Auto-generated method stub
		move();
		int mapOriginX = (int)pCmpRelPrnt.getX();
		int mapOriginY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getLocation().getX());
		int currentY = ((int)this.getLocation().getY());
		g.setColor(this.getColor());
		ObjectLocation top         = new ObjectLocation(pCmpRelPrnt.getX()+currentX, pCmpRelPrnt.getY()+currentY + (this.getSize()/2)); 
		ObjectLocation bottomLeft  = new ObjectLocation(pCmpRelPrnt.getX()+currentX - (this.getSize()/2), pCmpRelPrnt.getY()+currentY  - (this.getSize()/2)); 
		ObjectLocation bottomRight = new ObjectLocation(pCmpRelPrnt.getX()+currentX + (this.getSize()/2), pCmpRelPrnt.getY()+currentY  - (this.getSize()/2)); 
	     
	      
	    int [] xPts = new int [] {(int) top.getX(), (int) bottomLeft.getX(), (int)bottomRight.getX()} ; 
	    int [] yPts = new int [] {(int) top.getY(), (int) bottomLeft.getY(), (int)bottomRight.getY()} ; 

	    g.fillPolygon(xPts, yPts, 3);
	    
	    //test line offsets center_of_objectX-mapOriginX to the center_of_object
	    //g.drawLine((int)top.getX()-mapOriginX, (int)top.getY()-(this.getSize()/2), (int)top.getX(), (int)top.getY()-(this.getSize()/2));
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	
	public void setFlag(Boolean crash) {
		this.flag = crash;
	}

	public boolean collidesWith(ICollider otherObject) {
		boolean result = false; 
		int thisCenterX = (int) (this.getLocation().getX() + (this.getSize()/2)); // find centers 
		int thisCenterY = (int) (this.getLocation().getY() + (this.getSize()/2)); 
		int otherCenterX = (int) (((GameObject)otherObject).getLocation().getX() + ((GameObject)otherObject).getSize()/2); 
		int otherCenterY = (int) (((GameObject)otherObject).getLocation().getY() + (((GameObject)otherObject).getSize()/2)); // find dist between centers (use square, to avoid taking roots) 
		int dx = thisCenterX - otherCenterX; 
		int dy = thisCenterY - otherCenterY; 
		int distBetweenCentersSqr = (dx*dx + dy*dy); // find square of sum of radii 
		int thisRadius = this.getSize()/2; 
		int otherRadius = ((GameObject)otherObject).getSize()/2; 
		int radiiSqr = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius); 
		if (distBetweenCentersSqr <= radiiSqr) { 
			result = true; 
			} 
		return result ; 
		}

	public void handleCollision(ICollider othObject) {
				//Case 1: ship hits asteroid
				// 	explode the ship
				if(othObject instanceof Asteroids) {
					this.setFlag(true);
				}
				//Case 3: ship hits Missile
				//	explode the ship		
				//	explode the missile
				if(othObject instanceof Missiles) {
					this.setFlag(false);
				}
				
				//Case 4: ship hits Flying Saucer
				//	explode the ship		
				//	explode the missile
				if(othObject instanceof FlyingSaucer) {
					this.setFlag(true);
				}
				
				//Case 5: ship hits SpaceStation
				//	do not explode ship
				//	do not explode space station.
				if(othObject instanceof SpaceStation) {
					System.out.println("space ship hit!!");
					this.setFlag(false);
					this.setMissiles(10);
				}
	}
	

	/*public String toString() {
		String stats = ""
				+ "SpaceShip: [" + this.getLocation().getX() + ", " +  this.getLocation().getY() + "], "
				+ "Size " + this.getSize() + ", "
				+ "Heading: " + this.getDirection() + ", "
				+ "Color: " + this.getColor() + ", "
				+ "Flag: " + this.getFlag();
		return stats;
		
	}*/
	
	public String toString() {
		return "Ship: " + super.toString() + " Missiles: " + this.missileCount;
	}
	
}
