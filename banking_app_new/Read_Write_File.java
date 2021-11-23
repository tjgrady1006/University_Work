package banking_app_new;

/**
 * @authors Aiden Parker
 * Jamie Longbottom
 * Samuel Gibson-Chalmers
 * Thomas Grady
 * Lee Thompson
 * Joshua Molyneux
 * 
 * @version 1.3
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Read_Write_File Class for calling objects from the
 * text file, as well as write new objects.
 *
 */

public class Read_Write_File {

	/**
	 * Method for reading the text file to obtain objects.
	 * 
	 */
	protected ArrayList<String> readFile() {

		File file = new File("." + File.separator + "src" + File.separator + "account.txt"); // Path location for customer file to be read.
		ArrayList<String> fileContents = new ArrayList<String>();

		if (file.exists()) { // If the file exists
			BufferedReader bfRead = null; // Initialise BufferedReader.

			try {
				/*
				 * Try to create an input stream for the file, create a new array list to store
				 * each line from the file as an element in the array, Use a while loop to get
				 * each line that has content from the file and add it to the ArrayList.
				 */

				bfRead = new BufferedReader(new FileReader(file));
				String line;
				try {
					while ((line = bfRead.readLine()) != null) {
						/*
						 * Loops over each line in the file that does not equal "null" (has content on
						 * it's line), store that line as an element in an ArrayList
						 */
						fileContents.add(line);
					}

				} catch (IOException e) {
					System.out.println("Cannot write to this file");
				} finally {
					bfRead.close();
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Could not read from this file");
			}

		} else {
			System.out.println("File does not exist");
			System.out.println("Creating new file..");
			try {
				file.createNewFile();
				System.out.println("file created - readFile()");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileContents;
	}


	/**
	 * Method for writing objects to the text file.
	 * 
	 */
	protected void writeFile() {
	
		FileWriter fileWrite = null;
		File file = new File("." + File.separator + "src" + File.separator + "account.txt");
		BufferedWriter buffWrite = null;

		if (file.exists()) {
			file.setWritable(true); // if file is in a read-only format, override it and make it writable

			// if the file exists then try to open a FileWriter stream to write to the file
			try {
				fileWrite = new FileWriter("." + File.separator + "src" + File.separator + "account.txt", false);
				buffWrite = new BufferedWriter(fileWrite);
				buffWrite.write("PIN: " + BankAcc.userPin + "\nBalance: £" + BankAcc.userBal
							  + "\n" + "=".repeat(20) + "\n Date\t\tAmount\n");
				for (int i = 0; i < BankAcc.prevTrans.size(); i++) {
					buffWrite.write(BankAcc.prevTrans.get(i) + "\n");
				}
				buffWrite.close();
				file.setWritable(false);
			} catch (FileNotFoundException e) {
				System.out.println("File Not Found");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException");
			} finally {
				try {
					fileWrite.close();
				} catch (IOException e) {
					System.out.println("IOException closing file write stream.");
				}
			}
		} else {
			System.out.println("This file does not exist.");
			System.out.println("creating new file");
			try {
				file.createNewFile();
				System.out.println("file created - writeFile()");
				writeFile();
			} catch (IOException e) {
				System.out.println("Failed to create new file. Exception: " + e);
				e.printStackTrace();
			}
		}

	}
}
