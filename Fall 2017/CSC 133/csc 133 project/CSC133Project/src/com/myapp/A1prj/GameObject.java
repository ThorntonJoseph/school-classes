package com.myapp.A1prj;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.*;
public abstract class GameObject {
	private static final int width = 1024;
	private static final int height = 768;
	public static final int speedconstant=1;
	private int size,color;
	private Rectangle2D bounds;
	private Location L;
	private Random rn = new Random();
	
	// constructs object of this type
	public GameObject() {
		setlocation(new Location(rn.nextInt(width), rn.nextInt(height)));
	}
	public void setsize(int size) {
		this.size=size;
		bounds=new Rectangle2D(L.getx(), L.gety(), size, size);
	}
	public int getsize() {
		return size;
	}
	
	public Location getlocation() {
		return L;
	}
	// set location of this object
	public void setlocation(Location l) {
			L=l;
			bounds=new Rectangle2D(L.getx(), L.gety(), size, size);	
	}
	// returns this objects color
	public int getcolor() {
		return color;
	}
	// sets this objects color
	public void setcolor(int color) {
		this.color=color;
	}
	public Rectangle2D getbounds() {
		return this.bounds;
	}
	
	public String toString() {
	 return "Location: " + this.getlocation().toString() +" Color:"+ "["+ ColorUtil.red(color)+","+ColorUtil.green(color)+
			 ","+ ColorUtil.blue(color)+"]";
			 }
}
