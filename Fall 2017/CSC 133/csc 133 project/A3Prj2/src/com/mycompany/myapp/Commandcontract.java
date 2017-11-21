package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// command reduces the size of the spaceship
public class Commandcontract extends Command {
	private GameWorld gw;
	public Commandcontract(GameWorld gw) {
		super("contract");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.contract();
	}
	
}
