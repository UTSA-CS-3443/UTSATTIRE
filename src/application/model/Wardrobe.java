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
	private boolean temp1,  temp2, temp3, temp4;
	
	/**
	 * Wardrobe constructor 
	 * 
	 * @param String name - Description of clothing
	 */
	public Wardrobe(String name,  String imageFileName,boolean temp1, boolean temp2, boolean temp3, boolean temp4)
	{
		this.name = name;
		this.imageFileName = imageFileName;
		this.setTemp2(temp2);
		this.setTemp1(temp1);
		this.setTemp3(temp3);
		this.setTemp4(temp4);
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



	public boolean isTemp1() {
		return temp1;
	}

	public void setTemp1(boolean temp1) {
		this.temp1 = temp1;
	}

	public boolean isTemp2() {
		return temp2;
	}

	public void setTemp2(boolean temp2) {
		this.temp2 = temp2;
	}

	public boolean isTemp3() {
		return temp3;
	}

	public void setTemp3(boolean temp3) {
		this.temp3 = temp3;
	}

	public boolean isTemp4() {
		return temp4;
	}

	public void setTemp4(boolean temp4) {
		this.temp4 = temp4;
	}
	
	
}

