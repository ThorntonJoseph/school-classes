package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandteleportastro extends Command {
	private GameWorld gw;
	public Commandteleportastro(GameWorld gw) {
		super("teleportastro");
		this.gw=gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.transferastronaut();
	}
}
