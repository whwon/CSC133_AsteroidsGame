package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class addAsteroidWhackedSaucer extends Command {
	
	private GameWorld gw;
	
	public addAsteroidWhackedSaucer(GameWorld gw) {
		super("Asteroid Whacked Flying Saucer");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.asteroidWhackedFlyingSaucer();
		System.out.println("invoked");
	}

}
