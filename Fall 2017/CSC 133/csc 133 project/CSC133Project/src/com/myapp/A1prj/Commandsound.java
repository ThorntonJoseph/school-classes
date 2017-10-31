package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandsound extends Command{
	private GameWorld gw;
	public Commandsound(GameWorld gw) {
		super("Sound");
		this.gw=gw;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.togglesound();
	}
}
