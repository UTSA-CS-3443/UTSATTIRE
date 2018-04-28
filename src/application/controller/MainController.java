package application.controller;

import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import application.Main;
import application.model.FiveDayForecast;
import application.model.Outfit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Main class to Start app
 * 
 * @author All Dragon Members of Team Dragon
 *
 */
public class MainController {

	@FXML
	public Button btnWeather;
	
	@FXML
	public Button btnWardrobe;
	
	@FXML
	public Button btnOutfit;

	/**
	 * buttonClicked method for when user clicks on a button
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void buttonClicked(ActionEvent event) throws IOException {

		if (event.getSource() == btnWeather) {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("controller/Weather.fxml"));

			AnchorPane layout = (AnchorPane) loader.load();
			Scene scene = new Scene(layout);

			Main.stage.setScene(scene);

		} else if (event.getSource() == btnWardrobe) {

			FiveDayForecast fiveDayForecast = new FiveDayForecast();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("controller/Wardrobe.fxml"));

			AnchorPane layout = (AnchorPane) loader.load();
			Scene scene = new Scene(layout);

			Main.stage.setScene(scene);

		} else if (event.getSource() == btnOutfit) {

			FiveDayForecast fiveDayForecast = new FiveDayForecast();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("controller/Outfit.fxml"));

			AnchorPane layout = (AnchorPane) loader.load();
			Scene scene = new Scene(layout);

			Main.stage.setScene(scene);

		}

	}
}
