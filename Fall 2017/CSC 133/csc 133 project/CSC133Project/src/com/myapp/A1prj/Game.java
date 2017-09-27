package com.myapp.A1prj;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 

public class Game extends Form {
	private boolean exit=false;
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
			 if(exit==false) {
			 switch (sCommand.charAt(0)) {
			 	case 'e':
			 		gw.expand();
			 		break;
			 	case 'a':
			 		gw.transferalien();
			 		break;
			 	case 'o':
			 		gw.transferastronaut();
			 		break;
			 	case 'r':
			 		gw.moveright();
			 		break;
			 	case 'l':
			 		gw.moveleft();
			 		break;
			 	case 'u':
			 		gw.moveup();
			 		break;
			 	case 'c':
			 		gw.contract();
			 		break;
			 	case 'd':
			 		gw.movedown();
			 		break;
			 	case 't':
			 		gw.clock();
			 		break;
			 	case 's':
			 		gw.openenter();
			 		break;
			 	case 'w':
			 		gw.pretenda();
			 		break;
			 	case 'f':
			 		gw.pretendaa();
			 		break;
			 	case 'p':
			 		gw.gamestate();
			 		break;
			 	case 'm':
			 		gw.map();
			 		break;
			 	case 'x':
			 		exit=true;
			 		System.out.println("are you sure you want to exit y or n");
			 		break;
			 }//switch
			 } //if exit
			 else {
				 switch (sCommand.charAt(0)) {
				 case 'y':
					 System.exit(0);
					 break;
				 case 'n':
					 exit=false;
					 System.out.println("then don't hit x");
					 break;
				default:
					System.out.println("Answer the question... do you want to exit y or n");
					break;
				 }
				
			 }
			 } //actionPerformed
			 } //new ActionListener()
			 ); //addActionListener 
	}

}
