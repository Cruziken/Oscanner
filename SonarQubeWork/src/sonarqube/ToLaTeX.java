package ExcelRead;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
//import org.scilab.forge.jlatexmath.*;


public class ToLaTeX {

	//Creates a Process instance called process
		private static Process process;
		// Creates String variables commands and directory
		private static String commands;
		private static String directory;
		private static String author;
		private static String os;
		
/**public static void main (String[] args) {
/**Process p;
try {
    p = Runtime.getRuntime().exec("C:\\Users\\b0c\\AppData\\Local\\Programs\\MiKTeX 2.9\\miktex\\bin\\x64\\pdflatex.exe -synctex=1 -interaction=nonstopmode C:\\Users\\b0c\\Documents\\TestWork.tex");
    p.waitFor();
    System.out.println("We Here");
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} **/

	
	

	/**
	 * This method sets the Variables. Note that commented out section contain
	 * calls to get command and directory to start SonarQube for Variables
	 */

	public void setVars(String directit, String auth) {
		// Creates a string that takes the value of the operating system's name
		 os = System.getProperty("os.name");
		 author = auth;
		if (os.equals("Windows 10")) {
			// Prints out correct commands for windows
			String program = "\"C:\\Users\\b0c\\AppData\\Local\\Programs\\MiKTeX 2.9\\miktex\\bin\\x64\\lualatex.exe\"";
			commands = program + " " + directit + "\\"+ author + ".tex"; 
			// gets the directory to start commands from
			System.out.println("commands");
		} else {
			// Prints out the correct commands for linux
			//commands = myVari.getSendCommandLinux();
		}
		// Directory is linux or windows depending on what the user passes
		directory = directit;
		// Prints out the commands
		System.out.println(commands);
		// Prints out the directory
		System.out.println(directory);
	}

	/**
	 * This method runs commands through command prompt
	 */
	public void commandPrompt() {
		// Creates an instance of ProcessBuilder called probuilder
		ProcessBuilder probuilder = null;
		// Creates a string called os that calls for the property name
		 os = System.getProperty("os.name");
		// Creates an instance of an array of strings called theCommand
		String[] theCommand = null;
		// If the computer is Windows 10 OS...
		if (os.equals("Windows 10")) {
			// Creates an array of strings called commandW that takes command
			// specific to windows
			String[] theCommandW = { "CMD", "/C", commands };
			//Sets theCommand equal to theCommandW
			theCommand = theCommandW;
		} 
		//If its Linux or Mac
		else {
			//Creates an array of strings called theCommandL that takes commands specific to linux
			String[] theCommandL = { "/bin/bash", "-c", commands };
			//Sets theCommand equal to theCommandW
			theCommand = theCommandL;
		}
		// Creates an instance of ProcessBuilder called probuilder given the
		// command
		probuilder = new ProcessBuilder(theCommand);
		// Redirects errosStream to eclipse console
		probuilder.redirectErrorStream(true);
		// You can set up your work directory
		// How to get path from working directory
		probuilder.directory(new File(directory));
		// Sets theCommand equal to the command output on windows
		System.out.println("We here");
		try

		{
			// Starts the process
			process = probuilder.start();
			// Sends command to sendToConsolemethod
			sendToConsole(theCommand);
		}
		// ..print off the following statement
		catch (IOException e2) {
			// Inform that error ocurred here
			System.out.println("Something happened in Commander commandPrompt");
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
		// System.out.println("wHat"); 
		
		try {
			// While the bufferedreader is giving content and no null values do
			// the following
			while ((line = br.readLine()) != null) {
				// Prints off the content the BufferedReader gives
				System.out.println(line);
				// Zero means fail, anything else means successs
				process.waitFor(1, TimeUnit.SECONDS);
				process.destroy();
				process.waitFor();
				// Prints out success or failure
				//System.out.println("\n\nExit Value is " + exitValue);
			}
			// Closes the buffered reader
			br.close();
			//is.close();
			//isr.close();
			
		}
		// ...print the followng statement if something goes wrong
		catch (IOException | InterruptedException e1) {
			// Inform that a mistake happened in sendToConsole
			System.out.println("Something went wrong in sendToConsole");
		}
		/**Process process = Runtime.getRuntime().exec("tasklist");
		BufferedReader reader =
		new BufferedReader(new InputStreamReader(process.getInputStream()));
		while ((reader.readLine()) != null) {}
		process.waitFor(); 
		Process process = new ProcessBuilder(command, and, arguments)
    .redirectErrorStream(true)
    .directory(workingDir)
    .start();

process.waitFor(5, TimeUnit.SECONDS);
process.destroy();
process.waitFor(); // wait for the process to terminate
		**/
		
	}
}
