package com.myapp.A1prj;

	import java.io.*;
	import com.codename1.util.MathUtil;
public abstract class rescuers extends GameObject implements Guided {
	final float moveconstant=10;
	private Location currentLocation;
	private double deltax,deltay;
	
	
	// moves object left
	public void moveleft() {
		 deltax=-5*speedconstant;
		 deltay=0;
		 currentLocation=super.getlocation();
		 currentLocation=Location.add(currentLocation, new Location(deltax,deltay));
		 super.setlocation(currentLocation);
	 }
	
	// moves object right
	 public void moveright() {
		 deltax=5*speedconstant;
		 deltay=0;
		 currentLocation=super.getlocation();
		 currentLocation=Location.add(currentLocation, new Location(deltax,deltay));
		 super.setlocation(currentLocation);
	 }
	 
	 //moves object up
	 public void moveup() {
		 deltax=0;
		 deltay=5*speedconstant;
		 currentLocation=super.getlocation();
		 currentLocation=Location.add(currentLocation, new Location(deltax,deltay));
		 super.setlocation(currentLocation);
	 }
	 
	 // moves object down
	 public void movedown() {
		 deltax=0;
		 deltay=-5*speedconstant;
		 currentLocation=super.getlocation();
		 currentLocation=Location.add(currentLocation, new Location(deltax,deltay));
		 super.setlocation(currentLocation);
	 }
	 
	 // jumps to location
	 public void jumptolocation(Location l) {
		 super.setlocation(l);
	 }
	 
}
