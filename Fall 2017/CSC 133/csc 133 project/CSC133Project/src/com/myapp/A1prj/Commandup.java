package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

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
