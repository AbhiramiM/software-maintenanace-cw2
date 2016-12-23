//G52SWM Software Maintenance Coursework 2
//Autumn 2016 - 2017
//OUMME KOOTAB - 023668
//MEYAMMAI ABIRAMI MEYAPPA - 023544


package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root  = FXMLLoader.load(getClass().getResource("Menu.fxml"));				//FXMLLoader loads Menu.fxml
			Scene scene = new Scene(root,600,600);								//Determines size of dialogue box
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {								//Executable JavaFX main function
		launch(args);
	}
}
