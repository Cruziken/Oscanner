package practice;

/**
 * This main method starts the program
 * 
 * @author fz3
 *
 */
public class SonarQube {
	// This is the localpath where the remote Repository will be cloned to
	private final static String localRepo = "C:\\Users\\fz3\\SonarQube\\TheClone3";
	// This is the remoteRepo URL; what will be cloned
	private final static String remoteRepo = "https://github.com/Cruziken/SonarQube-Practice.git";
	// This is projectName for the project
	private final static String projectName = "sonarqubework";
	// This is the name of the properties file. Should not change
	private final static String filename = "sonar-project.properties";
	// This is the name of the source in the project
	private final static String source = "./SonarQubeWork/src";

	/**
	 * This method starts the process
	 */
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
		// that we will send from
		myVariables.sonarVars(localRepo);
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
	 * @param args
	 */
	public static void main(String[] args) {
		// Calls the startIt() method
		startIt();
	}
}
