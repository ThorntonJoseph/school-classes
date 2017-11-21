package com.mycompany.myapp;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class WinGame extends Command{
	private GameWorld gw;
	public WinGame(GameWorld gw) {
		super("Game Over");
		this.gw=gw;
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {	
		Command cCancel = new Command("Quit");
		Command cok = new Command("Restart");
		Command[] cmds = new Command[] {cok,cCancel};
		Label score = new Label("");
		score.setText(""+gw.getscore());
		Command ex = Dialog.show("Your score was ",score,cmds);
		if(ex==cok) {
			
		} else {
			System.exit(0);
		}
	}
}
