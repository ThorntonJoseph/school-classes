package com.myapp.A1prj;


public class Location {
	private double x,y;
	public Location(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public Location getlocation() {
		return this;
	}
	public void setlocation(Location l) {
		this.x=x;
		this.y=y;
	}
	public static Location add(Location l1, Location l2) {
		return new Location(Math.round(l1.x*10.0)/10.0+Math.round(l2.x*10.0)/10.0,Math.round(l1.y*10.0)/10.0+
				Math.round(l2.y*10.0)/10.0);
	}
	public String toString() {
		return ("("+x+","+y+")");
	}
	public double getx() {
		return this.x;
	}
	public double gety() {
		return this.y;
	}
}
