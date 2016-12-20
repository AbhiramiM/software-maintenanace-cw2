//Controller class for HomeScreen in GUI

package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.neet.DiamondHunter.Main.GamePanel;

public class HomeScreenControl implements Initializable {	
	
	@Override
	public void initialize (URL arg0 , ResourceBundle arg1){
		
	}
	
	@FXML
	private Button pg;
	
	@FXML
	private Button vm;
	
	@FXML
	private Button ep;
	
	@FXML
	private Text dh;
	
	public HomeScreenControl(){
		
	}
	
		@FXML public void onClickPlay(){	//calls this method when Play Game button in GUI is clicked
	
		JFrame window = new JFrame("Diamond Hunter");
		
		window.add(new GamePanel());
		
		window.setResizable(false);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	}
	
	@FXML public void onClickView(){	//calls this method when View Map button in GUI is clicked
		JFrame frame = new JFrame("Map Engine");
		PanelGraphics MapPanel = new PanelGraphics();
		frame.setSize(new Dimension (800, 600));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setContentPane(MapPanel);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//closes JFrame and also terminates application when exit button is clicked
		frame.setVisible(true);
	}
	
		@FXML public void onClickEdit() throws IOException{	//calls this method when Edit Position button in GUI is clicked
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditScreenControl.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOpacity(1);
		stage.setTitle("My New Stage Title");
		stage.setScene(new Scene(root, 450, 450));
		stage.showAndWait();
	}
	
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
	
	public static class TileLayer 
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
		 
		 public static  TileLayer loadMap(String fileName)
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
							exceedWidth++;	
							index = index - (tileSet.getWidth() / Engine.TILE_WIDTH);
						}
						
						g.drawImage(tileSet, x * Engine.TILE_WIDTH, y * Engine.TILE_HEIGHT, (x * Engine.TILE_WIDTH) + Engine.TILE_WIDTH, (y * Engine.TILE_HEIGHT) + Engine.TILE_HEIGHT, index * Engine.TILE_WIDTH, exceedWidth * Engine.TILE_HEIGHT, (index * Engine.TILE_WIDTH) + Engine.TILE_WIDTH, (exceedWidth * Engine.TILE_HEIGHT) + Engine.TILE_HEIGHT, null);
					
						
					}
				}
		 }
	}
	public class Engine {

		public static final int TILE_HEIGHT = 16;	//represents y variable
		public static final int TILE_WIDTH = 16;	//represents x variable
}


	
}


