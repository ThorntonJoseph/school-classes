package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// score observer of gameworld shows the scores in different areas
public class Commandopendoor extends Command{
	private GameWorld gw;
	public Commandopendoor(GameWorld gw) {
		super("OPEN DOOR");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.opendoor();
	}

}
