package guessingGame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	//declares a new text field that will take in users guess
	private JTextField txtGuess;
	//declares a new label that will display the output of whether the user guessed the right number or not and if not, was it too high or too low
	private JLabel lblOutput;
	//declares a new Int that will be used for the number that the user is trying to guess
	private int theNumber;

	//method to check the guess of the user
	public void checkGuess() {
		//declares a new string that is assigned to the text that the user inputs into the text field "txtGuess"
		String guessText = txtGuess.getText();
		//declares a string that will be used to give a message to the player on if they guessed the number or not and what to do
		String message = "";

		//try block for exception handling
		try {
			//declares an Int that will take the string text from the user and parse it to Int
			int guess = Integer.parseInt(guessText);
			//if statement for if user's guess is too low, too high, or right
			if(guess < theNumber) {
				message = guess + " is too low. Try again.";
			} 
			else if(guess > theNumber) {
				message = guess + " is too high. Try again.";
			}
			else {
				message = guess + " is correct. You win! Let's play again!";
				newGame();
			}	
			//catch block for exception handling
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
			//finally block for exception handling
		} finally {
			//will display the message that comes from the above if statement depending on the user's guess into the label "lblOutput"
			lblOutput.setText(message);
			//The request focus will bring the mouse back into the text field so that we can select all. Now the user doesnt have to select the text or delete it before typing in another answer.
			//It will be selected automatically so once user starts typing, the text will be replaced with the new text 
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	//method used for the game so that we can replay it
	public void newGame() {
		//assigns a random number from 1 to 100 that the user will have to guess
		theNumber = (int)(Math.random() * 100 + 1);
	}

	//method for displaying GUI and everything in it
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Lawton's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		//label for title
		JLabel lblNewLabel = new JLabel("Lawton's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 36, 434, 27);
		getContentPane().add(lblNewLabel);

		//label to prompt user to guess a number between 1 and 100
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(46, 98, 229, 14);
		getContentPane().add(lblNewLabel_1);

		//text field that user will input their guess
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			//this is a listener for the text field so that when the user hits the "Enter" key, their guess will be accepted. So user can choose to hit the guess button or just hit the "Enter" key
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(285, 95, 60, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		//button for user to hit for their guess
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			//the event listener used to handle when the button is clicked
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(172, 149, 89, 23);
		getContentPane().add(btnGuess);

		//label to prompt user on what to do and how to play the game
		lblOutput= new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(116, 208, 203, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		//declares a new instance of the game/GUI
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
