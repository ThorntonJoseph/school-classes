package com.mycompany.myapp;
import java.util.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
public class ScoreView extends Container implements Observer {
	private GameWorld gw=null;
	//set variables
	private Label score,rescued,in,asremaining,alremaining,sound;
	private mylabel scoreval,rescuedval,aliensin,remainingastro,remainingaliens,soundstate;
	public ScoreView(GameWorld gw) {
		super(new FlowLayout(CENTER));
		score = new Label("Total Score: ");
		scoreval = new mylabel();
		rescued = new Label("Astronauts Rescued: ");
		rescuedval = new mylabel();
		in = new Label("Aliens Sneaked in: ");
		aliensin = new mylabel();
		asremaining = new Label("Astronauts Remaining: ");
		remainingastro = new mylabel();
		alremaining = new Label("Aliens Remaining: ");
		remainingaliens = new mylabel();
		sound = new Label("sound: ");
		soundstate = new mylabel();
		this.gw=gw;
		add(score);
		add(scoreval);
		add(rescued);
		add(rescuedval);
		add(in);
		add(aliensin);
		add(asremaining);
		add(remainingastro);
		add(alremaining);
		add(remainingaliens);
		add(sound);
		add(soundstate);
		//Setting the Border Color
		this.getAllStyles().setBorder(Border.createLineBorder(4,
		ColorUtil.BLUE));
	}
	private class mylabel extends Label{
		public mylabel() {
			super("       ");
			getAllStyles().setPadding(RIGHT, 2);
			getAllStyles().setPadding(LEFT, 2);
		}
	}
	// updates the necessary values on this container
	public void update(Observable observable, Object data) {
		if(observable==gw) {
			scoreval.setText("" + gw.getscore());
			rescuedval.setText("" + gw.getsaved());
			aliensin.setText(""+ gw.getnumaliensin());
			remainingastro.setText("" + gw.getastro());
			remainingaliens.setText("" + gw.getalien());
			soundstate.setText(gw.getsound());
		}
		
	}

}
