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

	 private int [][] map;
	 private BufferedImage tileSet;
	 
	 public TileLayer(int [][] currentMap)
	 {
		map = new int [currentMap.length][currentMap[0].length]; 
		
		for(int y=0; y<map.length; y++)
		{
			for(int x=0; x<map[y].length; x++)
			{
				map[y][x] = currentMap [y][x];
			}
		}
		
		tileSet = LoadtileSet("testtileset.jpg");
	 }
	 
	 public TileLayer(int width, int height)
	 {
		 map = new int [height][width];
	 } 
	 
	 public static TileLayer loadMap(String fileName)
	 {
		 TileLayer layer = null;
		 ArrayList<ArrayList<Integer>> mapLayout = new ArrayList <>();
		 
		 try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
		 {
			 String currentLine;
			 while((currentLine = br.readLine()) != null)
			 {
				 if(currentLine.isEmpty())
				 {
					 continue;
				 }
				 
				 ArrayList<Integer> mapRow = new ArrayList<>();
				 
				 String[] values = currentLine.trim().split(" ");
				 
				 for(String string : values)
				 {
					if(!string.isEmpty())
					{
						int id = Integer.parseInt(string);
						mapRow.add(id);
					}
				 }
				 
				 mapLayout.add(mapRow);
			 }
		 }catch(IOException e){
			 
		 }
		 
		 int width = mapLayout.get(0).size();
		 int height = mapLayout.size();
		 
		 layer = new TileLayer(width, height);
		 
		 for (int y=0; y<height; y++)
		 {
			 for(int x=0; x<width; x++)
			 {
				 layer.map[y][x] = mapLayout.get(y).get(x);
			 }
		 }
		 
		 layer.tileSet = layer.LoadtileSet("testtileset.jpg");
		 
		 return layer;
	 }
	 
	 public BufferedImage LoadtileSet (String fileName)
	 {
		 BufferedImage testImage = null;
		 
		 try
		 {
			testImage = ImageIO.read(new File(fileName)); 
		 }catch(IOException e)
		 {
			System.out.println("Error loading test tile set image!"); 
		 }
		 
		 return testImage;
	 }
	 
	 public void DrawLayer (Graphics g)
	 {
		 for(int y=0; y<map.length; y++)
			{
				for(int x=0; x<map[y].length; x++)
				{
					int index = map [y][x];
					int exceedWidth = 0;
					
					if(index > (tileSet.getWidth() / Engine.TILE_WIDTH) - 1)
					{
						//while((index > (tileSet.getWidth() / Engine.TILE_WIDTH) - 1))
						//{
						exceedWidth++;	
						index = index - (tileSet.getWidth() / Engine.TILE_WIDTH);
							
							
						//}
					}
					
					g.drawImage(tileSet, x * Engine.TILE_WIDTH, y * Engine.TILE_HEIGHT, (x * Engine.TILE_WIDTH) + Engine.TILE_WIDTH, (y * Engine.TILE_HEIGHT) + Engine.TILE_HEIGHT, index * Engine.TILE_WIDTH, exceedWidth * Engine.TILE_HEIGHT, (index * Engine.TILE_WIDTH) + Engine.TILE_WIDTH, (exceedWidth * Engine.TILE_HEIGHT) + Engine.TILE_HEIGHT, null);
				
					
				}
			}
	 }
}