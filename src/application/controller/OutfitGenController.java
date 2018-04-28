package application.controller;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import application.Main;
import application.model.Outfit;
import application.model.Wardrobe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * OutfitGenController, controller class that controls the outfit generator
 * 
 * @author All Dragon Members of Team Dragon
 *
 */
public class OutfitGenController {
	
	@FXML
	private Button btnHome;	
	
	@FXML
	private Button btnGenerate;
	
	@FXML
	private ImageView topImage, bottomImage, shoeImage;
	
	@FXML
	private Label topName, bottomName, shoeName;
	
	private Outfit temp = new Outfit();
	
	private Wardrobe tempTop = new Wardrobe("", ""), tempBot = new Wardrobe("", ""), tempShoe = new Wardrobe("", "");
	
	/**
	 * initialize method to initialize the fxml 
	 */
	@FXML
	public void initialize(){
		

		//Create Outfit object
		//Outfit temp = new Outfit();
		temp.populateOutfit();
		
		tempTop = temp.getTodayTop();
//Upload Outfit images--------------------------------------------------------
		//input image file for top
		FileInputStream input;
		try {
			String fileName = "src/Resource/" + tempTop.getImageFileName();
			input = new FileInputStream(fileName);
			Image image = new Image(input);
			topImage.setImage(image);
			topName.setText(tempTop.getName());
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tempBot = temp.getTodayBottom();

		//input image file for Bottom
		try {
			String fileName = "src/Resource/" + tempBot.getImageFileName();
			input = new FileInputStream(fileName);
			Image image = new Image(input);
			bottomImage.setImage(image);
			bottomName.setText(tempBot.getName());
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tempShoe = temp.getTodayShoe();
//Upload Outfit images--------------------------------------------------------
		//input image file for top
		try {
			String fileName = "src/Resource/" + tempShoe.getImageFileName();
			input = new FileInputStream(fileName);
			Image image = new Image(input);
			shoeImage.setImage(image);
			shoeName.setText(tempShoe.getName());
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//-------------------------------------------------------------
		

		//Update labels of each clothing
		topName.setText(tempTop.getName());
		bottomName.setText(tempBot.getName());
		shoeName.setText(tempShoe.getName());
		
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
			//Outfit temp = new Outfit();
			temp.populateOutfit();
			tempTop = temp.getTodayTop();
			//Upload Outfit images--------------------------------------------------------
					//input image file for top
					FileInputStream input;
					try {
						String fileName = "src/Resource/" + tempTop.getImageFileName();
						input = new FileInputStream(fileName);
						Image image = new Image(input);
						topImage.setImage(image);
						topName.setText(tempTop.getName());
					} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					tempBot = temp.getTodayBottom();
					//Upload Outfit images--------------------------------------------------------
							//input image file for top
							try {
								String fileName = "src/Resource/" + tempBot.getImageFileName();
								input = new FileInputStream(fileName);
								Image image = new Image(input);
								bottomImage.setImage(image);
								bottomName.setText(tempBot.getName());
							} 
							catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							tempShoe = temp.getTodayShoe();
					//Upload Outfit images--------------------------------------------------------
							//input image file for top
							try {
								String fileName = "src/Resource/" + tempShoe.getImageFileName();
								input = new FileInputStream(fileName);
								Image image = new Image(input);
								shoeImage.setImage(image);
								shoeName.setText(tempShoe.getName());
							} 
							catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	//-------------------------------------------------------------
			
			//Update labels of each clothing
			topName.setText(tempTop.getName());
			bottomName.setText(tempBot.getName());
			shoeName.setText(tempShoe.getName());
		}
	}
}
