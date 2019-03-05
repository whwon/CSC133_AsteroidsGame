package com.mycompany.commands;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Command;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a4.Game;
import com.mycompany.a4.GameWorld;

public class addBGSettings extends Command {
	private GameWorld tempGW;
	private Slider ambianceLevel;
	private Slider FXLevel;
	private Slider red;
	private Slider green;
	private Slider blue;
	private Game gRef;
	private int colorRef;
	public addBGSettings(GameWorld g, Slider BGVol, Slider vol, Game ge, Slider r, Slider gr, Slider b) {
		super("Apply");
		// TODO Auto-generated constructor stub
		tempGW = g;
		ambianceLevel = BGVol;
		FXLevel = vol;
		gRef = ge;
		red = r;
		green = gr;
		blue = b;
	}

	public void actionPerformed(ActionEvent evt) {
		colorRef = ColorUtil.rgb(red.getProgress(),  green.getProgress(),  blue.getProgress());
		tempGW.setBGVolume(ambianceLevel.getProgress());
		tempGW.setVolume(FXLevel.getProgress());
		gRef.colorSwap(colorRef);
	}
}
