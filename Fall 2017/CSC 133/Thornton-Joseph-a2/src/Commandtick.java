package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandtick extends Command {
	private GameWorld gw;
	public Commandtick(GameWorld gw) {
		super("tick");
		this.gw=gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.clock();
	}
}
