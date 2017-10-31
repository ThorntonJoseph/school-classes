package com.myapp.A1prj;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class Commandexpand extends Command{
	private GameWorld gw;
	public Commandexpand(GameWorld gw) {
		super("expand");
		this.gw=gw;
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.expand();
	}
}

