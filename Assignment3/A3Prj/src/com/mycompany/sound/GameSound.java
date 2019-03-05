package com.mycompany.sound;

import com.mycompany.sound.BGSound;
import com.mycompany.sound.Sound;

public class GameSound {
	private Sound shipCrashed, gameOver, missileLaunch;//, genericCollision;
	private BGSound ambiance;
	private int bgVol, vol;
	private boolean enable;
	
	public GameSound(){
		//genericCollision = new Sound("explosion.au");
		//shipCrashed = new Sound("");
		gameOver = new Sound("jabba1.wav");
		missileLaunch = new Sound("laser.wav");
		ambiance = new BGSound("background.mp3");
		bgVol = 50;
		vol = 50;
		
		enable = false;
	}
	
	/*public void genericSound(){
		if (enable){
			genericCollision.play(getVol());
		}
	}
	
	public void shipCrashSound(){
		if (enable){
			shipCrashed.play(getVol());
		}
	}*/
	
	public void gameOverSound(){
		if (enable){
			gameOver.play(getVol());
		}
	}
	
	public void missileLaunchSound(){
		if (enable){
			missileLaunch.play(getVol());
		}
	}
	
	public void playMusic() { //play bg sound
		if(enable){
			ambiance.play(getBGVol());
		}
	}
	
	public void pauseMusic() { //pause
		ambiance.pause();
	}
	
	public void soundToggle() {
		enable =! enable;
		if (enable == false){
			pauseMusic();
		}
		else{
			playMusic();
		}
	}

	public boolean getSound() {
		return enable;
	}
	
	public void setVol(int v) {
		vol = v;
	}
	
	public void setBGVol(int v) {
		bgVol = v;
		playMusic();
	}
	
	public int getVol() {
		return vol;
	}
	
	public int getBGVol() {
		return bgVol;
	}
}
