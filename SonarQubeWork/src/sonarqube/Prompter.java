package sonarqube;

import java.util.Scanner;

/**
 * This class returns input that it requests
 * 
 * @author fz3
 *
 */
public class Prompter {
	// This creates a variable called values
	private String values;
	// This creates a Scanner called input
	private Scanner scanner;

	/**
	 * This method accepts prompts and returns the user input
	 * 
	 * @param value
	 * @return
	 */
	public String scanIt(String value) {
		// Print out the prompt for the user
		System.out.println("Please enter the value for " + value + ".");
		// Creates an instance of Scanner named scanner.
		// Assigns the scanner whatever value is inputed
		scanner = new Scanner(System.in);
		{
			// Creates a string called values that capture sthe input
			values = scanner.nextLine();
		}
		// Returns the input scanned
		return values;
	}

	/**
	 * Method that closes the scanner
	 */
	public void closeIt() {
		// closes the scanner
		scanner.close();
	}
}
