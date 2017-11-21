package com.mycompany.myapp;
import java.util.*;
import com.codename1.ui.Graphics;
// observer of gameworld is the actual play space
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.plaf.Border;
public class MapView extends Container implements Observer {
	//pointer location
	private int iPx =0;
	private int iPy =0;
	// implements singleton design pattern.
	private GameWorld gw;
	private Game game;
	private GameObjectCollection go;
	public MapView(GameWorld gw,Game g) {
		this.game=g;
		this.gw=gw;
		go=gw.getobjects();
		//setting the back ground color of center container to light gray
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		//setting the border Color
		this.getAllStyles().setBorder(Border.createLineBorder(4,
		ColorUtil.GRAY));
	}
	public void update(Observable observable, Object data) {
		if(observable==gw) {
			repaint();
		}else
			System.out.println("something is wrong");
		
	}
	// overrides paint method to draw objects
	public void paint(Graphics g) {
		super.paint(g);
		IIterator itr= go.iterator();
		while (itr.hasNext()){
			GameObject temp =(GameObject) itr.Next();
			if(temp instanceof Astronaut) {
				if(game.pausestate()==false) {
					((Astronaut)temp).setSelected(false);
				}
				if(((Astronaut)temp).isSelected()) {
					((Astronaut)temp).draw(g, new Location(iPx,iPy));
				}else
					temp.draw(g);
			}else {
				temp.draw(g);
			}
		}
	}
	@Override
	public void pointerPressed(int x,int y){
		if(game.pausestate()) {
			iPx=x;
			IIterator itr =go.iterator();
			while(itr.hasNext()) {
				Object temp = itr.Next();
				if(temp instanceof Astronaut) {
					iPy=y-65;
					if(((Astronaut)temp).contains(new Location(((Astronaut) temp).getlocation().getx(),((Astronaut) temp).getlocation().gety()), 
							new Location((double) iPx,(double) iPy))) {
					((Astronaut)temp).setSelected(true);
					}else {
						((Astronaut)temp).setSelected(false);
					}
					repaint();
				}
			}
		
		}
	}
}
