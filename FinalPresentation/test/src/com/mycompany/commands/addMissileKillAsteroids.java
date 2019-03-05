package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addMissileKillAsteroids extends Command {
	
	private GameWorld gw;
	
	public addMissileKillAsteroids(GameWorld gw) {
		super("Missile Kills Asteroid");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.missileKillAsteroid();
		System.out.println("invoked");
	}

}
