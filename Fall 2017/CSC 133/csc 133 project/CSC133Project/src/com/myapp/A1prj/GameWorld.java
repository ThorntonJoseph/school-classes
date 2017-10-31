package com.myapp.A1prj;
import java.util.*;
// @formatter:on 
public class GameWorld extends Observable  {
	// set variables
	private int score=0;
	private int numastronauts=4;
	private int numaliens=3;
	private int numAstronautsaved=0;
	private int numAliensin=0;
	private int height = 768;
	private int width=1024;
	private GameObjectCollection Gameobjects = new GameObjectCollection();
	private String sound = "OFF";

	public void setheight(int height) {
		this.height=height;
	}
	public void setwidth(int width) {
		this.width=width;
	}
	public GameWorld() {
		
	}	
	// getters for observers
	public int getscore() {
		return score;
	}
	public int getastro() {
		return numastronauts;
	}
	public int getalien() {
		return numaliens;
	}
	public int getnumaliensin() {
		return numAliensin;
	}
	public String getsound() {
		return sound;
	}
	public int getsaved() {
		return numAstronautsaved;
	}
	public void togglesound() {
		if(sound=="OFF") {
			sound ="ON";
		}else
			sound="OFF";
		setChanged();
		notifyObservers();
	}
	// creates the game world
	public void init() {
		
		 // create player
		 Gameobjects.add(SpaceShip.getspaceship(width,height));
		 // create the players space ship
		 // instantiates all astronauts
		 for(int i=0;i<numastronauts;i++) {
			 Gameobjects.add(new Astronaut());
		 }
		 
		 // instantiates all Aliens
		 for(int i=0;i<numaliens;i++) {
			 Gameobjects.add(new Alien());
		 }
		 setChanged();
		notifyObservers();
	}
	// code e expands door size
	public void expand() {
		SpaceShip.getspaceship().expand();
		setChanged();
		notifyObservers();
	}
	
	// code a transfer player to random alien location
	public void transferalien() {
		if(numaliens<=0) {
			System.out.println("there is no alien to teleport to");
		}else {
		setChanged();
		Random rn=new Random();
		int rando=rn.nextInt(numaliens+numastronauts+1);
		Object temp =Gameobjects.get(rando);
		while(temp instanceof Alien==false) {
			rando=rn.nextInt(numaliens+numastronauts+1);
			temp =Gameobjects.get(rando);
		}
		temp =(GameObject)temp;
		SpaceShip.getspaceship().jumptolocation(((GameObject) temp).getlocation());
		}
		notifyObservers();
	}
	
	//code o transfer player to random astronaut location
	public void transferastronaut() {
		if(numastronauts<=0) {
			System.out.println("there is no astronaut to teleport to");
		}else {
			Random rn=new Random();
			int rando=rn.nextInt(numaliens+numastronauts+1);
			Object temp =Gameobjects.get(rando);
			while(temp instanceof Astronaut==false) {
				rando=rn.nextInt(numaliens+numastronauts+1);
				temp =Gameobjects.get(rando);
			}
			temp = (GameObject)temp;
			SpaceShip.getspaceship().jumptolocation(((GameObject) temp).getlocation());
			setChanged();
		}
		
		notifyObservers();
	}
	// code r move spaceship right
	public void moveright() {
		SpaceShip.getspaceship().moveright();
		setChanged();
		notifyObservers();
	}
	// code l move spaceship left
	public void moveleft() {
		SpaceShip.getspaceship().moveleft();
		setChanged();
		notifyObservers();
	}
	// code u move spaceship up
	public void moveup() {
		SpaceShip.getspaceship().moveup();
		setChanged();
		notifyObservers();
	}
	//code c close spaceship door
	public void contract() {
		SpaceShip.getspaceship().contract();
		setChanged();
		notifyObservers();
		
	}
	// code d move spaceship down
	public void movedown() {
		SpaceShip.getspaceship().movedown();
		setChanged();
		notifyObservers();
		
	}
	// code s open door and update score according to previous input
	public void openenter() {
		// checks for contained opponents
		IIterator itr= Gameobjects.iterator();
		while (itr.hasNext()) {
			GameObject temp=(GameObject) itr.Next();
			if(SpaceShip.getspaceship().contains(temp.getlocation().getx(),temp.getlocation().gety())) {
				if(temp instanceof Astronaut) {
					score+= ((Astronaut)temp).gethealth()*10;
					numAstronautsaved++;
					numastronauts--;
				}else if(temp instanceof Alien) {
					score-=10;
					numAliensin++;
					numaliens--;
				}
				if(temp instanceof SpaceShip) {
					
				}else {
					itr.remove();
					setChanged();
				}
					
			}
		}
			notifyObservers();
	}
	
	//code w alien collides with another alien
	public void pretenda() {
		if(numaliens<2) {
			System.out.println("There are not enough aliens to produce a child");
		}else {
			Gameobjects.add(new Alien());
			numaliens++;
			setChanged();
		}
		notifyObservers();
	}
	//code f alien collides with astronaut
	public void pretendaa() {
		// checks for at least 1 alien and 1 astronaut if true fight insues
		if(numaliens>0 && numastronauts>0) {
			Random rn = new Random();
			int rando=rn.nextInt(numastronauts+numaliens+1);
			GameObject temp=(GameObject) Gameobjects.get(rando);
			while(temp instanceof Astronaut==false) {
				rando=rn.nextInt(numastronauts+numaliens+1);
				temp=(GameObject)Gameobjects.get(rando);
			}
			((Astronaut) temp).fight();
		// removes astronaut if he has been damaged to death
			if(((Astronaut) temp).gethealth()<=0) {
				Gameobjects.remove(temp);
				numastronauts--;
			}
			setChanged();
		//there are not enough Opponents to create a fight
		}else {
			System.out.println("not enough opponents to complete attack");
		}
		notifyObservers();
	}
	// code m prints the map of current world state
	public void map() {
		IIterator itr=Gameobjects.iterator();
		//prints out Opponents
		while(itr.hasNext()) {	
			System.out.println(itr.Next().toString());
		}
			
	}
	
	//code t increments the clock
	public void clock() {
		IIterator itr = Gameobjects.iterator();
		// moves Opponents
		while(itr.hasNext()) {
			
			Object temp=itr.Next();
			if(temp instanceof Opponents) {
				((Opponents)temp).Moveit();
			}	
		}
		setChanged();
		notifyObservers();
	}
	
	// shows the help menu
}
