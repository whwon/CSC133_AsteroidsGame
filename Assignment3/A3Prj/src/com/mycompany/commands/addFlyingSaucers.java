package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld; 

public class addFlyingSaucers extends Command {
	
	private GameWorld gw;
	
	public addFlyingSaucers(GameWorld gw) {
		super("Add Flying Saucer");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.addFlyingSaucer();
		System.out.println("Flying Saucer created");
	}

}
