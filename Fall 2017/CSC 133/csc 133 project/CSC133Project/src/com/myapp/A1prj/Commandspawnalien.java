package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandspawnalien extends Command{
	private GameWorld gw;
	public Commandspawnalien(GameWorld gw) {
		super("spawn");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.pretenda();
	}

}
