package practice;

import java.io.BufferedWriter;
import java.io.File;
/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;*/
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Properties;

public class PropsWriter {
	// Creates a FileWriter variable named fileWriter
	/*
	 * private FileOutputStream fileOut; private FileInputStream fileIn; //
	 * Creates a BufferedWriter variable named buffWriter private File file;
	 * private Properties configProperty;
	 */
	private FileWriter fileWriter;
	private BufferedWriter buffWriter;

	public PropsWriter(String filename) {

		// Creates (or gets access to ) a file from this absolute path
		File file = new File(filename);

		// In case there is no file to write to...
		try {
			// Creates a new FileWriter for that file.
			// Without the true you write over it. With it, you append
			fileWriter = new FileWriter(file, true);
			// Creates an instance buffWriter that writes the content from the
			// fileWriter
			buffWriter = new BufferedWriter(fileWriter);

		}
		// ...do this.
		catch (IOException e) {
			// Throws NullPointerException if doesn't work
			System.out.println("Problem in Writer contructor");
		}
	}

	public void propsVars(String projectname) {

		String keyDescript = "# The project key";
		String projKey = "sonar.projectKey=my:" + projectname;
		String otherDescript = "# name, version, source folder";
		String projName = "sonar.projectName=My " + projectname;
		String projVersion = "sonar.projectVersion=" + "1.0";
		String projSource = "sonar.sources=./src";
		propsWriter(keyDescript);
		propsWriter(projKey);
		propsWriter(otherDescript);
		propsWriter(projName);
		propsWriter(projVersion);
		propsWriter(projSource);
		closeIt();
	}

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
