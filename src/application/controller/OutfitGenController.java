package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class OutfitGenController {
	@FXML
	public Button btnHome;	
	@FXML
	public Button btnGenerate;
	@FXML
	    public void buttonClicked(ActionEvent event) throws IOException {
	    	
	    	if(event.getSource() == btnHome) {
	    		
	    		FXMLLoader loader = new FXMLLoader();
	    		loader.setLocation( Main.class.getResource("controller/Main.fxml") );

	    		AnchorPane layout = (AnchorPane) loader.load();				
	    		Scene scene = new Scene( layout );

	    		Main.stage.setScene(scene);
	    		
	    	}else if (event.getSource() == btnGenerate){
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("controller/Outfit2.fxml"));
				
				AnchorPane layout = (AnchorPane) loader.load();
				Scene scene = new Scene(layout);
				
				Main.stage.setScene(scene);
				
			}
}
}
