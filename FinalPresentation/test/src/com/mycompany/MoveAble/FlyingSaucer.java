package com.mycompany.MoveAble;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.MoveAble.FlyingSaucer;
import com.mycompany.a4.GameObject;
import com.mycompany.a4.ObjectLocation;
import com.mycompany.interfaces.ICollider;
import com.mycompany.interfaces.IDrawable;
import com.mycompany.interfaces.IMove;
import com.mycompany.interfaces.ISteerable;
import com.mycompany.sound.GameSound;

public class FlyingSaucer extends MoveableObject implements IDrawable, ISteerable, IMove, ICollider{
	public void steerLeft() {}
	public void steerRight() {}
	private boolean flag;
	
	public FlyingSaucer() {
		super();
	}
	
	public void move() {
		int angle = 90 - getDirection();
		float deltaX = (((float)Math.cos(Math.toRadians(angle)))* (getSpeed()/2));	//computes X shift on speed
		float deltaY = (((float)Math.sin(Math.toRadians(angle)))* (getSpeed()/2));	//computes Y shift on speed
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
		ObjectLocation top         = new ObjectLocation(pCmpRelPrnt.getX()+currentX, pCmpRelPrnt.getY()+currentY + (this.getSize()/12)); 
		ObjectLocation bottomLeft  = new ObjectLocation(pCmpRelPrnt.getX()+currentX - (this.getSize()), pCmpRelPrnt.getY()+currentY  - (this.getSize()/4)); 
		ObjectLocation bottomRight = new ObjectLocation(pCmpRelPrnt.getX()+currentX + (this.getSize()), pCmpRelPrnt.getY()+currentY  - (this.getSize()/4)); 
	     
	      
	    int [] xPts = new int [] {(int) top.getX(), (int) bottomLeft.getX(), (int)bottomRight.getX()} ; 
	    int [] yPts = new int [] {(int) top.getY(), (int) bottomLeft.getY(), (int)bottomRight.getY()} ; 

	    g.fillPolygon(xPts, yPts, 3);
	}
	
	public boolean getFlag() {
		return this.flag;
	}
	
	public void setFlag(Boolean crash) {
		this.flag = crash;
	}
	
	public String toString() {
		return "FlyingSaucer: " + super.toString();
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
		//Case 1: asteroid hits ship
		//	ship loses life
		// 	asteroid explodes
		if(othObject instanceof Ship) {
			this.setFlag(true);
			//((SpaceShip)otherObject).setFlag(true);
		}
		//Case 2: asteroid hits asteroid
		// 	explode the asteroids
		if(othObject instanceof Asteroids) {
			this.setFlag(true);
		}
		//Case 3: Asteroid hits Missile
		//	explode the asteroid		
		//	explode the missile
		if(othObject instanceof Missiles) {
			this.setFlag(true);
		}
		//Case 4: Asteroid hits Flying Saucer
		//	explode the asteroid		
		//	explode the missile
		if(othObject instanceof FlyingSaucer) {
			this.setFlag(true);
		}
			
		//Case 5: Asteroid hits SpaceStation
		//	do not explode asteroid
		//	do not explode space station.
		if(othObject instanceof SpaceStation) {
			this.setFlag(false);
		}
	}

}
