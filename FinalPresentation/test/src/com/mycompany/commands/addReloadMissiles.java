package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addReloadMissiles extends Command {
	
	private GameWorld gRef;
	public addReloadMissiles(GameWorld g) {
		super("refill");
		gRef = g;
	}
	public void actionPerformed(ActionEvent E) {
		//gRef.refillMissiles();
		gRef.stockMissile();
	}
}
