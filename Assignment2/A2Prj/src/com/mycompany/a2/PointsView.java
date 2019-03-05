package com.mycompany.a2;

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
import com.mycompany.commands.addTurnShipRight;
import com.mycompany.interfaces.IGameWorld;

public class PointsView extends Container implements Observer {
	
	private Label pointsValueLabel;
	private Label livesValueLabel;
	private Label missilesValueLabel;
	private Label timesValueLabel;
	private Label soundValueLabel;
	
	public PointsView(GameWorld gw) {
		
		Label scoreTextLabel = new Label("Score: 0   ");
		pointsValueLabel = new Label("X");
		scoreTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		Label livesTextLabel = new Label("Lives: 3   ");
		livesValueLabel = new Label("X");
		livesTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		Label missilesTextLabel = new Label("Missiles: 12  ");
		missilesValueLabel = new Label("X");
		missilesTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		Label timesTextLabel = new Label("Time: 0  ");
		timesValueLabel = new Label("X");
		timesTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		CheckBox soundTextLabel = new CheckBox("Sound: OFF  ");
		soundValueLabel = new CheckBox("X");
		soundTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		myContainer.add(scoreTextLabel);
		myContainer.add(livesTextLabel);
		myContainer.add(missilesTextLabel);
		myContainer.add(timesTextLabel);
		myContainer.add(soundTextLabel);
		this.add(myContainer);
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		IGameWorld gw = (IGameWorld) arg;
		
		//getting player score
		int score = gw.getScore();
		int life = gw.getLives();
		//int missile = gw.loadNewMissiles();
		//int time = gw.getTime();
		Boolean sound = gw.getSound();
		pointsValueLabel.setText("Scores: " + ((GameWorld) o).getScore());
		livesValueLabel.setText("Lives: " + ((GameWorld) o).getLives());
		//missilesValueLabel.setText("" + missile);
		//timesValueLabel.setText("" + time);
		soundValueLabel.setText("Sound: " + (((GameWorld) o).getSound() ? "ON" : "OFF"));
		
	}

}
