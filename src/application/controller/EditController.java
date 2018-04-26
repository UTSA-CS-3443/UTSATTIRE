package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.model.Wardrobe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class EditController 
{
	@FXML
	private ListView<String> tops;
	@FXML
	private ListView<String> bottoms;
	@FXML
	private ListView<String> shoes;
	@FXML
	private Button edit;
	@FXML
	private Button home;
	
	
	private ArrayList<String> top = new ArrayList<String>();
	private ArrayList<Wardrobe> bottom = new ArrayList<Wardrobe>();
	private ArrayList<Wardrobe> shoe = new ArrayList<Wardrobe>();
	
	public void populate() throws FileNotFoundException
	{
		File file = new File("Top.csv");
		Scanner inputStream = new Scanner(file);
		System.out.println("Before reading file");
		while(inputStream.hasNextLine())
		{
			String data = inputStream.nextLine();
			String[] info = data.split(",");
			top.add(info[0]);
		}
		inputStream.close();

		File file = new File("Bottoms.csv");
		Scanner inputStream = new Scanner(file);
		System.out.println("Before reading file");
		while(inputStream.hasNextLine())
		{
			String data = inputStream.nextLine();
			String[] info = data.split(",");
			top.add(info[0]);
		}
		inputStream.close();
	}
		
	@FXML
	public void initialize() throws FileNotFoundException 
	{
		
		populate();
		
		ObservableList<String> history = FXCollections.observableArrayList(
				top);
		tops.setItems(history);
		
	}
	
	
	
	
	
	
}
