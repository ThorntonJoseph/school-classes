package com.myapp.A1prj;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

public class Commandexit extends Command{

	public Commandexit() {
		super("exit");
		
	}
	public void actionPerformed(ActionEvent e) {	
		Command cCancel = new Command("Cancel");
		Command cok = new Command("Ok");
		Command[] cmds = new Command[] {cok,cCancel};
		Command ex = Dialog.show("Are you sure you want to exit",new Label(""),cmds);
		if(ex==cok) {
			System.exit(0);
		} 
	}
}
