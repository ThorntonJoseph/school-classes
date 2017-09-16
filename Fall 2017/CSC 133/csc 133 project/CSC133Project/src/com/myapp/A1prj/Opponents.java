package com.myapp.A1prj;
import java.util.Random;
public abstract class Opponents extends GameObject {
	private int speed,direction;
	private int high=50;
	private int low =20;
	public Opponents() {
	Random rn = new Random();
	super.setsize(rn.nextInt(high-low)+low);
	}
	// this objects size is unchangeable
	public void setsize(int size) {
		
	}
	public void setdirection(int direction) {
		this.direction=direction;
	}
	public int getdirection() {
		return direction;
	}
	public void setspeed(int speed) {
		this.speed=speed;
	}
	public int getspeed() {
		return speed;
	}
}
