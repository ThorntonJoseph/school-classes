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
		return new Location(l1.x+l2.x,l1.y+l2.y);
	}
	public String toString() {
		return ("Loc=("+x+","+y+")");
	}
	public double getx() {
		return this.x;
	}
	public double gety() {
		return this.y;
	}
}
