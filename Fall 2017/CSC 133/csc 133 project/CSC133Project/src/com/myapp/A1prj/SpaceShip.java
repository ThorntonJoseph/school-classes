package com.myapp.A1prj;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
public class SpaceShip extends rescuers{
	// set variables
	//door state variables
	public static final boolean Closed = false;
	public static final boolean Open = true;
	boolean doorstate;
	public SpaceShip() {
		//set color
		super.setcolor(ColorUtil.GREEN);
		// create object at random location
		Random rn = new Random();
		int x=1024;
		int y=768;
		Location alright = new Location(rn.nextInt(x),rn.nextInt(y));
		super.setlocation(alright);
		super.setsize(100);
		
		//set door state
		doorstate=Closed;
	}
	
	// this objects size can change according to game
	public void setsize(int size) {
		if(size>1024) {
			super.setsize(1024);
		}
		else if(size<50) {
			super.setsize(50);
		}
		else {
			super.setsize(size);
		}
	}
	
	// this objects color cannot change
	public void setcolor(int color) {
		
	}
	
	//controls for opening and closing the space ship door
	public void opendoor() {
		doorstate=Open;
		super.setsize(150);
	}
	
	public void closedoor() {
		doorstate=Closed;
		super.setsize(100);
	}
	public String toString() {
		return (this.getlocation().toString()+ " Color="+this.getcolor()+" size="+this.getsize());
	}
	
	
}
