package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import application.model.Wardrobe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * @author Team Dragon
 * 
 *         This class is responsible for taking in the values the user would
 *         like to assign to their selected item they Wish to edit or delete the
 *         value that they select from the file
 */
public class EditController {
	@FXML
	private AnchorPane rootPane;
	
	@FXML
	private ListView<String> tops;
	
	@FXML
	private ListView<String> bottoms;
	
	@FXML
	private ListView<String> shoes;
	
	@FXML
	private Button edit;
	
	@FXML
	private Button home;
	
	@FXML
	private ImageView current;
	
	@FXML
	public CheckBox eightyPlus, sevNineToSixFive, sixFourToFifOne, fiftyBelow;
	
	@FXML
	public TextField userInput;
	
	// Boolean array for temperatures range
	private static boolean[] tempChecked = new boolean[4];
	
	// String ArrayList for the ListView
	private ArrayList<String> top = new ArrayList<String>();
	private ArrayList<String> bottom = new ArrayList<String>();
	private ArrayList<String> shoe = new ArrayList<String>();

	// Wardrobe ArrayList for editing
	private ArrayList<Wardrobe> topInfo = new ArrayList<Wardrobe>();
	private ArrayList<Wardrobe> bottomInfo = new ArrayList<Wardrobe>();
	private ArrayList<Wardrobe> shoeInfo = new ArrayList<Wardrobe>();

	/**
	 * Populates a Wardrobe object with the current items in the CSV file. Then adds
	 * object to array list and adds the name of the item to a separate string array
	 * so that it can be compared later
	 * 
	 * @throws FileNotFoundException
	 * 				File not found
	 */
	public void populate() throws FileNotFoundException {
		
		File file = new File("Top.csv");
		Scanner inputStream = new Scanner(file);

		while (inputStream.hasNextLine()) {

			String data = inputStream.nextLine();
			String[] info = data.split(",");
			Boolean temp1 = Boolean.valueOf(info[2]);
			Boolean temp2 = Boolean.valueOf(info[3]);
			Boolean temp3 = Boolean.valueOf(info[4]);
			Boolean temp4 = Boolean.valueOf(info[5]);
			Wardrobe T = new Wardrobe(info[0], info[1], temp1, temp2, temp3, temp4);
			topInfo.add(T);
			top.add(info[0]);
		}
		inputStream.close();

		File file1 = new File("Bottom.csv");
		Scanner inputStream1 = new Scanner(file1);
		while (inputStream1.hasNextLine()) {
			String data = inputStream1.nextLine();
			String[] info = data.split(",");
			Boolean temp1 = Boolean.valueOf(info[2]);
			Boolean temp2 = Boolean.valueOf(info[3]);
			Boolean temp3 = Boolean.valueOf(info[4]);
			Boolean temp4 = Boolean.valueOf(info[5]);
			Wardrobe T = new Wardrobe(info[0], info[1], temp1, temp2, temp3, temp4);
			bottomInfo.add(T);
			bottom.add(info[0]);
		}
		inputStream1.close();

		File file2 = new File("Shoes.csv");
		Scanner inputStream2 = new Scanner(file2);
		while (inputStream2.hasNextLine()) {
			String data = inputStream2.nextLine();
			String[] info = data.split(",");
			Boolean temp1 = Boolean.valueOf(info[2]);
			Boolean temp2 = Boolean.valueOf(info[3]);
			Boolean temp3 = Boolean.valueOf(info[4]);
			Boolean temp4 = Boolean.valueOf(info[5]);
			Wardrobe T = new Wardrobe(info[0], info[1], temp1, temp2, temp3, temp4);
			shoeInfo.add(T);
			shoe.add(info[0]);
		}
		inputStream2.close();

	}

	/**
	 * Deletes the line in the file that is passed in.
	 * 
	 * @param file:
	 *            Name of the file you wish to open
	 * @param getRidOf:
	 *            The String you wish to get rid of
	 * @throws IOException
	 * 		File not found
	 */
	public void delete(String file, String getRidOf) throws IOException {
		try {

			File inFile = new File(file);

			if (!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
			}

			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {

				if (!line.trim().equals(getRidOf)) {

					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Event listener that executes the delete method and depending on which item is
	 * selected it passes the information that is required for that specific
	 * instance.
	 *
	 * @param event:
	 *            Button on the FXML
	 * @throws IOException
	 * 		File not found
	 */
	@FXML
	public void handleDelete(ActionEvent event) throws IOException {
		
		if (tops.getSelectionModel().getSelectedItem() != null && bottoms.getSelectionModel().getSelectedItem() == null
				&& shoes.getSelectionModel().getSelectedItem() == null) {
			
			for (int i = 0; i < top.size(); i++) {

				if (topInfo.get(i).getName().equals(tops.getSelectionModel().getSelectedItem())) {

					delete("Top.csv",
							topInfo.get(i).getName() + "," + topInfo.get(i).getImageFileName() + ","
									+ topInfo.get(i).getTemp1() + "," + topInfo.get(i).getTemp2() + ","
									+ topInfo.get(i).getTemp3() + "," + topInfo.get(i).getTemp4());

				}
			}

		}
		if (bottoms.getSelectionModel().getSelectedItem() != null && tops.getSelectionModel().getSelectedItem() == null
				&& shoes.getSelectionModel().getSelectedItem() == null) {

		}
		if (shoes.getSelectionModel().getSelectedItem() != null && tops.getSelectionModel().getSelectedItem() == null
				&& bottoms.getSelectionModel().getSelectedItem() == null) {

		}
		handleRefresh();
	}

	/**
	 * Displays the three different arraylists onto the listview so that it can be
	 * refreshed becaue the replaceSelected method is called which updates the file
	 * and accounts for the different situations that are possible when chossing the
	 * threee different items
	 * 
	 * @param event
	 * 			user control
	 * @throws IOException
	 * 		File not found
	 */
	@FXML
	public void handle(ActionEvent event) throws IOException {
		ObservableList<String> history = FXCollections.observableArrayList(top);
		ObservableList<String> history1 = FXCollections.observableArrayList(bottom);
		ObservableList<String> history2 = FXCollections.observableArrayList(shoe);

		String newName = userInput.getText();

		if (eightyPlus.isSelected() == true)
			tempChecked[0] = true;

		if (sevNineToSixFive.isSelected() == true)
			tempChecked[1] = true;

		if (sixFourToFifOne.isSelected() == true)
			tempChecked[2] = true;

		if (fiftyBelow.isSelected() == true)
			tempChecked[3] = true;

		if (tops.getSelectionModel().getSelectedItem() != null && bottoms.getSelectionModel().getSelectedItem() == null
				&& shoes.getSelectionModel().getSelectedItem() == null) {
			for (int i = 0; i < top.size(); i++) {
				if (topInfo.get(i).getName().equals(tops.getSelectionModel().getSelectedItem())) {

					replaceSelected(i, topInfo, "Top.csv", newName);

				}
			}

		}
		if (bottoms.getSelectionModel().getSelectedItem() != null && tops.getSelectionModel().getSelectedItem() == null
				&& shoes.getSelectionModel().getSelectedItem() == null) {
			for (int i = 0; i < bottom.size(); i++) {
				if (bottomInfo.get(i).getName().equals(bottoms.getSelectionModel().getSelectedItem())) {

					replaceSelected(i, bottomInfo, "Bottom.csv", newName);

				}
			}

		}
		if (shoes.getSelectionModel().getSelectedItem() != null && tops.getSelectionModel().getSelectedItem() == null
				&& bottoms.getSelectionModel().getSelectedItem() == null) {
			for (int i = 0; i < shoe.size(); i++) {
				if (shoeInfo.get(i).getName().equals(shoes.getSelectionModel().getSelectedItem())) {
					replaceSelected(i, shoeInfo, "Shoes.csv", newName);

				}
			}

		}
		
		tops.setItems(null);
		tops.setItems(history);
		bottoms.setItems(null);
		bottoms.setItems(history1);
		shoes.setItems(null);
		shoes.setItems(history2);
		handleRefresh();

	}

	/**
	 * Method that takes a string and Replaces specific values inside of it and
	 * placed back into the file
	 * 
	 * @param i
	 *            index to get current item in the arraylist
	 * @param tops
	 *            the arraylist youll be comparing
	 * @param inputFile
	 *            the name of the file to be read from
	 * @param newName
	 *            The new String you wish to placed
	 */
	public static void replaceSelected(int i, ArrayList<Wardrobe> tops, String inputFile, String newName) {
		try {
			// input the file content to the StringBuffer "input"
			BufferedReader file = new BufferedReader(new FileReader(inputFile));
			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			String inputStr = inputBuffer.toString();

			file.close();

			inputStr = inputStr.replace(
					tops.get(i).getName() + "," + tops.get(i).getImageFileName() + "," + tops.get(i).getTemp1() + ","
							+ tops.get(i).getTemp2() + "," + tops.get(i).getTemp3() + "," + tops.get(i).getTemp4(),
					newName + "," + tops.get(i).getImageFileName() + "," + tempChecked[0] + "," + tempChecked[1] + ","
							+ tempChecked[2] + "," + tempChecked[3]);

			// write the new String with the replaced line OVER the same file
			FileOutputStream fileOut = new FileOutputStream(inputFile);
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			System.out.println("Problem reading file.");
		}
	}

	/**
	 * Takes you back to wardrobe
	 * 
	 * @throws IOException
	 * 				IO execption
	 */
	public void handleWardrobe() throws IOException {

		AnchorPane pane = FXMLLoader.load(getClass().getResource("Wardrobe.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	/**
	 * Refreshed the fxml and resets the check boxes back to false
	 * 
	 * @throws IOException
	 * 	IO Exception
	 */
	public void handleRefresh() throws IOException {
		eightyPlus.setSelected(false);
		sevNineToSixFive.setSelected(false);
		sixFourToFifOne.setSelected(false);
		fiftyBelow.setSelected(false);
		if (eightyPlus.isSelected() == false)
			tempChecked[0] = false;

		if (sevNineToSixFive.isSelected() == false)
			tempChecked[1] = false;

		if (sixFourToFifOne.isSelected() == false)
			tempChecked[2] = false;

		if (fiftyBelow.isSelected() == false)
			tempChecked[3] = false;
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Edit.fxml"));
		rootPane.getChildren().setAll(pane);
	}

	/**
	 * Displays the list view as well as populating it.
	 * 
	 * @throws FileNotFoundException
	 * 	File not found
	 */
	@FXML
	public void initialize() throws FileNotFoundException { 
		eightyPlus.setSelected(false);
		sevNineToSixFive.setSelected(false);
		sixFourToFifOne.setSelected(false);
		fiftyBelow.setSelected(false);
		populate();

		ObservableList<String> history = FXCollections.observableArrayList(top);
		ObservableList<String> history1 = FXCollections.observableArrayList(bottom);
		ObservableList<String> history2 = FXCollections.observableArrayList(shoe);
		tops.setItems(history);
		bottoms.setItems(history1);
		shoes.setItems(history2);
		
		
	}
}
