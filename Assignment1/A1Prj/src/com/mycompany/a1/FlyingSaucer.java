package com.mycompany.a1;

import java.util.Random;

public class FlyingSaucer extends MoveableObject {
	private int sSize;
	public void steerLeft() {}
	public void steerRight() {}
	
	public FlyingSaucer() {
		this.sSize = randNumber();
		super.setLocation(randNumber(), randNumber());
		super.setSpeed(randSpeed());
		super.setDirection(randDirection());
		super.setColor(255,0,0);
	}
	
	public void move() {
		super.move();
	}
	
	public void setAstSize(int inSize) {
		this.sSize = inSize;
	}
	
	private int randNumber() {
		int max = 100;
		int min = 1;
		Random randNum = new Random();
		int randNumber = min + randNum.nextInt(max);
		return randNumber;
	}
	
	private int randSpeed() {
		int max = 10;
		int min = 1;
		Random randNum = new Random();
		int randNumber = min + randNum.nextInt(max);
		return randNumber;
	}
	
	private int randDirection() {
		int max = 359;
		int min = 0;
		Random randNum = new Random();
		int randNumber = min + randNum.nextInt(max);
		return randNumber;
	}
	
	public String toString() {
		return "FlyingSaucer: " + super.toString() + " size = " + this.sSize;
	}
}
