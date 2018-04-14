package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import application.model.Wardrobe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



public class WardrobeController implements Initializable {
	
	@FXML
	public Button btnHome;	
	@FXML
	private Button clickCheck;
    @FXML
    private Button Tops, Bottoms, Footwear;
	
    public static Wardrobe closet = new Wardrobe();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

        }

	@FXML
	public void addToWardrobe(ActionEvent event) throws IOException {
		

		clickCheck = (Button)event.getSource();
	
		if (clickCheck == Tops) {
			closet.addClothing();
		}
		else if (clickCheck == Bottoms) {
			closet.addClothing();
		}
		else if (clickCheck == Footwear) {
			closet.addClothing();
		}
		else {
			
		}
		
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