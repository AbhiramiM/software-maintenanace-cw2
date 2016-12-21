package application;


import com.neet.DiamondHunter.Main.Game;
import com.neet.DiamondHunter.TileEngine.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	@FXML private Button btnPlay;
	
	 @FXML protected void Play(ActionEvent event) {
	     
		 	Game.main(null);
	    }
	 
	 @FXML private Button btnShow;
	 @FXML protected void ShowMap(ActionEvent event) {
	        
			com.neet.DiamondHunter.TileEngine.Main.main(null);
	    }
}
