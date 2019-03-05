package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addTick extends Command {
	
	private GameWorld gw;
	
	public addTick(GameWorld gw) {
		super("Tick");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.tick();
		System.out.println("invoked");
	}

}
