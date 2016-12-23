//Controller class for Edit boat and axe position screen in GUI. 

package application;

import java.io.IOException;
import java.io.PrintWriter;

import com.neet.DiamondHunter.Main.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PositionController {
	
	@FXML private Button btnConfirm;	//Initialises the button Save and Play with fx id btnConfirm
	@FXML private TextField txtBoat;	//Initialises textfield for boat positions with fx id txtBoat
	@FXML private TextField txtAxe;		//Initialises textfield for axe positions with fx id txtBoat
	
	//Creates new string variables to store input
	private String boatpos="";
	private String axepos="";
	
	
	
	 @FXML protected void Confirm(ActionEvent event) {		//when Save and Play button is clicked, this method is invoked
		
		//String variables that take user input in textfields
		boatpos=txtBoat.getText();
		axepos=txtAxe.getText();
		
		
		try{
		    PrintWriter writer = new PrintWriter("Position.txt", "UTF-8");	//Reads user inputed coordinates from a text file called Position.text
		    writer.println(boatpos);
		    writer.println(axepos);
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Game.main(null);		//Invokes main function in Game.java which is responsible for running game with updated boat and axe positions					
	   }
}
