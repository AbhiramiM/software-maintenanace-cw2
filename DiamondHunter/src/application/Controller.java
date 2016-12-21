package application;


import com.neet.DiamondHunter.Main.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	@FXML private Button btnPlay;
	
	 @FXML protected void Play(ActionEvent event) {
	        //System.out.println("Sign in button pressed");
		 	Game.main(null);
	    }
	 
	 @FXML private Button btnShow;
	 @FXML protected void ShowMap(ActionEvent event) {
	        System.out.println("Sign in button pressed");
		 	//Game.main(null);
	    }
}
