package com.mycompany.Panels;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a4.Game;
import com.mycompany.a4.GameWorld;
import com.mycompany.commands.addBGSettings;

public class SettingsPanel extends Dialog{
	private Game gRef;
	private int MaxSound = 100;
	private int MinSound = 0;
	private int currBGSound;
	private int currSound;
	private int fontColor;
	private Slider bgsoundLevel;
	private Slider soundLevel;
	private Slider redSetting;
	private Slider greenSetting;
	private Slider blueSetting;
	
	public SettingsPanel(GameWorld gw, int color, Game g){
		super();
		
		fontColor = ColorUtil.BLUE;
		gRef = g;
		
		//Pane formating
		
		this.setLayout(new BorderLayout());
    	this.getAllStyles().setBgTransparency(255);
    	this.getAllStyles().setBgColor(color);
    	
		//Set Variables
		//prevents too many gw calls.
    	//ensures the slider progress reflects the gw volumes.
    	
		currBGSound = gw.getBGVolume();
		currSound = gw.getVolume();
		
		//Settings Labels
		
		Label bgSoundLabel = new Label("Background Sound");
			bgSoundLabel.getAllStyles().setUnderline(true);
			bgSoundLabel.getAllStyles().setFgColor(fontColor);
		Label soundLabel = new Label("Sound Effects");
			soundLabel.getAllStyles().setUnderline(true);
			soundLabel.getAllStyles().setFgColor(fontColor);
		Label redLabel = new Label("Red Bg Component");
			redLabel.getAllStyles().setUnderline(true);
			redLabel.getAllStyles().setFgColor(fontColor);
		Label greenLabel = new Label("Green Bg Component");
			greenLabel.getAllStyles().setUnderline(true);
			greenLabel.getAllStyles().setFgColor(fontColor);
		Label blueLabel = new Label("Blue Bg Component");
			blueLabel.getAllStyles().setUnderline(true);
			blueLabel.getAllStyles().setFgColor(fontColor);	
        Label bgSoundLabelMax = new Label("100%");
        	//bgSoundLabelMax.getAllStyles().setFgColor(fontColor);
        Label bgSoundLabelMin = new Label("0%");
        	//bgSoundLabelMin.getAllStyles().setFgColor(fontColor);
		Label fxSoundLabelMax = new Label("100%");
			//fxSoundLabelMax.getAllStyles().setFgColor(fontColor);
		Label fxSoundLabelMin = new Label("0%");
			//fxSoundLabelMin.getAllStyles().setFgColor(fontColor);
		Label redLabelMax = new Label("Dark");
			//redLabelMax.getAllStyles().setFgColor(fontColor);
		Label redLabelMin = new Label("Light");
			//redLabelMin.getAllStyles().setFgColor(fontColor);
		Label greenLabelMax = new Label("Dark");
			//greenLabelMax.getAllStyles().setFgColor(fontColor);
		Label greenLabelMin = new Label("Light");
			//greenLabelMin.getAllStyles().setFgColor(fontColor);
		Label blueLabelMax = new Label("Dark");
			//blueLabelMax.getAllStyles().setFgColor(fontColor);
		Label blueLabelMin = new Label("Light");
			//blueLabelMin.getAllStyles().setFgColor(fontColor);
			
		//Containers
		
		Container slidersContainer = new Container();
			slidersContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			slidersContainer.getAllStyles().setBgTransparency(255);
			slidersContainer.getAllStyles().setBgColor(ColorUtil.BLACK);
			slidersContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(13, 200, 48)));
		Container bgSliderComponents = new Container();
			bgSliderComponents.setLayout(new BoxLayout(BoxLayout.X_AXIS));
			bgSliderComponents.getAllStyles().setBgTransparency(255);
			bgSliderComponents.getAllStyles().setBgColor(color);
		Container fxSliderComponents = new Container();
			fxSliderComponents.setLayout(new BoxLayout(BoxLayout.X_AXIS));
			fxSliderComponents.getAllStyles().setBgTransparency(255);
			fxSliderComponents.getAllStyles().setBgColor(color);
		Container redContainer = new Container();
			redContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
			redContainer.getAllStyles().setBgTransparency(255);
			redContainer.getAllStyles().setBgColor(color);
		Container greenContainer = new Container();
			greenContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
			greenContainer.getAllStyles().setBgTransparency(255);
			greenContainer.getAllStyles().setBgColor(color);
		Container blueContainer = new Container();
			blueContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
			blueContainer.getAllStyles().setBgTransparency(255);
			blueContainer.getAllStyles().setBgColor(color);
		
		//Sliders
			
		bgsoundLevel = new Slider();
        	bgsoundLevel.setMaxValue(MaxSound);
        	bgsoundLevel.setMinValue(MinSound);
        	bgsoundLevel.setProgress(currBGSound);
        	bgsoundLevel.setEditable(true);
        	//FontImage.setMaterialIcon(bgsoundLevel, FontImage.MATERIAL_ALARM);
			
		soundLevel = new Slider();
    		soundLevel.setMaxValue(MaxSound);
    		soundLevel.setMinValue(MinSound);
    		soundLevel.setProgress(currSound);
    		soundLevel.setEditable(true);
    	
    	redSetting = new Slider();
    		redSetting.setMaxValue(255);
    		redSetting.setProgress(ColorUtil.red(color));
    		redSetting.setMinValue(0);
    		redSetting.setEditable(true);
    		
    	greenSetting = new Slider();
    		greenSetting.setMaxValue(255);
    		greenSetting.setProgress(ColorUtil.green(color));
    		greenSetting.setMinValue(0);
    		greenSetting.setEditable(true);
    		
    	blueSetting = new Slider();
    		blueSetting.setMaxValue(255);
    		blueSetting.setProgress(ColorUtil.blue(color));
    		blueSetting.setMinValue(0);
    		blueSetting.setEditable(true);
    		
    	
    	//Build Containers
    		
        	bgSliderComponents.add(bgSoundLabelMin);
        	bgSliderComponents.add(bgsoundLevel);
        	bgSliderComponents.add(bgSoundLabelMax);
    		
    		fxSliderComponents.add(fxSoundLabelMin);
    		fxSliderComponents.add(soundLevel);
    		fxSliderComponents.add(fxSoundLabelMax);
    		
    		redContainer.add(redLabelMax);
    		redContainer.add(redSetting);
    		redContainer.add(redLabelMin);
    		
    		greenContainer.add(greenLabelMax);
    		greenContainer.add(greenSetting);
    		greenContainer.add(greenLabelMin);
    		
    		blueContainer.add(blueLabelMax);
    		blueContainer.add(blueSetting);
    		blueContainer.add(blueLabelMin);
    		
    		
    		slidersContainer.add(bgSoundLabel);
    		slidersContainer.add(bgSliderComponents);
    		slidersContainer.add(soundLabel);
    		slidersContainer.add(fxSliderComponents);
    		slidersContainer.add(redLabel);
    		slidersContainer.add(redContainer);
    		slidersContainer.add(greenLabel);
    		slidersContainer.add(greenContainer);
    		slidersContainer.add(blueLabel);
    		slidersContainer.add(blueContainer);
    		
    	//Buttons
    		
        Button applyB = new Button("Apply");
        	applyB.getAllStyles().setBgTransparency(255);
        	applyB.getAllStyles().setBgColor(color);
        	applyB.getAllStyles().setFgColor(ColorUtil.BLUE);
        	applyB.getAllStyles().setBorder(Border.createCompoundBorder(
        			null, 
        			null, 
        			Border.createLineBorder(4, ColorUtil.rgb(13, 200, 48)), 
        			Border.createLineBorder(4, ColorUtil.rgb(13, 200, 48))));
        	addBGSettings apply = new addBGSettings(gw, bgsoundLevel, soundLevel, gRef, redSetting, greenSetting, blueSetting);
        	applyB.setCommand(apply);      
        	slidersContainer.add(applyB);
        Button closer = new Button("Close");
        	closer.getAllStyles().setBgTransparency(255);
        	closer.getAllStyles().setBgColor(color);
        	closer.getAllStyles().setFgColor(ColorUtil.BLUE);
        	closer.getAllStyles().setBorder(Border.createCompoundBorder(
        			null, 
        			Border.createLineBorder(4, ColorUtil.rgb(13, 200, 48)), 
        			Border.createLineBorder(4, ColorUtil.rgb(13, 200, 48)), 
        			Border.createLineBorder(4, ColorUtil.rgb(13, 200, 48))));
        	Command close = new Command("Close");
        	closer.setCommand(close);
        	slidersContainer.add(closer);
        	
		//Dialog Builder
        
        	this.add(BorderLayout.CENTER, slidersContainer);
	}
	
}
