package com.mycompany.myapp;
import java.util.Random;
public abstract class Opponents extends GameObject implements IMoving,ICollider {
	private int speed,direction;
	private int high=50;
	private int low =20;
	private static int fertiletimer = 200;
	private static int attacktimer=100;
	public static int directiontimer=20;
	public int directiontime;
	private int attacktime;
	private int fertiletime;
	private Random rn = new Random();
	// constructs opponent
	public Opponents() {
		super.setsize(rn.nextInt(high-low)+low);
		fertiletime=0;
		attacktime=0;
		directiontime=rn.nextInt(10);
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
		directiontime++;
		//changes the direction of an object randomly
		if(directiontime>=directiontimer) {
			directiontime=rn.nextInt(10)+1;
			setdirection(rn.nextInt(365));
		}
		// sets attack and fertile for aliens dependent on main timer
		if(this instanceof Alien) {
			// sets fertile based on timer
			if(((Alien)this).getfertile()==false) {
				fertiletime++;
				if(fertiletime>=fertiletimer) {
					fertiletime=0;
					((Alien)this).setfertile(true);
				}
			}
			//sets attack based on timer
			if(((Alien)this).getattack()==false) {
				attacktime++;
				if(attacktime>=attacktimer) {
					attacktime=0;
					((Alien)this).setattack(true);
				}
			}
		}
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
