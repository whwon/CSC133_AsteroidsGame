package com.mycompany.a2;

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
import com.mycompany.commands.addAbout;
import com.mycompany.commands.addAsteroidCollided;
import com.mycompany.commands.addAsteroidWhackedSaucer;
import com.mycompany.commands.addAsteroids;
import com.mycompany.commands.addDecreaseShipSpeed;
import com.mycompany.commands.addEliminate;
import com.mycompany.commands.addFireMissile;
import com.mycompany.commands.addFlyingSaucers;
import com.mycompany.commands.addIncreaseShipSpeed;
import com.mycompany.commands.addJumpThroughSpace;
import com.mycompany.commands.addMissileKillAsteroids;
import com.mycompany.commands.addQuit;
import com.mycompany.commands.addReloadMissiles;
import com.mycompany.commands.addShipCrashedAsteroid;
import com.mycompany.commands.addShipHitFlyingSaucer;
import com.mycompany.commands.addShips;
import com.mycompany.commands.addSound;
import com.mycompany.commands.addSpaceStation;
import com.mycompany.commands.addTick;
import com.mycompany.commands.addTurnShipLeft;
import com.mycompany.commands.addTurnShipRight;

import java.lang.String;
import java.util.Observable;
import java.util.Observer;

public class Game extends Form{
	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	
	public Game() {
		gw = new GameWorld();
		mv = new MapView();
		pv = new PointsView(gw);
		gw.addObserver(mv);
		gw.addObserver(pv);
		gw.init();
		//play();
		
		int backGround = ColorUtil.BLACK;
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(backGround);
		this.setLayout(new BorderLayout());
		
		//UITimer timer = new UITimer(this);
		//startTime(timer);
		
		//Create instances of command objects to be used
		Command newCommand = new Command("New"); 		//does nothing yet
		Command saveCommand = new Command("Save");		//does nothing yet
		Command undoCommand = new Command("Undo");	//does nothing yet
		addAbout aboutCommand = new addAbout("About", gw);
		addQuit quitCommand = new addQuit(gw);
		addSound toggleSound = new addSound("Sound", gw);
		addAsteroids addAsteroid2 = new addAsteroids(gw);
		addSpaceStation addSpaceStation2 = new addSpaceStation(gw);
		addShips addShip2 = new addShips(gw);
		addJumpThroughSpace addJumpThroughSpace2 = new addJumpThroughSpace(gw);
		addReloadMissiles addReloadMissile2 = new addReloadMissiles(gw);
		addMissileKillAsteroids addMissileKillAsteroid2 = new addMissileKillAsteroids(gw);
		addShipCrashedAsteroid addShipCrashedAsteroid2 = new addShipCrashedAsteroid(gw);
		addEliminate addEliminate2 = new addEliminate(gw);
		addTick tick2 = new addTick(gw);
		
		/****************************TOOLBAR*****************************/
		
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);//make sure to use lower-case "b", setToolBar() is depreciated
		Command titleBarAreaItem = new Command("Command Menu");
		myToolbar.addCommandToLeftBar(titleBarAreaItem);
		myToolbar.setTitle("ASTEROID GAME");
	    myToolbar.getAllStyles().setBgColor(ColorUtil.LTGRAY);
	    
		//Create Check box and add sound toggle
		CheckBox soundBox = new CheckBox("Toggle Sound");
		soundBox.getAllStyles().setBgTransparency(255);
		soundBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundBox.setCommand(toggleSound);
		toggleSound.putClientProperty("SideComponent", soundBox); 
	    
		//Add Commands to Overflow Menu
		myToolbar.addCommandToOverflowMenu(toggleSound);
		myToolbar.addCommandToOverflowMenu(newCommand);
		myToolbar.addCommandToOverflowMenu(saveCommand);
		myToolbar.addCommandToOverflowMenu(undoCommand);
		myToolbar.addCommandToOverflowMenu(aboutCommand);
		myToolbar.addCommandToOverflowMenu(quitCommand);
	    
	    //Add Commands to Side bar
		myToolbar.addCommandToSideMenu(toggleSound);
		myToolbar.addComponentToSideMenu(new ButtonPanel(addAsteroid2));
		myToolbar.addComponentToSideMenu(new ButtonPanel(addSpaceStation2));
		myToolbar.addComponentToSideMenu(new ButtonPanel(addShip2));
		myToolbar.addComponentToSideMenu(new ButtonPanel(addReloadMissile2));
		myToolbar.addComponentToSideMenu(new ButtonPanel(addMissileKillAsteroid2));
		myToolbar.addComponentToSideMenu(new ButtonPanel(addShipCrashedAsteroid2));
		myToolbar.addComponentToSideMenu(new ButtonPanel(addEliminate2));
		myToolbar.addComponentToSideMenu(new ButtonPanel(tick2));

	    /******************************TOP CONTAINER/POINTSVIEW********************************/
	    
		setLayout(new BorderLayout());
		//top Container with the GridLayout positioned on the north 
		Container topContainer = new Container(new FlowLayout(Component.CENTER));
		topContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
	    add(BorderLayout.NORTH,topContainer);
	    topContainer.add(pv);
	   
		/******************************LEFT CONTAINER******************************/
	    
		//left Container with the BoxLayout positioned on the west 
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		//start adding components at a location 50 pixels below the upper border of the container
		leftContainer.getAllStyles().setPadding(Component.TOP, 50);
		leftContainer.setScrollable(true);
		leftContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		add(BorderLayout.WEST,leftContainer);	
		
		/*********************************RIGHT CONTAINER**************************/
		
		//right Container with the GridLayout positioned on the east 
		Container rightContainer = new Container(new GridLayout(4,1));
		//...[add similar components that exists on the left container]
		add(BorderLayout.EAST,rightContainer);
		
		/*****************************CENTER CONTAINER/MAPVIEW**************************/
		
		//add empty container to the center
		Container centerContainer = new Container();
		//setting the back ground color of center container to light gray
		centerContainer.getAllStyles().setBgTransparency(255);
		centerContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		//setting the border Color
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLACK));
		add(BorderLayout.CENTER,centerContainer);
		centerContainer.add(mv);
		
		/************************************BUTTONS*****************************/
		
		//Creating Asteroid
		Button addAsteroid = new Button("Add Asteroid Command");
		addAsteroids myAddAsteroids = new addAsteroids(gw);
		addAsteroid.setCommand(myAddAsteroids);
		leftContainer.add(addAsteroid);
		
		//Creating Ship
		Button addShip = new Button("Add Space Ship Command");
		addShips myAddShips = new addShips(gw);
		addShip.setCommand(myAddShips);
		leftContainer.add(addShip);
		
		//Creating Flying Saucer
		Button addFlyingSaucer = new Button("Add Flying Saucer Command");
		addFlyingSaucers myFlyingSaucers = new addFlyingSaucers(gw);
		addFlyingSaucer.setCommand(myFlyingSaucers);
		leftContainer.add(addFlyingSaucer);
		
		//Creating Space Station
		Button addSpaceStation1 = new Button("Add Space Station Command");
		addSpaceStation mySpaceStation = new addSpaceStation(gw);
		addSpaceStation1.setCommand(mySpaceStation);
		leftContainer.add(addSpaceStation1);
		
		//Jumping through Space
		Button addJumpThroughSpace1 = new Button("Jump Through Space Command");
		addJumpThroughSpace myJumpThroughSpace = new addJumpThroughSpace(gw);
		addJumpThroughSpace1.setCommand(myJumpThroughSpace);
		leftContainer.add(addJumpThroughSpace1);
		
		//Increase Speed
		Button addSpeedIncrease = new Button("Increase Ship Speed");
		addIncreaseShipSpeed myIncreaseSpeed = new addIncreaseShipSpeed(gw);
		addSpeedIncrease.setCommand(myIncreaseSpeed);
		leftContainer.add(addSpeedIncrease);
		
		//Decrease Speed
		Button addSpeedDecrease = new Button("Decrease Ship Speed");
		addDecreaseShipSpeed myDecreaseSpeed = new addDecreaseShipSpeed(gw);
		addSpeedDecrease.setCommand(myDecreaseSpeed);
		leftContainer.add(addSpeedDecrease);
		
		//Turn Right
		Button addTurnRight = new Button("Turn Ship Right");
		addTurnShipRight myTurnRight = new addTurnShipRight(gw);
		addTurnRight.setCommand(myTurnRight);
		leftContainer.add(addTurnRight);
		
		//Turn Left
		Button addTurnLeft = new Button("Turn Ship Left");
		addTurnShipLeft myTurnLeft = new addTurnShipLeft(gw);
		addTurnLeft.setCommand(myTurnLeft);
		leftContainer.add(addTurnLeft);
		
		//Fire Missiles
		Button addFireMissiles = new Button("Fire Missile");
		addFireMissile myFireMissiles = new addFireMissile(gw);
		addFireMissiles.setCommand(myFireMissiles);
		leftContainer.add(addFireMissiles);
		
		//Reload Missiles
		Button addReloadMissile = new Button("Reload Missiles Command");
		addReloadMissiles myReloadMissiles = new addReloadMissiles(gw);
		addReloadMissile.setCommand(myReloadMissiles);
		leftContainer.add(addReloadMissile);
		
		//Missile vs. Asteroid
		Button addMissileKillAsteroid = new Button("Missile Kill Asteroid Command");
		addMissileKillAsteroids myMissileKillAsteroids = new addMissileKillAsteroids(gw);
		addMissileKillAsteroid.setCommand(myMissileKillAsteroids);
		leftContainer.add(addMissileKillAsteroid);
		
		//Eliminate
		Button addEliminate1 = new Button("Elminiate Enemy Command");
		addEliminate myEliminate = new addEliminate(gw);
		addEliminate1.setCommand(myEliminate);
		leftContainer.add(addEliminate1);
		
		//Ship vs. Asteroid
		Button addShipCrashedAsteroid1 = new Button("Ship Crashed Into Asteroid Command");
		addShipCrashedAsteroid myShipCrashedAsteroid = new addShipCrashedAsteroid(gw);
		addShipCrashedAsteroid1.setCommand(myShipCrashedAsteroid);
		leftContainer.add(addShipCrashedAsteroid1);
		
		//Ship vs. Flying Saucer;
		Button addShipHitFlyingSaucer1 = new Button("Ship Hit Flying Saucer Command");
		addShipHitFlyingSaucer myShipHitFlyingSaucer = new addShipHitFlyingSaucer(gw);
		addShipHitFlyingSaucer1.setCommand(myShipHitFlyingSaucer);
		leftContainer.add(addShipHitFlyingSaucer1);
		
		//Asteroid vs Asteroid
		Button addAsteroidCollided1 = new Button("Asteroid Collided Command");
		addAsteroidCollided myAsteroidCollided = new addAsteroidCollided(gw);
		addAsteroidCollided1.setCommand(myAsteroidCollided);
		leftContainer.add(addAsteroidCollided1);
		
		//Asteroid vs. Flying Saucer
		Button addAsteroidWhackedSaucer1 = new Button("Asteroid Whacked Flying Saucer Command");
		addAsteroidWhackedSaucer myAsteroidWhackedSaucer = new addAsteroidWhackedSaucer(gw);
		addAsteroidWhackedSaucer1.setCommand(myAsteroidWhackedSaucer);
		leftContainer.add(addAsteroidWhackedSaucer1);
		
		//Add Tick
		Button addTick1 = new Button("Tick");
		addTick myTick = new addTick(gw);
		addTick1.setCommand(myTick);
		leftContainer.add(addTick1);
       
		this.show();
		
		/***********************KEY BINDING**********************/
		
		//Key bind the SPACE bar
		addFireMissile myFireMissile = new addFireMissile(gw);
		addKeyListener(-90, myFireMissile);
		
		//Key bind the up arrow key
		addIncreaseShipSpeed myIncreaseShipSpeed = new addIncreaseShipSpeed(gw);
		addKeyListener(-91, myIncreaseShipSpeed);
		
		//key bind the down arrow key
		addDecreaseShipSpeed myDecreaseShipSpeed = new addDecreaseShipSpeed(gw);
		addKeyListener(-92, myDecreaseShipSpeed);
		
		//key bind the left arrow key
		addTurnShipLeft myTurnShipLeft = new addTurnShipLeft(gw);
		addKeyListener(-93, myTurnShipLeft);
		
		//key bind the right arrow key
		addTurnShipRight myTurnShipRight = new addTurnShipRight(gw);
		addKeyListener(-94, myTurnShipRight);
	}

	/*private void play () { //A2 - going to become useless
		//code here to accept and
		//execute user commands that
		//operate on the game world
		//refer to "Appendix - CN1 Notes
		//for accepting
		//Keyboard commands via a text
		//field located on the form
		System.out.println("New Game");
		Label myLabel=new Label("Enter a Command:"); 
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt) {
				
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				switch (sCommand.charAt(0)) {
					case 'a':
						System.out.println("You have added a Asteroid");
						gw.addAsteroid();
						break;
					case 'y':
					    System.out.println("You have added a Flying Saucer");
						gw.addFlyingSaucer();
						break;
					case 'b':
						System.out.println("Your Orbital Command Center is blinking");
						gw.addBlinkingSpaceStation();
						break;
				    case 's':
				    	//System.out.println("You have added a BattleCruiser");
						gw.addShip(); //Only creates one ship at a time on the map
						break;
					case 'i':
						gw.increaseShipSpeed(); //has a max speed of 6
						break;
					case 'd':
						gw.decreaseShipSpeed(); //when it reaches zero it cannot go down anymore
						break;
					case 'l':
						gw.turnShipLeft(); //rotates 360 degree (360 degree also acts as 0 degrees) then sets back to 90
						break;
					case 'r':
						gw.turnShipRight(); //rotates -360 degree( -360 degree also acts as 0 degrees) then sets back to -90
						break;
					case 'f':
						gw.fireMissile(); //keeps firing missiles until none left
						break;
					case 'j':
						gw.jumpThroughSpace(); //Jumps you back to the center space
						break;
					case 'n':
						gw.loadNewMissiles(); //load up missiles back up to its max capacity of 12
						break;
					case 'k':
						System.out.println("Your missile has destroyed a Asteroid"); //Missile count goes down and removes the missile and asteroid
						gw.missileKillAsteroid(); //Player receives a point for destroying asteroid
						break;
					case 'e':
						System.out.println("You have eliminated a enemy Saucer");
						gw.eliminate();
						break;
					case 'c':
						System.out.println("Your BattleCruiser has crashed into a Asteroid"); //removes the battlecruiser and asteroid out of the map
						gw.shipCrashedIntoAsteroid(); //should give a warning asking you to add new ship - Need fix as right now keeps saying 
						break; //ship already exits when you just removed it
					case 'h':
						System.out.println("Your BattleCruiser has crashed into a Enemy Flying Saucer"); //removes the battlecruiser and flying saucer
						gw.shipHitFlyingSaucer(); //should give a warning asking you to add new ship - need fix as right now keeps saying
						break; //ship already exits when you just removed it
					case 'x':
						gw.asteroidCollided(); //need fix - deletes every asteroids, infinite loop
						break;
					case 'w':
						System.out.println("Enemy Flying Saucer was crushed by a Asteroid"); //removes the asteroid and flying saucer
						gw.asteroidWhackedFlyingSaucer();
						break;
					case 't':
						gw.tick();
						break;
					case 'p':
						gw.print();
						break;
					case 'm':
						System.out.println("This is the map:");
						gw.map();
						break;
					case 'q':
						System.out.println("Would you like to exit out of this game? Press Okay, 'o', to confirm"); //ask if you are sure you want to quit the game
						break;
					case 'o':
						System.out.println("You have quit the game. Thanks for playing.");
						gw.quit();
						break;
						//add code to handle rest of the commands
					default:
						System.out.println("Invalid Key");
				}//switch
			}//actionPerformed
		});//new ActionListener()
	}//addActionListener*/

	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
}//play