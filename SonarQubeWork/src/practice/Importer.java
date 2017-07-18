package practice;

public class Importer {
	public void main(String[] args){
		PropsWriter myPropsWriter = new PropsWriter("sonar.properties");
		myPropsWriter.propsVars("sonarqubework");
	}
}
