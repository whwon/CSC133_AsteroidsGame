package com.mycompany.a4;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	private ObjectLocation location;
	private int size;
	private boolean flag;
	private int color;

	public GameObject(){
		ObjectLocation newLoc = new ObjectLocation(randInt(0, 700), randInt(0, 900));
		int s =  randInt(15, 35);
		size = s;
		flag = false;
		location = newLoc;
	}
	
	public GameObject(ObjectLocation location, int size){
		this.location = location;
		this.size = size;
	}
	
	public ObjectLocation getLocation(){
		return location;
	}
	
	public void setLocation(ObjectLocation location){
		this.location = location;
	}

	public void setSize(int size){
		this.size = size;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setColor(int color){
		this.color = color;
	}

	public int getColor(){
		return color;
	}

	public boolean getFlag() {
		return this.flag;
	}
	
	public void setFlag(Boolean crash) {
		this.flag = crash;
	}
	
	public void setRandomColor(){
		int c = ColorUtil.rgb(randInt(0,255), randInt(0,255), randInt(0,255));
		setColor(c);
	}
	
	public void setRandomLocation(int wFloor, int hFloor, int wCeiling, int hCeiling) {
		int x = this.randInt(wFloor, wCeiling);
		int y = this.randInt(hFloor, hCeiling);
		ObjectLocation newLoc = new ObjectLocation(x,y);
		this.setLocation(newLoc);
	}
	
	public int randInt(int min, int max){
		int rNum;
		Random numGen = new Random();
		rNum = numGen.nextInt(max - min + 1);
		rNum += min;
		return rNum;
	}
	
}