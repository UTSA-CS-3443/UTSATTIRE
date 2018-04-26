package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

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
	@FXML
	private ImageView current;
	
	
	private ArrayList<String> top = new ArrayList<String>();
	private ArrayList<String> bottom = new ArrayList<String>();
	private ArrayList<String> shoe = new ArrayList<String>();
	
	public void populate() throws FileNotFoundException
	{
		File file = new File("Top.csv");
		Scanner inputStream = new Scanner(file);
		System.out.println("Before reading file");
		while(inputStream.hasNextLine())
		{
			String data = inputStream.nextLine();
			String filePath;
			String[] info = data.split(",");
			top.add(info[0]);
		}
		inputStream.close();

		File file1 = new File("Bottom.csv");
		Scanner inputStream1 = new Scanner(file1);
		System.out.println("Before reading file");
		while(inputStream1.hasNextLine())
		{
			String data = inputStream1.nextLine();
			String filePath;
			String[] info = data.split(",");
			bottom.add(info[0]);
		}
		inputStream1.close();
		
		File file2 = new File("Shoes.csv");
		Scanner inputStream2 = new Scanner(file2);
		System.out.println("Before reading file");
		while(inputStream2.hasNextLine())
		{
			String data = inputStream2.nextLine();
			String filePath;
			String[] info = data.split(",");
			shoe.add(info[0]);
		}
		inputStream2.close();
		
		
	}
	@FXML
	public void handle(ActionEvent event)
	{
		System.out.println(tops.getSelectionModel().getSelectedItem());

	}
		
	@FXML
	public void initialize() throws FileNotFoundException 
	{
		
		populate();
		
		ObservableList<String> history = FXCollections.observableArrayList(
				top);
		ObservableList<String> history1 = FXCollections.observableArrayList(
				bottom);
		ObservableList<String> history2 = FXCollections.observableArrayList(
				shoe);
		tops.setItems(history);
		bottoms.setItems(history1);
		shoes.setItems(history2);
		
	}
	
	
	
	
	
	
}
