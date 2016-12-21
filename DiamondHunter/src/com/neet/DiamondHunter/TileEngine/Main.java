package com.neet.DiamondHunter.TileEngine;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Map Engine");
		PanelGraphics MapPanel = new PanelGraphics();
		frame.setSize(new Dimension (800, 600));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setContentPane(MapPanel);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//closes JFrame and also terminates application when exit button is clicked
		frame.setVisible(true);
	
	}
}