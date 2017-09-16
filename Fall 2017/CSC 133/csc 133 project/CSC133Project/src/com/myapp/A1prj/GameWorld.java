package com.myapp.A1prj;

public class GameWorld {
	// set variables
	private int numastronauts=4;
	private int numaliens=3;
	private int maxnumaliens=50;
	private int numAstronautsaved;
	private int numAliensin;
	private Astronaut[] Astronauts;
	private Alien[] Aliens;
	
	// creates the game world
	public void init() {
		 Astronauts =new Astronaut[numastronauts];
		 Aliens = new Alien[maxnumaliens];
		 
		 // instantiates all astronauts
		 for(int i=0;i<numastronauts;i++) {
			 Astronauts[i]=new Astronaut();
		 }
		 
		 // instantiates all Aliens
		 for(int i=0;i<numastronauts;i++) {
			 Aliens[i]=new Alien();
		 }
		 
		 // creates the player ship
		SpaceShip player = new SpaceShip();
	}
	//
	public void expand() {
		
	}
	
	

}
