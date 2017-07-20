package practice;

import java.util.Scanner;

public class Prompter {
	private String values;
	private Scanner input;

	public String scanIt(String value) {
		System.out.println("Please enter the value for " + value + ".");
		// Creates an instance of Scanner named input.
		input = new Scanner(System.in);
		{
			// Creates a string out of Text found within file.
			values = input.nextLine();
			// Prints num string from past line

		}
		return values;
	}

	public void closeIt() {
		input.close();
	}
}
