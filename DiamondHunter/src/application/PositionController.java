package application;

import java.util.StringTokenizer;

import com.neet.DiamondHunter.Main.Game;

import javafx.application.Platform;
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
		 
		StringTokenizer stb = new StringTokenizer(boatpos, " ");
		 int x = Integer.parseInt(stb.nextToken());
		 int y = Integer.parseInt(stb.nextToken());
		
			StringTokenizer sta = new StringTokenizer(axepos, " ");
			 int a = Integer.parseInt(sta.nextToken());
			 int b = Integer.parseInt(sta.nextToken());
		 
		 	System.out.printf("%d\n%d\n%d\n%d",x,y,a,b);							
	    }
	 
	 @FXML protected void Cancel(ActionEvent event) {			
		Platform.exit();
		
	    }
	
	/* public int Convert(String string){
		 StringTokenizer st = new StringTokenizer(string, " ");
		 int x = Integer.parseInt(st.nextToken());
		 int y = Integer.parseInt(st.nextToken());
	 }*/
}
