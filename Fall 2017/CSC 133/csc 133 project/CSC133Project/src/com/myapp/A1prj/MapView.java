package com.mycompany.myapp;
import java.util.*;
import com.codename1.ui.*;
public class MapView extends Container implements Observer {
	// implements singleton design pattern.
	private static  MapView mv;
	public MapView(GameWorld gw) {
		gw.addObserver(this);
	}
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}

}
