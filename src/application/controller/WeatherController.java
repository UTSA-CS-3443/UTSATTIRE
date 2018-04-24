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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



public class WeatherController implements Initializable{
	
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




	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FiveDayForecast fiveDayForecast;
		try {
			fiveDayForecast = new FiveDayForecast();
			System.out.println(fiveDayForecast.getForecast().get(0).getTempMax());
			
			condition1.setText(FiveDayForecast.getForecast().get(0).getForecast());
			condition2.setText(FiveDayForecast.getForecast().get(1).getForecast());
			condition3.setText(FiveDayForecast.getForecast().get(2).getForecast());
			
			today.setText(FiveDayForecast.getForecast().get(0).getDate());
			day2.setText(FiveDayForecast.getForecast().get(1).getDate());
			day3.setText(FiveDayForecast.getForecast().get(2).getDate());
			
			high1.setText("High: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(0).getTempMax())));
			high2.setText("High: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(1).getTempMax())));
			high3.setText("High: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(2).getTempMax())));
			
			low1.setText("Low: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(0).getTempMin())));
			low2.setText("Low: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(1).getTempMin())));
			low3.setText("Low: " + String.valueOf(FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(2).getTempMin())));
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
}