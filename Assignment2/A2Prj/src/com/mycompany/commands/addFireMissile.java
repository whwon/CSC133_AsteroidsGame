package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class addFireMissile extends Command {
	
	private GameWorld gw;
	
	public addFireMissile(GameWorld gw) {
		super("Fire Ship Missile");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.fireMissile();
		System.out.println("invoked");
	}

}
