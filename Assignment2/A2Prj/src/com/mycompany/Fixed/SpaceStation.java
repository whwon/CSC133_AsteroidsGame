package com.mycompany.Fixed;

import com.mycompany.Fixed.SpaceStation;

public class SpaceStation extends FixedObject {
	private static SpaceStation OrbitalCommand; 
	private int blinkRate;
	//private boolean blinkLight;
	
	private SpaceStation() {
	}
	
	public static SpaceStation getSpaceStation() {
		if(OrbitalCommand == null) {
			OrbitalCommand = new SpaceStation();
			OrbitalCommand.setIdentification(45);
			OrbitalCommand.setLocation(210, 800);
		}
		return OrbitalCommand;
	}
	
	/*public boolean blinkLights(int time) {
		int check = time % blinkRate;
		if(check == 0) {
			blinkLight = true;
		} else {
			blinkLight = false;
		}
		return blinkLight;
	}*/
	
	public void setBlinkRate(int blink) {
		this.blinkRate = blink;
	}
	
	public int getBlinkRate() {
		return this.blinkRate;
	}
	
	public String toString() {
		return "Station: " + super.toString() + "Rate: " + this.blinkRate;
	}
	
	
}
