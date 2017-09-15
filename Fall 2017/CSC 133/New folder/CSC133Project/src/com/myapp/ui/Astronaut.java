package com.myapp.ui;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Astronaut extends Opponents{
	private int Health;
	private int Constant =1;
	private int fade=50;
	public Astronaut() {
		//set speed
		speed=Health*Constant;
		//set color
		Health =5;
		super.setcolor(ColorUtil.rgb(255, 0, 0));
		// create object at random location
		Random rn = new Random();
		int x=1024;
		int y=768;
		super.setsize(100);
		super.setlocation(rn.nextInt(x), rn.nextInt(y));
	}
	public void hit() {
		Health--;
		speed = Health*Constant;
		super.setcolor(ColorUtil.rgb(super.getcolor()-fade, 0, 0));
	}

}
