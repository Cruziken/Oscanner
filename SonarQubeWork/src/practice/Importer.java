package practice;

public class Importer {
	public static void main(String[] args){
		PropsWriter myPropsWriter = new PropsWriter("sonar-project.properties");
		myPropsWriter.propsVars("sonarqubework");
	}
}
