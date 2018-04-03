package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



public class WeatherController implements Initializable {
	
	@FXML
	public Button btnHome;	
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

        }


    
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
    
}