package application.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import application.Main;
import application.model.Outfit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
		
		//Create Outfit object
		Outfit temp = new Outfit();
		
//Upload Outfit images--------------------------------------------------------
		//input image file for top
		FileInputStream input;
		try {
			input = new FileInputStream(temp.getTopURL());
			Image image = new Image(input);
			topImage.setImage(image);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//input image file for bottom
		try {
			input = new FileInputStream(temp.getBottomURL());
			Image image = new Image(input);
			bottomImage.setImage(image);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//input image file for shoe
		try {
			input = new FileInputStream(temp.getShoeURL());
			Image image = new Image(input);
			shoeImage.setImage(image);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//-------------------------------------------------------------
		
		//Update labels of each clothing
		topName.setText(temp.getTopName());
		bottomName.setText(temp.getBottomName());
		shoeName.setText(temp.getShoeName());
		
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
				
			//Create Outfit object
			Outfit temp = new Outfit();
			
			//Upload Outfit images--------------------------------------------------------
			//input image file for top
			FileInputStream input;
			try {
				input = new FileInputStream(temp.getTopURL());
				Image image = new Image(input);
				topImage.setImage(image);
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//input image file for bottom
			try {
				input = new FileInputStream(temp.getBottomURL());
				Image image = new Image(input);
				bottomImage.setImage(image);
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//input image file for shoe
			try {
				input = new FileInputStream(temp.getShoeURL());
				Image image = new Image(input);
				shoeImage.setImage(image);
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//-------------------------------------------------------------
			
			//Update labels of each clothing
			topName.setText(temp.getTopName());
			bottomName.setText(temp.getBottomName());
			shoeName.setText(temp.getShoeName());
				
		}
	}
}
