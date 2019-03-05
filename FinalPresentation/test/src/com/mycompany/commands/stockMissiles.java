package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class stockMissiles extends Command {
	private GameWorld g;
	public stockMissiles(GameWorld gw) {
		super("Stock");
		g = gw;
	}
	//override
	public void actionPerformed(ActionEvent evt) {
		String s = ("Source Type: ");
		s = s + "\n Command: " + evt.getCommand();
		s = s + "\n Class: "+ evt.getSource().getClass();
		System.out.println(s);
		g.stockMissile();
	}
}
