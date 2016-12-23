//Controller class for Edit boat and axe position screen in GUI.

package application;

import java.io.IOException;
import java.io.PrintWriter;


import javax.swing.JFrame;

import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.TileEngine.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PositionController {
	
	@FXML private Button btnConfirm;	//Initialises the button Save and Play with fx id btnConfirm
	@FXML private Button btnMap;		//Initialises the button Save and View Map with fx id btnMap
	@FXML private TextField txtBoat;	//Initialises textfield for boat positions with fx id txtBoat
	@FXML private TextField txtAxe;		//Initialises textfield for axe positions with fx id txtAxe
	
	//Creates new string variables to store input
	private String boatpos="";
	private String axepos="";
	
	
	
	 @FXML protected void Confirm(ActionEvent event) {	//when Save and Play button is clicked, this method is invoked
		
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
		
		 JFrame window = new JFrame("Diamond Hunter");
			window.add(new GamePanel());
			window.setResizable(false);
			window.pack();
			window.setLocationRelativeTo(null);
			window.setVisible(true);						
	    }
	 
	 @FXML protected void Map(ActionEvent event) {	//when Save and View Map button is clicked, this method is invoked		
		
			boatpos=txtBoat.getText();
			axepos=txtAxe.getText();
			
			
			try{
			    PrintWriter writer = new PrintWriter("Position.txt", "UTF-8");
			    writer.println(boatpos);
			    writer.println(axepos);
			    writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			com.neet.DiamondHunter.TileEngine.Main.main(null);	//Invokes main function in Main.java in TileEngine package which is responsible for displaying tilemap with updated boat and axe positions					
		
	    }
}
