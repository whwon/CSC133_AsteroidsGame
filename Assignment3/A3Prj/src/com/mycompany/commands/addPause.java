package com.mycompany.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.UITimer;
import com.mycompany.a3.Game;
import com.mycompany.a3.GameWorld;

public class addPause extends Command{
	UITimer timeRef;
	GameWorld gwRef;
	Game gRef;
	public addPause(UITimer time, GameWorld gw, Game g) {
		/*
		 * doing this also allows the gameworld to have access to the timer and thus mapview via gameworld.
		 * also alter this to use a gameworld proxy as it breaks encapsualtion to reference gameworld directly.
		 */
		super("pause");
		timeRef = time;			//timer reference, removes need for global timer in game
		gwRef = gw;				//reference to the game world, for data purposes.
		gRef = g;				//reference to the game, for timer functions.
	}
	
	public void actionPerformed(ActionEvent E) {
		//if the game is now in play then
		if(gwRef.isPaused()) {
			gRef.startTime(timeRef);	//start the game timer
			gwRef.setPaused();			//flip-flop the pause in gw(T) => F
			gRef.notPaused();
			System.out.println("Game paused");
		}
		//if the game is now paused then
		else {
			gRef.stopTime(timeRef);		//stop the game timer
			gwRef.setPaused();			//flip-flop the pause in gw(F) => T
			gRef.isPaused();
			System.out.println("Game resumed");
		}
	}
	
}
