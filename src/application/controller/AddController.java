package application.controller;

import java.io.File;

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
		
		System.out.println(f.getName());
		
		File f1 = new File("C:\\User\\zzn974\\Desktop\\Chrysanthemum.jpg");
		
		System.out.println(f.getAbsolutePath());
		
		
	}

}
