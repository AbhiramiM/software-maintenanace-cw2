package com.neet.DiamondHunter.TileEngine;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.neet.DiamondHunter.TileEngine.TileLayer;


public class Items {
	
	private static final int SIZE = 16;
	int Xboat=0;
	int Yboat=0;
	int Xaxe=0;
	int Yaxe=0;

	public Items(TileLayer tm) {
		super();
	
	}
	
	public static BufferedImage axe;
	public static BufferedImage boat;
	
	public void setAxe(Graphics g)
    {
       // axe= loadItem("items.jpg");
		System.out.println(Xaxe);
        drawItem(g, axe, 16, 16, Xaxe, Yaxe);
    }


    public void setAxeCoordinate(int xCoordinate, int yCoordinates)
    {
        this.Xaxe = xCoordinate;
        this.Yaxe = yCoordinates;
    }
 /*   public void setPlayer(GraphicsContext g){
        player=loadItem("/Sprites/playersprites.gif");
        drawItem(g, player, 0, 0, 17, 17);
    }*/

    public void setBoat(Graphics g)
    {
    	System.out.println(Xboat);
       // boat= loadItem("items.jpg");
        drawItem(g, boat, 0, 16, Xboat, Yboat);
       
    }


    public void setBoatCoordinate(int xCoordinate, int yCoordinate)
    {
        this.Xboat = xCoordinate;
        this.Yboat = yCoordinate;
    }



    //crop the wanted image from tileset
    public void drawItem(Graphics g, BufferedImage item, int sx, int sy, int xIndex, int yIndex){
        g.drawImage(item, sx, sy, SIZE,SIZE, xIndex*SIZE, yIndex*SIZE, SIZE, SIZE, null);
    }
    
	 public BufferedImage loadItem(String fileName)				//method to return BufferedImage
	 {
		  BufferedImage testImage=null;						//initialise testImage to null
		 
		 try														//ImageIO needs to throw exception.
		 {
			testImage = ImageIO.read(new File(fileName)); 			//load image file into testImage
		 }catch(IOException e)										//catch IOException e
		 {
			System.out.println("Error loading test tile set image!"); //loads this message if try() doesn't execute.
		 }
		 
		 return testImage;											//returns loaded image
	 }

}


