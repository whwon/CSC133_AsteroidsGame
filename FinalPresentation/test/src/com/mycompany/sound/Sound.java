package com.mycompany.sound;

import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound{
	private Media m;
	
	public Sound(String fileName) {
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(),"/"+fileName);
			
			m = MediaManager.createMedia(is, "audio/wav");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play(int vol) {
		m.setTime(0);
		m.setVolume(vol);
		m.play();
	}

}
