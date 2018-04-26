package application.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

//TODO: Vinh still needs to finish saving Temperature criteria

/**
 * Add model class that takes care of the background
 * processes of Add fxml
 * 
 * @author All Dragon Members of Team Dragon
 *
 */
public class Add {

	private static ArrayList<Wardrobe> Top, Bottom, Shoe;
	
	//String variables for holding names of uploaded image
	private static String topName = "", botName = "", shoeName = "";
	


	/**
	 *Constructor for Add class
	 */
	public Add()
	{	
	}
	
	/**
	 * Add method for top
	 * 
	 * @param String input - String for description of clothing
	 * @param boolean upload - boolean if user uploaded image
	 */
	public static void addTop(String input, boolean upload)
	{
		//check if user uploaded an image or not
		//then add new Wardrobe to arraylist
		if(upload == true)
		{
			Wardrobe top = new Wardrobe(input, topName);
			Top.add(top);
		}
		else
		{
			Wardrobe top = new Wardrobe(input);
			Top.add(top);
		}
	}
	
	/**
	 * Add method for Bottom
	 * 
	 * @param String input - String for description of clothing
	 * @param boolean upload - boolean if user uploaded image
	 */
	public static void addBottom(String input, boolean upload)
	{
		//check if user uploaded an image or not
		//then add new Wardrobe to arraylist
		if(upload == true)
		{
			Wardrobe bottom = new Wardrobe(input, botName);
			Bottom.add(bottom);
		}
		else
		{
			Wardrobe bottom = new Wardrobe(input);
			Bottom.add(bottom);
		}
	}
	
	/**
	 * Add method for Shoe
	 * 
	 * @param String input - String for description of clothing
	 * @param boolean upload - boolean if user uploaded image
	 */
	public static void addShoe(String input, boolean upload)
	{
		//check if user uploaded an image or not
		//then add new Wardrobe to arraylist
		if(upload == true)
		{
			Wardrobe shoe = new Wardrobe(input, shoeName);
			Shoe.add(shoe);
		}
		else
		{
			Wardrobe shoe = new Wardrobe(input);
			Shoe.add(shoe);
		}
	}
	
	
	/**
	 * addImage method is called when addController wants to upload an image 
	 * into resource folder for a clothing item
	 * 
	 * @param clothing - string for cloth tier
	 * @param count - index
	 */
	public static void addImage(String clothing, int count)
	{
		FileChooser c = new FileChooser();
		
		//Get extention filters, and add new extension
		c.getExtensionFilters().add(new ExtensionFilter("JPG","*.jpg"));
		c.getExtensionFilters().add(new ExtensionFilter("PNG","*.png"));
		
		File f = c.showOpenDialog(null);
		
		//create new file with clothing and index in name
		File f1 = new File("src/Resource/" + clothing + Integer.toString(count) + ".png");
		
		//Copy into folder
		try {
			Files.copy(f.toPath(),f1.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f1.getAbsolutePath());
		
		
		
		//update appropriate String variable of clothing url name
		if(clothing.equals("top"))
			topName = "src/Resource/" + "clothing" + Integer.toString(count) + ".png";
		else if(clothing.equals("bottom"))
			botName = "src/Resource/" + "clothing" + Integer.toString(count) + ".png";
		else if(clothing.equals("shoe"))
			shoeName = "src/Resource/" + "clothing" + Integer.toString(count) + ".png";
		
	}
	
	
	
	//Getters and Setters
	public static String getTopName() {
		return topName;
	}

	public static void setTopName(String topName) {
		Add.topName = topName;
	}

	public static String getBotName() {
		return botName;
	}

	public static void setBotName(String botName) {
		Add.botName = botName;
	}

	public static String getShoeName() {
		return shoeName;
	}

	public static void setShoeName(String shoeName) {
		Add.shoeName = shoeName;
	}
}
