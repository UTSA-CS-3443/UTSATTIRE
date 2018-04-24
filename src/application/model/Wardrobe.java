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
	
	private String name, imageFileName;
	private boolean[] temperature = new boolean[4];
	
	
	public Wardrobe(String name) {
		this.name = name;
	}
	
	/**
	 * Wardrobe constructor
	 * 
	 * @param cT
	 */
	public Wardrobe(String name, String image) {
		this.name = name;
		this.imageFileName = image;
	}

	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public boolean[] getTemperature() {
		return temperature;
	}

	public void setTemperature(boolean[] temperature) {
		this.temperature = temperature;
	}
	
	
}

