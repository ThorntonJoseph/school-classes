package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandcontract extends Command {
	private GameWorld gw;
	public Commandcontract(GameWorld gw) {
		super("contract");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.contract();
	}
	
}
