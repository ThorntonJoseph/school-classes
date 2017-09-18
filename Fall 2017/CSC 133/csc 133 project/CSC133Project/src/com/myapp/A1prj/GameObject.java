package com.myapp.A1prj;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.*;
public abstract class GameObject {
	private int size,color;
	private Rectangle2D bounds;
	public static final int speedconstant=1;
	private Location L;
	
	public void setsize(int size) {
		this.size=size;
		bounds.setBounds(L.getx(), L.gety(), size/2, size/2);
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
		bounds.setBounds(L.getx(), L.gety(), size/2, size/2);
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
}
