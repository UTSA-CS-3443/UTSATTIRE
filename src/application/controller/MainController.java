package application.controller;

import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;



public class MainController {
	
	@FXML
	public Button btnWeather;
	@FXML
	public Button btnWardrobe;
	@FXML
	public Button btnOutfit;
	
	@FXML
	public void buttonClicked(ActionEvent event) throws IOException {

		
		if(event.getSource() == btnWeather) {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("controller/Weather.fxml") );

			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );

			Main.stage.setScene(scene);
			
		}else if (event.getSource() == btnWardrobe){
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("controller/Wardrobe.fxml") );

			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );

			Main.stage.setScene(scene);
			
		} else if (event.getSource() == btnOutfit){
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("controller/Outfit.fxml") );

			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );

			Main.stage.setScene(scene);
			
		}
		
	}
}
