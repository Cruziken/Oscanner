package practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;



public class PropsWriter {
	//Creates a FileWriter variable named fileWriter
	private FileWriter fileWriter;
	// Creates a BufferedWriter variable named buffWriter
	private BufferedWriter buffWriter;
	private Properties configProperty;
	public PropsWriter() {
		 configProperty = new Properties();
	}
	public void propsVars(String projectname){
		String keyDescript = "# The project key";
		String projKey = "sonar.projectKey=my:" ;
		String otherDescript = "#name, version, source folder";
		String projName = "sonar.projectName=My ";
		String projValue = projectname;
		String versionKey = "sonar.projectVersion=";
		String versionVal = "1.0";
		String sourceKey= "sonar.sources=";
		String sourceVal = "./src";
		propsWriter(projKey, projValue);
		propsWriter(projName, projValue);
		propsWriter(versionKey, versionVal);
		propsWriter(sourceKey, sourceVal);
	}
	public void propsWriter(String key, String data) {
		
		configProperty.setProperty(key, data);
		File file = new File("D:\\Helper.properties");
		FileOutputStream fileOut = new FileOutputStream(file,true);
		configProperty.store(fileOut, "sample properties");
		fileOut.close();

			/**
			 * Method allows the passing of filenames from other classes. Creates a new
			 * File and also creates new instances of fileWriter and buffWriter
			 * 
			 * @param filename
			 * @return 
			 */
	}
}
	