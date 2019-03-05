package com.mycompany.a3;

public class ObjectLocation {
	private float x;
	private float y; 
	
	public ObjectLocation(float xIn, float yIn){
		x = xIn;
		y = yIn;
	}
		
	public void setX(float inX) {
		this.x = inX;
	}
		
	public void setY(float inY) {
		this.y = inY;
	}
		
	public float getX() {
		return x;
	}
		
	public float getY() {
		return y;
	}
		
	public void setLocation(float inX, float inY) {
		setX(inX);
		setY(inY);
	}
}
