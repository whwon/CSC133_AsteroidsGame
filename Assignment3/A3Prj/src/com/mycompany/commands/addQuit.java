package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class addQuit extends Command {
	
	private GameWorld gw;
	
	public addQuit(GameWorld gw) {
		super("Quit");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.quit();
	}

}
