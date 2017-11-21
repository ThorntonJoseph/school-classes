package com.mycompany.myapp;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.events.ActionEvent; 
import com.codename1.ui.Toolbar;
public class Game extends Form implements ActionListener,Runnable{
	private Button help;
	private boolean pause=false;
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private Help Helpc = new Help(this);
	private About Aboutc = new About(this);
	private UITimer timer;
	private CommandPause cpause;
	private MyButton pauseb;
	private CheckBox soundcheck;
	// private command variables for access in methods later
	private Commandexpand cexpand;
	private Commandopendoor copendoor;;
	private Commandcontract ccontract;
	private Commanddown cdown;
	private Commandleft cleft;
	private Commandright cright;
	private Commandteleportalien ctalien;
	private Commandteleportastro ctastro;
	private Commandup cup;
	private Commandexit cexit;
	private Commandsound csound;
	private Commandclosedoor cclosedoor;
	private CommandHeal cheal;
	// private button variables for access in methods later
	MyButton close;
	MyButton expand;
	MyButton score;
	MyButton up;
	MyButton down;
	MyButton teleportas;
	MyButton contract;
	MyButton right;
	MyButton left;
	MyButton teleportal;
	MyButton heal;
	public Game() {
		gw = new GameWorld();
		sv = new ScoreView(gw);
		mv = new MapView(gw,this);
		gw.addObserver(sv);
		gw.addObserver(mv);
		//setters
		
		//create timer and pass runnable
		timer = new UITimer(this);
		// schedule this timer
		timer.schedule(20, true, this);
		// set some game variables up
		this.setTitle("SPACE FIGHTS");
		setLayout(new BorderLayout());
		
		//top scoreview with the GridLayout positioned on the north
		add(BorderLayout.NORTH,sv);
		
		// add mapview with no layout positioned at the center
		add(BorderLayout.CENTER,mv);
		
		// get command instances
		cexpand = new Commandexpand(gw);
		copendoor = new Commandopendoor(gw);
		ccontract = new Commandcontract(gw);
		cdown = new Commanddown(gw);
		cpause = new CommandPause(this);
		cleft = new Commandleft(gw);
		cright = new Commandright(gw);
		ctalien = new Commandteleportalien(gw);
		ctastro = new Commandteleportastro(gw);
		cup = new Commandup(gw);
		cexit = new Commandexit();
		csound = new Commandsound(this);
		cclosedoor = new Commandclosedoor(gw);
		cheal = new CommandHeal(gw);
		// instantiate buttons and commands
		close = new MyButton("closedoor");
		close.setCommand(cclosedoor);
		expand = new MyButton("Expand");
		expand.setCommand(cexpand);
		score = new MyButton("Score");
		score.setCommand(copendoor);
		up = new MyButton("UP");
		up.setCommand(cup);
		down = new MyButton("DOWN");
		down.setCommand(cdown);
		teleportas = new MyButton("Teleport To Astronaut");
		teleportas.setCommand(ctastro);
		contract = new MyButton("Contract");
		contract.setCommand(ccontract);
		right = new MyButton("Right");
		right.setCommand(cright);
		left = new MyButton("Left");
		left.setCommand(cleft);
		teleportal = new MyButton("Teleport To Alien");
		teleportal.setCommand(ctalien);
		pauseb = new MyButton("Fight");
		pauseb.setCommand(cpause);
		heal = new MyButton ("Heal");
		heal.setCommand(cheal);
		heal.setEnabled(false);
		cheal.setEnabled(false);
		
		//set key bindings
		addKeyListener('w',cup);
		addKeyListener('s',cdown);
		addKeyListener('a',cleft);
		addKeyListener('d',cright);
		addKeyListener('c',ccontract);
		addKeyListener('e',cexpand);
		addKeyListener('f',copendoor);
		addKeyListener('o',ctastro);
		addKeyListener('t',ctalien);
		addKeyListener('p',cpause);
		addKeyListener('r',cclosedoor);
		addKeyListener('x',cexit);
		
		// set up toolbar
		help = new Button("Help");
		Button about = new Button("About");
		about.addActionListener(this);
		help.addActionListener(this);
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		soundcheck=new CheckBox("Sound");
		soundcheck.getAllStyles().setBgTransparency(255);
		soundcheck.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundcheck.setSelected(true);
		myToolbar.setTitle("Space Fights");
		myToolbar.addCommandToSideMenu(cexit);
		myToolbar.addCommandToSideMenu(copendoor);
		csound.putClientProperty("SideComponent", soundcheck);
		soundcheck.setCommand(csound);
		myToolbar.addCommandToSideMenu(csound);
		myToolbar.addComponentToSideMenu(help);
		myToolbar.addComponentToSideMenu(about);
		
		//bottom commands
		Container bottomcommands = new Container(new FlowLayout(Component.CENTER));
		bottomcommands.add(pauseb);
		bottomcommands.add(heal);
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
		leftcommands.add(close);
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
		gw.setframe(mv.getHeight(),mv.getWidth(),mv.getX(),mv.getY());
		gw.init();
	}
	//methods
	//get the game pause state
	public boolean pausestate() {
		return pause;
	}
	//pause the game
	public void pause() {
		if(pause==false) {
			gw.togglesound(false);
			pause=true;
			timer.cancel();
			pauseb.setText("Play");
			// disables commands
			cexpand.setEnabled(false);
			copendoor.setEnabled(false);
			ccontract.setEnabled(false);
			cdown.setEnabled(false);
			cleft.setEnabled(false);
			cright.setEnabled(false);
			ctalien.setEnabled(false);
			ctastro.setEnabled(false);
			cup.setEnabled(false);
			cexit.setEnabled(false);
			csound.setEnabled(false);
			cclosedoor.setEnabled(false);
			//disable buttons
			close.setEnabled(false);
			expand.setEnabled(false);
			score.setEnabled(false);
			up.setEnabled(false);
			down.setEnabled(false);
			teleportas.setEnabled(false);
			contract.setEnabled(false);
			right.setEnabled(false);
			left.setEnabled(false);
			teleportal.setEnabled(false);
			//disable heal
			heal.setEnabled(true);
			cheal.setEnabled(true);
			// removes key listeners
			removeKeyListener('w',cup);
			removeKeyListener('s',cdown);
			removeKeyListener('a',cleft);
			removeKeyListener('d',cright);
			removeKeyListener('c',ccontract);
			removeKeyListener('e',cexpand);
			removeKeyListener('f',copendoor);
			removeKeyListener('o',ctastro);
			removeKeyListener('t',ctalien);
			removeKeyListener('p',cpause);
			removeKeyListener('r',cclosedoor);
		
		}else {
			if(soundcheck.isSelected()) {
				gw.togglesound(true);
			}
			pause=false;
			timer.schedule(20, true, this);
			pauseb.setText("Pause");
			// enable commands
			cexpand.setEnabled(true);
			copendoor.setEnabled(true);
			ccontract.setEnabled(true);
			cdown.setEnabled(true);
			cleft.setEnabled(true);
			cright.setEnabled(true);
			ctalien.setEnabled(true);
			ctastro.setEnabled(true);
			cup.setEnabled(true);
			cexit.setEnabled(true);
			csound.setEnabled(true);
			cclosedoor.setEnabled(true);
			// enable buttons
			close.setEnabled(true);
			expand.setEnabled(true);
			score.setEnabled(true);
			up.setEnabled(true);
			down.setEnabled(true);
			teleportas.setEnabled(true);
			contract.setEnabled(true);
			right.setEnabled(true);
			left.setEnabled(true);
			teleportal.setEnabled(true);
			// disables heal
			heal.setEnabled(false);
			cheal.setEnabled(false);
			// adds back key listeners
			addKeyListener('w',cup);
			addKeyListener('s',cdown);
			addKeyListener('a',cleft);
			addKeyListener('d',cright);
			addKeyListener('c',ccontract);
			addKeyListener('e',cexpand);
			addKeyListener('f',copendoor);
			addKeyListener('o',ctastro);
			addKeyListener('t',ctalien);
			addKeyListener('p',cpause);
			addKeyListener('r',cclosedoor);
			
		}
	}
	// sound check
	public void togglesound(boolean state) {
		if(pause==true) {
			//do nothing
		}else {
			gw.togglesound(state);
		}
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
	public void run() {
		if(pause==false) {
			gw.clock(); 
			//gw.openenter();
			gw.Collisions();
		}
		
		if(gw.gameover()) {
			WinGame wg = new WinGame(gw);
			wg.actionPerformed(new ActionEvent("gameover"));
			new Game();
		}
	}


}
