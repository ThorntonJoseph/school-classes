package com.mycompany.myapp;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
// @formatter:on 
public class GameWorld extends Observable  {
	// set variables
	private static int maxalienspawn =20;
	private int score=0;
	private int numastronauts=4;
	private int numaliens=4;
	private int numAstronautsaved=0;
	private int numAliensin=0;
	private int height = 768;
	private int width=1024;
	private int locx,locy;
	private boolean bgsoundpause = false;
	private GameObjectCollection Gameobjects = new GameObjectCollection();
	private String sound = "OFF";
	private Sound sattack;
	private Sound sopen;
	private Sound sspawn;
	private BGSound bgdarkside;

	//setframe 
	public void setframe(int height,int width, int locx,int locy) {
		this.height=height;
		this.width=width;
		this.locx=locx;
		this.locy=locy;
	}
	public GameWorld() {
		 sattack= new Sound("attack.wav");
		 sspawn= new Sound("spawn.wav");
		 sopen = new Sound("open.wav");
		 bgdarkside= new BGSound("darkside.wav");
		 togglesound(true);
		 
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
	public GameObjectCollection getobjects() {
		return Gameobjects;
	}
	//setters
	public void togglesound(boolean state) {
		if(state==false) {
			sound ="OFF";
			bgdarkside.pause();
		}else {
			sound="ON";
			bgdarkside.play();
		}
		setChanged();
		notifyObservers();
	}
	// creates the game world
	public void init() {
		GameObject.setframe(height, width, locx, locy);
		 // create player
		 Gameobjects.add(SpaceShip.getspaceship());
		 // create the players space ship
		 // instantiates all astronauts
		 for(int i=0;i<numastronauts;i++) {
			 Gameobjects.add(new Astronaut());
		 }
		 
		 // instantiates all Aliens
		 for(int i=0;i<numaliens;i++) {
			 Gameobjects.add(new Alien());
		 }
		 IIterator itr =Gameobjects.iterator();
		 while (itr.hasNext()) {
			 GameObject temp = (GameObject) itr.Next();
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

	// closes the door of the spaceship
	public void closedoor() {
		if(SpaceShip.getspaceship().doorstate==true) {
			sopen.play();
		}
		SpaceShip.getspaceship().closedoor();
	}
	//opens the door of the spaceship
	public void opendoor() {
		if(SpaceShip.getspaceship().doorstate==false) {
			sopen.play();
		}
		SpaceShip.getspaceship().opendoor();
		
	}
	
	//code w alien collides with another alien
	public void Collisions() {
		IIterator itr = Gameobjects.iterator();
		while(itr.hasNext()) {
			GameObject temp = (GameObject)itr.Next();
			IIterator itr2 = Gameobjects.iterator();
			while(itr2.hasNext()) {
				GameObject temp2 = (GameObject) itr2.Next();
					// detects collision between aliens with astronauts and aliens with aliens
					if(!(temp2 instanceof SpaceShip)&&temp instanceof Alien &&((Alien)temp).collidesWith((ICollider)temp2)) 
					{
						((Alien)temp).handleCollision((ICollider) temp2,this);
						if(temp2 instanceof Astronaut &&((Astronaut)temp2).gethealth()<=0) {
							itr2.remove();
							numastronauts--;
						}
					}
					// allows alines or astronauts into the space ship
					if(!(temp2 instanceof SpaceShip)&&temp instanceof SpaceShip && SpaceShip.getspaceship().doorstate
							&&((SpaceShip)temp).contains(temp2.getlocation().getx(), temp2.getlocation().gety())) {
						itr2.remove();
						if(temp2 instanceof Alien) {
							numaliens--;
							score =score-10;
						}else if (temp2 instanceof Astronaut) {
							numastronauts--;
							score = score+((Astronaut)temp2).gethealth()*10;
						}
					}
					setChanged();
					notifyObservers();
			}
		}
	}
	
	// code for spawning an alien
	public void spawnAlien() {
		if(numaliens< maxalienspawn) {
			numaliens++;
			Alien added = new Alien();
			added.setfertile(false);
			Gameobjects.add(added);
			sspawn.play();
		}
		
		//do nothing
	}
	public void fight(Astronaut as) {
		as.fight();
		sattack.play();
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
	public boolean gameover() {
		return numastronauts==0;
	}
	// heals astronauts that are selected (only one can be)
	public void healAstronaut() {
		IIterator itr = Gameobjects.iterator();
		while(itr.hasNext()) {
			Object temp = itr.Next();
			if(temp instanceof Astronaut) {
				if(((Astronaut)temp).isSelected()) {
					if(((Astronaut)temp).gethealth()>=5) {
						
					}else {
						((Astronaut)temp).healme();
					}
				}
					
			}
		}
	}
	// shows the help menu
}
