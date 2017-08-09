package sonarqube;

import java.io.File;
import java.util.List;

/**
 * This main method starts the program
 * 
 * @author fz3
 *
 */
public class Oscanner {
	// This is the localpath where the remote Repository will be cloned
	// to.Examples: C:\\Users\\fz3\\SonarQube\\TheClone on Windows and
	// /home/mint/Programs/TheClone on linux
	private static String localRepo = null;
	// This is the remoteRepo URL; what will be cloned. Example:
	// https:://github.com/Cruziken/SonarQube-Practice.git
	private static String remoteRepo = null;
	// This is projectName for the project. sonarTest
	//private static String projectName = null;
	// This is the name of the properties file. Should not change
	private static final String filename = "sonar-project.properties";
	// This is the name of the source in the project. For example . or ./src or
	// ./SonarQubeWork/src
	private static String source = null;
	private static List<String> subPaths= null;

	           
	
	public static void startIt() {
		// Creates an instance of AllGit and passes the localpath and the remote
		// UR. to it
		
		AllGit myAllGit = new AllGit(localRepo, remoteRepo);
		myAllGit.createClone();
		
		DirectoryScanner myDirScan = new DirectoryScanner(localRepo);
		subPaths = myDirScan.listFolders();
			for (int i=0;i < subPaths.size();i++){
		String sub = subPaths.get(i);
		System.out.println(sub);
		System.out.println(subPaths.size());
		// Creates an instance of PropsWriter and passes the filename and
		// localRepo variables through it
		
		// Creates a clone in localpath location of remote repository
		
		PropsWriter myPropsWriter = new PropsWriter(filename, (localRepo +sub));
		// Creates an instance of Commander called myCommander
		Commander myCommander = new Commander();
		// Creates an instance of Variables called myVariables
		Variables myVariables = new Variables();
		
		// Calls the sonarVars method on myVariables. This sets the directory
		// that we will send from and tells where the sonar-scanner location
		myVariables.sonarVars((localRepo + sub));
		// Calls the fileVars method on myVariables. Sets the contents of the
		// properties file
		myVariables.fileVars(sub, source);
		// Gets the values from Varibles to print to the properties file
		myPropsWriter.propsVars(myVariables);
		// Gets the directory and command from myVariables class
		myCommander.setVars(myVariables);
		// Calls the commandPrompt on myCommander. In this case, this sends the
		// repo to the sonarqube scanner
		myCommander.commandPrompt();}
	}



	/**
	 * The main method is where the program looks to begin
	 * 
	 * @param path
	 */
	public static void main(String[] path) {
		// Calls the startIt() method
		// myValues();
		localRepo = path[0];
		remoteRepo = path[1];
		//projectName = path[2];
		source = path[2];
		startIt();
	}
}

