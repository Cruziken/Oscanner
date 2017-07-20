package practice;

public class SonarQube {
	private final String localRepo = "C:\\Users\\fz3\\SonarQube\\TheClone";
	private final String remoteRepo = "https://github.com/Cruziken/SonarQube.git";
	private final String projectName= "sonarqubework";
	public void startIt(){
		AllGit myAllGit = new AllGit(localRepo, remoteRepo);
		myAllGit.createClone();
		//PropsWriter myPropsWriter = new PropsWriter("sonar-project.properties");
		Importer myImporter = new Importer();
		Variables myVariables = new Variables();
		myVariables.sonarVars(localRepo);
		myVariables.fileVars(projectName);
		//myPropsWriter.propsVars(myVariables);
		myImporter.setVars(myVariables);
		myImporter.commandPrompt();
		
	}
	public void main(String[] args){
		startIt();
	}
}

