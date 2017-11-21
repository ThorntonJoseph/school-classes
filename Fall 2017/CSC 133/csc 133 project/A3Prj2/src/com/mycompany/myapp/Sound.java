package com.mycompany.myapp;
import java.io.IOException;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
public class Sound {
	private Media m;
	public Sound(String fileName) {
		//sound method
			try {
					InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/"+fileName);
					m= MediaManager.createMedia(is, "audio/wav");
				}
				catch (IOException e) {
					e.printStackTrace();
				}	
	}
	public void play() {
		if(m!=null) {
			m.setTime(0);
			m.play();
		}

	}
}
