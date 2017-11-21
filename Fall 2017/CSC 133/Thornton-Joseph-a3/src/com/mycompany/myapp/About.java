package com.mycompany.myapp;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

public class About extends Form implements ActionListener{
	private Game g;
	public About(Game g) {
		super(new BorderLayout());
		this.g=g;
		this.setTitle("About");
		Container textcontainer = new Container(new FlowLayout(Component.CENTER));
		Button close = new Button("Close");
		close.addActionListener(this);
		textcontainer.add(new SpanLabel("Create By Joseph Thornton for Class csc 133"
				+ "\nYou can use the Buttons on the side to control your space ship or Use Key commands"
				+ "\nControls:\ne = Expand Spaceship Door\nc = Contract Spaceship Door\n"
				+ "s = move down\nd = Moves Spaceship Right\na = Moves Spaceship left\nw = Moves Spaceship Up\n"
				+ "o = Teleport To Astronaut Location\nt = Teleport to Alien Location\n"
				+ "x = Exit Game \ng = pause"));
		add(BorderLayout.NORTH,close);
		add(BorderLayout.CENTER,textcontainer);
	}
	public void actionPerformed(ActionEvent evt) {
		g.actionPerformed(evt);
		
	}

}
