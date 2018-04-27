package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import application.model.Wardrobe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class EditController 
{
	@FXML
	private AnchorPane rootPane;
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
	@FXML
	public CheckBox eightyPlus, sevNineToSixFive, sixFourToFifOne, fiftyBelow;
	@FXML
	public TextField userInput;
	private static boolean[] tempChecked = new boolean[4];
	
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
	public void handle(ActionEvent event) throws IOException
	{
		ObservableList<String> history = FXCollections.observableArrayList(
				top);
		ObservableList<String> history1 = FXCollections.observableArrayList(
				bottom);
		ObservableList<String> history2 = FXCollections.observableArrayList(
				shoe);
//		System.out.println(tops.getSelectionModel().getSelectedItem());
//		System.out.println(bottoms.getSelectionModel().getSelectedItem());
//		System.out.println(shoes.getSelectionModel().getSelectedItem());
//		System.out.println(tops.getSelectionModel().getSelectedItem());
//		if(tops.getSelectionModel().getSelectedItem() != null && bottoms.getSelectionModel().getSelectedItem() == null && shoes.getSelectionModel().getSelectedItem() == null)
//		{
//		for(int i=0; i < top.size();i++)
//		{
//			//System.out.println("---------------------" + topInfo.get(i).getImageFileName());
//			//System.out.println(tops.getSelectionModel().getSelectedItem() + "-----------------------");
//			
//			if(topInfo.get(i).getName().equals(tops.getSelectionModel().getSelectedItem()))
//			{
//				FileInputStream input;
//				try {
//					System.out.println("---------------------" + topInfo.get(i).getImageFileName());
//					input = new FileInputStream(topInfo.get(i).getImageFileName());
//					Image image = new Image(input);
//					System.out.println(topInfo.get(i).getImageFileName());
//					current.setImage(image);
//					
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		}
		
		String newName = userInput.getText();
		
		
		if(eightyPlus.isSelected() == true)
			tempChecked[0] = true;
		
		if(sevNineToSixFive.isSelected() == true)
			tempChecked[1] = true;
		
		if(sixFourToFifOne.isSelected() == true)
			tempChecked[2] = true;
		
		if(fiftyBelow.isSelected() == true)
			tempChecked[3] = true;
		//System.out.println(topInfo);
		
		
		if(tops.getSelectionModel().getSelectedItem() != null && bottoms.getSelectionModel().getSelectedItem() == null && shoes.getSelectionModel().getSelectedItem() == null)
		{
			for(int i=0; i < top.size();i++)
			{
				//System.out.println("---------------------" + topInfo.get(i).getImageFileName());
				//System.out.println(tops.getSelectionModel().getSelectedItem() + "-----------------------");
				
				if(topInfo.get(i).getName().equals(tops.getSelectionModel().getSelectedItem()))
				{

					replaceSelected(i,topInfo,"Top.csv",newName);
					 
					
				}
			}
			
		}
		if(bottoms.getSelectionModel().getSelectedItem() != null && tops.getSelectionModel().getSelectedItem() == null && shoes.getSelectionModel().getSelectedItem() == null)
		{
			for(int i=0; i < bottom.size();i++)
			{
				//System.out.println("---------------------" + topInfo.get(i).getImageFileName());
				//System.out.println(tops.getSelectionModel().getSelectedItem() + "-----------------------");
				
				if(bottomInfo.get(i).getName().equals(bottoms.getSelectionModel().getSelectedItem()))
				{

					replaceSelected(i,bottomInfo,"Bottom.csv",newName);
					 
					
				}
			}
			
		}
		if(shoes.getSelectionModel().getSelectedItem() != null && tops.getSelectionModel().getSelectedItem() == null && bottoms.getSelectionModel().getSelectedItem() == null)
		{
			for(int i=0; i < shoe.size();i++)
			{
				//System.out.println("---------------------" + topInfo.get(i).getImageFileName());
				//System.out.println(tops.getSelectionModel().getSelectedItem() + "-----------------------");
				
				if(shoeInfo.get(i).getName().equals(shoes.getSelectionModel().getSelectedItem()))
				{

					replaceSelected(i,shoeInfo,"Shoes.csv",newName);
					 
					
				}
			}
			
		}
		
		
		
		tops.setItems(null);
		tops.setItems(history);
		bottoms.setItems(null);
		bottoms.setItems(history1);
		shoes.setItems(null);
		shoes.setItems(history2);
		
		
		handleRefresh();
		
	}
	public static void replaceSelected(int i, ArrayList<Wardrobe> tops, String inputFile, String newName) {
	    try {
	        // input the file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader(inputFile));
	        String line;
	        StringBuffer inputBuffer = new StringBuffer();

	        while ((line = file.readLine()) != null) {
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        String inputStr = inputBuffer.toString();

	        file.close();

	        //System.out.println(inputStr); // check that it's inputted right

	        // this if structure determines whether or not to replace "0" or "1"
	       
//	        System.out.println(userInput.getText() + "," + tops.get(i).getImageFileName() + "," + tempChecked[0] + "," + tempChecked[1] + "," + tempChecked[2] + "," + tempChecked[3]);
	        
	        System.out.println(tops.get(i).getName()+","+tops.get(i).getImageFileName() + "," + tops.get(i).getTemp1() + "," + tops.get(i).getTemp2() + "," + tops.get(i).getTemp3
            		() + "," + tops.get(i).getTemp4());
	        
	        System.out.println(newName);
	        
	            inputStr = inputStr.replace(tops.get(i).getName()+","+tops.get(i).getImageFileName() + "," + tops.get(i).getTemp1() + "," + tops.get(i).getTemp2() + "," + tops.get(i).getTemp3
	            		() + "," + tops.get(i).getTemp4(), newName + "," + tops.get(i).getImageFileName() + "," + tempChecked[0] + "," + tempChecked[1] + "," + tempChecked[2] + "," + tempChecked[3]); 
	      

	        
	        // check if the new input is right
	        System.out.println("----------------------------------\n"  + inputStr);

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(inputFile);
	        fileOut.write(inputStr.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
	public void handleWardrobe() throws IOException
	{
		
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Wardrobe.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	public void handleRefresh() throws IOException
	{
		eightyPlus.setSelected(false);
	    sevNineToSixFive.setSelected(false);
	    sixFourToFifOne.setSelected(false);
	    fiftyBelow.setSelected(false);
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Edit.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
		
	@FXML
	public void initialize() throws FileNotFoundException 
	{
		eightyPlus.setSelected(false);
	    sevNineToSixFive.setSelected(false);
	    sixFourToFifOne.setSelected(false);
	    fiftyBelow.setSelected(false);
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
