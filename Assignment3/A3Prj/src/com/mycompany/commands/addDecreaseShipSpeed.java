package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class addDecreaseShipSpeed extends Command {
	
	private GameWorld gw;
	
	public addDecreaseShipSpeed(GameWorld gw) {
		super("Decrease Ship Speed");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.decreaseShipSpeed();
		System.out.println("Decrease Ship Speed invoked");
	}

}
