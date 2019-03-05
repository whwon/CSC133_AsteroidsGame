package com.mycompany.a1;

import java.util.Random;

public class Asteroids extends MoveableObject {
	private int aSize;
	public void steerLeft() {}
	public void steerRight() {}
	private static Asteroids rocks; 
	
	public static Asteroids getRocks() {
		return rocks;
	}
	
	public static void setRocks(Asteroids rocks) {
		Asteroids.rocks = rocks;
	}
	
	public Asteroids() {
		this.aSize = randNumber();
		super.setLocation(randNumber(), randNumber());
		super.setSpeed(randSpeed());
		super.setDirection(randDirection());
		super.setColor(255,0,0);
		//this.rocks = new Asteroids();
	}
	
	public void move() {
		super.move();
	}
	
	public void setAstSize(int inSize) {
		this.aSize = inSize;
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
		return "Asteroids: " + super.toString() + " size = " + this.aSize;
	}
}
