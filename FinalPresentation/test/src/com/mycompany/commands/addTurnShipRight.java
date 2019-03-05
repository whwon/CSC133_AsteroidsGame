package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addTurnShipRight extends Command {
	
	private GameWorld gw;
	
	public addTurnShipRight(GameWorld gw) {
		super("Turn Ship Right");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnShipRight();
		System.out.println("Ship Turn Right");
	}

}
