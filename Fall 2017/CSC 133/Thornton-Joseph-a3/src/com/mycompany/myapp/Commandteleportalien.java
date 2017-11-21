package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// command teleports player to the location of a random alien
public class Commandteleportalien extends Command {
	private GameWorld gw;
	public Commandteleportalien(GameWorld gw) {
		super("teleportalien");
		this.gw=gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.transferalien();
	}
}
