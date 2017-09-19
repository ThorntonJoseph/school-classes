package com.myapp.A1prj;
import java.util.Random;
import java.util.ArrayList;
public class GameWorld {
	// set variables
	private int score;
	private int numastronauts=4;
	private int numaliens=3;
	private int maxnumaliens=50;
	private int numAstronautsaved=0;
	private int numAliensin=0;
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
		System.out.println(player.toString());
	}
	//code o transfer player to random astronaut location
	public void transfer() {
		Random rn=new Random();
		int astro=rn.nextInt(3);
		Object temp =Astronauts.get(astro);
		if(temp instanceof Astronaut) {
			temp = (Astronaut)temp;
			System.out.println("OldLocation: " + player.toString());
			player.jumptolocation(((Astronaut) temp).getlocation());
			System.out.println("NewLocation: " + player.toString());
		}
	}
	// code r move spaceship right
	public void moveright() {
		System.out.println("OldLocation: " + player.toString());
		player.moveright();
		System.out.println("NewLocation: " + player.toString());
	}
	// code l move spaceship left
	public void moveleft() {
		System.out.println("OldLocation: " + player.toString());
		player.moveleft();
		System.out.println("NewLocation: " + player.toString());
	}
	// code u move spaceship up
	public void moveup() {
		System.out.println("OldLocation: " + player.toString());
		player.moveup();
		System.out.println("NewLocation: " + player.toString());
	}
	//code c close spaceship door
	public void contract() {
		player.closedoor();
		System.out.println(player.toString());
		
	}
	// code d move spaceship down
	public void movedown() {
		System.out.println("OldLocation: " + player.toString());
		player.movedown();
		System.out.println("NewLocation: " + player.toString());
		
	}
	// code s open door and update score according to previous input
	public void openenter() {
		// checks for astronauts
		for (int i=0;i<numastronauts && Astronauts.get(i) instanceof Astronaut;i++) {
			Astronaut temp =(Astronaut) Astronauts.get(i);
			if(player.getbounds().contains(temp.getlocation().getx(),temp.getlocation().gety())) {
				score+= temp.gethealth()*10;
				numAstronautsaved++;
				Astronauts.remove(i);
				numastronauts--;
			}
		}
			//checks for aliens
			for (int i=0;i<numastronauts && Aliens.get(i) instanceof Alien;i++) {
				Alien temp =(Alien) Astronauts.get(i);
				if(player.getbounds().contains(temp.getlocation().getx(),temp.getlocation().gety())) {
					score-= 10;
					Aliens.remove(i);
					numaliens--;
					numAliensin++;
				}
		}
			System.out.println("the score is update use p to view status");
	}
	
	//code w alien collides with another alien
	public void pretenda() {
		if(numaliens<2) {
			System.out.println("There are not enough aliens to produce a child");
		}else {
			Aliens.add(new Alien());
			numaliens++;
			System.out.println("A new Alien has been spawned");
		}
	
		
	}
	//code f alien collides with astronaut
	public void pretendaa() {
		// checks for at least 1 alien and 1 astronaut if true fight insues
		if(numaliens>0 && numastronauts>0) {
			Random rn = new Random();
			int position=rn.nextInt(numastronauts);
			Astronaut temp=(Astronaut) Astronauts.get(position);
			temp.fight();
		// removes astronaut if he has been damaged to death
			if(temp.gethealth()<=0) {
				Astronauts.remove(position);
				numastronauts--;
			}
		//there are not Opponents to create a fight
		}else {
			System.out.println("not enough opponents to complete attack");
		}
		
	}
	// code p prints game state score values
	public void gamestate() {
		System.out.println("(1) Current Score: " + score +" (2)# of Astronauts Rescued: " + numAstronautsaved + " (3) # of Aliens entered: " + numAliensin);
		System.out.println("(4) # of Astronauts left: "+ numastronauts + " # of Aliens left: "+ numaliens);
	}
	// code m prints the map of current world state
	public void map() {
		// prints out player variables
		System.out.println(player.toString());
		//prints out astronaut variables
		for(int i=0;i<numastronauts;i++) {
			Astronaut temp= (Astronaut) Astronauts.get(i);
			System.out.println(temp.toString());
		}
		// prints out alien variables
		for(int i=0;i<numaliens;i++) {
			Alien temp= (Alien) Aliens.get(i);
			System.out.println(temp.toString());
		}
			
		}
	//code t increments the clock
	public void clock() {
		// moves astronauts
		for (int i=0;i<numastronauts;i++) {
			Astronaut temp = (Astronaut) Astronauts.get(i);
			temp.Moveit();
		}
		// moves aliens
		for (int i=0;i<numaliens;i++) {
			Alien temp = (Alien) Aliens.get(i);
			temp.Moveit();
		}
		System.out.println("The clock has ticked: all moving objects have moved use m to see new state");
		
	}
}
