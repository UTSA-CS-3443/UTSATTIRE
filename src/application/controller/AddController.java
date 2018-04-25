package application.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import application.Main;
import application.model.Wardrobe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class AddController 
{
	ArrayList<Wardrobe> Top, Bottom, Shoe;
	
	@FXML
	private Button choose;
	
	@FXML
	TextField userInput;
	
	@FXML
	Text title;
	
	//80+, 79-65, 64-51, 50-
	@FXML
	CheckBox eightyPlus, sevNineToSixFive, sixFourToFifOne, fiftyBelow;
	
	@FXML
	Button save;
	
	@FXML
	public void buttonClicked(ActionEvent event) throws IOException {
		
		//When user clicks save button
		if(event.getSource() == save) {
			
			//check if user is adding a top, bottom, or shoe
			if(WardrobeController.clothingTier == "top")
			{
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( Main.class.getResource("controller/Wardrobe.fxml") );

				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );

				Main.stage.setScene(scene);
			}
			else if(WardrobeController.clothingTier == "bottom")
			{
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( Main.class.getResource("controller/Wardrobe.fxml") );

				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );

				Main.stage.setScene(scene);
			}
			else if(WardrobeController.clothingTier == "shoe")
			{
			
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( Main.class.getResource("controller/Wardrobe.fxml") );

				AnchorPane layout = (AnchorPane) loader.load();				
				Scene scene = new Scene( layout );

				Main.stage.setScene(scene);
			}
			
		}
	}
	
	@FXML
	public void chooseImage(ActionEvent event)
	{
		FileChooser c = new FileChooser();
		
		c.getExtensionFilters().add(new ExtensionFilter("JPG","*.jpg"));
		c.getExtensionFilters().add(new ExtensionFilter("PNG","*.png"));
		File f = c.showOpenDialog(null);
		
		//System.out.println(f.getName());
		
		File f1 = new File("src/Resource/newPic.png");
		try {
			Files.copy(f.toPath(),f1.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f1.getAbsolutePath());
		
		
		
		
	}

}
