//Package responsible for showing map

package com.neet.DiamondHunter.TileEngine;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Map Engine");
		PanelGraphics MapPanel = new PanelGraphics();			//create MapPanel
		frame.setSize(new Dimension (641, 600));				//specifies size of frame so the entire maps is displayed
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setContentPane(MapPanel);							//Pass MapPanel into ContentPane as container
		frame.setVisible(true);									//makes frame visible
	
	}
}