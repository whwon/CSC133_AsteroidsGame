package com.mycompany.commands;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class addSound extends Command {

	private GameWorld gw;
	
	public addSound (String command, GameWorld gw){
	    super("Sound");
	    this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		gw.toggleSound();
		System.out.println("sound toggled");
	}
}

