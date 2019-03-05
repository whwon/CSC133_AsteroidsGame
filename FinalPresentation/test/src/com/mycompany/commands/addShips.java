package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addShips extends Command {
	
	private GameWorld gw;
	
	public addShips(GameWorld gw){
		super("Add Ship");
		this.gw = gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.addShip();
		System.out.println("BattleCruiser has been created");
	}

}
