package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
//yup
public class OutfitGenController {
	
	@FXML
	private Button btnHome;	
	
	@FXML
	private Button btnGenerate;
	
	@FXML
	private ImageView topImage, bottomImage, shoeImage;
	
	@FXML
	private Label topName, bottomName, shoeName;
	
	@FXML
	public void initialize() {
		
	}
	
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
