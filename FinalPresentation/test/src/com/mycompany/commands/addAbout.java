package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.GameWorld;

public class addAbout extends Command {
	
	public addAbout() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent evt) {
		String s = ("Source Type: ");
		s = s + "\n Command: About";
		s = s + "\n Class:  133";
		System.out.println(s);
		String info = ("Woonghui Won");
			info = info + "\n Assignment 3";
		if(Dialog.show("About", info, "Credits", "Close")) {
				Dialog.show("Credits", "Okay", null, info);
		}
	}

}
