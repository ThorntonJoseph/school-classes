package com.mycompany.a2;


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
		this.x=Math.round(x*10.0)/10.0;
		this.y=Math.round(y*10.0)/10.0;
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
