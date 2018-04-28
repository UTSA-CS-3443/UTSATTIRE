package application.model;

/**
 * Wardrobe model class for the background processes when on Wardrobe fxml
 * 
 * @author Team Dragon
 *
 */
public class Wardrobe {

	private String name, imageFileName;
	private boolean temp1 = false, temp2 = false, temp3 = false, temp4 = false;

	/**
	 * Wardrobe constructor
	 * 
	 * @param String
	 *            name - Description of clothing
	 */
	public Wardrobe(String name, String imageFileName, boolean t1, boolean t2, boolean t3, boolean t4) {
		this.name = name;
		this.imageFileName = imageFileName;
		this.setTemp1(t1);
		this.setTemp2(t2);
		this.setTemp3(t3);
		this.setTemp4(t4);

	}

	/**
	 * Wardrobe constructor
	 * 
	 * @param String
	 *            name - Description of clothing
	 */
	public Wardrobe(String name, String imageFileName) {
		this.name = name;
		this.imageFileName = imageFileName;
	}

	// Getters and Setters
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

	public boolean getTemp1() {
		return temp1;
	}

	public void setTemp1(boolean temp1) {
		this.temp1 = temp1;
	}

	public boolean getTemp2() {
		return temp2;
	}

	public void setTemp2(boolean temp2) {
		this.temp2 = temp2;
	}

	public boolean getTemp3() {
		return temp3;
	}

	public void setTemp3(boolean temp3) {
		this.temp3 = temp3;
	}

	public boolean getTemp4() {
		return temp4;
	}

	public void setTemp4(boolean temp4) {
		this.temp4 = temp4;
	}

	public String toString() {
		return "" + getName() + "," + getImageFileName() + "," + getTemp1() + "," + getTemp2() + "," + getTemp3() + ","
				+ getTemp4();
	}
}
