package application.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;


public class AddController 
{
	
	@FXML
	private Button choose;
	
	
	
	
	
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
