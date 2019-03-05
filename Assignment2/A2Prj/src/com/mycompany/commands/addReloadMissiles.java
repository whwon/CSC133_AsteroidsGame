package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class addReloadMissiles extends Command {
	
	private GameWorld gw;
	
	public addReloadMissiles(GameWorld gw) {
		super("Reload Missile");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.loadNewMissiles();
		System.out.println("invoked");
	}

}
