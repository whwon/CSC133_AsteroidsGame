package com.mycompany.MoveAble;

import java.lang.Math;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.mycompany.a4.GameObject;
import com.mycompany.interfaces.ISteerable;

public abstract class MoveableObject extends GameObject implements ISteerable {

	private int speed;
	private int direction;
	private int color;
	
	public MoveableObject() {
		int sp = randInt(4,24);
		int d = randInt(0,360);
		speed = sp;
		direction = d;
	}
	
	public MoveableObject(int color) {
		this.color = color;
	}
	
	public void setDirection(int d) {
		this.direction = d;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setColor(int color){
		this.color = color;
	}

	public int getColor(){
		return color;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int s) {
		this.speed = s;
	}
	
	public void setRandomColor(){
		int c = ColorUtil.rgb(randInt(0,255), randInt(0,255), randInt(0,255));
		setColor(c);
	}
	
	//creates random integers with given constraints
	public int randInt(int min, int max){
		int rNum;
		Random numGen = new Random();
		rNum = numGen.nextInt(max - min + 1);
		rNum += min;
		return rNum;
	}
	
	public String toString() {
		return super.toString() + "speed: " + this.speed + " direction: " + this.direction + "color:[" + ColorUtil.red(color) + "," + 
				   ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]"; 
	}

}
