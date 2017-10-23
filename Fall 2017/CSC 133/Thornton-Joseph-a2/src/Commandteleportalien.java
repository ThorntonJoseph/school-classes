package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

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
