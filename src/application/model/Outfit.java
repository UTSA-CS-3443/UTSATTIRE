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
	 * Sets up ArrayList and current Temperature
	 * @throws FileNotFoundException 
	 */
	public Outfit()
	{
			
	}
	
	public void populateOutfit() {
		Top.clear();
		Bottom.clear();
		Shoe.clear();
		//Fill in ArrayList-----------------------------------------------------------------------------------
		
		//Create Top outfit
		File file = new File("Top.csv");
		Scanner inputStream;

		try {
			
			inputStream = new Scanner(file);

			while(inputStream.hasNextLine())
			{

				String data = inputStream.nextLine();

				String[] info = data.split(",");

				//Create Wardrobe for top
				Wardrobe top = new Wardrobe(info[0], info[1],Boolean.valueOf(info[2]), Boolean.valueOf(info[3]), Boolean.valueOf(info[4]), Boolean.valueOf(info[5]));
				
			/*	for(int i = 2; i < info.length; i++)
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
				}*/
				
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

			while(inputStream.hasNextLine())
			{
				
				String data = inputStream.nextLine();
				String[] info = data.split(",");
				
				//Create Wardrobe for Bottom
				Wardrobe bottom = new Wardrobe(info[0], info[1],Boolean.valueOf(info[2]), Boolean.valueOf(info[3]), Boolean.valueOf(info[4]), Boolean.valueOf(info[5]));
				
				/*for(int i = 2; i < info.length; i++)
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
				}*/
				
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

			while(inputStream.hasNextLine())
			{
				
				String data = inputStream.nextLine();
				String[] info = data.split(",");
				
				//Create Wardrobe for Shoe
				Wardrobe shoe = new Wardrobe(info[0], info[1],Boolean.valueOf(info[2]), Boolean.valueOf(info[3]), Boolean.valueOf(info[4]), Boolean.valueOf(info[5]));
				
				/*for(int i = 2; i < info.length; i++)
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
				}*/
				
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
			int index = ThreadLocalRandom.current().nextInt(0, Top.size() -1);
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

		//Loop until gets appropriate Top
		while(loop == true)
		{
			//System.out.println(Top.size());
			//Randomly generated index
			int index = ThreadLocalRandom.current().nextInt(0, Top.size()-1);
				//int index = 0;
			//Temp Wardrobe
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
	 * @return
	 */
	public Wardrobe getTodayShoe()
	{
		boolean loop = true;

		//Loop until gets appropriate Top
		while(loop == true)
		{
			//Randomly generated index
			int index = ThreadLocalRandom.current().nextInt(0, Top.size()-1);
			//int index = 1;
			
			//Temp Wardrobe
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
	

	
	//Getters
	
	/**
	 * String method to get imageURL of top
	 * @return String temp.getImageFIleName()
	 */
	public String getTopURL()
	{
		System.out.println("Enter getTopURL: ");
		Wardrobe temp = getTodayTop();
		System.out.println("---------"+temp.getImageFileName() );
		System.out.println("Exit getTopURL: ");
		return  temp.getImageFileName();
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
		return  temp.getImageFileName();
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
