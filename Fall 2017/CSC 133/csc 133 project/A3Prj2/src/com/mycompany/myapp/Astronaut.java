package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class Astronaut extends Opponents implements IMoving,ISelectable{
	//set variables
	private int Health;
	private int fade=50;
	private boolean selected=false;
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
		setcolor(ColorUtil.rgb(ColorUtil.red(this.getcolor())-fade,0, 0));
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
	public void draw(Graphics g) {
		g.setColor(this.getcolor());
		g.fillTriangle((int)getlocation().getx(), (int)getlocation().gety()-(getsize()/2),
				(int)getlocation().getx()-(getsize()/2),(int)getlocation().gety()+getsize()/2,
				(int) getlocation().getx()+(getsize()/2),(int) getlocation().gety()+(getsize()/2));
	}
	public boolean collidesWith(ICollider otherObject) {
		return false;
	}
	public void handleCollision(ICollider otherObject, GameWorld gw) {
		// TODO Auto-generated method stub
		
	}
	public void setSelected(boolean yesNo) {
		selected = yesNo;
		
	}
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return selected;
	}
	public boolean contains(Location pCmpRelPrnt, Location  pPtrRelPrnt) {
		if(pPtrRelPrnt.getx()<super.getlocation().getx()+(getsize()/2)&& pPtrRelPrnt.getx()>super.getlocation().getx()-(getsize()/2)&&
				pPtrRelPrnt.gety()<super.getlocation().gety()+(getsize()/2)&&pPtrRelPrnt.gety()>super.getlocation().gety()-(getsize()/2)) {
			return true;
		}else {
			return false;
		}
			
	}
	// heals this astronaut
	public void healme() {
		this.Health++;
		changespeed();
		setcolor(ColorUtil.rgb(ColorUtil.red(this.getcolor())+fade,0, 0));
	}
	public void draw(Graphics g, Location pCmpRelPrnt) {
		g.setColor(ColorUtil.red(255));
		g.drawLine((int)super.getlocation().getx(), (int)super.getlocation().gety()-(getsize()/2), (int)super.getlocation().getx()-(getsize()/2),(int) super.getlocation().gety()+(getsize()/2));
		g.drawLine((int)super.getlocation().getx()-(getsize()/2), (int)super.getlocation().gety()+(getsize()/2), (int)super.getlocation().getx()+(getsize()/2),(int) super.getlocation().gety()+(getsize()/2));
		g.drawLine((int)super.getlocation().getx()+(getsize()/2), (int)super.getlocation().gety()+(getsize()/2), (int)super.getlocation().getx(),(int) super.getlocation().gety()-(getsize()/2));
		
	}

}
