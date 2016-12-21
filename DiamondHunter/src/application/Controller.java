//Controller class for HomeScreen in GUI

package application;

import com.neet.DiamondHunter.Main.Game;
import com.neet.DiamondHunter.TileEngine.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	
	@FXML private Button btnPlay;							//initialise button Play Game with id btnPLay
	
	 @FXML protected void playGame(ActionEvent event) {			//when Play Game button is clicked, this method is invoked
	     
		 	Game.main(null);								//method Play() calls main function in Game.java. Runs the game.
	    }
	 
	 @FXML private Button btnShow;							//initialise button Show Map with id btnShow
	 
	 @FXML protected void showMap(ActionEvent event) {		//when Show Map button is clicked, this method is invoked
	        
			com.neet.DiamondHunter.TileEngine.Main.main(null);	//method showMap() calls main function in Main.java. Shows map with tilesets.
	    }
}
