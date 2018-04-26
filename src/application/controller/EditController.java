package application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import application.model.Wardrobe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
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
	private ArrayList<Wardrobe> topInfo = new ArrayList<Wardrobe>();
	private ArrayList<Wardrobe> bottomInfo = new ArrayList<Wardrobe>();
	private ArrayList<Wardrobe> shoeInfo = new ArrayList<Wardrobe>();
	
	public void populate() throws FileNotFoundException
	{
		File file = new File("Top.csv");
		Scanner inputStream = new Scanner(file);
		
		System.out.println("Before reading file");
		while(inputStream.hasNextLine())
		{
			
			String data = inputStream.nextLine();
			String[] info = data.split(",");
			Boolean temp1 = Boolean.valueOf(info[2]);
			Boolean temp2 = Boolean.valueOf(info[3]);
			Boolean temp3 = Boolean.valueOf(info[4]);
			Boolean temp4 = Boolean.valueOf(info[5]);
			Wardrobe T = new Wardrobe(info[0],info[1],temp1,temp2,temp3,temp4);
			topInfo.add(T);
			top.add(info[0]);
		}
		inputStream.close();

		File file1 = new File("Bottom.csv");
		Scanner inputStream1 = new Scanner(file1);
		System.out.println("Before reading file");
		while(inputStream1.hasNextLine())
		{
			String data = inputStream1.nextLine();
			String[] info = data.split(",");
			Boolean temp1 = Boolean.valueOf(info[2]);
			Boolean temp2 = Boolean.valueOf(info[3]);
			Boolean temp3 = Boolean.valueOf(info[4]);
			Boolean temp4 = Boolean.valueOf(info[5]);
			Wardrobe T = new Wardrobe(info[0],info[1],temp1,temp2,temp3,temp4);
			bottomInfo.add(T);
			bottom.add(info[0]);
		}
		inputStream1.close();
		
		File file2 = new File("Shoes.csv");
		Scanner inputStream2 = new Scanner(file2);
		System.out.println("Before reading file");
		while(inputStream2.hasNextLine())
		{
			String data = inputStream2.nextLine();
			String[] info = data.split(",");
			Boolean temp1 = Boolean.valueOf(info[2]);
			Boolean temp2 = Boolean.valueOf(info[3]);
			Boolean temp3 = Boolean.valueOf(info[4]);
			Boolean temp4 = Boolean.valueOf(info[5]);
			Wardrobe T = new Wardrobe(info[0],info[1],temp1,temp2,temp3,temp4);
			shoeInfo.add(T);
			shoe.add(info[0]);
		}
		inputStream2.close();
		
		
	}
	@FXML
	public void handle(ActionEvent event)
	{
		ObservableList<String> history = FXCollections.observableArrayList(
				top);
		ObservableList<String> history1 = FXCollections.observableArrayList(
				bottom);
		ObservableList<String> history2 = FXCollections.observableArrayList(
				shoe);
		System.out.println(tops.getSelectionModel().getSelectedItem());
		System.out.println(bottoms.getSelectionModel().getSelectedItem());
		System.out.println(shoes.getSelectionModel().getSelectedItem());
		for(int i=0; i < top.size();i++)
		{
			System.out.println("---------------------" + topInfo.get(i).getImageFileName());
			//System.out.println(tops.getSelectionModel().getSelectedItem() + "-----------------------");
			
			if(topInfo.get(i).getName().equals(tops.getSelectionModel().getSelectedItem()))
			{
				FileInputStream input;
				try {
					input = new FileInputStream("Resource/" + topInfo.get(i).getImageFileName());
					Image image = new Image(input);
					System.out.println(topInfo.get(i).getImageFileName());
					current.setImage(image);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		tops.setItems(null);
		tops.setItems(history);
		bottoms.setItems(null);
		bottoms.setItems(history1);
		shoes.setItems(null);
		shoes.setItems(history2);
		
		
		
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
