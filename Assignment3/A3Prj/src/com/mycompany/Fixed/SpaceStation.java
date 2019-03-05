package com.mycompany.Fixed;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.mycompany.Fixed.SpaceStation;
import com.mycompany.MoveAble.MoveableObject;
import com.mycompany.a3.GameObject;
import com.mycompany.a3.ObjectLocation;
import com.mycompany.interfaces.ICollider;
import com.mycompany.interfaces.IDrawable;
import com.mycompany.interfaces.IStatic;

public class SpaceStation extends FixedObject implements IStatic, IDrawable, ICollider {
	private boolean blink;
	private int blinkRate;
	public void setLocation() {}
	public void setSpeed() {}
	public void setDirection() {}
	public void move() {}
	
	public SpaceStation() {
		super();
		blinkRate = randInt(2, 20);
		this.setDirection();
		this.setSpeed();
	}

	public boolean blink(int time){
		int check = time % blinkRate;
		if(check == 0) {
			blink = true;
		}
		else {
			blink = false;
		}
		return blink;
		
	}

	public String toString() {
		String stats = ""
				+ "SpaceStation: [" + this.getLocation().getX() + ", " +  this.getLocation().getY() + "], "
				+ "Size " + this.getSize() + ", "
				+ "Color: " + this.getColor();
		return stats;
	}
	
	public void draw(Graphics g, ObjectLocation pCmpRelPrnt) {
		// TODO Auto-generated method stub

		int mapOriginX = (int)pCmpRelPrnt.getX();
		int mapOriginY = (int)pCmpRelPrnt.getY();
		int currentX = ((int)this.getLocation().getX()) + mapOriginX;
		int currentY = ((int)this.getLocation().getY()) + mapOriginY;

		g.setColor(this.getColor());
		
		if(this.blink) {
			g.fillRect(currentX-(this.getSize()/4), currentY-(this.getSize()/2), this.getSize(), this.getSize());
			//g.fillRoundRect(currentX, currentY, getSize(), getSize(), 20, 10);
		}
		g.drawRect(currentX-(this.getSize()/4), currentY-(this.getSize()/2), this.getSize(), this.getSize());
		//g.drawRoundRect(currentX, currentY, getSize(), getSize(), 20, 10);

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

	public void handleCollision(ICollider otherObject) {
		// TODO Auto-generated method stub
		System.out.println("collision");
	}
	
}
