package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandscore extends Command{
	private GameWorld gw;
	public Commandscore(GameWorld gw) {
		super("score");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.openenter();
	}

}
