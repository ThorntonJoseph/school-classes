package com.myapp.A1prj;

import java.util.Random;
import java.util.ArrayList;
public class GameWorld {
	// set variables
	private int score;
	private int numastronauts=4;
	private int numaliens=3;
	private int numAstronautsaved=0;
	private int numAliensin=0;
	private ArrayList Opponents = new ArrayList();
	private SpaceShip player;
	
	// creates the game world
	public void init() {
		
		 
		 // create the players space ship
		 player = new SpaceShip();
		 // instantiates all astronauts
		 for(int i=0;i<numastronauts;i++) {
			 Opponents.add(new Astronaut());
		 }
		 
		 // instantiates all Aliens
		 for(int i=0;i<numaliens;i++) {
			 Opponents.add(new Alien());
		 }
		 
		 // creates the player ship
		SpaceShip player = new SpaceShip();
	}
	// code e opens spaceship door
	public void expand() {
		player.expand();
		System.out.println(player.toString());
	}
	
	// code a transfer player to random alien location
	public void transferalien() {
		if(numaliens<=0) {
			System.out.println("there is no alien to teleport to");
		}else {
		Random rn=new Random();
		int rando=rn.nextInt(numaliens+numastronauts);
		Object temp =Opponents.get(rando);
		while(temp instanceof Alien==false) {
			rando=rn.nextInt(numaliens+numastronauts);
			temp =Opponents.get(rando);
		}
		temp =(GameObject)temp;
		System.out.println("OldLocation: " + player.toString());
		player.jumptolocation(((GameObject) temp).getlocation());
		System.out.println("NewLocation: " + player.toString());
		}
	}
	
	//code o transfer player to random astronaut location
	public void transferastronaut() {
		if(numastronauts<=0) {
			System.out.println("there is no astronaut to teleport to");
		}else {
		Random rn=new Random();
		int rando=rn.nextInt(numaliens+numastronauts);
		Object temp =Opponents.get(rando);
		while(temp instanceof Astronaut==false) {
			rando=rn.nextInt(numaliens+numastronauts);
			temp =Opponents.get(rando);
		}
		temp = (GameObject)temp;
		System.out.println("OldLocation: " + player.toString());
		player.jumptolocation(((GameObject) temp).getlocation());
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
		player.contract();
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
		for (int i=0;i<numastronauts+numaliens;i++) {
			GameObject temp =(GameObject) Opponents.get(i);
			if(player.getbounds().contains(temp.getlocation().getx(),temp.getlocation().gety())) {
				if(temp instanceof Astronaut) {
					score+= ((Astronaut) temp).gethealth()*10;
					numAstronautsaved++;
					numastronauts--;
				}else if(temp instanceof Alien) {
					score-=10;
					numAliensin++;
					numaliens--;
				}
				Opponents.remove(i);
				
			}
			System.out.println("not contained");
		}
		
			System.out.println("the score is update use p to view status");
	}
	
	//code w alien collides with another alien
	public void pretenda() {
		if(numaliens<2) {
			System.out.println("There are not enough aliens to produce a child");
		}else {
			Opponents.add(new Alien());
			numaliens++;
			System.out.println("A new Alien has been spawned");
		}
	
	}
	//code f alien collides with astronaut
	public void pretendaa() {
		// checks for at least 1 alien and 1 astronaut if true fight insues
		if(numaliens>0 && numastronauts>0) {
			Random rn = new Random();
			int rando=rn.nextInt(numastronauts+numaliens);
			GameObject temp=(GameObject) Opponents.get(rando);
			while(temp instanceof Astronaut==false) {
				rando=rn.nextInt(numastronauts+numaliens);
				temp=(GameObject)Opponents.get(rando);
			}
			((Astronaut) temp).fight();
		// removes astronaut if he has been damaged to death
			if(((Astronaut) temp).gethealth()<=0) {
				Opponents.remove(rando);
				numastronauts--;
			}
		System.out.println("an astronaut has been damaged view new status with m");
		//there are not enough Opponents to create a fight
		}else {
			System.out.println("not enough opponents to complete attack");
		}
		
	}
	// code p prints game state score values
	public void gamestate() {
		System.out.println("(1) Current Score: " + score +" (2)# of Astronauts Rescued: " + numAstronautsaved + " (3) # of Aliens entered: " + numAliensin);
		System.out.println("(4) # of Astronauts left: "+ numastronauts + " (5) # of Aliens left: "+ numaliens);
	}
	// code m prints the map of current world state
	public void map() {
		// prints out player variables
		System.out.println(player.toString());
		//prints out astronaut variables
		for(int i=0;i<numastronauts+numaliens;i++) {
			GameObject temp= (GameObject) Opponents.get(i);
			if (temp instanceof Astronaut) {
				System.out.println(temp.toString());
			}
		}
		// prints out alien variables
		for(int i=0;i<numaliens+numastronauts;i++) {
			GameObject temp= (GameObject) Opponents.get(i);
			if(temp instanceof Alien) {
				System.out.println(temp.toString());
			}
		}
			
		}
	
	//code t increments the clock
	public void clock() {
		// moves Opponents
		for (int i=0;i<numastronauts+numaliens;i++) {
			Opponents temp = (Opponents) Opponents.get(i);
			temp.Moveit();
		}
		System.out.println("The clock has ticked: all moving objects have moved use m to see new state");
	}
}
