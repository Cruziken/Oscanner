package sonarqube;

/**
 * This main method starts the program
 * 
 * @author fz3
 *
 */
public class SonarQube {
	// This is the localpath where the remote Repository will be cloned to
	private static String localRepo = null;
	// This is the remoteRepo URL; what will be cloned
	private static String remoteRepo = null;
	// This is projectName for the project
	private static String projectName = null;
	// Pathname that houses the sonar scanner
	private static String sonarOS = null;
	// This is the name of the properties file. Should not change
	private static final String filename = "sonar-project.properties";
	// This is the name of the source in the project
	private static String source = null;

	/**
	 * This method starts the process
	 */
	/*
	public static void myValues() {
		Prompter myPrompter = new Prompter();
		// Prompts the user for the Pathname to the sonar scanner. Ex;
		// "C:\\Users\\fz3\\SonarQube\\sonarqube-6.4\\sonarqube-6.4\\bin\\windows-x86-64";
		sonarOS = myPrompter.scanIt("the path to sonar scanner.");
		// Example: C:\\Users\\fz3\\SonarQube\\TheClone
		localRepo = myPrompter.scanIt("local path for cloned repository");
		// Example: https://github.com/Cruziken/SonarQube-Practice.git
		remoteRepo = myPrompter.scanIt("remote URL for remote repository");
		// Example: sonarqubework
		projectName = myPrompter.scanIt(" the name of the project.");
		// Example: ./SonarQubeWork/src
		source = myPrompter.scanIt(
				" the source of the files you wish to scan. Should be path one level above files that you wish to scan.");
		// closes the scanner
		myPrompter.closeIt();

	} */

	public static void startIt() {
		// Creates an instance of AllGit and passes the localpath and the remote
		// URL to it
		AllGit myAllGit = new AllGit(localRepo, remoteRepo);
		// Creates a clone in localpath location of remote repository
		myAllGit.createClone();
		// Creates an instance of PropsWriter and passes the filename and
		// localRepo variables through it
		PropsWriter myPropsWriter = new PropsWriter(filename, localRepo);
		// Creates an instance of Commander called myCommander
		Commander myCommander = new Commander();
		// Creates an instance of Variables called myVariables
		Variables myVariables = new Variables();
		// Calls the sonarVars method on myVariables. This sets the directory
		// that we will send from and tells where the sonar-scanner location
		myVariables.sonarVars(localRepo, sonarOS);
		// Calls the fileVars method on myVariables. Sets the contents of the
		// properties file
		myVariables.fileVars(projectName, source);
		// Gets the values from Varibles to print to the properties file
		myPropsWriter.propsVars(myVariables);
		// Gets the directory and command from myVariables class
		myCommander.setVars(myVariables);
		// Calls the commandPrompt on myCommander. In this case, this sends the
		// repo to the sonarqube scanner
		myCommander.commandPrompt();

	}

	/**
	 * The main method is where the program looks to begin
	 * 
	 * @param path
	 */
	public static void main(String[] path) {
		// Calls the startIt() method
		//myValues();
		localRepo = path[0];
		remoteRepo = path[1];
		projectName = path[2];
		sonarOS = path[3];
		source = path[4];
		startIt();
	}
}
