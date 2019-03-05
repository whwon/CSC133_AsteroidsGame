package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class addAbout extends Command {
	
	public addAbout() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent evt) {
		String s = ("Source Type: ");
		s = s + "\n Command: " + evt.getCommand();
		s = s + "\n Class: "+ evt.getSource().getClass();
		System.out.println(s);
		String info = ("Woonghui Won");
			info = info + "\n Assignment 3";
		
	}

}
