package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// command moves space ship up
public class Commandup extends Command {
	private GameWorld gw;
	public Commandup(GameWorld gw) {
		super("up");
		this.gw=gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.moveup();
	}
}
