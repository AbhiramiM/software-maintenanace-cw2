package application;

import com.neet.DiamondHunter.Main.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PositionController {
	@FXML private Button btnConfirm;
	@FXML private Button btnCancel;	
	@FXML private TextField txtBoat;	
	@FXML private TextField txtAxe;
	
	 @FXML protected void Confirm(ActionEvent event) {
		 String boatpos= txtBoat.getText();
		 String axepos= txtAxe.getText();
	     
		 	System.out.printf("%s %s",boatpos,axepos);							
	    }
	 
	 @FXML protected void Cancel(ActionEvent event) {			
	     
		 System.out.println("Cancel");									
	    }
}
