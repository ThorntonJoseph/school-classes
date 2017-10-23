package com.mycompany.a2;
import com.codename1.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 
import com.codename1.ui.Toolbar;
public class Game extends Form implements ActionListener {
	// set private variable fields
	private boolean exit=false;
	private Button help;
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private Help Helpc = new Help(this);
	private About Aboutc = new About(this);
	public Game() {
		gw = new GameWorld();
		sv = new ScoreView(gw);
		mv = new MapView(gw);
		gw.addObserver(sv);
		gw.addObserver(mv);
		gw.init();
		
		// set some game variables up
		this.setTitle("SPACE FIGHTS");
		setLayout(new BorderLayout());
		//top scoreview with the GridLayout positioned on the north
		add(BorderLayout.NORTH,sv);
		// add mapview with no layout postioned at the center
		add(BorderLayout.CENTER,mv);
		// get command instances
		Commandexpand cexpand = new Commandexpand(gw);
		Commandscore cscore = new Commandscore(gw);
		Commandcontract ccontract = new Commandcontract(gw);
		Commanddown cdown = new Commanddown(gw);
		Commandfight cfight = new Commandfight(gw);
		Commandleft cleft = new Commandleft(gw);
		Commandright cright = new Commandright(gw);
		Commandspawnalien calien = new Commandspawnalien(gw);
		Commandteleportalien ctalien = new Commandteleportalien(gw);
		Commandteleportastro ctastro = new Commandteleportastro(gw);
		Commandtick ctick = new Commandtick(gw);
		Commandup cup = new Commandup(gw);
		Commandexit cexit = new Commandexit();
		Commandsound csound = new Commandsound(gw);
		// instantiate buttons and commands
		MyButton expand = new MyButton("Expand");
		expand.setCommand(cexpand);
		MyButton score = new MyButton("Score");
		score.setCommand(cscore);
		MyButton up = new MyButton("UP");
		up.setCommand(cup);
		MyButton down = new MyButton("DOWN");
		down.setCommand(cdown);
		MyButton teleportas = new MyButton("Teleport To Astronaut");
		teleportas.setCommand(ctastro);
		MyButton contract = new MyButton("Contract");
		contract.setCommand(ccontract);
		MyButton right = new MyButton("Right");
		right.setCommand(cright);
		MyButton left = new MyButton("Left");
		left.setCommand(cleft);
		MyButton teleportal = new MyButton("Teleport To Alien");
		teleportal.setCommand(ctalien);
		MyButton newalien = new MyButton("Spawn Alien");
		newalien.setCommand(calien);
		MyButton fight = new MyButton("Fight");
		fight.setCommand(cfight);
		MyButton tick = new MyButton("Tick");
		tick.setCommand(ctick);
		addKeyListener('u',cup);
		addKeyListener('d',cdown);
		addKeyListener('l',cleft);
		addKeyListener('r',cright);
		addKeyListener('c',ccontract);
		addKeyListener('e',cexpand);
		addKeyListener('s',cscore);
		addKeyListener('o',ctastro);
		addKeyListener('a',ctalien);
		addKeyListener('w',calien);
		addKeyListener('f',cfight);
		addKeyListener('t',ctick);
		addKeyListener('x',cexit);
		// set up toolbar
		help = new Button("Help");
		Button about = new Button("About");
		about.addActionListener(this);
		help.addActionListener(this);
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		CheckBox soundcheck=new CheckBox("Sound");
		soundcheck.getAllStyles().setBgTransparency(255);
		soundcheck.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		myToolbar.setTitle("Space Fights");
		myToolbar.addCommandToSideMenu(cexit);
		myToolbar.addCommandToSideMenu(cscore);
		csound.putClientProperty("SideComponent", soundcheck);
		soundcheck.setCommand(csound);
		myToolbar.addCommandToSideMenu(csound);
		myToolbar.addComponentToSideMenu(help);
		myToolbar.addComponentToSideMenu(about);
		//bottom commands
		Container bottomcommands = new Container(new FlowLayout(Component.CENTER));
		
		bottomcommands.add(newalien);
		bottomcommands.add(fight);
		bottomcommands.add(tick);
		//Setting the Border Color
		bottomcommands.getAllStyles().setBorder(Border.createLineBorder(4,
		ColorUtil.BLUE));
		add(BorderLayout.SOUTH,bottomcommands);
		//left Container with the BoxLayout positioned on the west
		
		Container leftcommands = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		leftcommands.getAllStyles().setPadding(Component.TOP, 50);
		//start adding components at a location 50 pixels below the upper border of the container
		leftcommands.add(expand);
		leftcommands.add(up);
		leftcommands.add(down);
		leftcommands.add(teleportas);
		leftcommands.getAllStyles().setBorder(Border.createLineBorder(4,
		ColorUtil.BLUE));
		add(BorderLayout.WEST,leftcommands);
		//right Container with the GridLayout positioned on the east
		Container rightcommands = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		rightcommands.getAllStyles().setPadding(Component.TOP, 50);
		rightcommands.getAllStyles().setPadding(Component.BOTTOM, 50);
		rightcommands.add(contract);
		rightcommands.add(left);
		rightcommands.add(right);
		rightcommands.add(teleportal);
		rightcommands.add(score);
		rightcommands.getAllStyles().setBorder(Border.createLineBorder(4,
		ColorUtil.BLUE));
		add(BorderLayout.EAST,rightcommands);
		this.show();
		gw.setheight(mv.getHeight());
		System.out.println("height: " + mv.getHeight()+ "Width: " + mv.getWidth());
		gw.setheight(mv.getWidth());

	}
	public void actionPerformed(ActionEvent evt) {
		if(evt.getComponent().equals(help)) {
			Helpc.show();
		}
		if(((Button)evt.getComponent()).getText().equals("Close")) {
			this.show();
		}
		if(((Button)evt.getComponent()).getText().equals("About")) {
			Aboutc.show();
		}
		
	}
	

}
