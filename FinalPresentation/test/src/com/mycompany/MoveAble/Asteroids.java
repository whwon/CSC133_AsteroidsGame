package com.mycompany.MoveAble;

import java.util.Random;

import com.codename1.ui.Graphics;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.MoveAble.Asteroids;
import com.mycompany.a4.GameObject;
import com.mycompany.a4.ObjectLocation;
import com.mycompany.interfaces.ICollider;
import com.mycompany.interfaces.IDrawable;
import com.mycompany.interfaces.IMove;
import com.mycompany.sound.GameSound;

public class Asteroids extends MoveableObject implements IMove, IDrawable, ICollider {
	public void steerLeft() {}
	public void steerRight() {}
	private boolean flag;
	
	public Asteroids() {
		super();
	}
	
	public void move() {
		int angle = 90 - getDirection();
		float deltaX = (((float)Math.cos(Math.toRadians(angle)))* (getSpeed()/3));	//computes X shift on speed
		float deltaY = (((float)Math.sin(Math.toRadians(angle)))* (getSpeed()/3));	//computes Y shift on speed
		float newX = Math.round(this.getLocation().getX() + deltaX);			//computes newX using the shiftX
		float newY = Math.round(this.getLocation().getY() + deltaY);			//computes newY using the shiftY
		ObjectLocation newLoc = new ObjectLocation(newX, newY);					//sets new location
		this.setLocation(newLoc);
	}
	
	public void draw(Graphics g, ObjectLocation pCmpRelPrnt) {
		// TODO Auto-generated method stub
		this.move();
		g.setColor(this.getColor());
		//g.drawArc((int)this.getLocation().getX(), (int)this.getLocation().getY(), this.getSize(), this.getSize(), 0, 359);
		
		int mapOriginX = (int)pCmpRelPrnt.getX();
		int mapOriginY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getLocation().getX()) + mapOriginX;
		int currentY = ((int)this.getLocation().getY()); //+ mapOriginY;
		
		g.fillRoundRect(currentX, currentY, getSize(), getSize(), 20, 10);
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
		//Case 1: asteroid hits ship
		//	ship loses life
		// 	asteroid explodes
		if(othObject instanceof Ship) {
			this.setFlag(true);
			//((Ship)othObject).setFlag(true);
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
		//Case3.5: Asteroid hits missiles 
		//  explode missiles
		//  the asteroid breaks into pieces
		/*if(othObject instanceof MissileDestroys) {
			this.setFlag(true);
		}*/
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

