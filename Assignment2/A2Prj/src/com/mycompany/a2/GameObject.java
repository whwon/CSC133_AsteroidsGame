package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.models.*;

public abstract class GameObject {
	private float x;
	private float y;
	private int color;
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public void setX(float inX) {
		this.x = inX;
	}
	
	public void setY(float inY) {
		this.y = inY;
	}
	
	public void setLocation(float inX, float inY) {
		this.x = inX;
		this.y = inY;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public int getColor() {
		return this.color;
	}
	
	public String toString() {
		return "loc = " + this.x + " , " + this.y + " , " + " colors = " + this.color;
	}
}
