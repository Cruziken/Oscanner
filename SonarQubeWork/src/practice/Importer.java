package practice;

public class Importer {
	public static void main(String[] args){
		PropsWriter myPropsWriter = new PropsWriter("C:/Users/fz3/workspace/Files/sonar-project.properties");
		myPropsWriter.propsVars("sonarqubework");
	}
}
