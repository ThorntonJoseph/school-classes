package com.mycompany.a1;


import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Astronaut extends Opponents implements Move{
	//set variables
	private int Health;
	private int fade=50;
	private Random rn = new Random();
	//create an astronaut
	public Astronaut() {
	//set speed
		Health=5;
		setcolor(ColorUtil.rgb(255, 0, 0));
	}
	// when this object is attacked it takes damage and color fades
	public void fight() {
		Health--;
		changespeed();
		setcolor(ColorUtil.rgb(ColorUtil.red(this.getcolor())-fade, 0, 0));
	}
	// returns health
	public int gethealth() {
		return Health;
	}
	// this object is will move by itself
	
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
		String parent = super.toString();
		String me = " Health: "+Health;
		return "Astronaut: "+parent+me;
	}

}
