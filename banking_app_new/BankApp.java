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

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bank Application Class created for back-end use,
 * including deposits, withdrawals, changing PIN
 * and including the Main Method.
 *
 */
public class BankApp {
	static BankAcc acc = new BankAcc();
	
	/**
	 * Sets the users PIN.
	 * 
	 * @param pin = user PIN
	 */
	protected void setPin(String pin) {
		acc.readWrite = new Read_Write_File();
		BankAcc.userPin = pin;
		if (acc.readWrite == null) {
			System.out.println("Object cannot be null");
		} else
			acc.readWrite.writeFile();
	}

	/**
	 * Returns the users balance.
	 * 
	 * @return userBal = return Users Balance
	 */
	public BigDecimal getBalance() {
		return BankAcc.userBal;
	}

    /**
     * Withdraws the amount in "f" from the users balance, if the funds are
     * sufficient. The transaction is cancelled if the amount is not
     * greater than 0 or it is greater than balance.
     * 
     * @param f = Users withdrawal amount.
     */
	protected Boolean balWithdraw(BigDecimal f) {
		acc.prevTransType = 'W';
		acc.readWrite = new Read_Write_File();
        
		// Checking for max. 2 dp, and the amount withdrawn is greater than 0.
        if (f.scale() <= 2 && f.compareTo(BigDecimal.ZERO) > 0
        	&& f.compareTo(BankAcc.userBal) <= 0) {
        	// BigDecimal subtract from balance the value in "f".
        	BankAcc.userBal = BankAcc.userBal.subtract(f); 
            acc.previousTransaction(f);
            acc.readWrite.writeFile();
            return true;

        } else {
            return false;
        }
    }
	
	/**
     * 
     * Deposits the amount in "f" to the users balance. 
     * The transaction is cancelled if the amount is not
     * greater than 0 or it is greater than £50,000.
     * 
     * @param f = Users deposit amount.
     */
	protected boolean balDeposit(BigDecimal f) {
		// Creating variable for use with ternary.
		acc.prevTransType = 'D';
		acc.readWrite = new Read_Write_File();
        
		// Checking for max. 2 dp, and the amount Deposited is not greater than £50,000.
        if (f.scale() <= 2 && f.compareTo(BigDecimal.ZERO) == 1 
        	&& f.compareTo(new BigDecimal("50000")) <= 0) {
        	BankAcc.userBal = BankAcc.userBal.add(f);
            acc.previousTransaction(f);
            acc.readWrite.writeFile();
            return true;
        } else {
        	return false;
        }
    }

	/**
	 * A method to check the new PIN only contains
	 * integers to a min/max value of 4.
	 * 
	 * @param pin = Users PIN.
	 * @return str.matches = ensure new PIN matches regex.
	 */
	public static boolean changePIN(String pin) {
		// PIN must contain specific regex.
		String mustCont = "^(?=.*[0-9]).{4}$";
		// Check if PIN is valid as per regex.
		Pattern isValid = Pattern.compile(mustCont);

		if (pin == null) {
			return false;
		}
		// Check PIN matches the valid regex.
		Matcher str = isValid.matcher(pin);
		return str.matches();
	}

	public static void main(String[] args) {
		acc.setDetails();
		new GUI();

	}

}