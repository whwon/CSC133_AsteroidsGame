package com.mycompany.a2;

public class ObjectLocation {
	private float x;
	private float y;
		
	public ObjectLocation(float inX, float inY) {
		x = inX;
		y = inY;
	}
	
	public void setX(float newX) {
		this.x = newX;
	}
	
	public void setY(float newY) {
		this.y = newY;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setLocation(float newX, float newY) {
		this.x = newX;
		this.y = newY;
	}
	
	public String toString() {
		return "loc = " + this.x + " , " + this.y + " , " ;
	}

}
