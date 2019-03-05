package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.models.*;

public abstract class GameObject {
	private float x;
	private float y;
	static int color;
	ColorUtil colorutil = new ColorUtil();
	private static int r;
	private static int g;
	private static int b;
	
	
	public void setColor(int inr, int ing, int inb) {
		this.r = inr;
		this.g = ing;
		this.b = inb;
		colorutil.rgb(inr, ing, inb);
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
		return "loc = " + this.x + " , " + this.y + " , " + " colors = [" + this.r + " , " + this.g + " , " + this.b + "] ";
	}
}
