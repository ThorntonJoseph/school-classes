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
		//set door state
		doorstate=Closed;
	}
	
	// this objects size can change according to game
	public void setsize(int size) {
		if(size>1024) {
		// do nothing
		}
		else if(size<50) {
		// do nothing
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
		closedoor();
		
	}
	
	public void closedoor() {
		doorstate=Closed;
		
	}
	// expand space ship door
	public void expand() {
		setsize(super.getsize()+50);
	}
	// expand space ship door
	public void contract() {
		setsize(super.getsize()-50);
	}
}
