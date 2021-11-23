package banking_app_new;

/**
 * @authors Aiden Parker
 * Jamie Longbottom
 * Samuel Gibson-Chalmers
 * Thomas Grady
 * Lee Thompson
 * Joshua Molyneux
 * 
 * VERSION 1.6 (CODE OPTIMISED)
 * 
 */


import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame {
	ActionMainclass Action1 = new ActionMainclass();
	ActionHelpclass Action2 = new ActionHelpclass();
	ActionBackclass Action3 = new ActionBackclass();
	ActionDepositclass Action4 = new ActionDepositclass();
	ActionWithdrawclass Action5 = new ActionWithdrawclass();
	ActionLoginClass Action6 = new ActionLoginClass();
	ActionPinClass Action7 = new ActionPinClass();

	BankApp app = new BankApp();
	BankAcc acc = new BankAcc();
	Read_Write_File rw = new Read_Write_File();

	/*
	 * The majority of objects are declared in the class rather than inside the
	 * constructor itself. This is primarily used for the buttons so that
	 * actionperformed can interact with the objects.
	 */

	JButton DFIVE = new JButton("£5"); // First instance of JButton, used alongside actionlisteners in the constructor
										// so that when the user interacts with it, an event occurs.
	JButton DTEN = new JButton("£10");// Creates a JButton
	JButton DTWENTY = new JButton("£20");// Creates a JButton
	JButton DFIFTY = new JButton("£50");// Creates a JButton
	JButton DHUNDRED = new JButton("£100");// Creates a JButton
	JButton DTWOFIFTY = new JButton("£250");// Creates a JButton

	JButton WFIVE = new JButton("£5");// Creates a JButton
	JButton WTEN = new JButton("£10");// Creates a JButton
	JButton WTWENTY = new JButton("£20");// Creates a JButton
	JButton WFIFTY = new JButton("£50");// Creates a JButton
	JButton WHUNDRED = new JButton("£100");// Creates a JButton
	JButton WTWOFIFTY = new JButton("£250");// Creates a JButton

	JButton Deposit = new JButton("Deposit");// Creates a JButton
	JButton Withdraw = new JButton("Withdraw");// Creates a JButton
	JButton See_Balance = new JButton("See Balance");// Creates a JButton
	JButton View_Transactions = new JButton("View Transactions");// Creates a JButton
	JButton Change_Pin = new JButton("Change Pin");// Creates a JButton
	JButton Login = new JButton("Login");// Creates a JButton
	JButton Logout = new JButton("Logout");// Creates a JButton

	JButton HelpMain = new JButton("Help");// Creates a JButton
	JButton HelpDeposit = new JButton("Help");// Creates a JButton
	JButton HelpWithdraw = new JButton("Help");// Creates a JButton
	JButton HelpBalance = new JButton("Help");// Creates a JButton
	JButton HelpTransactions = new JButton("Help");// Creates a JButton
	JButton HelpPin = new JButton("Help");// Creates a JButton

	JButton Back = new JButton("Back");// Creates a JButton
	JButton BackDeposit = new JButton("Back");// Creates a JButton
	JButton BackWithdraw = new JButton("Back");// Creates a JButton
	JButton BackBalance = new JButton("Back");// Creates a JButton
	JButton BackTransactions = new JButton("Back");// Creates a JButton
	JButton BackPin = new JButton("Back");// Creates a JButton
	JButton Exit = new JButton("Exit");// Creates a JButton

	JButton PinConfirm = new JButton("Confirm");// Creates a JButton
	JPasswordField OldPin;// Creates a JTextArea
	JPasswordField NewPin; // Creates a JTextArea
	JPasswordField ConfirmPin; // Creates a JTextArea
	JLabel OldPintext;// Creates a JLabel
	JLabel NewPintext;// Creates a JLabel
	JLabel ConfirmPintext;// Creates a JLabel
	JLabel HugeW;// Creates a JLabel
	JLabel Failure;// Creates a JLabel

	JLabel welcome; // First instance of JLabel, it's used to display text, and can even be used to
					// display images, although not utilised in this code.
	JLabel title;// Creates a JLabel
	JLabel Logo = new JLabel();// creates a JLabel that will hold contents of our custom made Logo
	JLabel EnterCard;// Creates a JLabel
	JLabel EnterPin;// Creates a JLabel
	JLabel CurrentAmount;// Creates a JLabel
	JLabel FAIL;// Creates a JLabel
	JLabel SUCCESS;// Creates a JLabel
	JLabel ACCESS;// Creates a JLabel
	JPasswordField Pin;// Creates a JPasswordField, used for logging into the ATM
	JTextArea PreviousTransaction1;// Creates a JTextArea
	JTextArea PreviousTransaction2;// Creates a JTextArea
	JTextArea PreviousTransaction3;// Creates a JTextArea
	JTextArea HelpText; // First instance of JTextArea, primarily used for the help screens and is
						// overwritten with a new description when each of the help buttons is clicked
	ImageIcon LogoImage = new ImageIcon("." + File.separator + "src" + File.separator + "Logo.png"); // First instance of ImageIcon and holds the logo for the
														// application
	ImageIcon Mini = new ImageIcon("." + File.separator + "src" + File.separator + "Mini_Logo.png");// Holds the mini logo for the application

	JFrame f = new JFrame("Bank");// creating instance of JFrame

	GUI() {// Constructor

		f.setIconImage(Mini.getImage());// Get mini Logo image and sets the application mini icon
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close JFrame on close
		f.getContentPane().removeAll();// Clear current content pane
		Logo = new JLabel();// Creates new JLabel for Logo
		Logo.setIcon(LogoImage);// sets the image of Logo
		Logo.setBounds(5, 0, 423, 122);// X axis, Y axis, Width, Height

		ACCESS = new JLabel("ACCESS DENIED");// Sets the contents of JLabel
		ACCESS.setBounds(450, 320, 150, 40);// X axis, Y axis, Width, Height
		ACCESS.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		ACCESS.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		ACCESS.setForeground(Color.RED);// Sets colour of foreground to red

		Login.setBounds(440, 470, 180, 40);// X axis, Y axis, Width, Height
		Login.setFocusable(false);// Removes the annoying box around the text inside the button.

		Logout.setBounds(150, 370, 180, 40);// X axis, Y axis, Width, Height
		Logout.setFocusable(false);// Removes the annoying box around the text inside the button.

		Pin = new JPasswordField();// makes a JPasswordField called Pin

		Pin.setBounds(360, 320, 100, 40);// X axis, Y axis, Width, Height

		EnterCard = new JLabel("Please Insert Your Card");// Sets the contents of the JLabel
		EnterCard.setBounds(250, 220, 350, 30);// X axis, Y axis, Width, Height
		EnterCard.setFont(new Font(null, Font.PLAIN, 25));// Sets font of text
		EnterCard.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		EnterCard.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		EnterPin = new JLabel("Please Type In Your Pin");// Sets the contents of JLabel
		EnterPin.setBounds(160, 320, 250, 30);// X axis, Y axis, Width, Height
		EnterPin.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		EnterPin.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		See_Balance.setBounds(360, 220, 180, 40);// X axis, Y axis, Width, Height
		See_Balance.setFocusable(false);// Removes the annoying box around the text inside the button.

		View_Transactions.setBounds(360, 270, 180, 40);// X axis, Y axis, Width, Height
		View_Transactions.setFocusable(false);// Removes the annoying box around the text inside the button.

		Change_Pin.setBounds(360, 320, 180, 40);// X axis, Y axis, Width, Height
		Change_Pin.setFocusable(false);// Removes the annoying box around the text inside the button.

		HelpMain.setBounds(650, 60, 180, 40);// X axis, Y axis, Width, Height
		HelpMain.setFocusable(false);// Removes the annoying box around the text inside the button.

		HelpDeposit.setBounds(650, 60, 180, 40);// X axis, Y axis, Width, Height
		HelpMain.setFocusable(false);// Removes the annoying box around the text inside the button.

		HelpWithdraw.setBounds(650, 60, 180, 40);// X axis, Y axis, Width, Height
		HelpWithdraw.setFocusable(false);// Removes the annoying box around the text inside the button.

		HelpBalance.setBounds(650, 60, 180, 40);// X axis, Y axis, Width, Height
		HelpBalance.setFocusable(false);// Removes the annoying box around the text inside the button.

		HelpTransactions.setBounds(650, 60, 180, 40);// X axis, Y axis, Width, Height
		HelpTransactions.setFocusable(false);// Removes the annoying box around the text inside the button.

		HelpPin.setBounds(650, 60, 180, 40);// X axis, Y axis, Width, Height
		HelpPin.setFocusable(false);// Removes the annoying box around the text inside the button.

		Back.setBounds(10, 60, 180, 40);// X axis, Y axis, Width, Height
		Back.setFocusable(false);// Removes the annoying box around the text inside the button.

		BackDeposit.setBounds(10, 60, 180, 40);// X axis, Y axis, Width, Height
		BackDeposit.setFocusable(false);// Removes the annoying box around the text inside the button.

		BackWithdraw.setBounds(10, 60, 180, 40);// X axis, Y axis, Width, Height
		BackWithdraw.setFocusable(false);// Removes the annoying box around the text inside the button.

		BackBalance.setBounds(10, 60, 180, 40);// X axis, Y axis, Width, Height
		BackBalance.setFocusable(false);// Removes the annoying box around the text inside the button.

		BackTransactions.setBounds(10, 60, 180, 40);// X axis, Y axis, Width, Height
		BackTransactions.setFocusable(false);// Removes the annoying box around the text inside the button.

		BackPin.setBounds(10, 60, 180, 40);// X axis, Y axis, Width, Height
		BackPin.setFocusable(false);// Removes the annoying box around the text inside the button.

		Deposit.setBounds(360, 120, 180, 40);// X axis, Y axis, Width, Height
		Deposit.setFocusable(false); // Removes the annoying box around the text inside the button.

		DFIVE.setBounds(10, 125, 271, 110);// X axis, Y axis, Width, Height
		DFIVE.setFocusable(false); // Removes the annoying box around the text inside the button.

		DTEN.setBounds(10, 285, 271, 110);// X axis, Y axis, Width, Height
		DTEN.setFocusable(false); // Removes the annoying box around the text inside the button.

		DTWENTY.setBounds(10, 443, 271, 110);// X axis, Y axis, Width, Height
		DTWENTY.setFocusable(false); // Removes the annoying box around the text inside the button.

		DFIFTY.setBounds(603, 125, 271, 110);// X axis, Y axis, Width, Height
		DFIFTY.setFocusable(false); // Removes the annoying box around the text inside the button.

		DHUNDRED.setBounds(603, 285, 271, 110);// X axis, Y axis, Width, Height
		DHUNDRED.setFocusable(false); // Removes the annoying box around the text inside the button.

		DTWOFIFTY.setBounds(603, 443, 271, 110);// X axis, Y axis, Width, Height
		DTWOFIFTY.setFocusable(false); // Removes the annoying box around the text inside the button.

		WFIVE.setBounds(10, 125, 271, 110);// X axis, Y axis, Width, Height
		WFIVE.setFocusable(false); // Removes the annoying box around the text inside the button.

		WTEN.setBounds(10, 285, 271, 110);// X axis, Y axis, Width, Height
		WTEN.setFocusable(false); // Removes the annoying box around the text inside the button.

		WTWENTY.setBounds(10, 443, 271, 110);// X axis, Y axis, Width, Height
		WTWENTY.setFocusable(false); // Removes the annoying box around the text inside the button.

		WFIFTY.setBounds(603, 125, 271, 110);// X axis, Y axis, Width, Height
		WFIFTY.setFocusable(false); // Removes the annoying box around the text inside the button.

		WHUNDRED.setBounds(603, 285, 271, 110);// X axis, Y axis, Width, Height
		WHUNDRED.setFocusable(false); // Removes the annoying box around the text inside the button.

		WTWOFIFTY.setBounds(603, 443, 271, 110);// X axis, Y axis, Width, Height
		WTWOFIFTY.setFocusable(false); // Removes the annoying box around the text inside the button.

		Withdraw.setBounds(360, 170, 180, 40);// X axis, Y axis, Width, Height
		Withdraw.setFocusable(false);// Removes the annoying box around the text inside the button.

		OldPin = new JPasswordField();// makes a JPasswordField called Pin
		OldPin.setBounds(360, 120, 100, 40);// X axis, Y axis, Width, Height

		NewPin = new JPasswordField();// makes a JPasswordField called Pin
		NewPin.setBounds(360, 220, 100, 40);// X axis, Y axis, Width, Height

		ConfirmPin = new JPasswordField();// makes a JPasswordField called Pin
		ConfirmPin.setBounds(360, 320, 100, 40);// X axis, Y axis, Width, Height

		OldPintext = new JLabel("Please Enter Current PIN");
		OldPintext.setBounds(150, 120, 160, 30);
		OldPintext.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		OldPintext.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		NewPintext = new JLabel("Please Enter New PIN");
		NewPintext.setBounds(150, 220, 160, 30);
		NewPintext.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		NewPintext.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		ConfirmPintext = new JLabel("Please Re-enter New PIN");
		ConfirmPintext.setBounds(150, 320, 160, 30);
		ConfirmPintext.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		ConfirmPintext.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		HugeW = new JLabel("You have successfully changed your PIN.");// Sets the contents of JLabel
		HugeW.setBounds(450, 320, 300, 40);// X axis, Y axis, Width, Height
		HugeW.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		HugeW.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		HugeW.setForeground(Color.GREEN);// Sets colour of foreground to red

		Failure = new JLabel("One or more fields were incorrect");// Sets the contents of JLabel
		Failure.setBounds(450, 320, 300, 40);// X axis, Y axis, Width, Height
		Failure.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		Failure.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		Failure.setForeground(Color.RED);// Sets colour of foreground to red

		f.setSize(900, 700);// 900 width and 700 height
		f.setLayout(null);// using no layout managers
		f.setResizable(false); // Stops user resizing the window.
		f.getContentPane().setBackground(new Color(15267269));// Sets background color of pane

		// e -> is lambda syntax. It basically saves adding the actionperformed class
		// and implementing action listener. DEPRECATED
		/*
		 * Multiple Actionlisteners are set within the constructor. Actionlisteners
		 * check for when a user interacts with buttons, and then activates when they
		 * do.
		 */
		// Listeners for the deposit/withdraw buttons are set here.
		DFIVE.addActionListener(Action4);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		DTEN.addActionListener(Action4);// Adds an ActionListener for the associated button and assigns it to a specific
										// ActionListener
		DTWENTY.addActionListener(Action4);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		DFIFTY.addActionListener(Action4);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		DHUNDRED.addActionListener(Action4);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		DTWOFIFTY.addActionListener(Action4);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		WFIVE.addActionListener(Action5);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		WTEN.addActionListener(Action5);// Adds an ActionListener for the associated button and assigns it to a specific
										// ActionListener
		WTWENTY.addActionListener(Action5);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		WFIFTY.addActionListener(Action5);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		WHUNDRED.addActionListener(Action5);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		WTWOFIFTY.addActionListener(Action5);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener

		// Listeners for the main home buttons are set here.
		Deposit.addActionListener(Action1);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		Withdraw.addActionListener(Action1);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		See_Balance.addActionListener(Action1);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		View_Transactions.addActionListener(Action1);
		;// Adds an ActionListener for the associated button and assigns it to a specific
			// ActionListener
		Change_Pin.addActionListener(Action1);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		Login.addActionListener(Action6);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		Logout.addActionListener(Action6);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener

		// Listener for the Pin buttons are set here.
		PinConfirm.addActionListener(Action7);

		// Listeners for the help buttons are set here.
		HelpMain.addActionListener(Action1);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		HelpMain.addActionListener(Action2);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		HelpDeposit.addActionListener(Action2);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		HelpWithdraw.addActionListener(Action2);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		HelpBalance.addActionListener(Action2);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		HelpTransactions.addActionListener(Action2);// Adds an ActionListener for the associated button and assigns it
													// to a specific ActionListener
		HelpPin.addActionListener(Action2);

		// Listeners for the back buttons are set here.
		BackDeposit.addActionListener(Action3);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		BackWithdraw.addActionListener(Action3);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		BackBalance.addActionListener(Action3);// Adds an ActionListener for the associated button and assigns it to a
												// specific ActionListener
		BackTransactions.addActionListener(Action3);// Adds an ActionListener for the associated button and assigns it
													// to a specific ActionListener
		BackPin.addActionListener(Action3);// Adds an ActionListener for the associated button and assigns it to a
											// specific ActionListener
		Back.addActionListener(Action3);// Adds an ActionListener for the associated button and assigns it to a specific
										// ActionListener
		Exit.addActionListener(Action3);// Adds an ActionListener for the associated button and assigns it to a specific
										// ActionListener

		Login(); // Used to display the Login menu.
	}

	public void Login() {// First page the user sees

		Exit.setBounds(230, 470, 180, 40);// X axis, Y axis, Width, Height
		Exit.setFocusable(false);// Removes the annoying box around the text inside the button.

		f.add(Login);// Adds the Login to the pane
		f.add(EnterCard);// Adds the EnterCard to the pane
		f.add(EnterPin);// Adds the EnterPin to the pane
		f.add(Pin);// Adds the Pin to the pane
		f.add(Logo);// Adds the Logo to the pane
		f.add(Exit);// Adds Exit to the pane
		f.setVisible(true);// ALWAYS CALL SETVISIBLE LAST.
		f.repaint();// Paints the components to content pane
	}

	protected void Home() {// Holds the contents for our homepage
		/*
		 * welcome = new JLabel("Welcome to INSERT_NAME_HERE Banking!");
		 * welcome.setBounds(50,30, 250,30);
		 * welcome.setHorizontalAlignment(JLabel.CENTER);
		 * welcome.setVerticalAlignment(JLabel.CENTER); DEPRECATED example of JLabel
		 *
		 *
		 * Home sets the values of many objects when it is called, and then displays the
		 * home page contents.
		 */

		Exit.setBounds(360, 370, 180, 40);// X axis, Y axis, Width, Height
		Exit.setFocusable(false);// Removes the annoying box around the text inside the button.
		FAIL = new JLabel("Transaction has failed.");// Sets the contents of the JLabel
		FAIL.setBounds(279, 240, 300, 16);// X axis, Y axis, Width, Height
		FAIL.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		FAIL.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		FAIL.setForeground(Color.RED);// Sets colour of foreground to red

		SUCCESS = new JLabel("Transaction has succeeded.");// Sets the contents of the JLabel
		SUCCESS.setBounds(279, 240, 300, 16);// X axis, Y axis, Width, Height
		SUCCESS.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		SUCCESS.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		SUCCESS.setForeground(Color.GREEN);// Sets colour of foreground to green

		PinConfirm.setBounds(360, 420, 180, 40);// X axis, Y axis, Width, Height
		PinConfirm.setFocusable(false);// Removes the annoying box around the text inside the button.

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close JFrame on exit
		f.setSize(900, 700);// 900 width and 700 height
		f.setLayout(null);// using no layout managers
		f.setResizable(false); // Stops user resizing the window.
		// f.add(welcome);//Adds welcome label DEPRECATED
		f.add(Deposit); // Adds the deposit button
		f.add(Withdraw); // Adds the Withdraw button
		f.add(See_Balance); // Adds the See Balance button
		f.add(View_Transactions);// Adds view transactions button
		f.add(Change_Pin); // Adds the Change Pin button
		f.add(HelpMain); // Adds the Help button
		f.add(Exit); // Adds the Exit button
		f.add(Logo); // Adds the Logo in the top left
		f.add(Logout);// Adds the logout button
		f.getContentPane().setBackground(new Color(15267269));// Sets the background to specific color
		f.setVisible(true);// ALWAYS CALL SETVISIBLE LAST.

	}

	protected void Deposit() { // Deposit page, values of many objects are set here, then displayed.

		f.getContentPane().removeAll();// Clear current content pane
		f.add(Back);// Adds back button
		f.add(HelpDeposit);// Adds help button for deposit
		f.add(DFIVE);// Adds a deposit amount button
		f.add(DTEN);// Adds a deposit amount button
		f.add(DTWENTY);// Adds a deposit amount button
		f.add(DFIFTY);// Adds a deposit amount button
		f.add(DHUNDRED);// Adds a deposit amount button
		f.add(DTWOFIFTY);// Adds a deposit amount button

		title = new JLabel("Deposit");// Sets the contents of the JLabel
		title.setBounds(360, 0, 100, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title

		CurrentAmount = new JLabel("Current Amount: £" + BankAcc.userBal);
		CurrentAmount.setBounds(279, 285, 300, 16);// X axis, Y axis, Width, Height
		CurrentAmount.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		CurrentAmount.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(CurrentAmount);// Adds current amount label
		f.repaint();// Paints the components to content pane

	}

	protected void Withdraw() { // Withdraw page, values of many objects are set here, then displayed.

		f.getContentPane().removeAll();// Clear current content pane
		f.add(Back);// Add back button
		f.add(HelpWithdraw);// Add help button
		f.repaint();// Paints the components to content pane

		title = new JLabel("Withdraw");// Sets the contents of the JLabel
		title.setBounds(380, 0, 100, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title

		CurrentAmount = new JLabel("Current Amount: £" + BankAcc.userBal);
		CurrentAmount.setBounds(279, 285, 300, 16);// X axis, Y axis, Width, Height
		CurrentAmount.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		CurrentAmount.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		f.add(CurrentAmount);// Adds current amount
		f.add(WFIVE);// Adds WFIVE button to screen
		f.add(WTEN);// Adds WTEN button to screen
		f.add(WTWENTY);// Adds WTWENTY button to screen
		f.add(WFIFTY);// Adds WFIFTY button to screen
		f.add(WHUNDRED);// Adds WHUNDRED button to screen
		f.add(WTWOFIFTY);// Adds WTWOFIFTY button to screen
	}

	protected void See_Balance() { // Withdraw page, values of many objects are set here, then displayed.

		f.getContentPane().removeAll();// Clear current content pane
		f.add(Back);// Adds back button
		f.add(HelpBalance);// Adds help button
		f.repaint();// Paints the components to content pane
	
		CurrentAmount = new JLabel("Current Amount: £" + BankAcc.userBal);
		CurrentAmount.setBounds(279, 285, 300, 16);// X axis, Y axis, Width, Height
		CurrentAmount.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		CurrentAmount.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		title = new JLabel("Your Balance");
		title.setBounds(380, 0, 100, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		f.add(title);// Adds title
		f.add(CurrentAmount);// Adds current amount button
	}

	protected void View_Transactions() {// Forms the view transactions page
		f.getContentPane().removeAll();// Clear current content pane
		f.add(Back);// Add back button
		f.add(HelpTransactions);// Add help button
		rw.readFile();
		String x = null;
		String y = null;
		String z = null;
		
		try {
			x = BankAcc.prevTrans.get(0);
			y = BankAcc.prevTrans.get(1);
			z = BankAcc.prevTrans.get(2);
		} catch (IndexOutOfBoundsException e) {
			if (x != null && y != null) {
				x = BankAcc.prevTrans.get(0);
				y = BankAcc.prevTrans.get(1);
			} else if (x != null) {
				x = BankAcc.prevTrans.get(0);	
				}
			else
				x = "There have been no Previous Transactions";
		}
		
		PreviousTransaction1 = new JTextArea(x);// Sets the content of JTextArea
		PreviousTransaction1.setBounds(260, 100, 250, 30);// X axis, Y axis, Width, Height
		PreviousTransaction1.setEditable(false);// Disables editing so it is read only
		PreviousTransaction1.setCursor(null);// Changes cursor
		PreviousTransaction1.setOpaque(false);// Allows for the text background to become transparent
		PreviousTransaction1.setFocusable(false);// Removes the annoying box around the text inside the button.
		PreviousTransaction1.setLineWrap(true);// Lines will wrap if they're too long to fit width
		PreviousTransaction1.setWrapStyleWord(true);// Allows text to wrap

		PreviousTransaction2 = new JTextArea(y);// Sets the content of JTextArea
		PreviousTransaction2.setBounds(260, 150, 250, 30);// X axis, Y axis, Width, Height
		PreviousTransaction2.setEditable(false);// Disables editing so it is read only
		PreviousTransaction2.setCursor(null);// Changes cursor
		PreviousTransaction2.setOpaque(false);// Allows for the text background to become transparent
		PreviousTransaction2.setFocusable(false);// Removes the annoying box around the text inside the button.
		PreviousTransaction2.setLineWrap(true);// Lines will wrap if they're too long to fit width
		PreviousTransaction2.setWrapStyleWord(true);// Allows text to wrap

		PreviousTransaction3 = new JTextArea(z);// Sets the content of JTextArea
		PreviousTransaction3.setBounds(260, 200, 250, 30);// X axis, Y axis, Width, Height
		PreviousTransaction3.setEditable(false);// Disables editing so it is read only
		PreviousTransaction3.setCursor(null);// Changes cursor
		PreviousTransaction3.setOpaque(false);// Allows for the text background to become transparent
		PreviousTransaction3.setFocusable(false);// Removes the annoying box around the text inside the button.
		PreviousTransaction3.setLineWrap(true);// Lines will wrap if they're too long to fit width
		PreviousTransaction3.setWrapStyleWord(true);// Allows text to wrap

		title = new JLabel("Your Previous Transactions");// Sets the contents of the JLabel
		title.setBounds(380, 0, 160, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre

		f.add(title);// Adds title
		f.add(PreviousTransaction1);// Adds PreviousTransaction1 JTextArea to the pane
		f.add(PreviousTransaction2);// Adds PreviousTransaction2 JTextArea to the pane
		f.add(PreviousTransaction3);// Adds PreviousTransaction3 JTextArea to the pane
		f.repaint();// Paints the components to content pane
	}

	protected void Change_Pin() {// Forms the change pin page
		f.getContentPane().removeAll();// Clear current content pane
		f.add(Back);// Add back button
		f.add(HelpPin);// Add help pin button

		f.add(PinConfirm);
		f.add(ConfirmPintext);
		f.add(NewPintext);
		f.add(OldPintext);
		f.add(ConfirmPin);
		f.add(NewPin);
		f.add(OldPin);
		f.repaint();// Paints the components to content pane

		title = new JLabel("Change Your Pin");// Sets the contents of the JLabel
		title.setBounds(380, 0, 140, 40);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title
	}

	protected void HelpMain() { // Withdraw page, values of many objects are set here, then displayed.
		f.getContentPane().removeAll();// Clear current content pane
		f.add(Back);// Adds back button

		f.repaint();// Paints the components to content pane

		title = new JLabel("Help - Main Page");// Sets the contents of the JLabel
		title.setBounds(380, 0, 100, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title

		HelpText = new JTextArea(
				"Press the deposit button to make a desposit."
				+ "\nPress the withdraw button to make a withdrawal."
				+ "\nPress the See Balance button to check your balance."
				+ "\nPress the view Transactions button to view previous transactions."
				+ "\nPress the change pin button to change your pin."
				+ "\nPress the logout button to logout."
				+ "\nPress the exit button to terminate the program.");
		HelpText.setBounds(260, 120, 400, 400);// X axis, Y axis, Width, Height
		HelpText.setEditable(false);// Disables editing so it is read only
		HelpText.setCursor(null);// Changes cursor
		HelpText.setOpaque(false);// Allows for the text background to become transparent
		HelpText.setFocusable(false);// Removes the annoying box around the text inside the button.
		HelpText.setLineWrap(true);// Lines will wrap if they're too long to fit width
		HelpText.setWrapStyleWord(true);// Allows text to wrap
		f.add(HelpText);// Adds help text
	}

	protected void HelpDeposit() {// Forms the help page for deposit
		f.getContentPane().removeAll();// Clear current content pane
		f.add(BackDeposit);// Adds back button

		f.repaint();// Paints the components to content pane

		title = new JLabel("Help - Deposits");// Sets the contents of the JLabel
		title.setBounds(380, 0, 100, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title to content pane

		HelpText = new JTextArea(
				"Press any of the deposit buttons to withdraw that amount, press the back button to go back a page.");
		HelpText.setBounds(260, 120, 400, 400);// X axis, Y axis, Width, Height
		HelpText.setEditable(false);// Disables editing so it is read only
		HelpText.setCursor(null);// Changes cursor
		HelpText.setOpaque(false);// Allows for the text background to become transparent
		HelpText.setFocusable(false);// Removes the annoying box around the text inside the button.
		HelpText.setLineWrap(true);// Lines will wrap if they're too long to fit width
		HelpText.setWrapStyleWord(true);// Allows text to wrap
		f.add(HelpText);// Adds help text
	}

	protected void HelpWithdraw() {// Forms the help page for Withdraw
		f.getContentPane().removeAll();// Clear current content pane
		f.add(BackWithdraw);// Adds back button

		f.repaint();// Paints the components to content pane

		title = new JLabel("Help - Withdrawals");// Sets the contents of the JLabel
		title.setBounds(380, 0, 120, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title

		HelpText = new JTextArea(
				"Press any of the withdraw buttons to withdraw that amount, press the back button to go back a page.");
		HelpText.setBounds(260, 120, 400, 400);// X axis, Y axis, Width, Height
		HelpText.setEditable(false);// Disables editing so it is read only
		HelpText.setCursor(null);// Changes cursor
		HelpText.setOpaque(false);// Allows for the text background to become transparent
		HelpText.setFocusable(false);// Removes the annoying box around the text inside the button.
		HelpText.setLineWrap(true);// Lines will wrap if they're too long to fit width
		HelpText.setWrapStyleWord(true);// Allows text to wrap
		f.add(HelpText);// Adds help text
	}

	protected void HelpBalance() {// Forms the help page for Balance
		f.getContentPane().removeAll();// Clear current content pane
		f.add(BackBalance);// Add back button

		f.repaint();// Paints the components to content pane

		title = new JLabel("Help - Viewing Balancing");// Sets the contents of the JLabel
		title.setBounds(360, 0, 150, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title

		HelpText = new JTextArea(
				"The current amount displayed is your current balance, press the back button to go back a page.");
		HelpText.setBounds(260, 120, 400, 400);// X axis, Y axis, Width, Height
		HelpText.setEditable(false);// Disables editing so it is read only
		HelpText.setCursor(null);// Changes cursor
		HelpText.setOpaque(false);// Allows for the text background to become transparent
		HelpText.setFocusable(false);// Removes the annoying box around the text inside the button.
		HelpText.setLineWrap(true);// Lines will wrap if they're too long to fit width
		HelpText.setWrapStyleWord(true);// Allows text to wrap
		f.add(HelpText);// Adds help text
	}

	protected void HelpTransactions() {// Forms the help page for Transactions
		f.getContentPane().removeAll();// Clear current content pane
		f.add(BackTransactions);// Add back button

		f.repaint();// Paints the components to content pane

		title = new JLabel("Help - Transactions");// Sets the contents of the JLabel
		title.setBounds(360, 0, 120, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title

		HelpText = new JTextArea(
				"The transactions displayed contain the date of the deposit / "
				+ "withdrawal from your account and also the amount, "
				+ "press the back button to go back a page.");
		HelpText.setBounds(260, 120, 400, 400);// X axis, Y axis, Width, Height
		HelpText.setEditable(false);// Disables editing so it is read only
		HelpText.setCursor(null);// Changes cursor
		HelpText.setOpaque(false);// Allows for the text background to become transparent
		HelpText.setFocusable(false);// Removes the annoying box around the text inside the button.
		HelpText.setLineWrap(true);// Lines will wrap if they're too long to fit width
		HelpText.setWrapStyleWord(true);// Allows text to wrap
		f.add(HelpText);// Adds help text
	}

	protected void HelpPin() {// Forms the help page for changing pin
		f.getContentPane().removeAll();// Clear current content pane
		f.add(BackPin);// Add back button

		f.repaint();// Paints the components to content pane

		title = new JLabel("Help - Changing your Pin");// Sets the contents of the JLabel
		title.setBounds(360, 0, 140, 30);// X axis, Y axis, Width, Height
		title.setHorizontalAlignment(JLabel.CENTER);// Sets alignment on X axis to centre
		title.setVerticalAlignment(JLabel.CENTER);// Sets alignment on Y axis to centre
		f.add(title);// Adds title

		HelpText = new JTextArea(
				"Input your old/current pin into the old pin box, "
				+ "then input your new desired pin into the bottom 2 pin boxes. "
				+ "Once that is done, press confirm. Press the back button to go back a page.");
		HelpText.setBounds(260, 120, 400, 400);// X axis, Y axis, Width, Height
		HelpText.setEditable(false);// Disables editing so it is read only
		HelpText.setCursor(null);// Changes cursor
		HelpText.setOpaque(false);// Allows for the text background to become transparent
		HelpText.setFocusable(false);// Removes the annoying box around the text inside the button.
		HelpText.setLineWrap(true);// Lines will wrap if they're too long to fit width
		HelpText.setWrapStyleWord(true);// Allows text to wrap
		f.add(HelpText);// Adds help text to content pane
	}

	protected boolean CustomerDeposit(ActionEvent Action) {// CusterWithdraw method returns boolean and accepts action
															// event input
		if (Action.getSource() == DFIVE) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(5);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balDeposit(INPUT);// Inputs the INPUT variable into balDeposit method
			return State;// Returns boolean
		} else if (Action.getSource() == DTEN) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(10);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balDeposit(INPUT);// Inputs the INPUT variable into balDeposit method
			return State;// Returns boolean
		} else if (Action.getSource() == DTWENTY) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(20);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balDeposit(INPUT);// Inputs the INPUT variable into balDeposit method
			return State;// Returns boolean
		} else if (Action.getSource() == DFIFTY) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(50);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balDeposit(INPUT);// Inputs the INPUT variable into balDeposit method
			return State;// Returns boolean
		} else if (Action.getSource() == DHUNDRED) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(100);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balDeposit(INPUT);// Inputs the INPUT variable into balDeposit method
			return State;// Returns boolean
		} else if (Action.getSource() == DTWOFIFTY) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(250);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balDeposit(INPUT);// Inputs the INPUT variable into balDeposit method
			return State;// Returns boolean
		} else {
			return false;
		}
	}

	protected boolean CustomerWithdraw(ActionEvent Action) {// CusterWithdraw method returns boolean and accepts action
															// event input
		if (Action.getSource() == WFIVE) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(5);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balWithdraw(INPUT);// Inputs the INPUT variable into balWithdraw method
			return State;// Returns boolean
		} else if (Action.getSource() == WTEN) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(10);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balWithdraw(INPUT);// Inputs the INPUT variable into balWithdraw method
			return State;// Returns boolean
		} else if (Action.getSource() == WTWENTY) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(20);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balWithdraw(INPUT);// Inputs the INPUT variable into balWithdraw method
			return State;// Returns boolean

		} else if (Action.getSource() == WFIFTY) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(50);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balWithdraw(INPUT);// Inputs the INPUT variable into balWithdraw method
			return State;// Returns boolean
		} else if (Action.getSource() == WHUNDRED) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(100);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balWithdraw(INPUT);// Inputs the INPUT variable into balWithdraw method
			return State;// Returns boolean
		} else if (Action.getSource() == WTWOFIFTY) {// double checks the contents of the action itself
			BigDecimal INPUT = new BigDecimal(250);// Creates a BigDecimal variable called INPUT
			Boolean State = app.balWithdraw(INPUT);// Inputs the INPUT variable into balWithdraw method
			return State;// Returns boolean
		} else {
			return false;
		}
	}

	/*
	 * A wide host of protected classes that implement else and if statements to
	 * perform actions for the GUI
	 */
	protected class ActionMainclass implements ActionListener {// Forms a class that implements ActionListener
		public void actionPerformed(ActionEvent Action) {// Performs events based on the contents of the actionevent
															// called action utilising if and elses

			if (Action.getSource() == Deposit) { // double checks the contents of the action itself
				Deposit();// Calls the deposit method
			} else if (Action.getSource() == Withdraw) {// double checks the contents of the action itself
				Withdraw();// Calls the Withdraw method
			} else if (Action.getSource() == See_Balance) {// double checks the contents of the action itself
				See_Balance();// Calls the See_Balance method
			} else if (Action.getSource() == View_Transactions) {// double checks the contents of the action itself
				View_Transactions();// Calls the View_Transactions method
			} else if (Action.getSource() == Change_Pin) {// double checks the contents of the action itself
				Change_Pin();// Calls the Change_Pin method
			} else if (Action.getSource() == HelpMain) {// double checks the contents of the action itself
				HelpMain();// Calls the HelpMain method
			} else {
				System.exit(0);// Exits GUI
			}
		}
	}

	protected class ActionHelpclass implements ActionListener {// Forms a class that implements ActionListener
		public void actionPerformed(ActionEvent Action) {// Performs events based on the contents of the actionevent
															// called action utilising if and elses
			if (Action.getSource() == HelpMain) {// double checks the contents of the action itself
				HelpMain();
			} else if (Action.getSource() == HelpDeposit) {// double checks the contents of the action itself
				HelpDeposit();// Calls the HelpDeposit method
			} else if (Action.getSource() == HelpWithdraw) {// double checks the contents of the action itself
				HelpWithdraw();// Calls the HelpWithdraw method
			} else if (Action.getSource() == HelpBalance) {// double checks the contents of the action itself
				HelpBalance();// Calls the HelpBalance method
			} else if (Action.getSource() == HelpTransactions) {// double checks the contents of the action itself
				HelpTransactions();// Calls the HelpTransactions method
			} else if (Action.getSource() == HelpPin) {// double checks the contents of the action itself
				HelpPin();// Calls the HelpPin method
			} else {
				System.exit(0);// Exits GUI
			}

		}
	}

	protected class ActionBackclass implements ActionListener {// Forms a class that implements ActionListener
		public void actionPerformed(ActionEvent Action) {// Performs events based on the contents of the actionevent
															// called action utilising if and elses
			if (Action.getSource() == Back) {// double checks the contents of the action itself
				f.getContentPane().removeAll();// Clear current content pane
				Home();// Calls the Home method
				f.repaint();// Paints the components to content pane
			} else if (Action.getSource() == BackDeposit) {// double checks the contents of the action itself
				f.getContentPane().removeAll();// Clear current content pane
				Deposit();// Calls the Deposit method
				f.repaint();// Paints the components to content pane
			} else if (Action.getSource() == BackWithdraw) {// double checks the contents of the action itself
				f.getContentPane().removeAll();// Clear current content pane
				Withdraw();// Calls the Withdraw method
				f.repaint();// Paints the components to content pane
			} else if (Action.getSource() == BackBalance) {// double checks the contents of the action itself
				f.getContentPane().removeAll();// Clear current content pane
				See_Balance();// Calls the See_Balance method
				f.repaint();// Paints the components to content pane
			} else if (Action.getSource() == BackTransactions) {// double checks the contents of the action itself
				f.getContentPane().removeAll();// Clear current content pane
				View_Transactions();// Calls the View_Transactions method
				f.repaint();// Paints the components to content pane
			} else if (Action.getSource() == BackPin) {// double checks the contents of the action itself
				f.getContentPane().removeAll();// Clear current content pane
				Change_Pin();// Calls the Change_Pin method
				f.repaint();// Paints the components to content pane
			} else {
				System.exit(0);// Exits GUI
			}
		}
	}

	protected class ActionDepositclass implements ActionListener {// Forms a class that implements ActionListener
		public void actionPerformed(ActionEvent Action) {// Performs events based on the contents of the actionevent
															// called action utilising if and elses
			if (Action.getSource() == DFIVE) {// double checks the contents of the action itself
				Boolean State = CustomerDeposit(Action); // Inputs the received input named Action into CustomerDeposit
															// method
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Deposit();// Calls deposit page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Deposit();// Calls deposit page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == DTEN) {// double checks the contents of the action itself
				Boolean State = CustomerDeposit(Action);
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) { // Checks if the state boolean is true
					Deposit();// Calls deposit page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Deposit();// Calls deposit page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == DTWENTY) {// double checks the contents of the action itself
				Boolean State = CustomerDeposit(Action);
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Deposit();// Calls deposit page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Deposit();// Calls deposit page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == DFIFTY) {// double checks the contents of the action itself
				Boolean State = CustomerDeposit(Action);
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Deposit();// Calls deposit page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Deposit();// Calls deposit page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == DHUNDRED) {// double checks the contents of the action itself
				Boolean State = CustomerDeposit(Action);
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Deposit();// Calls deposit page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Deposit();// Calls deposit page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == DTWOFIFTY) {// double checks the contents of the action itself
				Boolean State = CustomerDeposit(Action);
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Deposit();// Calls deposit page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Deposit();// Calls deposit page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else {
				System.exit(0);// Exits GUI
			}
		}
	}

	protected class ActionWithdrawclass implements ActionListener {// Forms a class that implements ActionListener
		public void actionPerformed(ActionEvent Action) {// Performs events based on the contents of the actionevent
															// called action utilising if and elses
			if (Action.getSource() == WFIVE) {// double checks the contents of the action itself
				Boolean State = CustomerWithdraw(Action);
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Withdraw();// Calls withdraw page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Withdraw();// Calls withdraw page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == WTEN) {// double checks the contents of the action itself
				Boolean State = CustomerWithdraw(Action); // Inputs the Action variable into CustomerWithdraw method
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Withdraw();// Calls withdraw page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Withdraw();// Calls withdraw page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == WTWENTY) {// double checks the contents of the action itself
				Boolean State = CustomerWithdraw(Action); // Inputs the received input named Action into
															// CustomerWithdraw method
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Withdraw();// Calls withdraw page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane//Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Withdraw();// Calls withdraw page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == WFIFTY) {// double checks the contents of the action itself
				Boolean State = CustomerWithdraw(Action); // Inputs the received input named Action into
															// CustomerWithdraw method
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Withdraw();// Calls withdraw page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Withdraw();// Calls withdraw page
					f.remove(SUCCESS);// Remove success from content pane//Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == WHUNDRED) {// double checks the contents of the action itself
				Boolean State = CustomerWithdraw(Action); // Inputs the received input named Action into
															// CustomerWithdraw method
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Withdraw();// Calls withdraw page
					f.remove(FAIL);// Remove fail from content pane//Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Withdraw();// Calls withdraw page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else if (Action.getSource() == WTWOFIFTY) {// double checks the contents of the action itself
				Boolean State = CustomerWithdraw(Action); // Inputs the received input named Action into
															// CustomerWithdraw method
				/*
				 * This handy line inputs the users action into our CustomerDeposit method which
				 * then checks what button the user clicked, and correlates a bigdecimal value
				 * to that input before sending it into the balDeposit method in BankAcc which
				 * deposits it!
				 */
				if (State == true) {// Checks if the state boolean is true
					Withdraw();// Calls withdraw page
					f.remove(FAIL);// Remove fail from content pane
					f.add(SUCCESS);// Add success to content pane
					f.repaint();// Paints the components to content pane
				} else {
					Withdraw();// Calls withdraw page
					f.remove(SUCCESS);// Remove success from content pane
					f.add(FAIL);// Add fail to content pane//Add fail to content pane
					f.repaint();// Paints the components to content pane
				}
			} else {
				System.exit(0);// Exits GUI
			}
		}
	}

	protected class ActionLoginClass implements ActionListener {// Forms a class that implements ActionListener
		public void actionPerformed(ActionEvent Action) {// Performs events based on the contents of the actionevent
															// called action utilising if and else statements
			if (Action.getSource() == Login) {// double checks the contents of the action itself
				String TextPin = String.valueOf(Pin.getPassword());// Grabs the char array contents of the pin password
																	// field, converts to a string and assigns it to the
																	// string textpin variable
				if (TextPin.equals(BankAcc.userPin)) {// If TextPin is equal to the contents of userPin in the BankAcc
														// class
					f.getContentPane().removeAll();// Clear current content pane
					Home();// Calls the Home method
					f.repaint();// Paints the components to content pane
				} else {
					f.remove(ACCESS);// Remove Access to content pane
					f.add(ACCESS);// Add Access to content pane
					f.repaint();// Paints the components to content pane
				}

			} else if (Action.getSource() == Logout) {// double checks the contents of the action itself
				f.getContentPane().removeAll();// Clear current content pane
				Login();// Calls the Login method
				f.repaint();// Paints the components to content pane
			} else {
				System.exit(0);// Exits GUI
			}
		}
	}

	protected class ActionPinClass implements ActionListener {
		public void actionPerformed(ActionEvent Action) {

			if (Action.getSource() == PinConfirm) {
				String OldPin1 = String.valueOf(OldPin.getPassword());

				if (BankAcc.userPin.equals(OldPin1)) {
					String NewPin1 = String.valueOf(NewPin.getPassword());
					String ConfirmPin1 = String.valueOf(ConfirmPin.getPassword());

					if (NewPin1.equals(ConfirmPin1)) {

						if (BankApp.changePIN(NewPin1) == true) {
							f.remove(Failure);
							f.add(HugeW);
							f.repaint();
							String p = String.valueOf(NewPin.getPassword());
							app.setPin(p);
						}

						else {
							f.remove(HugeW);
							f.add(Failure);
							f.repaint();
						}

					} else {
						f.remove(HugeW);
						f.add(Failure);
						f.repaint();
					}

				} else {
					f.remove(HugeW);
					f.add(Failure);
					f.repaint();
				}
			} else {
				System.exit(0);
			}
		}
	}
}