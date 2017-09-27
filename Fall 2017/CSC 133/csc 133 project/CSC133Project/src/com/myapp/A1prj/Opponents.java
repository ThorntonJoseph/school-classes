package com.myapp.A1prj;

import java.util.Random;
public abstract class Opponents extends GameObject {
	private int speed,direction;
	private int high=50;
	private int low =20;
	private Random rn = new Random();
	// constructs opponent
	public Opponents() {
		super.setsize(rn.nextInt(high-low)+low);
		setdirection(rn.nextInt(359));
		setspeed(5*speedconstant);
	}
	// this objects size is unchangeable
	public void setsize(int size) {
		
	}
	// definition for how object move
	public void Moveit() {
		double deltax,deltay;
		double theta=((double) getdirection()/180)*Math.PI;
		deltax=Math.round(getspeed()*Math.cos(theta)*10.0)/10.0;
		deltay=Math.round(getspeed()*Math.sin(theta)*10.0)/10.0;
		Location newlocation=new Location(super.getlocation().getx()+deltax,super.getlocation().gety()+deltay);
		this.setlocation(newlocation);
		setdirection(rn.nextInt(359));
	}
	// set direction
	public void setdirection(int direction) {
		this.direction=direction;
	}
	// get direction
	public int getdirection() {
		return direction;
	}
	public void setspeed(int speed) {
		this.speed=speed;
	}
	public int getspeed() {
		return speed;
	}
	public String toString() {
		String parent=super.toString();
		String me = " size: "+ this.getsize()+ " speed: "+ getspeed()+" direction: "+
		direction;
	return parent+me;
	}
}
