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
    private Button Tops, Bottoms, Footwear, edit;
	
    //public static Wardrobe closet = new Wardrobe();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

        }

    /**
     * addToWardrobe function is for any of the add buttons clicked to switch to the same Add fxml page. 
     * 
     * @param event
     * @throws IOException
     */
	@FXML
	public void addToWardrobe(ActionEvent event) throws IOException {
		

		clickCheck = (Button)event.getSource();
		
		//User clicks which button, and switches to Add function 
		//along with creating a wardrobe item with String of which tier of clothing
		if (clickCheck == Tops) {
			
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation( Main.class.getResource("controller/Add.fxml") );

    		AnchorPane layout = (AnchorPane) loader.load();				
    		Scene scene = new Scene( layout );

    		Main.stage.setScene(scene);	
		}
		else if (clickCheck == Bottoms) {
			
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation( Main.class.getResource("controller/Add.fxml") );

    		AnchorPane layout = (AnchorPane) loader.load();				
    		Scene scene = new Scene( layout );

    		Main.stage.setScene(scene);	
		}
		else if (clickCheck == Footwear) {
			
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation( Main.class.getResource("controller/Add.fxml") );

    		AnchorPane layout = (AnchorPane) loader.load();				
    		Scene scene = new Scene( layout );

    		Main.stage.setScene(scene);	
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
    	else if(event.getSource() == edit)
    	{
    		FXMLLoader loader = new FXMLLoader();
    		loader.setLocation( Main.class.getResource("controller/Edit.fxml") );

    		AnchorPane layout = (AnchorPane) loader.load();				
    		Scene scene = new Scene( layout );

    		Main.stage.setScene(scene);	
    	}
    	
}
    
}