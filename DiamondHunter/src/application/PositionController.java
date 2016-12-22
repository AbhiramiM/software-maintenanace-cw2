package application;

import java.util.StringTokenizer;

import com.neet.DiamondHunter.GameState.*;
import com.neet.DiamondHunter.Main.Game;
import com.neet.DiamondHunter.Manager.GameStateManager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PositionController {
	
	public PositionController(){
		super();
		String bpos;
		String apos;
	}
	
	@FXML private Button btnConfirm;
	@FXML private Button btnCancel;	
	@FXML private TextField txtBoat;	
	@FXML private TextField txtAxe;
	
	private String boatpos="";
	private String axepos="";
	
	
	
	 @FXML protected void Confirm(ActionEvent event) {
		//boatpos= txtBoat.getText();
		//axepos= txtAxe.getText();
		
		boatpos=txtBoat.getText();
		axepos=txtBoat.getText();
		
				/* 
		
		StringTokenizer stb = new StringTokenizer(boatpos, " ");
		 int x = Integer.parseInt(stb.nextToken());
		 int y = Integer.parseInt(stb.nextToken());
		
			StringTokenizer sta = new StringTokenizer(axepos, " ");
			 int a = Integer.parseInt(sta.nextToken());
			 int b = Integer.parseInt(sta.nextToken());
			 */

			 Game.main(null);
		 	//System.out.printf("%d\n%d\n%d\n%d",x,y,a,b);							
	    }
	 
	 @FXML protected void Cancel(ActionEvent event) {			
		//Platform.exit();
		 System.out.printf(this.getBoatPos());
		 System.out.printf(this.getAxePos());
		
	    }
	 public String getBoatPos(){
		 return this.boatpos;
	 }
	
	 public String getAxePos(){
		 return this.axepos;
	 }
	/* public int Convert(String string){
		 StringTokenizer st = new StringTokenizer(string, " ");
		 int x = Integer.parseInt(st.nextToken());
		 int y = Integer.parseInt(st.nextToken());
	 }*/
}
