package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;


import application.model.FiveDayForecast;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * @author Members of Team Dragon
 *
 */

public class WeatherController implements Initializable{
	
	
	/**
	 * Buttons and Labels created for GUI interface of weather screen.
	 * Will display a Return Home Button, 3 days of weather forecast 
	 * Highs and Lows for each day and the conditions.
	 * 
	 */
	@FXML
	public Button btnHome;	
	
	@FXML
    private Label high1, high2 , high3;

    @FXML
    private ImageView imgToday, imgday2, imgday3;

    @FXML
    private Label low1, low2, low3;

    @FXML
    private Label condition1, condition2, condition3;

    @FXML
    private Label today, day2, day3;

  
	/**
	 * Action Event for the Return Home Button
	 * @param event
	 * @throws IOException
	 */
    @FXML
    public void buttonClicked(ActionEvent event) throws IOException {
    	
    	if(event.getSource() == btnHome) {
    		
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation( Main.class.getResource("controller/Main.fxml") );

    		AnchorPane layout = (AnchorPane) loader.load();				
    		Scene scene = new Scene( layout );

    		Main.stage.setScene(scene);
    		
    	}
    }



    /**
     * initialize method sets all the current weather stats on the labels.  
     * Each time you return it will make a call to the API and update labels.
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		FiveDayForecast fiveDayForecast;
		try {
			fiveDayForecast = new FiveDayForecast();
			
			condition1.setText(FiveDayForecast.getForecast().get(0).getForecast());
			condition2.setText(FiveDayForecast.getForecast().get(1).getForecast());
			condition3.setText(FiveDayForecast.getForecast().get(2).getForecast());
			
			day2.setText(FiveDayForecast.getForecast().get(1).getDate());
			day3.setText(FiveDayForecast.getForecast().get(2).getDate());
			
			high1.setText("High: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(0).getTempMax())));
			high2.setText("High: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(1).getTempMax())));
			high3.setText("High: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(2).getTempMax())));
			
			low1.setText("Low: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(0).getTempMin())));
			
			
			 String path1 = (FiveDayForecast.getForecast().get(0).getIcon());
			 String path2 = (FiveDayForecast.getForecast().get(1).getIcon());
			 String path3 = (FiveDayForecast.getForecast().get(2).getIcon());
			 Image image1 = new Image(path1);
			 Image image2 = new Image(path2);
			 Image image3 = new Image(path3);
			
			imgToday.setImage(image1);
			imgday2.setImage(image2);
			imgday3.setImage(image3);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    
}