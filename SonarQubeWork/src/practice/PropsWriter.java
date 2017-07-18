package practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsWriter {
	// Creates a FileWriter variable named fileWriter
	private FileOutputStream fileOut;
	// Creates a BufferedWriter variable named buffWriter
	private File file;
	private Properties configProperty;

	public PropsWriter(String filename) {
		configProperty = new Properties();
		file = new File(filename);
		try {
			fileOut = new FileOutputStream(file, true);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Check your constructer");;
		}
	}

	public void propsVars(String projectname) {
		String keyDescript = "# The project key";
		String projKey = "sonar.projectKey=my:";
		String otherDescript = "#name, version, source folder";
		String projName = "sonar.projectName=My ";
		String projValue = projectname;
		String versionKey = "sonar.projectVersion=";
		String versionVal = "1.0";
		String sourceKey = "sonar.sources=";
		String sourceVal = "./src";
		propsWriter(keyDescript);
		propsWriter(projKey, projValue);
		propsWriter(otherDescript);
		propsWriter(projName, projValue);
		propsWriter(versionKey, versionVal);
		propsWriter(sourceKey, sourceVal);
	}

	public void propsWriter(String content) {
		byte[] bytesArray = content.getBytes();
		try {
			fileOut.write(bytesArray);
			fileOut.flush();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Check your propsWriter(String content) method");
		}
		
	}

	public void propsWriter(String key, String data) {

		configProperty.setProperty(key, data);

		try {
			
			configProperty.store(fileOut, "sample properties");
			fileOut.close();
		} catch (IOException e) {
			System.out.println("File was a dud in PropsWriter");

			/**
			 * Method allows the passing of filenames from other classes.
			 * Creates a new File and also creates new instances of fileWriter
			 * and buffWriter
			 * 
			 * @param filename
			 * @return
			 */
		}
	}
}
