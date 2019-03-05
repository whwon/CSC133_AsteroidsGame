I presented on Tuesday 5/8/18.

I would like to add my points into my Final Exam grade

Presented in class without any problems. If there is any problem running this i can provide another version.

One of the unique functions to my game is the added keybind that allows you to hold down
your arrow keys without disrupting the other buttons by scrolling through them. So to implement them
you first have your regular key binding code inside Game:

public class Game extends Form implements Runnable {
	public Game () {
		
		//Key bind the up arrow key
		addKeyListener(-91, i);
		
		//key bind the down arrow key
		addKeyListener(-92, d);
		
		//key bind the left arrow key
		addKeyListener(-93, l);
		
		//key bind the right arrow key
		addKeyListener(-94, r);
	}

Outside the method Game but inside the Game Class. The keyPressed overrides the
KeyListener once you let go of the key that you are holding.

	@Override
	public void keyPressed(int KeyCode) {
		
		//Increase speed
		switch(KeyCode) {
			case -91:keyReleased(-91);
			break;
		}
		//Decrease Speed
		switch(KeyCode) {
			case -92:keyReleased(-92);
			break;
		}
		//Turn Left
		switch(KeyCode) {
			case -93:keyReleased(-93);
			break;
		}
		//Turn Right
		switch(KeyCode) {
			case -94:keyReleased(-94);
			break;
		}
	}

Hope this code can help future students to help and make their ship manueuver a lot smoother
and easier.