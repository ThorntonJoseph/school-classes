package com.mycompany.myapp;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
// command turn sound on an off
public class Commandsound extends Command{
	private Game game;
	public Commandsound(Game g) {
		super("Sound");
		this.game=g;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(((CheckBox)e.getActualComponent()).isSelected()) {
			game.togglesound(true);
		}else {
			game.togglesound(false);
		}
		
	}
}
