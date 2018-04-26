package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Outfit {
	
	private static ArrayList<Wardrobe> Top, Bottom, Shoe;
	
	public Outfit()
	{
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
	}
}
