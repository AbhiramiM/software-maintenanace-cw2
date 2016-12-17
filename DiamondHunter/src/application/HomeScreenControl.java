//Controller class for HomeScreen in GUI

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.Graphics;
import java.io.IOException;

import com.neet.DiamondHunter.TileEngine.PanelGraphics;

//import com.neet.DiamondHunter.Main.*;

public class HomeScreenControl extends Pane {	

	PanelGraphics display = new PanelGraphics();
	
	@FXML public void onClickPlay(){	//calls this method when Play Game button in GUI is clicked
	}
	
	@FXML public void onClickView(){	//calls this method when View Map button in GUI is clicked
		Graphics g = null;
		display.paintComponent(g);
	}
	
	@FXML public void onClickEdit() throws IOException{	//calls this method when Edit Position button in GUI is clicked
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditScreenControl.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("My New Stage Title");
		stage.setScene(new Scene(root, 450, 450));
		stage.showAndWait();
	}
	
}


