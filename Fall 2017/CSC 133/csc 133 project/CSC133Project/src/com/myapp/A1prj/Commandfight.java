package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Commandfight extends Command{
	private GameWorld gw;
	public Commandfight(GameWorld gw) {
		super("fight");
		this.gw=gw;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.pretendaa();
	}
}
