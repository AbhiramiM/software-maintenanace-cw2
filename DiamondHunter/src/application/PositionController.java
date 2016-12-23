package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JFrame;

import com.neet.DiamondHunter.GameState.*;
import com.neet.DiamondHunter.Main.Game;
import com.neet.DiamondHunter.Main.GamePanel;
import com.neet.DiamondHunter.TileEngine.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PositionController {
	/*
	public PositionController(){
		super();
		String bpos;
		String apos;
	}*/
	
	@FXML private Button btnConfirm;
	@FXML private Button btnMap;	
	@FXML private TextField txtBoat;	
	@FXML private TextField txtAxe;
	
	private String boatpos="";
	private String axepos="";
	
	
	
	 @FXML protected void Confirm(ActionEvent event) {
		//boatpos= txtBoat.getText();
		//axepos= txtAxe.getText();
		
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
		
		 JFrame window = new JFrame("Diamond Hunter");
			window.add(new GamePanel());
			window.setResizable(false);
			window.pack();
			window.setLocationRelativeTo(null);
			window.setVisible(true);
		
		//Game.main(null);
		
				/* 
		
		StringTokenizer stb = new StringTokenizer(boatpos, " ");
		 int x = Integer.parseInt(stb.nextToken());
		 int y = Integer.parseInt(stb.nextToken());
		
			StringTokenizer sta = new StringTokenizer(axepos, " ");
			 int a = Integer.parseInt(sta.nextToken());
			 int b = Integer.parseInt(sta.nextToken());
			 */

			 //Game.main(null);
		 	//System.out.printf("%d\n%d\n%d\n%d",x,y,a,b);							
	    }
	 
	 @FXML protected void Map(ActionEvent event) {			
		//Platform.exit();
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
			
			com.neet.DiamondHunter.TileEngine.Main.main(null);
		
	    }
/*	 public String getBoatPos(){
		 return this.boatpos;
	 }
	
	 public String getAxePos(){
		 return this.axepos;
	 }*/
	/* public int Convert(String string){
		 StringTokenizer st = new StringTokenizer(string, " ");
		 int x = Integer.parseInt(st.nextToken());
		 int y = Integer.parseInt(st.nextToken());
	 }*/
}
