package com.myapp.A1prj;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 

public class Game extends Form {
	private GameWorld gw;
	public Game() {
		gw = new GameWorld();
		gw.init();
		play(); 
		
	}
	private void play(){
		Label myLabel=new Label("Enter a Command:");
		 this.addComponent(myLabel);
		 final TextField myTextField=new TextField();
		 this.addComponent(myTextField);
		 this.show();
		 
		 myTextField.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent evt) {

			 String sCommand=myTextField.getText().toString();
			 myTextField.clear();
			 switch (sCommand.charAt(0)) {
			 	case 'e':
			 		gw.expand();
			 	case 'a':
			 		gw.transfer();
			 	case 'o':
			 		gw.transfer();
			 	case 'r':
			 		gw.moveright();
			 	case 'l':
			 		gw.moveleft();
			 	case 'u':
			 		gw.moveup();
			 	case 'c':
			 		gw.contract();
			 	case 'd':
			 		gw.movedown();
			 	case 't':
			 		gw.clock();
			 	case 's':
			 		gw.openenter();
			 	case 'w':
			 		gw.pretenda();
			 	case 'f':
			 		gw.pretendaa();
			 	case 'p':
			 		gw.gamestate();
			 	case 'm':
			 		gw.map();
			 	case 'x':
			 		
			 	case 'y':
			 		System.exit(0);
			 	case 'n':
			 		break;
			 //add code to handle rest of the commands
			 } //switch
			 } //actionPerformed
			 } //new ActionListener()
			 ); //addActionListener 
	}

}
