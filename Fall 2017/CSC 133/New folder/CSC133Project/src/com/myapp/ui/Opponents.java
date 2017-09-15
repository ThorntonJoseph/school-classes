package com.myapp.ui;
import java.util.Random;
public abstract class Opponents extends GameObject implements Move {
	int speed,direction;
	private int high=50;
	private int low =20;
	public Opponents() {
	Random rn = new Random();
	super.setsize(rn.nextInt(high-low)+low);
	}
	public void Moveit() {
		
	}
	public void setsize() {
		
	}
}
