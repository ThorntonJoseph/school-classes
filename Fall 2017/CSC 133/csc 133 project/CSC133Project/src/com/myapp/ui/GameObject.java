package com.myapp.ui;
import com.codename1.charts.util.ColorUtil;
public abstract class GameObject {
	private Integer size,color;
	private Point L;
	
	public void setsize(int size) {
		this.size=size;
	}
	public Point getlocation() {
		return this.L;
	}
	public void setlocation(float x,float y) {
		L.setpoint(x, y);
	}
	public int getcolor() {
		return color;
	}
	public void setcolor(int color) {
		this.color=color;
	}
	
	
}
