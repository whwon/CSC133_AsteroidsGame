package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.lang.String;

public class Game extends Form {
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	private void play () {
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
	}//addActionListener
}//play