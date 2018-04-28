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
		
		//Populate Outfit 
		temp.populateOutfit();
		
		//Get today's Top Wardrobe
		tempTop = temp.getTodayTop();
		
		//Upload Outfit to fxml
		
		//Initialize input stream
		FileInputStream input;
		try {
			String fileName = "src/Resource/" + tempTop.getImageFileName();
			input = new FileInputStream(fileName);
			Image image = new Image(input);
			
			//Upload image and text to fxml
			topImage.setImage(image);
			topName.setText(tempTop.getName());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		//Get today's Bot Wardrobe
		tempBot = temp.getTodayBottom();

		//Upload image and text to fxml
		try {
			String fileName = "src/Resource/" + tempBot.getImageFileName();
			input = new FileInputStream(fileName);
			Image image = new Image(input);
			bottomImage.setImage(image);
			bottomName.setText(tempBot.getName());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//Get today's Shoe Wardrobe
		tempShoe = temp.getTodayShoe();

		//Upload image and text to fxml
		try {
			String fileName = "src/Resource/" + tempShoe.getImageFileName();
			input = new FileInputStream(fileName);
			Image image = new Image(input);
			shoeImage.setImage(image);
			shoeName.setText(tempShoe.getName());
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * buttonClicked method when user clicks on any buttons on fxml
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void buttonClicked(ActionEvent event) throws IOException {
	    	
		//If user clicks on home button, goes to Main fxml
		if(event.getSource() == btnHome) {
	    		
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( Main.class.getResource("controller/Main.fxml") );

			AnchorPane layout = (AnchorPane) loader.load();				
			Scene scene = new Scene( layout );

			Main.stage.setScene(scene);
	    
		//else if user clicks Generate button, generate a new outfit
		}else if (event.getSource() == btnGenerate){
			
			//populate Outfit object again
			temp.populateOutfit();

			//Get top wardrobe from outfit
			tempTop = temp.getTodayTop();
			
			//Upload Top Outfit images
			//Upload image and text to fxml
			FileInputStream input;
			try {
				String fileName = "src/Resource/" + tempTop.getImageFileName();
				input = new FileInputStream(fileName);
				Image image = new Image(input);
				topImage.setImage(image);
				topName.setText(tempTop.getName());
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			//Get Bottom wardrobe from outfit
			tempBot = temp.getTodayBottom();
			
			//Upload Bottom Outfit images--------------------------------------------------------
			//Upload image and text to fxml
			try {
				String fileName = "src/Resource/" + tempBot.getImageFileName();
				input = new FileInputStream(fileName);
				Image image = new Image(input);
				bottomImage.setImage(image);
				bottomName.setText(tempBot.getName());
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
							
			//Get Shoe wardrobe from outfit 
			tempShoe = temp.getTodayShoe();
			
			//Upload Outfit images
			//Upload image and text to fxml
			try {
				String fileName = "src/Resource/" + tempShoe.getImageFileName();
				input = new FileInputStream(fileName);
				Image image = new Image(input);
				shoeImage.setImage(image);
				shoeName.setText(tempShoe.getName());
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
