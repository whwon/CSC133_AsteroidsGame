package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class addAbout extends Command {
	
	private GameWorld gw;
	
	public addAbout(String Command, GameWorld gw) {
		super(Command);
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent evt) {
		gw.addAbout();
		System.out.println("Asteroid Project");
	}

}
