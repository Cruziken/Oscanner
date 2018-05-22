package ExcelRead;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This method writes content passed to it to a file
 * 
 * @author fz3
 *
 */
public class ValuesWriter {
	// Creates a FileWriter variable named fileWriter
	private FileWriter fileWriter;
	// Creates a BufferedWriter named buffWriter
	private BufferedWriter buffWriter;

	/**
	 * This method takes in a file and intializes the fileWriter and buffWriter
	 * 
	 * @param filename
	 * @return 
	 */
	public void readValues(String filename, String localPath) {

		// Creates (or gets access to ) a file from this absolute path
		File file = new File(localPath +"//"+ filename);

		// In case there is no file to write to...
		try {
			// Creates a new FileWriter for that file.
			// Without the true you write over it. With it, you append
			fileWriter = new FileWriter(file);
			// Creates an instance buffWriter that writes the content from the
			// fileWriter
			buffWriter = new BufferedWriter(fileWriter);

		}
		// ...do this.
		catch (IOException e) {
			// Say this is something happens
			System.out.println("Problem in Writer contructor");
		}
	}

	/**
	 * This method retrieves content for sonar-properties file and has them
	 * passed to be written to new file
	 * 
	 * @param myVars
	 */
	/*public void propsVars(Variables myVars) {
		// Gets the value assigned to keyDescript
		String keyDescript = myVars.getKeyDescript();
		// Gets the value assigned to projKey
		String projKey = myVars.getProjKey();
		// Gets the value assigned to otherDescript
		String otherDescript = myVars.getOtherDescript();
		// Gets the value assigned to projName
		String projName = myVars.getProjName();
		// Gets the value assigned to projVersion
		String projVersion = myVars.getProjVersion();
		// Gets the value assigned to projSource
		String projSource = myVars.getProjSource();
		// Gets projBin to be written to file
		String projBin = myVars.getProjBin();
		// Passes keyDescript to be written to file
		propsWriter(keyDescript);
		// Passes projKey to be written to file
		propsWriter(projKey);
		// Passes otherDescript to be written to file
		propsWriter(otherDescript);
		// Passes projName to be written to file
		propsWriter(projName);
		// Passes projVersion to be written to file
		propsWriter(projVersion);
		// Passes projSource to be written to file
		propsWriter(projSource);
		// Passes projBin to be written to file
		propsWriter(projBin);
		// Close the FileWriter
		closeIt(); 
	} */

	/**
	 * Method allows content to be passed into it when accessed by other classes
	 * and methods. This content is then written out to a file and also the
	 * console
	 * 
	 * @param content
	 */
	public void propsWriter(String content) {

		// In case no content is there to be read...
		try {
			// buffWriter writes content to file passed from other classes
			buffWriter.write(content);
			// Each time new content is passed, give it a new line
			buffWriter.newLine();
		}
		// ...do this.
		catch (IOException e) {
			// Throws NullPointerException if doesn't work
			System.out.println("Something wrong happened in log(content)");
		}
		// Prints out the content that other classes pass to this method to the
		// console
		System.out.println(content);

	}

	/**
	 * Method closes any implementation of the buffWriter
	 */
	public void closeIt() {
		// Closes the buffWriter if there is something to close.
		try {
			buffWriter.close();
		}
		// If there is nothing to close...
		catch (IOException e) {
			// Throws NullPointerException if doesn't work
			System.out.println("Something wrong happened in closeIt()");
		}

	}
}
