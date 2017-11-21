package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
public class SpaceShip extends rescuers{
	// set variables
	//door state variables
	public static final boolean Closed = false;
	public static final boolean Open = true;
	private static SpaceShip SS;
	boolean doorstate;
	// implements sigleton design pattern.
	private SpaceShip() {
		super.setsize(50);
		super.setcolor(ColorUtil.BLACK);
		//set door state
		doorstate=Closed;
	}
	public static SpaceShip getspaceship() {
		if(SS==null) {
			SS=new SpaceShip();
		}
		return SS;
	}
	
	// this objects size can change according to game
	public void setsize(int size) {
		if(size>super.getheight()-400) {
			//do nothing
		}
		else if(size<50) {
			//do nothing
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
		super.setcolor(ColorUtil.GREEN);
		
	}
	
	public void closedoor() {
		doorstate=Closed;
		super.setcolor(ColorUtil.BLACK);
	}
	// expand space ship door
	public void expand() {
		setsize(super.getsize()+50);
	}
	// expand space ship door
	public void contract() {
		setsize(super.getsize()-50);
	}
	public String toString() {
		String parent=super.toString();
		String me = "SpaceShip: " + parent + " Size: " + super.getsize();
		return me;
		
	}
	public void draw(Graphics g) {
		g.setColor(this.getcolor());
		g.fillRect((int)getlocation().getx()-(getsize()/2), 
				(int)getlocation().gety()-(getsize()/2), getsize(), getsize());
	}

	
}
