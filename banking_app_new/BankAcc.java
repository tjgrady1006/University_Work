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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

/**
 * Bank Account Class created to store and maintain a
 * users bank details, including PIN and previous
 * transactions.
 */
public class BankAcc {
	protected static String userPin = "";
	// Using BigDecimal for precise round values.
	protected static BigDecimal userBal = new BigDecimal("0.00");
	// Creating a list to store max.3 objects.
	protected static List<String> prevTrans = new ArrayList<String>(3);
	char prevTransType;
	LocalDate date = LocalDate.now();
	Read_Write_File readWrite;

	/**
	 * Method to create user objects to store in text file.
	 */
	protected void setDetails() {
		readWrite = new Read_Write_File();
		ArrayList<String> fdata = readWrite.readFile();

		// Get file contents from readWrite class, create substring of PIN/Balance.
		try {
			if ((fdata.get(0).contains(": ")) && (fdata.get(1).contains(": £"))) {

				// Checks each line to see if it contains a colon followed by a whitespace.
				userPin = fdata.get(0).substring(fdata.get(0).indexOf(":") + 2, fdata.get(0).length());
				userBal = new BigDecimal(fdata.get(1).substring(fdata.get(1).indexOf(":") + 3, fdata.get(1).length()));
				
				switch (fdata.size()) {
				case 5:
					prevTrans.add(fdata.get(4));
					break;
				case 6:
					for(int i=4;i<6;i++)
						prevTrans.add(fdata.get(i));
					break;
				case 7:
					for(int i=4;i<7;i++)
						prevTrans.add(fdata.get(i));
					break;
				default:
					break;
				}

			} else {
				System.out.println("Unexpected format for file.");
			}
		} catch (Exception e) {
			System.out.println("*\tThis file's format is not recognised or "
							 + "crucial parts of the file are missing.\t*");
		}
	}
	
	/**
	 * Method to set the Previous Transactions made
	 * by the user to the text file.
	 * 
	 * @param f = Previous Transaction type
	 */
	protected void previousTransaction(BigDecimal f) {
		// Add + / - to the amount of previousTransaction based on what method was called.
		char sign = prevTransType == 'D' ? '+' : '-';
		
		if (prevTrans.size() == 3) {
			prevTrans.set(2, prevTrans.get(1));
			prevTrans.set(1, prevTrans.get(0));
			prevTrans.set(0, date.toString() + " | " +  sign + f.toString());
		} else
			prevTrans.add(date.toString() + " | " + sign + f.toString());
	}

	
}