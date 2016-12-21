package com.neet.DiamondHunter.TileEngine;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelGraphics extends JPanel 
{
	
	private TileLayer layer;
	
	public PanelGraphics ()
	{
		layer = TileLayer.loadMap("testmap.map");
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		layer.DrawLayer(g);
	}
}
