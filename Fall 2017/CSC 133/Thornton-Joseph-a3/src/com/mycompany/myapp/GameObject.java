package com.mycompany.myapp;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
public abstract class GameObject implements IDrawable{
	//set variables
	private static int width = 1024;
	private static int height = 768;
	private static int locx,locy;
	public static final int speedconstant=1;
	private int size,color;
	private Location L;
	private Random rn = new Random();
	
	// constructs object of this type
	public GameObject() {
		setlocation(new Location(rn.nextInt(width)+locx, rn.nextInt(height)+locy));
	}
	// setter for contained size
	public static void setframe(int heighti,int widthi,int locxi,int locyi) {
		height=heighti;
		width=widthi;
		locx=locxi;
		locy=locyi;
	}
	//getter for contained size
	public int getheight() {
		return height;
	}
	public int getwidth() {
		return width;
	}
	public void setsize(int size) {
		this.size=size;
	}
	public int getsize() {
		return size;
	}
	
	public Location getlocation() {
		
		return L;
	}
	// set location of this object
	public void setlocation(Location l) {
		 if(l.getx()<(width+locx) && l.getx()>locy
				 && l.gety()<(height+locy)&&l.gety()>locy){
			 L=l;
		 }
	}
	// returns this objects color
	public int getcolor() {
		return color;
	}
	// sets this objects color
	public void setcolor(int color) {
		this.color=color;
	}
	
	public String toString() {
	 return "Location: " + this.getlocation().toString() +" Color:"+ "["+ ColorUtil.red(color)+","+ColorUtil.green(color)+
			 ","+ ColorUtil.blue(color)+"]";
			 }
	public boolean contains(double x,double y) {
		if(x>=(getlocation().getx()-(getsize()/2))&& x<=(getlocation().getx()+(getsize()/2))
				&& y>=(getlocation().gety()-(getsize()/2)) && y<=(getlocation().gety()+(getsize()/2))) {
			return true;
		}else
			return false;
	}
}
