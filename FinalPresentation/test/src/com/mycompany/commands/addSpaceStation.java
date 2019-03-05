package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addSpaceStation extends Command {
	
	private GameWorld gw;
	
	public addSpaceStation(GameWorld gw) {
		super("Add Space Station");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.addBlinkingSpaceStation();
		System.out.println("Space Station has been created");
	}

}
