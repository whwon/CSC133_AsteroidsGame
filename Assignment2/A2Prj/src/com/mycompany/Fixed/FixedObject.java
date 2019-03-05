package com.mycompany.Fixed;

import com.mycompany.a2.GameObject;

public abstract class FixedObject extends GameObject{

	private static int id;
	
	public void setLocation(){	
	}
	
	public void setIdentification(int inID) {
		this.id = inID;
	}
	
	public int getID() {
		return this.id;
	}
	
}
