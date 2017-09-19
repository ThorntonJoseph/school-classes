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
	// definition for how object movew
	public void Moveit() {
		double deltax,deltay;
		double theta;
		theta=rn.nextDouble();
		deltax=Math.cos(theta);
		deltay=Math.sin(theta);
		Location newlocation=Location.add(super.getlocation(),new Location(deltax,deltay));
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
		String me = " color: "+ this.getcolor()+" size: "+ this.getsize()+ " speed: "+ getspeed()+" direction: "+
		direction;
	return parent+me;
	}
}
