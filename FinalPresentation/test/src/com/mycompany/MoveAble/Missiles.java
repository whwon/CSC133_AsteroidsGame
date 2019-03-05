package com.mycompany.MoveAble;

import com.codename1.ui.Graphics;
import com.mycompany.MoveAble.MoveableObject;
import com.mycompany.MoveAble.Asteroids;
import com.mycompany.MoveAble.Missiles;
import com.mycompany.MoveAble.Ship;
import com.mycompany.a4.GameObject;
import com.mycompany.a4.ObjectLocation;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.interfaces.ICollider;
import com.mycompany.interfaces.IDrawable;
import com.mycompany.interfaces.IMove;
import com.mycompany.interfaces.ISelectable;
import com.mycompany.sound.GameSound;

public class Missiles extends MoveableObject implements IMove, IDrawable, ICollider, ISelectable {
	private int fuelLevel;
	private int maxFuelLevel = 20;
	private boolean hasFuel;
	//private boolean isSelected;
	public void steerLeft() {}
	public void steerRight() {}
	
	public Missiles() {
		super();
		fuelLevel = maxFuelLevel;
	}
	
	public int getFuelLevel() {
		return this.fuelLevel;
	}
	
	public void setFuelLevel() {
		this.fuelLevel = maxFuelLevel;
	}
	
	public boolean hasFuel() {
		return hasFuel;
	}
	
	public void useFuel(int f) {
		if(getFuelLevel() == 0) {
			hasFuel = false;
		}
		else {
			this.setSpeed(this.getSpeed()+1);
			fuelLevel--;
			hasFuel = true;
		}
	}
	/*@Override
	public void setSelected(boolean selected) {
		this.isSelected = selected;
	}
	
	@Override
	public boolean isSelected() {
		return isSelected;
	}*/
	
	public void move() {
		int angle = 90 - getDirection();
		float deltaX = (((float)Math.cos(Math.toRadians(angle)))* getSpeed());	//computes X shift on speed
		float deltaY = (((float)Math.sin(Math.toRadians(angle)))* getSpeed());	//computes Y shift on speed
		float newX = Math.round(this.getLocation().getX() + deltaX);			//computes newX using the shiftX
		float newY = Math.round(this.getLocation().getY() + deltaY);			//computes newY using the shiftY
		ObjectLocation newLoc = new ObjectLocation(newX, newY);					//sets new location
		this.setLocation(newLoc);
		this.useFuel(1);
	}
	
	public void draw(Graphics g, ObjectLocation pCmpRelPrnt) {
		move();
		
		g.setColor(this.getColor());
		
		int mapOriginX = (int)pCmpRelPrnt.getX();
		int mapOriginY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getLocation().getX()) + mapOriginX;
		int currentY = ((int)this.getLocation().getY()) + mapOriginY;
		
		ObjectLocation topLeft = new ObjectLocation(currentX-10, currentY-10);
		ObjectLocation topRight = new ObjectLocation(currentX+10, currentY-10);
		ObjectLocation bottomLeft = new ObjectLocation(currentX-10, currentY+10);
		ObjectLocation bottomRight = new ObjectLocation(currentX+10, currentY+10);
		
		g.fillRect(currentX-(this.getSize()/4), currentY-(this.getSize()/2), this.getSize()/2, this.getSize());
		
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
		//Case 1: missile hits ship
		//	do not explode the ship
		//	do not explode the missile
		if(othObject instanceof Ship) {
			this.setFlag(false);
		}
		//Case 2: missile hits asteroid
		// 	explode the asteroid
		//	explode the missile
		if(othObject instanceof Asteroids) {
			this.setFlag(true);
		}
		//Case 3: missile hits Missile
		//	do not explode the missiles
		if(othObject instanceof Missiles) {
			this.setFlag(false);
		}
		
		//Case 4: missile hits Flying Saucer
		//	do not explode the missiles
		if(othObject instanceof FlyingSaucer) {
			this.setFlag(true);
		}
		
		//Case 5: Missile hits SpaceStation
		//	do not explode Missile
		//	do not explode space station.
		if(othObject instanceof SpaceStation) {
			this.setFlag(false);
		}
	}
	
	public String toString() {
		return "Missiles: " + super.toString() + " Fuel: " + this.fuelLevel;
	}
	public void setSelected(boolean selected) {
		// TODO Auto-generated method stub
		
	}
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean contains(ObjectLocation pPtrRelPrnt, ObjectLocation pCmpRelPrnt) {
		// TODO Auto-generated method stub
		return false;
	}

}
