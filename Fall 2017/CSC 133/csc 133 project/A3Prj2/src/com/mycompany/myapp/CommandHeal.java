package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandHeal extends Command {
	private GameWorld gw;
	public CommandHeal(GameWorld gw) {
		super("Heal");
		this.gw=gw;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.healAstronaut();
	}
}
