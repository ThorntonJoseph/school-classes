package com.mycompany.myapp;
public abstract class rescuers extends GameObject implements IGuided{
	final float moveconstant=10;
	private Location currentLocation;
	private double deltax,deltay;
	
	public rescuers() {
		super();
	}
	
	// moves object left
	public void moveleft() {
		 deltax=-5*moveconstant;
		 deltay=0;
		 currentLocation=new Location(super.getlocation().getx()+deltax,super.getlocation().gety()+deltay);
	 	 super.setlocation(currentLocation);
	 }
	
	// moves object right
	 public void moveright() {
		 deltax=5*moveconstant;
		 deltay=0;
		 currentLocation=new Location(super.getlocation().getx()+deltax,super.getlocation().gety()+deltay);
		 super.setlocation(currentLocation);
	 }
	 
	 //moves object up
	 public void moveup() {
		 deltax=0;
		 deltay=-5*moveconstant;
		 currentLocation=new Location(super.getlocation().getx()+deltax,super.getlocation().gety()+deltay);
		 super.setlocation(currentLocation);
	 }
	 
	 // moves object down
	 public void movedown() {
		 deltax=0;
		 deltay=5*moveconstant;
		 currentLocation=super.getlocation();
		 currentLocation=new Location(super.getlocation().getx()+deltax,super.getlocation().gety()+deltay);
		 super.setlocation(currentLocation);
	 }
	 
	 // jumps to location
	 public void jumptolocation(Location l) {
		 super.setlocation(l);
	 }
	 
}
