package com.mycompany.commands;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Command;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.Panels.SettingsPanel;
import com.mycompany.a4.Game;
import com.mycompany.a4.GameWorld;

public class addSettings extends Command{
	private SettingsPanel sDTemp;
	public addSettings(SettingsPanel sD) {
		super("Settings");
		// TODO Auto-generated constructor stub
		sDTemp = sD;
	}
	
	public void actionPerformed(ActionEvent E) {
		String s = ("Source Type: ");
		s = s + "\n Command: " + E.getCommand();
		s = s + "\n Class: "+ E.getSource().getClass();
		sDTemp.show();
	}
}