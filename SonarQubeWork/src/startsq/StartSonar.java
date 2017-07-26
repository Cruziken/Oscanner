package startsq;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;



public class StartSonar {
	
	private static String startDirectory;// "C:\\Users\\fz3\\SonarQube\\sonarqube-6.4\\sonarqube-6.4\\bin\\windows-x86-64";
	private static String startCommand; //"StartSonar.bat";
	private Process process;
	
	public static void main (String[] args) {

		// Prints out the commands
		startCommand = args[0];
		startDirectory = args[1];
		// Prints out the directory
		System.out.println(startDirectory);
		StartSonar myStartSonar = new StartSonar();
		myStartSonar.commandPrompt();
	}

	/**
	 * This method runs commands through command prompt
	 */
	public void commandPrompt() {
		// Creates this OS specific command. In this case it is windows
		String[] command = { "CMD", "/C", startCommand };
		// Creates an instance of ProcessBuilder called probuilder given the
		// command
		ProcessBuilder probuilder = new ProcessBuilder(command);
		// Redirects errosStream to eclipse console
		probuilder.redirectErrorStream(true);
		// You can set up your work directory
		// How to get path from working directory
		probuilder.directory(new File(startDirectory));
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
				int exitValue = process.waitFor();
				System.out.println("\n\nExit Value is " + exitValue);
			}
			br.close();
		}
		// ...print the followng statement if something goes wrong
		catch (IOException | InterruptedException e1) {
			// Inform that a mistake happened in sendToConsole
			System.out.println("Something went wrong in sendToConsole");
		}
	}

}

