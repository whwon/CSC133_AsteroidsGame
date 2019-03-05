package com.mycompany.Fixed;

import com.mycompany.a4.GameObject;
import com.mycompany.interfaces.IStatic;

public abstract class FixedObject extends GameObject implements IStatic {

	private int id;
	private static int staticId = 0; //unique identification number

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getStaticId() {
		return staticId;
	}

	public static void setStaticId(int staticId) {
		FixedObject.staticId = staticId;
	}

	public FixedObject() {
		this.id = staticId;
		staticId++;
	}
	
	public String toString() {
		String parentDesc = super.toString();
		String myDesc = " id=" + id;
		return parentDesc + myDesc;
	}
}
