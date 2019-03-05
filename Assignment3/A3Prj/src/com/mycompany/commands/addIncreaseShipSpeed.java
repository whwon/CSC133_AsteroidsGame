package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class addIncreaseShipSpeed extends Command {
	
	private GameWorld gw;
	
	public addIncreaseShipSpeed(GameWorld gw) {
		super("Increase Ship Speed");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.increaseShipSpeed();
		System.out.println("Increase Ship Speed");
	}

}
