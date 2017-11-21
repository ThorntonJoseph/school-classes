package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// command moves spaceship in relitive down deriction
public class Commanddown extends Command{
	private GameWorld gw;
	public Commanddown(GameWorld gw) {
		super("down");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.movedown();
	}
}
