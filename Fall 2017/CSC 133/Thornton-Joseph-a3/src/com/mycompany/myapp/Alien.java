package com.mycompany.myapp;


import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.util.UITimer;

public class Alien extends Opponents {
	private boolean fertile;
	private boolean attack;

	public Alien() {
		//set color
		super.setcolor(ColorUtil.BLUE);
		fertile=true;
		attack=true;
	// create object at random location
		
	}
	//this objects color cannot be changed after created
	public void setcolor(int color) {
		
	}
	// this objects speed cannot change;
	public void setspeed() {
		
	
	}
	public String toString() {
		String parent =super.toString();
		return "Alein: "+ parent;
	}
	public void setfertile(boolean t) {
		fertile=t;
		if(fertile==false) {
			super.setcolor(ColorUtil.YELLOW);
		}else
			super.setcolor(ColorUtil.BLUE);
		
	}
	//returns if the alien is fertile
	public boolean getfertile() {
		return fertile;
	}
	public boolean getattack() {
		return attack;
	}
	public void setattack(boolean t) {
		attack=t;
	}
	public void draw(Graphics g) {
		g.setColor(this.getcolor());
		g.fillArc((int)getlocation().getx()-(getsize()/2), (int) getlocation().gety()-(getsize()/2),getsize(), 
				getsize(), 0, 365);
		if(getattack()) {
			g.setColor(ColorUtil.GREEN);
			g.fillArc((int)getlocation().getx()-5, (int)getlocation().gety()-5, 10, 10, 0, 360);
		}
	}
	public boolean collidesWith(ICollider otherObject) {
		if(contains(((GameObject)otherObject).getlocation().getx(),((GameObject)otherObject).getlocation().gety())&&this!=otherObject) 
		{
			return true;
		
		}
		return false;
	}
	public void handleCollision(ICollider otherObject,GameWorld gw) {
		if(otherObject instanceof Alien && getfertile()&&((Alien)otherObject).getfertile()) 
		{
			setfertile(false);
			((Alien)otherObject).setfertile(false);
			gw.spawnAlien();
		}
		if(otherObject instanceof Astronaut) 
		{
			if(getattack()){
				setattack(false);
				gw.fight((Astronaut)otherObject);
			}
		}
	}
}
