package com.mycompany.a4;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.mycompany.Panels.ButtonPanel;
import com.mycompany.Panels.SettingsPanel;
import com.mycompany.commands.addAbout;
//import com.mycompany.commands.addAsteroidCollided;
//import com.mycompany.commands.addAsteroidWhackedSaucer;
import com.mycompany.commands.addAsteroids;
import com.mycompany.commands.addDecreaseShipSpeed;
//import com.mycompany.commands.addEliminate;
import com.mycompany.commands.addFireMissile;
import com.mycompany.commands.addFlyingSaucers;
import com.mycompany.commands.addIncreaseShipSpeed;
import com.mycompany.commands.addJumpThroughSpace;
import com.mycompany.commands.addPause;
//import com.mycompany.commands.addMissileKillAsteroids;
import com.mycompany.commands.addQuit;
import com.mycompany.commands.addReloadMissiles;
import com.mycompany.commands.addSettings;
//import com.mycompany.commands.addShipCrashedAsteroid;
//import com.mycompany.commands.addShipHitFlyingSaucer;
import com.mycompany.commands.addShips;
import com.mycompany.commands.addSound;
import com.mycompany.commands.addSpaceStation;
import com.mycompany.commands.addTick;
import com.mycompany.commands.addTurnShipLeft;
import com.mycompany.commands.addTurnShipRight;

import java.lang.String;
import java.util.Observable;
import java.util.Observer;

public class Game extends Form implements Runnable {
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	private ButtonPanel b1, b3, b4, b5, b6, b7, b8, b9, b15, b16, b17, b18;
	private addAsteroids a;
	private addShips s;
	//private StockMissilesCmd n;
	private addFlyingSaucers y;
	private addTick t;
	private addIncreaseShipSpeed i;
	private addDecreaseShipSpeed d; 
	private addTurnShipLeft l;
	private addTurnShipRight r;
	private addFireMissile f;
	private addJumpThroughSpace j;
	private addPause p;
	private addQuit q;
	private addReloadMissiles fill;
	private SettingsPanel sd;
	private addAbout z;
	private Container cContainer;
	
	public Game() {
		gw = new GameWorld();
		mv = new MapView(gw, this.getComponentForm());
		pv = new PointsView();
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		int backGround = ColorUtil.BLACK;
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(backGround);
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, mv);
		this.add(BorderLayout.NORTH, pv);
		
		UITimer timer = new UITimer(this);
		startTime(timer);
		
		cContainer = new Container();
			cContainer.getAllStyles().setBgTransparency(0);
			cContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
			cContainer.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLACK));
			this.add(BorderLayout.WEST, cContainer);
			
	    a = new addAsteroids(gw);	    	    
	    s = new addShips(gw);	
	    y = new addFlyingSaucers(gw);
     	//n = new StockMissilesCmd(gw);	       
		t = new addTick(gw);
		i = new addIncreaseShipSpeed(gw);
		d = new addDecreaseShipSpeed(gw);
		l = new addTurnShipLeft(gw);
		r = new addTurnShipRight(gw);
		f = new addFireMissile(gw);
		j = new addJumpThroughSpace(gw);
		p = new addPause(timer, gw, this);
		q = new addQuit(gw);
		z = new addAbout();
		fill = new addReloadMissiles(gw);

		/****************************TOOLBAR*****************************/
		
		Toolbar myToolbar = new Toolbar();
		myToolbar.setUIID("mainToolbar");
		myToolbar.getAllStyles().setBgTransparency(0);
		myToolbar.getAllStyles().setBgColor(backGround);
		//myToolbar.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.rgb(100, 0, 0)));
		this.setToolbar(myToolbar);	
		myToolbar.setTitle("A S T E R O I D   G A M E");
		myToolbar.getTitleComponent().getAllStyles().setFgColor(ColorUtil.LTGRAY);
			
	    Command newGame = new Command("New");	    
	    Command saveGame = new Command("Save");    
	    Command undoAction = new Command("Undo");	    
	    CheckBox soundBox = new CheckBox();
	    soundBox.getAllStyles().setBgTransparency(255);
	    Command sCommand = new addSound(soundBox, gw);
	    soundBox.setCommand(sCommand);
	    sd = new SettingsPanel(gw, backGround, this);
	    addSettings settings = new addSettings(sd);
	    addAbout about = new addAbout();
	    addQuit q = new addQuit(gw);
	    
    	//side menu
    	myToolbar.addComponentToSideMenu(soundBox);
		myToolbar.addCommandToSideMenu(newGame);
		myToolbar.addCommandToSideMenu(saveGame);	
		myToolbar.addCommandToSideMenu(undoAction);
		myToolbar.addCommandToSideMenu(settings);
		myToolbar.addCommandToSideMenu(about);
		myToolbar.addCommandToSideMenu(q);
    
    	//overflow menu
    	myToolbar.addCommandToOverflowMenu(a);    
    	myToolbar.addCommandToOverflowMenu(s);
    	myToolbar.addCommandToOverflowMenu(y);
    	//myToolbar.addCommandToOverflowMenu(n);
    	myToolbar.addCommandToOverflowMenu(t);
	    
		
		/***********************KEY BINDING**********************/
		
		//Key bind the SPACE bar
		addKeyListener(-90, f);
		
		//Key bind the up arrow key
		addKeyListener(-91, i);
		
		//key bind the down arrow key
		addKeyListener(-92, d);
		
		//key bind the left arrow key
		addKeyListener(-93, l);
		
		//key bind the right arrow key
		addKeyListener(-94, r);
	
	    b1 = new ButtonPanel("Add Asteroid", a, backGround);
	    	cContainer.add(b1);
		b18 = new ButtonPanel("Add Flying Saucer", y, backGround);
			cContainer.add(b18);
	    b3 = new ButtonPanel("Add Ship", s, backGround);
	  		cContainer.add(b3);
	    b4 = new ButtonPanel("Increase Speed", i, backGround);
		    cContainer.add(b4);
	    b5 = new ButtonPanel("Decrease Speed", d, backGround);
		    cContainer.add(b5);
	    b6 = new ButtonPanel("Left", l, backGround);
		    cContainer.add(b6);
	    b7 = new ButtonPanel("Right", r, backGround);
		    cContainer.add(b7);
	    b8 = new ButtonPanel("Fire", f, backGround);
		    cContainer.add(b8);
	    b9 = new ButtonPanel("Jump through HyperSpace", j, backGround);
		    cContainer.add(b9);
		b15 = new ButtonPanel("Pause", p, backGround);
			cContainer.add(b15);
		b16 = new ButtonPanel("refuel", fill, backGround);
			cContainer.add(b16);
	    b17 = new ButtonPanel("Quit", q, backGround);
		    cContainer.add(b17);
		
		notPaused();
		this.show();
		gw.setHeight(mv.getHeight());
		gw.setWidth(mv.getWidth());
		gw.observerNotify();
		gw.init();
	}
	
	@Override
	public void keyPressed(int KeyCode) {
		switch(KeyCode) {
			case -91:keyReleased(-91);
			break;
		}
		switch(KeyCode) {
			case -92:keyReleased(-92);
			break;
		}
		switch(KeyCode) {
			case -93:keyReleased(-93);
			break;
		}
		switch(KeyCode) {
			case -94:keyReleased(-94);
			break;
		}
	}

	public void run() {
		gw.tick();
	}
	public void startTime(UITimer t) {
		t.schedule(100, true, this);
	}
	
	public void stopTime(UITimer t) {
		t.cancel();
	}

	public void notPaused() {
		b1.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		b16.setEnabled(false);
		b17.setEnabled(true);
		b15.setText("pause");
		b18.setEnabled(true);
		this.addKeyListener('w', i);	//Increase player speed on 'W' key.
		this.addKeyListener('s', d);	//Decrease player speed on 'S' key.
		this.addKeyListener('a', l);	//Turn player left on 'A' key.
		this.addKeyListener('d', r);	//Turn player right on 'D' key.
		this.addKeyListener('f', f);	//Fire missile on 'f' key.
		this.addKeyListener('j', j);	//Jump to start position on 'j' key.
	}
	
	public void isPaused() {
		b1.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
		b16.setEnabled(true);
		b17.setEnabled(false);
		b18.setEnabled(false);
		b15.setText("play");
		this.removeKeyListener('w', i);	//Increase player speed on 'i' key.
		this.removeKeyListener('s', d);	//Decrease player speed on 'd' key.
		this.removeKeyListener('a', l);	//Turn player left on 'l' key.
		this.removeKeyListener('d', r);	//Turn player right on 'r' key.
		this.removeKeyListener('f', f);	//Fire missile on 'f' key.
		this.removeKeyListener('j', j);	//Jump to start position on 'j' key.
	}
	
	public void colorSwap(int newColor) {
		this.getAllStyles().setBgColor(newColor);
		sd.getAllStyles().setBgColor(newColor);
	}
}
	