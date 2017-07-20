package practice;

public class SonarQube {
	public static void main(String[] args){
		AllGit myAllGit = new AllGit("C:\\Users\\fz3\\SonarQube\\TheClone", "https://github.com/Cruziken/SonarQube.git");
		PropsWriter myPropsWriter = new PropsWriter("sonar-project.properties");
		Importer myImporter = new Importer();
		Variables myVariables = new Variables();
		myVariables.fileVars("sonarqubework");
		myPropsWriter.propsVars(myVariables);
		myImporter.setVars(myVariables);
		myImporter.commandPrompt();
		
	}
}
