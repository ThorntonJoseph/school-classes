package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// command sets 2 opponents to insue in a fight
public class CommandPause extends Command{
	private Game g;
	public CommandPause(Game g) {
		super("Pause");
		this.g=g;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		g.pause();
	}
}
