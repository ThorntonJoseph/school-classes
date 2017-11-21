package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// command moves spaceship left
public class Commandleft extends Command{
	private GameWorld gw;
	public Commandleft(GameWorld gw) {
		super("left");
		this.gw=gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.moveleft();
	}
}
