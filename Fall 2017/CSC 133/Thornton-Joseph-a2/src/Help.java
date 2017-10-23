package com.mycompany.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class Help extends Form implements ActionListener{
	private Game g;
	public Help(Game g) {
		super(new BorderLayout());
		this.g=g;
		this.setTitle("Help");
		Container textcontainer = new Container(new FlowLayout(Component.CENTER));
		Button close = new Button("Close");
		close.addActionListener(this);
		textcontainer.add(new Label("Use the Controls on the side to change data within the game"
				+" try and use teleport to gain access"));
		textcontainer.add (new Label("to astronauts, dont let the aliens "
				+ "in they will decrease your score"));
		add(BorderLayout.NORTH,close);
		add(BorderLayout.CENTER,textcontainer);
	}

	public void actionPerformed(ActionEvent evt) {
		g.actionPerformed(evt);
		
	}
	
	
}
