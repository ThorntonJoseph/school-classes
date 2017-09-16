package com.myapp.A1prj;
import com.codename1.charts.util.ColorUtil;
public abstract class GameObject {
	private int size,color;
	public static final int speedconstant=1;
	private Location L;
	
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
		L.setlocation(l);
	}
	// returns this objects color
	public int getcolor() {
		return color;
	}
	// sets this objects color
	public void setcolor(int color) {
		this.color=color;
	}
		
}
