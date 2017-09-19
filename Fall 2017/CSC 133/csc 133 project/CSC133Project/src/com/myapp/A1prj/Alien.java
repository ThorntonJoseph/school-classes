package com.myapp.A1prj;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Alien extends Opponents implements Move{
	private Location oldlocation,newlocation;
	private int x = 1024;
	private int y = 768;
	private Random rn = new Random();
	public Alien() {
	//set variables
		
	//set speed
		super.setspeed(5*speedconstant);
		//set color
		super.setcolor(ColorUtil.BLUE);
	// create object at random location
		Random rn = new Random();
		super.setlocation(new Location(rn.nextInt(x), rn.nextInt(y)));
		super.setsize(100);
		oldlocation=super.getlocation();
		//set direction 
		super.setdirection(rn.nextInt(359));
	}
	
	// tells the object to move
	public void Moveit() {
		double deltax,deltay;
		double theta;
		theta=rn.nextDouble();
		deltax=Math.cos(theta);
		deltay=Math.sin(theta);
		newlocation = oldlocation= Location.add(oldlocation,new Location(deltax,deltay));
		this.setlocation(newlocation);
	}
	//this objects color cannot be changed after created
	public void setcolor(int color) {
		
	}
	// this objects speed cannot change;
	public void setspeed() {
		
	
	}
	//overwrites tostring method
	public String toString() {
		return ("Alien Location: " + super.getlocation().toString() +" Color: " + super.getcolor() + " Size: " + 
				super.getsize() + " Speed: " + super.getspeed() + " Direction: " + getdirection());
	}
	
}
