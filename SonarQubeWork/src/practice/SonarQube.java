package practice;

public class SonarQube {
	private final static String localRepo = "C:\\Users\\fz3\\SonarQube\\TheClone";
	private final static String remoteRepo = "https://github.com/Cruziken/CruzikenPractice.git";
	private final static String projectName= "CruzikenPractice";
	private final static String filename = "sonar-project.properties";
	public static void startIt(){
		AllGit myAllGit = new AllGit(localRepo, remoteRepo);
		myAllGit.createClone();
		PropsWriter myPropsWriter = new PropsWriter(filename, localRepo);
		Importer myImporter = new Importer();
		Variables myVariables = new Variables();
		myVariables.sonarVars(localRepo);
		myVariables.fileVars(projectName);
		myPropsWriter.propsVars(myVariables);
		myImporter.setVars(myVariables);
		myImporter.commandPrompt();
		
	}
	public static void main(String[] args){
		startIt();
	}
}

