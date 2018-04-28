package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Main class to Start app
 * 
 * @author All Dragon Members of Team Dragon
 *
 */
public class Main extends Application {
	
	
	/**
	 * Creating the stage 
	 */
	public static Stage stage; 
	
	/**
	 * Start method 
	 * 
	 * @param Stage primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		
		try 
		{
			
			// Load the FXML document (we created with SceneBuilder)
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("controller/Main.fxml") );
			
			// Load the layout from the FXML and add it to the scene
			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );
			
			// Set the scene to stage and show the stage to the user
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}