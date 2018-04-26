package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Outfit {
	
	private static ArrayList<Wardrobe> Top, Bottom, Shoe;
	
	public Outfit()
	{
		File file = new File("Top.csv");
		Scanner inputStream;
		
		try {
			
			inputStream = new Scanner(file);

			System.out.println("Before reading file");
			while(inputStream.hasNextLine())
			{
				
				String data = inputStream.nextLine();
				String[] info = data.split(",");
			
			}
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
