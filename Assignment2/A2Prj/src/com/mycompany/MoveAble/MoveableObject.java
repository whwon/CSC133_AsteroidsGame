package com.mycompany.MoveAble;

import java.lang.Math;

import com.mycompany.a2.GameObject;
import com.mycompany.interfaces.ISteerable;

public abstract class MoveableObject extends GameObject implements ISteerable {
	
	private int speed;
	private int direction;
	
	public MoveableObject() {
	}
	
	public MoveableObject(int r, int g, int b) {
		super.setColor(r);
	}
	
	public void move() {
		float dX, dY, theta, newX, newY;
		theta = 90 - this.direction;
		dX = (float) Math.cos(theta);
		dY = (float) Math.sin(theta);
		newX = (float)(Math.toDegrees(dX) * this.speed) + super.getX();
		newY = (float)(Math.toDegrees(dY) * this.speed) + super.getY();
		super.setLocation(newX,  newY);
	}
	
	public String toString() {
		return super.toString() + "speed: " + this.speed + " direction: " + this.direction; 
	}
	
	public void setSpeed(int inSpeed) {
		this.speed = inSpeed;
	}
	
	public void setDirection(int inDirection) {
		this.direction = inDirection;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public int getDirection() {
		return this.direction;
	}

}
