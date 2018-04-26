package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Outfit {
	
	private static ArrayList<Wardrobe> Top, Bottom, Shoe;
	
	private double temperature;
	
	/**
	 * Outfit Constructor
	 * Sets up ArrayList and current Temperature
	 */
	public Outfit()
	{
		//Fill in ArrayList-----------------------------------------------------------------------------------
		
		//Create Top outfit
		File file = new File("Top.csv");
		Scanner inputStream;
		
		try {
			
			inputStream = new Scanner(file);

			System.out.println("Before reading file");
			while(inputStream.hasNextLine())
			{
				
				String data = inputStream.nextLine();
				String[] info = data.split(",");
				
				//Create Wardrobe for top
				Wardrobe top = new Wardrobe(info[0], info[1]);
				
				for(int i = 2; i < info.length; i++)
				{
					switch(i)
					{
						case 2: if(info[i].equals("true"))
									top.setTemp1(true);
								break;
						case 3: if(info[i].equals("true"))
									top.setTemp2(true);
								break;
						case 4: if(info[i].equals("true"))
									top.setTemp3(true);
								break;
						case 5: if(info[i].equals("true"))
									top.setTemp4(true);
								break;	
					}
				}
				
				Top.add(top);
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Create Bottom outfit
		file = new File("Bottom.csv");
		
		try {
			
			inputStream = new Scanner(file);

			System.out.println("Before reading file");
			while(inputStream.hasNextLine())
			{
				
				String data = inputStream.nextLine();
				String[] info = data.split(",");
				
				//Create Wardrobe for Bottom
				Wardrobe bottom = new Wardrobe(info[0], info[1]);
				
				for(int i = 2; i < info.length; i++)
				{
					switch(i)
					{
						case 2: if(info[i].equals("true"))
									bottom.setTemp1(true);
								break;
						case 3: if(info[i].equals("true"))
									bottom.setTemp2(true);
								break;
						case 4: if(info[i].equals("true"))
									bottom.setTemp3(true);
								break;
						case 5: if(info[i].equals("true"))
									bottom.setTemp4(true);
								break;	
					}
				}
				
				Bottom.add(bottom);
			}
			inputStream.close();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//Create Shoe outfit
		file = new File("Shoes.csv");
		
		try {
			
			inputStream = new Scanner(file);

			System.out.println("Before reading file");
			while(inputStream.hasNextLine())
			{
				
				String data = inputStream.nextLine();
				String[] info = data.split(",");
				
				//Create Wardrobe for Shoe
				Wardrobe shoe = new Wardrobe(info[0], info[1]);
				
				for(int i = 2; i < info.length; i++)
				{
					switch(i)
					{
						case 2: if(info[i].equals("true"))
									shoe.setTemp1(true);
								break;
						case 3: if(info[i].equals("true"))
									shoe.setTemp2(true);
								break;
						case 4: if(info[i].equals("true"))
									shoe.setTemp3(true);
								break;
						case 5: if(info[i].equals("true"))
									shoe.setTemp4(true);
								break;	
					}
				}
				
					Shoe.add(shoe);
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//--------------------------------------------------------------------------------------------------
		
		//Get current temperature
		temperature = (FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(0).getTemp()));
		
	}
	
	
	
	//private static ArrayList<Wardrobe> Top, Bottom, Shoe;
	//private double temperature;
	//80+, 79-65, 64-51, 50-
	
	/**
	 * getTodayTop method returns top object for Generate 
	 * @return
	 */
	public Wardrobe getTodayTop()
	{
		boolean loop = true;

		//Loop until gets appropriate Top
		while(loop == true)
		{
			//Randomly generated index
			int index = ThreadLocalRandom.current().nextInt(0, Top.size());
		
			//Temp Wardrobe
			Wardrobe temp = Top.get(index);
			
			//check if clothing index fits temperature criteria
			//80+, 79-65, 64-51, 50-
			if(temperature >= 80 )
			{
				if(temp.getTemp1() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else if(temperature < 80 && temperature >= 65 )
			{
				if(temp.getTemp2() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else if(temperature < 65 && temperature > 50 )
			{
				if(temp.getTemp3() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else
			{
				if(temp.getTemp4() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
		}
		return null;
	}
	
	/**
	 * getTodayBottom method returns top object for Generate 
	 * @return
	 */
	public Wardrobe getTodayBottom()
	{
		boolean loop = true;

		//Loop until gets appropriate Top
		while(loop == true)
		{
			//Randomly generated index
			int index = ThreadLocalRandom.current().nextInt(0, Top.size());
		
			//Temp Wardrobe
			Wardrobe temp = Bottom.get(index);
			
			//check if clothing index fits temperature criteria
			//80+, 79-65, 64-51, 50-
			if(temperature >= 80 )
			{
				if(temp.getTemp1() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else if(temperature < 80 && temperature >= 65 )
			{
				if(temp.getTemp2() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else if(temperature < 65 && temperature > 50 )
			{
				if(temp.getTemp3() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else
			{
				if(temp.getTemp4() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
		}
		return null;
	}
	
	/**
	 * getTodayShoe method returns top object for Generate 
	 * @return
	 */
	public Wardrobe getTodayShoe()
	{
		boolean loop = true;

		//Loop until gets appropriate Top
		while(loop == true)
		{
			//Randomly generated index
			int index = ThreadLocalRandom.current().nextInt(0, Top.size());
		
			//Temp Wardrobe
			Wardrobe temp = Shoe.get(index);
			
			//check if clothing index fits temperature criteria
			//80+, 79-65, 64-51, 50-
			if(temperature >= 80 )
			{
				if(temp.getTemp1() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else if(temperature < 80 && temperature >= 65 )
			{
				if(temp.getTemp2() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else if(temperature < 65 && temperature > 50 )
			{
				if(temp.getTemp3() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
			else
			{
				if(temp.getTemp4() == true)
					return temp;
				//Stop loop
				loop = false;
				break;
			}
		}
		return null;
	}
	

	
	//Getters
	
	/**
	 * String method to get imageURL of top
	 * @return String temp.getImageFIleName()
	 */
	public String getTopURL()
	{
		Wardrobe temp = getTodayTop();
		return temp.getImageFileName();
	}
	
	/**
	 * String method to get imageURL of bottom
	 * @return String temp.getImageFIleName()
	 */
	public String getBottomURL()
	{
		Wardrobe temp = getTodayBottom();
		return temp.getImageFileName();
	}
	
	/**
	 * String method to get imageURL of Shoe
	 * @return String temp.getImageFIleName()
	 */
	public String getShoeURL()
	{
		Wardrobe temp = getTodayShoe();
		return temp.getImageFileName();
	}
	
	/**
	 * String method to get name of Top
	 * @return String temp.getImageFIleName()
	 */
	public String getTopName()
	{
		Wardrobe temp = getTodayTop();
		return temp.getName();
	}
	
	/**
	 * String method to get name of bottom
	 * @return String temp.getImageFIleName()
	 */
	public String getBottomName()
	{
		Wardrobe temp = getTodayBottom();
		return temp.getName();
	}
	
	/**
	 * String method to get imageURL of Shoe
	 * @return String temp.getImageFIleName()
	 */
	public String getShoeName()
	{
		Wardrobe temp = getTodayShoe();
		return temp.getName();
	}
}
