package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Add model class that takes care of the background
 * processes of Add fxml
 * 
 * @author All Dragon Members of Team Dragon
 *
 */
public class Add {

	//String variables for holding names of uploaded image
	private static String clothingURL = "";

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
	public static void addClothing(String tier, String input, boolean[] temp)
	{
		//top
		if(tier.equals("top"))
		{
			//then add new Wardrobe to arraylist
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Top.csv"),true)); 
				StringBuilder sb = new StringBuilder();
				sb.append(input);
				sb.append(",");
				sb.append(clothingURL);
				
				for(int i = 0; i < temp.length; i++)
				{
					sb.append(",");
					
					if(temp[i] == true)
						sb.append("true");
					else
						sb.append("false");
				}
				sb.append("\n");
				
				pw.write(sb.toString());
				
				pw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//bottom
		else if(tier.equals("bottom"))
		{
			//then add new Wardrobe to arraylist
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Bottom.csv"),true));
				StringBuilder sb = new StringBuilder();
				sb.append(input);
				sb.append(",");
				sb.append(clothingURL);
				
				for(int i = 0; i < temp.length; i++)
				{
					sb.append(",");
					
					if(temp[i] == true)
						sb.append("true");
					else
						sb.append("false");
				}
				sb.append("\n");
				
				pw.write(sb.toString());
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
			//shoe
			else if(tier.equals("shoe"))
			{
				//then add new Wardrobe to arraylist
				try {
					PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Shoes.csv"),true));
					StringBuilder sb = new StringBuilder();
					sb.append(input);
					sb.append(",");
					sb.append(clothingURL);
					
					for(int i = 0; i < temp.length; i++)
					{
						sb.append(",");
						
						if(temp[i] == true)
							sb.append("true");
						else
							sb.append("false");
					}
					sb.append("\n");
					
					pw.write(sb.toString());
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	
	
	/**
	 * addImage method is called when addController wants to upload an image 
	 * into resource folder for a clothing item
	 * 
	 * @param clothing - string for cloth tier
	 * @param count - index
	 */
	public static void addImage()
	{
		try {
		FileChooser c = new FileChooser();
		
		//Get extention filters, and add new extension
		c.getExtensionFilters().add(new ExtensionFilter("JPG","*.jpg"));
		c.getExtensionFilters().add(new ExtensionFilter("PNG","*.png"));
		
		File f = c.showOpenDialog(null);
		
		//create new file with clothing and index in name
		File f1 = new File("src/Resource/" + f.getName());
		
		//Copy into folder
		try {
			Files.copy(f.toPath(),f1.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(f1.getAbsolutePath());
		
		
		
		//update appropriate String variable of clothing url name
		clothingURL = f1.getName();
		}catch(NullPointerException e) {
			System.out.println("Please choose an Image");
		}
		
	}

	//Getters and Setters
	public static String getImageURL() {
		return clothingURL;
	}

}
