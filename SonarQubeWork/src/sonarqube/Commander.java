package sonarqube;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * This class runs command prompt arguments
 */

public class Commander {
	// Creates a Process instance called process
	private Process process;
	// Creates String variables commands and directory
	private String commands, directory;

	/**
	 * This method sets the Variables. Note that commented out section contain
	 * calls to get command and directory to start SonarQube for Variables
	 */
	public void setVars(Variables myVari) {

		// Calls the sonarVars to get acces to its methods
		// myVari.sonarVars();
		// gets the commands it needs from Variables
		// commands = myVari.getStartCommand();
		// gets the directory to start commands from
		// directory = myVari.getStartDirectory();
		// gets the commands it needs from Variables
		commands = myVari.getSendCommand();
		// gets the directory to start commands from
		directory = myVari.getFileSendDirectory();
		// Prints out the commands
		System.out.println(commands);
		// Prints out the directory
		System.out.println(directory);
	}

	/**
	 * This method runs commands through command prompt
	 */
	public void commandPrompt() {
		// Creates this OS specific command. In this case it is windows
		String[] command = { "CMD", "/C", commands };
		// Creates an instance of ProcessBuilder called probuilder given the
		// command
		ProcessBuilder probuilder = new ProcessBuilder(command);
		// Redirects errosStream to eclipse console
		probuilder.redirectErrorStream(true);
		// You can set up your work directory
		// How to get path from working directory
		probuilder.directory(new File(directory));
		// In case process is a dud
		try {
			// Starts the process
			process = probuilder.start();
			// Sends command to sendToConsolemethod
			sendToConsole(command);
		}
		// ..print off the following statement
		catch (IOException e2) {
			// Inform that error ocurred here
			System.out.println("Something happened in ");
		}
	}

	/**
	 * Method gets commandPrompt statements to output to Eclipse console
	 * 
	 * @param command
	 */
	public void sendToConsole(String[] command) {
		// Creates an instance of InputStream to get content from process
		InputStream is = process.getInputStream();
		// Creates an inputStreamreader to read content from inputstream
		InputStreamReader isr = new InputStreamReader(is);
		// Reads characterinput Stream from InputStreamReader
		BufferedReader br = new BufferedReader(isr);
		// Creates a String variable called line
		String line;
		// Converts whatever command to console
		System.out.printf("Output of running %s is:\n", Arrays.toString(command));
		// In case the lines are duds
		try {
			// While the bufferedreader is giving content and no null values do
			// the following
			while ((line = br.readLine()) != null) {
				// Prints off the content the BufferedReader gives
				System.out.println(line);
				//Zero means fail, anything else means successs
				int exitValue = process.waitFor();
				//Prints out success or failure
				System.out.println("\n\nExit Value is " + exitValue);
			}
			//Closes the buffered reader
			br.close();
		}
		// ...print the followng statement if something goes wrong
		catch (IOException | InterruptedException e1) {
			// Inform that a mistake happened in sendToConsole
			System.out.println("Something went wrong in sendToConsole");
		}
	}

}
