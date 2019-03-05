package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addTurnShipLeft extends Command {
	
	private GameWorld gw;
	
	public addTurnShipLeft(GameWorld gw) {
		super("Turn Ship Left");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnShipLeft();
		System.out.println("Ship Turn Left");
	}

}
