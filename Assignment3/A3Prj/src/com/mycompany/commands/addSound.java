package com.mycompany.commands;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class addSound extends Command {
	private CheckBox c;
	private GameWorld g;
	
	public addSound (CheckBox cIn, GameWorld gw){
	    super("Sound");
	    c=cIn;
	    g=gw;
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		System.out.println("sound toggled");
		if(c.isSelected()) {
			System.out.println("selected");
			g.soundToggle();
		}
		else {
			System.out.println("unselected");
			g.soundToggle();
		}
	}
}

