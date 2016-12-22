package com.neet.DiamondHunter.TileEngine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class TileLayer 
{

	 private int [][] map;												//create 2D array map
	 private BufferedImage tileSet;
	 
	 public TileLayer(int [][] currentMap)
	 {
		map = new int [currentMap.length][currentMap[0].length]; 		//initialise rows/columns of map to currentMap
		
		for(int y=0; y<map.length; y++)									//loop through map
		{
			for(int x=0; x<map[y].length; x++)
			{
				map[y][x] = currentMap [y][x];							//copy values of currentMap into map (Manual array copy)
			}
		}
		
		tileSet = LoadtileSet("testtileset.jpg");
	 }
	 
	 public TileLayer(int width, int height)			//Constructor taking in width and height to initialise map
	 {
		 map = new int [height][width];
	 } 
	 
	 public static TileLayer loadMap(String fileName)
	 {
		 TileLayer layer = null;												//initialise layer object to null.
		 ArrayList<ArrayList<Integer>> mapLayout = new ArrayList <>();
		 
		 try(BufferedReader br = new BufferedReader(new FileReader(fileName)))	//FileReader will read file name and pass it to BufferedReader.
		 {
			 String currentLine;
			 while((currentLine = br.readLine()) != null)						//only reads valid lines in file. Excludes empty spaces etc (null)
			 {
				 if(currentLine.isEmpty())										//checks if currentLine has empty spaces
				 {
					 continue;													//doesn't read empty spaces. Prevents IndexOutOfBound errors
				 }
				 
				 ArrayList<Integer> mapRow = new ArrayList<>();					//adds rows to produce mapLayout
				 
				 String[] values = currentLine.trim().split(" ");				//splits integers in file by a " " blank space
				 
				 for(String string : values)
				 {
					if(!string.isEmpty())										//checks is string is not empty
					{
						int id = Integer.parseInt(string);
						mapRow.add(id);
					}
				 }
				 
				 mapLayout.add(mapRow);
			 }
		 }catch(IOException e){													//throws IOException e
			 
		 }
		 //Gets size of mapLayout and stores it in width and height
		 int width = mapLayout.get(0).size();
		 int height = mapLayout.size();
		 
		 layer = new TileLayer(width, height);					//creates layer with width and height of mapLayout
		 
		 //loop through mapLayout
		 for (int y=0; y<height; y++)					
		 {
			 for(int x=0; x<width; x++)
			 {
				 layer.map[y][x] = mapLayout.get(y).get(x);		//pass x and y from mapLayout into map
			 }
		 }
		 
		 layer.tileSet = layer.LoadtileSet("testtileset.jpg");		//loads tile set called "testtileset.jpg". Also reads .png files. Java supports only limited file types
		 
		 return layer;
	 }
	 
	 public BufferedImage LoadtileSet (String fileName)				//method to return BufferedImage
	 {
		 BufferedImage testImage = null;							//initialise testImage to null
		 
		 try														//ImageIO needs to throw exception.
		 {
			testImage = ImageIO.read(new File(fileName)); 			//load image file into testImage
		 }catch(IOException e)										//catch IOException e
		 {
			System.out.println("Error loading test tile set image!"); //loads this message if try() doesn't execute.
		 }
		 
		 return testImage;											//returns loaded image
	 }
	 
	 public void DrawLayer (Graphics g)
	 {
		 for(int y=0; y<map.length; y++)							//loop through map
			{
				for(int x=0; x<map[y].length; x++)
				{
					int index = map [y][x];							//index counts tiles across
					int exceedWidth = 0;							//initialise exceedWidth. Required to make sure index is reset.
					
					if(index > (tileSet.getWidth() / Engine.TILE_WIDTH) - 1)	
					{
					//to make sure index doesn't exceed width of entire tile set. -1 is included since array index starts at 0
						exceedWidth++;		
						index = index - (tileSet.getWidth() / Engine.TILE_WIDTH);		//index is updated to first tile in the beginning of second row
					}
					//draws the corners of each tile rectangle using x, y, TILE_WDTH, and TILE_HEIGHT values
					g.drawImage(tileSet, x * Engine.TILE_WIDTH, y * Engine.TILE_HEIGHT, (x * Engine.TILE_WIDTH) + Engine.TILE_WIDTH, (y * Engine.TILE_HEIGHT) + Engine.TILE_HEIGHT, index * Engine.TILE_WIDTH, exceedWidth * Engine.TILE_HEIGHT, (index * Engine.TILE_WIDTH) + Engine.TILE_WIDTH, (exceedWidth * Engine.TILE_HEIGHT) + Engine.TILE_HEIGHT, null);
				
					
				}
			}
	 }
}