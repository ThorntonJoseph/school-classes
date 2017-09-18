package com.myapp.A1prj;
import java.util.Random;
import java.util.ArrayList;
public class GameWorld {
	// set variables
	private int score;
	private int numastronauts=4;
	private int numaliens=3;
	private int maxnumaliens=50;
	private int numAstronautsaved;
	private int numAliensin;
	private ArrayList Astronauts = new ArrayList();
	private ArrayList Aliens = new ArrayList();
	private SpaceShip player;
	
	// creates the game world
	public void init() {
		
		 
		 // create the players space ship
		 player = new SpaceShip();
		 // instantiates all astronauts
		 for(int i=0;i<numastronauts;i++) {
			 Astronauts.add(new Astronaut());
		 }
		 
		 // instantiates all Aliens
		 for(int i=0;i<numaliens;i++) {
			 Aliens.add(new Alien());
		 }
		 
		 
		 // creates the player ship
		SpaceShip player = new SpaceShip();
	}
	// code e opens spaceship door
	public void expand() {
		player.opendoor();
	}
	//code o transfer player to random astronaut location
	public void transfer() {
		Random rn=new Random();
		int astro=rn.nextInt(3);
		Object temp =Astronauts.get(astro);
		if(temp instanceof Astronaut) {
			temp = (Astronaut)temp;
			player.jumptolocation(((Astronaut) temp).getlocation());
		}
	}
	// code r move spaceship right
	public void moveright() {
		player.moveright();
	}
	// code l move spaceship left
	public void moveleft() {
		player.moveleft();
	}
	// code u move spaceship up
	public void moveup() {
		player.moveup();
	}
	//code c close spaceship door
	public void contract() {
		player.closedoor();
		
	}
	// code d move spaceship down
	public void movedown() {
		player.movedown();
		
	}
	// code s open door and update score according to previous input
	public void openenter() {
		// checks for astronauts
		for (int i=0;i<numastronauts && Astronauts.get(i) instanceof Astronaut;i++) {
			Astronaut temp =(Astronaut) Astronauts.get(i);
			if(player.getbounds().contains(temp.getlocation().getx(),temp.getlocation().gety())) {
				score+= temp.gethealth()*10;
				Astronauts.remove(i);
			}
		}
			//checks for aliens
			for (int i=0;i<numastronauts && Aliens.get(i) instanceof Alien;i++) {
				Alien temp =(Alien) Astronauts.get(i);
				if(player.getbounds().contains(temp.getlocation().getx(),temp.getlocation().gety())) {
					score-= 50;
					Aliens.remove(i);
				}
		}
	}
	
	//code w alien collides with another alien
	public void pretenda() {
		// TODO Auto-generated method stub
		
	}
	//code f alien collides with astronaut
	public void pretendaa() {
		// TODO Auto-generated method stub
		
	}
	// code p prints game state score values
	public void gamestate() {
		// TODO Auto-generated method stub
		
	}
	// code m prints the map of current world state
	public void map() {
		// TODO Auto-generated method stub
		}
	//code t increments the clock
	public void clock() {
		// TODO Auto-generated method stub
		
	}
}
