package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Outfit {
	
	public static ArrayList<Wardrobe> Top = new ArrayList<Wardrobe>();

	private static ArrayList<Wardrobe> Bottom = new ArrayList<Wardrobe>();

	private static ArrayList<Wardrobe> Shoe = new ArrayList<Wardrobe>();
	
	private double temperature;
	
	/**
	 * Outfit Constructor
	 */
	public Outfit()
	{	
	}
	
	/**
	 * populateOutfit method that fills the top, bottom, and shoe arraylist
	 * from csv files
	 */
	public void populateOutfit() {
		
		Top.clear();
		Bottom.clear();
		Shoe.clear();
		
		//Fill in ArrayLists-----------------------------------------------------------------------------------
		
		//Create Top outfit
		
		//Read Top.csv
		File file = new File("Top.csv");
		Scanner inputStream;

		try {
			inputStream = new Scanner(file);
			
			//Iterate through file
			while(inputStream.hasNextLine())
			{
				//Get line and split by commas
				String data = inputStream.nextLine();
				String[] info = data.split(",");

				//Create Wardrobe for top
				Wardrobe top = new Wardrobe(info[0], info[1],Boolean.valueOf(info[2]), Boolean.valueOf(info[3]), Boolean.valueOf(info[4]), Boolean.valueOf(info[5]));
				
				//Add Wardrobe to Outfit
				Top.add(top);
			}
			
			//Close inputstream
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Create Bottom outfit
		//Read Bottom.csv
		file = new File("Bottom.csv");
		
		try {
			inputStream = new Scanner(file);
			//Iterate through file
			while(inputStream.hasNextLine())
			{
				//Get line and split by commas
				String data = inputStream.nextLine();
				String[] info = data.split(",");
				
				//Create Wardrobe for Bottom
				Wardrobe bottom = new Wardrobe(info[0], info[1],Boolean.valueOf(info[2]), Boolean.valueOf(info[3]), Boolean.valueOf(info[4]), Boolean.valueOf(info[5]));
				
				//Add Wardrobe to Outfit
				Bottom.add(bottom);
			}
			
			//Close inputStream
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Create Shoe outfit
		//Read from file Shoes.csv
		file = new File("Shoes.csv");
		
		try {
			inputStream = new Scanner(file);
			//Iterate through file
			while(inputStream.hasNextLine())
			{
				
				String data = inputStream.nextLine();
				String[] info = data.split(",");
				
				//Create Wardrobe for Shoe
				Wardrobe shoe = new Wardrobe(info[0], info[1],Boolean.valueOf(info[2]), Boolean.valueOf(info[3]), Boolean.valueOf(info[4]), Boolean.valueOf(info[5]));
	
				//Add shoe to arraylist
				Shoe.add(shoe);
					
			}
			//Close inputstream
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//--------------------------------------------------------------------------------------------------
		
		//Get current temperature
		temperature = (FiveDayForecast.getFahrenheit(FiveDayForecast.getForecast().get(0).getTemp()));
	}
	
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
			int index = ThreadLocalRandom.current().nextInt(0, Top.size()-1);
			//int index = 0;
			
			//Temp Wardrobe
			Wardrobe temp = Top.get(index);
			
			//check if clothing index fits temperature criteria
			//80+, 79-65, 64-51, 50-
			if(temperature >= 80 )
			{
				if(temp.getTemp1() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
			else if(temperature < 80 && temperature >= 65 )
			{
				System.out.println(temp.toString());
				System.out.println("Should be the index: " + index+" "+ temp.getImageFileName());
				if(temp.getTemp2() == true)
					return temp;
				else {
					loop = true;
				}
				//Stop loop
				
			}
			else if(temperature < 65 && temperature > 50 )
			{
				if(temp.getTemp3() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
			else
			{
				if(temp.getTemp4() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
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

		//Loop until gets appropriate Bottom
		while(loop == true)
		{
			//Randomly generated index
			int index = ThreadLocalRandom.current().nextInt(0, Top.size()-1);

			Wardrobe temp = Bottom.get(index);
			
			//check if clothing index fits temperature criteria
			//80+, 79-65, 64-51, 50-
			if(temperature >= 80 )
			{
				if(temp.getTemp1() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
			else if(temperature < 80 && temperature >= 65 )
			{
				if(temp.getTemp2() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}

			}
			else if(temperature < 65 && temperature > 50 )
			{
				if(temp.getTemp3() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
			else
			{
				if(temp.getTemp4() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
		}
		return null;
	}
	
	/**
	 * getTodayShoe method returns top object for Generate 
	 * 
	 * @return 
	 */
	public Wardrobe getTodayShoe()
	{
		boolean loop = true;

		//Loop until gets appropriate Shoe
		while(loop == true)
		{
			//Randomly generated index
			int index = ThreadLocalRandom.current().nextInt(0, Top.size()-1);

			Wardrobe temp = Shoe.get(index);
			
			//check if clothing index fits temperature criteria
			//80+, 79-65, 64-51, 50-
			if(temperature >= 80 )
			{
				if(temp.getTemp1() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
			else if(temperature < 80 && temperature >= 65 )
			{
				if(temp.getTemp2() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
			else if(temperature < 65 && temperature > 50 )
			{
				if(temp.getTemp3() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
			else
			{
				if(temp.getTemp4() == true)
					return temp;
				//Stop loop
				else {
					loop = true;
				}
			}
		}
		return null;
	}
}
