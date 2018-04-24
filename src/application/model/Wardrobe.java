/**
 * 
 */
package application.model;


import java.util.Scanner;

/**
 * @author Team Dragon
 *
 */
public class Wardrobe {
	
	//String to determine which clothing ("top", "bottom", or "shoe")
	private String clothingTier;
	
	/**
	 * Wardrobe constructor
	 * 
	 * @param cT
	 */
	public Wardrobe(String cT) {
		
		this.clothingTier = cT;
	}
	
	Scanner userInput = new Scanner(System.in);
	
	public void addClothing() {
		
		System.out.println("enter brand here");
		String brand = userInput.nextLine();
		
		System.out.println("Enter color here");
		String color = userInput.nextLine();
		
		System.out.println("Enter style here");
		String style = userInput.nextLine();
		
		System.out.println(brand + "\n" + color + "\n" + style);
		userInput.close();
	}

	
	
}

