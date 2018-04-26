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
	
	private boolean[] tempChecked = new boolean[4];
	
	@FXML
	Button save;
	
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
			
			//Update Temperature info. 
			if(eightyPlus.isSelected() == true)
			{
				tempChecked[0] = true;
			}
			else if(sevNineToSixFive.isSelected() == true)
			{
				tempChecked[1] = true;
			}
			else if(sixFourToFifOne.isSelected() == true)
			{
				tempChecked[2] = true;
			}
			else if(fiftyBelow.isSelected() == true)
			{
				tempChecked[3] = true;
			}

			//check if user is adding a top, bottom, or shoe when saving. 
			//Saves data, and then comes back to Wardrobe page
			
			//top
			if(WardrobeController.clothingTier == "top")
			{
				String tier = "top";
				
				//Call addTop method
				Add.addClothing(tier, userInput.getText(), tempChecked);
				

				
				
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
				String tier = "bottom";
				
				//Call addBottom method
				Add.addClothing(tier, userInput.getText(), tempChecked);
			
				
				
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
			
				String tier = "shoe";
				
				//Call addTop method
				Add.addClothing(tier, userInput.getText(), tempChecked);
				
				
				
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
		//Call addImage method
		Add.addImage();
	}
}
