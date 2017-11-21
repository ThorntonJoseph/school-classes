package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandclosedoor extends Command {
	private GameWorld gw;
	public Commandclosedoor(GameWorld gw) {
		super("CLOSE DOOR");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.closedoor();
	}
}
