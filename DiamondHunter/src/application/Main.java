package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/HomeScreen.fxml"));
            Scene scene = new Scene(root,400,400);
            //stage.setScene(new Scene(root));
            stage.setScene(scene);
            stage.show();
			/*Scene scene = new Scene(400,400);
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/HomeScreen.fxml"));
			Parent content = loader.load();
			//Parent content = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
			//FXMLLoader content = FXMLLoader.load(getClass().getClassLoader().getResource("meyammai/workspace/DiamondHunter/src/application/HomeScreen.fxml"));
			stage.setScene(new Scene(content));
			stage.setTitle("Home Sceen");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.show();*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		//Application.launch(Main.class, args);
	}
}
