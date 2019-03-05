package com.mycompany.sound;

import com.mycompany.sound.BGSound;
import com.mycompany.sound.Sound;

public class GameSound {
	private Sound shipSpawn, shipCrashed, hyperSpace, gameOver, missileLaunch, genericCollision, saucerCollision;
	private BGSound ambiance;
	private int bgVol, vol;
	private boolean enable;
	
	public GameSound(){
		genericCollision = new Sound("BOMB.WAV");
		saucerCollision = new Sound("SaucerCollide.WAV");
		shipCrashed = new Sound("shipCollide.WAV");
		shipSpawn = new Sound("Protoss_Probe.m4a");
		hyperSpace = new Sound("hyperSpace.WAV");
		gameOver = new Sound("jabba1.wav");
		missileLaunch = new Sound("laser.wav");
		ambiance = new BGSound("WeWerentAngels.m4a");
		bgVol = 50;
		vol = 50;
		
		enable = false;
	}
	
	public void genericSound(){
		if (enable){
			genericCollision.play(getVol());
		}
	}
	
	public void saucerSound(){
		if (enable){
			saucerCollision.play(getVol());
		}
	}
	
	public void shipCrashSound(){
		if (enable){
			shipCrashed.play(getVol());
		}
	}
	
	public void shipCreation(){
		if (enable){
			shipSpawn.play(getVol());
		}
	}
	
	public void jumpHyperSpace(){
		if (enable){
			hyperSpace.play(getVol());
		}
	}
	
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
