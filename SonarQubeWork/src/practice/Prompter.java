package practice;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Prompter {
	private String values;
	
	public String scanIt(String value) {
		System.out.println("Please enter the value for " + value + ".");
		// Creates an instance of Scanner named input.
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			// Creates a string out of Text found within file.
			 values = input.nextLine();
			// Prints num string from past line
			
		}
		// Close input
		input.close();
		return values;
	}
}
