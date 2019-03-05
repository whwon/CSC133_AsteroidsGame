package com.mycompany.MoveAble;

import com.mycompany.MoveAble.MoveableObject;

public class Missiles extends MoveableObject {
	private int fuelLevel;
	
	public void steerLeft() {}
	public void steerRight() {}
	
	public Missiles(int direction, int inspeed, float x, float y) {
		this.fuelLevel = 14;
		super.setSpeed(inspeed + 2);
		super.setDirection(direction);
		super.setLocation(x,  y);
	}
	
	public void move() {
		this.fuelLevel -= 1;
		super.move();
	}
	
	public void setFuelLevel(int inFuellevel) {
		this.fuelLevel = inFuellevel;
	}
	
	public int getFuelLevel() {
		return this.fuelLevel;
	}
	
	public String toString() {
		return "Missiles: " + super.toString() + " Fuel: " + this.fuelLevel;
	}

}
