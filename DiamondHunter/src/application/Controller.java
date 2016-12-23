//Controller class for HomeScreen in GUI

package application;

import com.neet.DiamondHunter.TileEngine.*;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.neet.DiamondHunter.Main.Game;
import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.TileEngine.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
	
	
	@FXML private Button btnPlay;							//initialise button Play Game with id btnPLay
	
	 @FXML protected void playGame(ActionEvent event) {			//when Play Game button is clicked, this method is invoked
	     
		 JFrame window = new JFrame("Diamond Hunter");
			window.add(new GamePanel());
			window.setResizable(false);
			window.pack();
			window.setLocationRelativeTo(null);
			window.setVisible(true);
			//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 
		 	//Game.main(null);								//method Play() calls main function in Game.java. Runs the game.
	    }
	 
	 @FXML private Button btnShow;							//initialise button Show Map with id btnShow
	 
	 @FXML protected void showMap(ActionEvent event) {		//when Show Map button is clicked, this method is invoked
	        
			com.neet.DiamondHunter.TileEngine.Main.main(null);//method showMap() calls main function in Main.java. Shows map with tilesets.
			
	 }
	 
	 
	 
	 @FXML private Button btnEdit;
	private Stage stage;
	 @FXML protected void Edit(ActionEvent event){
			try {
				Parent root  = FXMLLoader.load(getClass().getResource("Positions.fxml"));				//FXMLLoader loads Menu.fxml
				Scene scene = new Scene(root,600,600);												//Determines size of dialogue box
				//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage=(Stage) btnEdit.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			}catch(Exception e) {
				e.printStackTrace();
			}
	 }
	 
	 
}
