package sonarqube;

import java.util.List;

/**
 * This class contains the main method that starts the program and the recipe
 * of events that take place
 * 
 *
 */
public class Oscanner {
	// This is the localpath where the remote Repository will be cloned
	// to.Examples: C:\\Users\\fz3\\SonarQube\\TheClone\\ on Windows and
	// /home/mint/Programs/TheClone/ on linux
	private static String localRepo = null;
	// This is the remoteRepo URL; what will be cloned. Example:
	// https:://github.com/Cruziken/SonarQube-Practice.git
	private static String remoteRepo = null;
	// This is the name of the properties file. Should not change
	private static final String filename = "sonar-project.properties";
	// This is the name of the source in the project. For example . or ./src or
	// ./SonarQubeWork/src
	private static String source = null;
	// Creates a List of Strings called subPaths. These are the subdirectories
	// within the cloned github repository
	private static List<String> subPaths = null;

	/**
	 * This method does it all
	 */
	public static void startIt() {
		// Creates an instance of AllGit and passes the localpath and the remote
		// URL to it
		AllGit myAllGit = new AllGit(localRepo, remoteRepo);
		//// Creates a clone in localpath location of remote repository
		myAllGit.createClone();
		// Creates an instance of DirectoryScanner. Passes the local repository
		// path through the constructor
		DirectoryScanner myDirScan = new DirectoryScanner(localRepo);
		// This method creates a list of the subdirectories from the localRepo
		// path passed through
		subPaths = myDirScan.listFolders();
		// For look state takes the number of subdirectories in subPaths and
		// says for each one starting from the first (subPaths.get(0)) to the
		// last (subPaths.get<subPaths.size()), pass the subdirectory through
		// the following methods
		for (int i = 0; i < subPaths.size(); i++) {
			// Takes the value for the subdirectory
			String sub = subPaths.get(i);
			// Creates an instance of PropsWriter and passes the filename and
			// subdirectory variables through it
			PropsWriter myPropsWriter = new PropsWriter(filename, (localRepo + sub));
			// Creates an instance of Commander called myCommander
			Commander myCommander = new Commander();
			// Creates an instance of Variables called myVariables
			Variables myVariables = new Variables();
			// Calls the sonarVars method on myVariables. This sets the
			// directory
			// that we will send from and tells where the sonar-scanner location
			myVariables.sonarVars((localRepo + sub));
			// Calls the fileVars method on myVariables. Sets the contents of
			// the
			// properties file
			myVariables.fileVars((sub), source);
			// Gets the values from Varibles to print to the properties file
			myPropsWriter.propsVars(myVariables);
			// Gets the directory and command from myVariables class
			myCommander.setVars(myVariables);
			// Calls the commandPrompt on myCommander. In this case, this sends
			// the
			// repo to the sonarqube scanner
			myCommander.commandPrompt();
		}
	}

	/**
	 * The main method is where the program looks to begin
	 * 
	 * @param path
	 */
	public static void main(String[] path) {
		//Allows user input of localRepo value
		localRepo = path[0];
		//Allows user input of remoteRepo value
		remoteRepo = path[1];
		//Allows user input of source file. To be safe make it .
		source = path[2];
		// starts the whole shabang
		startIt();
	}
}
