package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commanddown extends Command{
	private GameWorld gw;
	public Commanddown(GameWorld gw) {
		super("down");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.movedown();
	}
}
