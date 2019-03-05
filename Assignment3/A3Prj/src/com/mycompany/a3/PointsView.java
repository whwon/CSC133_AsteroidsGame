package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.commands.addTurnShipRight;
import com.mycompany.interfaces.IGameWorld;

public class PointsView extends Container implements Observer {
	private Label numberAsteroid;
	private Label sound;
	private Label time;
	private Label lives;
	private Label missiles;
	public PointsView() {
		
		this.setLayout(new FlowLayout(CENTER));
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.GREEN));
		this.getAllStyles().setBgTransparency(0);
		
		//***************************************************//
		//----------------------Labels-----------------------//
		//***************************************************//
		
		numberAsteroid = new Label ("Score: 0   ");
		sound = new Label ("Sound:   ");
		time = new Label ("Time: 0   ");
		lives = new Label("Lives: 3   ");
		missiles = new Label("Missiles: 10");
		
		
		//***************************************************//
		//--------------Label Customizations-----------------//
		//***************************************************//
		
		numberAsteroid.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		numberAsteroid.getAllStyles().setBgTransparency(0);
		numberAsteroid.getAllStyles().setPadding(RIGHT, 5);
		numberAsteroid.getAllStyles().setBorder(Border.createCompoundBorder(
				Border.createLineBorder(1, ColorUtil.GREEN),
				Border.createLineBorder(1, ColorUtil.GREEN), 
				null, 
				null));	
		sound.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		sound.getAllStyles().setBgTransparency(0);
		sound.getAllStyles().setPadding(RIGHT, 5);
		sound.getAllStyles().setBorder(Border.createCompoundBorder(
				Border.createLineBorder(1, ColorUtil.GREEN),
				Border.createLineBorder(1, ColorUtil.GREEN), 
				null, 
				null));	
		
		time.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		time.getAllStyles().setBgTransparency(0);
		time.getAllStyles().setPadding(RIGHT, 5);
		time.getAllStyles().setBorder(Border.createCompoundBorder(
				Border.createLineBorder(1, ColorUtil.GREEN),
				Border.createLineBorder(1, ColorUtil.GREEN), 
				null, 
				null));	
		
		lives.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		lives.getAllStyles().setBgTransparency(0);
		lives.getAllStyles().setBorder(Border.createCompoundBorder(
				Border.createLineBorder(1, ColorUtil.GREEN),
				Border.createLineBorder(1, ColorUtil.GREEN), 
				null, 
				null));	
		missiles.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		missiles.getAllStyles().setBgTransparency(0);
		missiles.getAllStyles().setBorder(Border.createCompoundBorder(
				Border.createLineBorder(1, ColorUtil.GREEN),
				Border.createLineBorder(1, ColorUtil.GREEN), 
				null, 
				null));	
		//***************************************************//
		//------------------Place Labels---------------------//
		//***************************************************//
		
		this.add(numberAsteroid);
		this.add(sound);
		this.add(time);
		this.add(lives);
		this.add(missiles);
	}

		//***************************************************//
		//----------------Observer Methods-------------------//
		//***************************************************//
	
		public void update(Observable observable, Object data) {
			Integer numberofAsteroid=((IGameWorld) data).getAsteroidCount();
			Integer curTime =((IGameWorld) data).getTime();
			Integer curLives =((IGameWorld) data).getLives();
			Integer curMissiles =((IGameWorld) data).getMissileCount();
			numberAsteroid.setText("Score: " + Integer.toString(numberofAsteroid));
			time.setText("Time: " + Integer.toString(curTime));
			lives.setText("  Lives: " + Integer.toString(curLives));
			missiles.setText("Missiles: " + Integer.toString(curMissiles));
			if(((IGameWorld) data).getSoundOn() == true) {
				sound.setText("Sound: ON");
			}
			else {
				sound.setText("Sound: OFF");
			}
		}

}