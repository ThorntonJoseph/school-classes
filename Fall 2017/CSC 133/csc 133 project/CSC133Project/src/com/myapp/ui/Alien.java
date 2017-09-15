package com.myapp.ui;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Alien extends Opponents{
	public Alien() {
		//set color
		super.setcolor(ColorUtil.GREEN);
		// create object at random location
		Random rn = new Random();
		int x=1024;
		int y=768;
		super.setsize(100);
		super.setlocation(rn.nextInt(x), rn.nextInt(y));
	}
	
}
