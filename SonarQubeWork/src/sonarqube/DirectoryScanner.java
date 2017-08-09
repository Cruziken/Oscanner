package sonarqube;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This method takes repository values and returns a list of its subdirectories
 * 
 *
 */
public class DirectoryScanner {
	// Creates a list called dirContent
	private String dirContent;
	// Creates a String called directPath
	private String directPath;
	// Creates a list of Strings called subPaths
	private List<String> subPaths;

	/**
	 * This constructor initializes the value of directPath
	 * 
	 * @param directPather
	 */
	public DirectoryScanner(String directPather) {
		// directPath = "C:\\Users\\fz3\\workspace";
		directPath = directPather;
	}

	/**
	 * This method takes the local repo directory and returns a subdirectory
	 * list
	 * 
	 * @return subPaths
	 */
	public List<String> listFolders() {
		//Creates a file variables called directory and sets it equal to a file created from local repo pathname
		File directory = new File(directPath);
		// get all the files from a the directory
		File[] fList = directory.listFiles();
		//This sets teh list of Strings equal to an ArrayList of Strings 
		subPaths = new ArrayList<String>();
		//For files within the directory
		for (File file : fList) {
			//If file is truly a directory
			if (file.isDirectory()) {
				//Sets each subdirectory equal to dirContent
				dirContent = file.getName();
				//Adds the subdirectory value to subPath list
				subPaths.add(dirContent);

			}
		}
		//Lets people know how many sudirectories will be passed to the SonarQube server
		System.out.println("Number of subdirectories = " + subPaths.size());
		//Returns the list of subDirectory values
		return subPaths;

	}
}