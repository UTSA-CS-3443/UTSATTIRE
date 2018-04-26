package application.controller;

import java.io.IOException;

import application.Main;
import application.model.Add;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

//TODO: Vinh still needs to finish saving Temperature criteria

/**
 * AddController class controls the Add fxml 
 * when user is adding a clothing item
 * 
 * @author All Dragon Members of Team Dragon
 *
 */
public class AddController 
{
	
	@FXML
	private Button choose;
	
	@FXML
	Text title;
	
	@FXML
	TextField userInput;
	
	//80+, 79-65, 64-51, 50-
	@FXML
	CheckBox eightyPlus, sevNineToSixFive, sixFourToFifOne, fiftyBelow;
	
	@FXML
	Button save;
	
	//count for when user uploads an image
	private int topCount = 0, bottomCount = 0, shoeCount = 0;
	
	//boolean for when user uploads an image
	private boolean topUpload = false, bottomUpload = false, shoeUpload = false;
	
	/**
	 * buttonClicked method when user clicks save button,
	 * saves data into wardrobe arraylist
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void buttonClicked(ActionEvent event) throws IOException {
		
		//When user clicks save button
		if(event.getSource() == save) {
			
			//check if user is adding a top, bottom, or shoe when saving. 
			//Saves data, and then comes back to Wardrobe page
			
			//top
			if(WardrobeController.clothingTier == "top")
			{
				//Call addTop method
				Add.addTop(userInput.getText(), topUpload);
				
				//increment count for top since done. 
				topCount++;
				
				//reset topUpload
				topUpload = false;
				
				
				//change scene to Wardrobe fxml
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( Main.class.getResource("controller/Wardrobe.fxml") );

				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );

				Main.stage.setScene(scene);
			}
			
			//bottom
			else if(WardrobeController.clothingTier == "bottom")
			{
				//Call addBottom method
				Add.addBottom(userInput.getText(), bottomUpload);
				
				//increment count for top since done. 
				bottomCount++;
				
				//reset bottomUpload
				bottomUpload = false;
				
				
				//change scene to Wardrobe fxml
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( Main.class.getResource("controller/Wardrobe.fxml") );

				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );

				Main.stage.setScene(scene);
			}
			
			//shoe
			else if(WardrobeController.clothingTier == "shoe")
			{
			
				//Call addTop method
				Add.addShoe(userInput.getText(), shoeUpload);
				
				//increment count for top since done. 
				shoeCount++;
				
				//reset shoeUpload
				shoeUpload = false;
				
				
				//change scene to Wardrobe fxml
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( Main.class.getResource("controller/Wardrobe.fxml") );

				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );

				Main.stage.setScene(scene);
			}
		}
	}
	
	/**
	 * chooseImage method to add image into resource folder.
	 * 
	 * @param event
	 */
	@FXML
	public void chooseImage(ActionEvent event)
	{
		//Check if user is in top, bottom, or shoe, 
		//upload image with according name,
		//and update appropriate boolean to "true"
		if(WardrobeController.clothingTier == "top")
		{
			Add.addImage("top", topCount);
			topUpload = true;
		}
		else if(WardrobeController.clothingTier == "bottom")
		{
			Add.addImage("bottom", bottomCount);
			bottomUpload = true;
		}
		else if(WardrobeController.clothingTier == "shoe")
		{
			Add.addImage("shoe", shoeCount);
			shoeUpload = true;
		}
	}
}
