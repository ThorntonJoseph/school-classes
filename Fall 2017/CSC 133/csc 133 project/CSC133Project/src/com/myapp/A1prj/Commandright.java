package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandright extends Command {
	private GameWorld gw;
	public Commandright(GameWorld gw) {
		super("right");
		this.gw=gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.moveright();
	}
}
