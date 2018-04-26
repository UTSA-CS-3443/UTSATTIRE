package application.model;

/**
 * Wardrobe model class for the background processes when
 * on Wardrobe fxml
 * 
 * @author Team Dragon
 *
 */
public class Wardrobe {
	
	private String name, imageFileName;
	private boolean[] temperature = new boolean[4];
	
	/**
	 * First Wardrobe constructor with just description
	 * if user did not want to upload image
	 * 
	 * @param String name - Description of clothing
	 */
	public Wardrobe(String name) {
		this.name = name;
	}
	
	/**
	 * Second Wardrobe constructor with description
	 * and upload image url
	 * 
	 * @param String name - Description of clothing
	 * @param String image - image url
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

