package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Ship extends MoveableObject {
	private int missilecount = 12;
	private static Ship BattleCruiser;
	
	private Ship() {
		super.setLocation(512, 384);
		super.setSpeed(0);
		super.setDirection(0);
		super.setColor(0, 255, 10);
	}
	
	public static Ship getShip() {
		if(BattleCruiser == null) {
			BattleCruiser = new Ship();
			//System.out.println("New BattleCruiser created");  
		}
		return BattleCruiser;
	}
	
	public Ship(int x, int y, int speed, int direction, int r, int g, int b) {
		super.setLocation(x,  y);
		super.setSpeed(speed);
		super.setDirection(direction);
		super.setColor(r, g, b);
	}
	
	public void fire() {
		if(missilecount <= 0) {
			missilecount = 0;
		} else {
			missilecount --;
		}
	}
	
	public void reload() {
		if(this.missilecount == 12) {
			System.out.println("Missiles are at full capacity: " + this.missilecount);
		} else {
			missilecount += 1;
		}
	}
	
	public void move() {
		super.move();
	}
	
	public void setMissiles(int inMissiles) {
		this.missilecount += inMissiles;
	}
	
	public int getMissiles() {
		return this.missilecount;
	}
	
	public void increaseSpeed() {
		if(super.getSpeed() == 6) {
			super.setSpeed(6);
			System.out.println("You have reached your max speed");
		} else {
			int currentSpeed = super.getSpeed() + 2;
			super.setSpeed(currentSpeed);
		}
	}
	
	public void decreaseSpeed() {
		if(super.getSpeed() <= 0) {
			super.setSpeed(0);
		} else {
			int currentSpeed = super.getSpeed() - 2;
			super.setSpeed(currentSpeed);
		}
	}
	
	public void steerLeft() {
		if(super.getDirection() >= 360) {
			super.setDirection(90);
		} else {
			int currentDirection = super.getDirection() + 90;
			super.setDirection(currentDirection);
		}
	}
	
	public void steerRight() {
		if(super.getDirection() <= -360) {
			super.setDirection(-90);
		} else {
			int currentDirection = super.getDirection() - 90;
			super.setDirection(currentDirection);
		}
	}
	
	public int getDirection() {
		return super.getDirection();
	}
	
	public String toString() {
		return "Ship: " + super.toString() + " Missiles: " + this.missilecount;
	}
	
	public void setLocation(float inX, float inY) {
		super.setLocation(inX,  inY);
	}
}
