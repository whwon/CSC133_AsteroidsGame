package com.mycompany.a2;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.Container;
import com.mycompany.interfaces.IGameWorld;

public class MapView extends Container implements Observer {
	
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		IGameWorld gw = (IGameWorld) arg;
		
		
		
	}

}
