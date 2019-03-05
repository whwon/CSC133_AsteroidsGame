package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class addAsteroids extends Command{
	
	private GameWorld gw;
	
	public addAsteroids(GameWorld gw) { //parameter would be GameWorld gw
		super("Add Asteroids");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.addAsteroid();
		System.out.println("invoked");
	}
	
}
