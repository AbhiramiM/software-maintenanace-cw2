package com.neet.DiamondHunter.TileEngine;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelGraphics extends JPanel 
{
	
	private TileLayer layer;
	
	public PanelGraphics ()									//constructor class
	{
		layer = TileLayer.loadMap("testmap.map");			//reads from the text file testmap.map. Loads data into layer.
	}
	
	@Override public void paintComponent(Graphics g)		//Override painComponent when using JPanel
	{
		super.paintComponent(g);							//calls paintComponent from JPanel
		
		layer.DrawLayer(g);									//invokes DrawLayer method on layer and 'crops' the tileset.
	}
}
