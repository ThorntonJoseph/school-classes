package com.mycompany.myapp;
import java.util.*;
import com.codename1.ui.*;
public class ScoreView extends Container implements Observer {
	private static ScoreView sv;
	// impliments singeton design
	public ScoreView(GameWorld gw) {
		gw.addObserver(this);
	}
	
	
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}

}
