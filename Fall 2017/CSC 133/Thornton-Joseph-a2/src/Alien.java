package com.mycompany.a2;


import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Alien extends Opponents implements IMoving{
	private Random rn = new Random();
	public Alien() {
		//set color
		super.setcolor(ColorUtil.BLUE);
	// create object at random location
		
	}
	//this objects color cannot be changed after created
	public void setcolor(int color) {
		
	}
	// this objects speed cannot change;
	public void setspeed() {
		
	
	}
	public String toString() {
		String parent =super.toString();
		return "Alein: "+ parent;
	}
}
