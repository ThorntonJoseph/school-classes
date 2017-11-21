package com.mycompany.myapp;


public class Location {
	private double x,y;
	public Location(double x, double y) {
		this.x=x;
		this.y=y;
	}
	// return the object type location
	public Location getlocation() {
		return this;
	}
	// sets this object location to the incoming location
	public void setlocation(Location l) {
		this.x=Math.round(x*10.0)/10.0;
		this.y=Math.round(y*10.0)/10.0;
	}
	// prints out this location
	public String toString() {
		return ("("+x+","+y+")");
	}
	// returns the primitive type double x assosiated with this location
	public double getx() {
		return this.x;
	}
	// returns the primitive type double y assosiated with this location
	public double gety() {
		return this.y;
	}
}
