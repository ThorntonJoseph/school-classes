package com.myapp.A1prj;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Astronaut extends Opponents implements Move{
	//set variables
	private int Health;
	private int fade=50;
	//create an astronaut
	public Astronaut() {
	//set variables
		int x=1024;
		int y=768;
	//set speed
		super.setspeed(5*speedconstant);
	//set color
		Health =5;
		setcolor(ColorUtil.rgb(255, 0, 0));
	// create object at random location
		Random rn = new Random();
		super.setsize(100);
		super.setlocation(new Location(rn.nextInt(x), rn.nextInt(y)));
	// set direction
		super.setdirection(rn.nextInt(359));
	}
	// when this object is attacked it takes damage and color fades
	public void fight() {
		Health--;
		changespeed();
		setcolor(ColorUtil.rgb(super.getcolor()-fade, 0, 0));
	}
	// returns health
	public int gethealth() {
		return Health;
	}
	// this object is will move by itself
	public void Moveit() {
		
	}
	//this objects color can change
	public void setcolor(int color) {
		
	}
	// sets speed of object
	private void changespeed() {
		super.setspeed(Health*speedconstant);
	}
	
	//to string method for this object
	public String ToString() {
		return ("Location: " + getlocation().ToString() +" Color: " + super.getcolor() + " size: "+ super.getsize()+ " Speed: " +super.getspeed()
				+ " Direction: " +super.getdirection()+ " Health: " +Health );
	}

}
