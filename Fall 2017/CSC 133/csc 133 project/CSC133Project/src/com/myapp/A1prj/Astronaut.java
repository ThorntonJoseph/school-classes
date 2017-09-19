package com.myapp.A1prj;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Astronaut extends Opponents implements Move{
	//set variables
	private Location oldlocation,newlocation;
	private int Health;
	private int fade=50;
	private Random rn = new Random();
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
		super.setlocation(new Location(rn.nextInt(x), rn.nextInt(y)));
		super.setsize(100);
		
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
		double deltax,deltay;
		double theta;
		theta=rn.nextDouble();
		deltax=Math.cos(theta);
		deltay=Math.sin(theta);
		newlocation = oldlocation= Location.add(oldlocation,new Location(deltax,deltay));
		this.setlocation(newlocation);
	}
	//this objects color can change
	public void setcolor(int fade) {
		super.setcolor(fade);
	}
	// sets speed of object
	private void changespeed() {
		super.setspeed(Health*speedconstant);
	}
	
	//to string method for this object
	public String toString() {
		return ("Astronaut Location: " + getlocation().toString() +" Color: " + super.getcolor() + " size: "+ super.getsize()+ " Speed: " +super.getspeed()
				+ " Direction: " +super.getdirection()+ " Health: " +Health );
	}

}
