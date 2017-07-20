package practice;

public class Variables {
	private String keyDescript;
	private String projKey;
	private String otherDescript;
	private String projName;
	private String projVersion;
	private String projSource;
	private String startDirectory;
	private String fileSendDirectory;
	private String startCommand;
	private String sendCommand;

	
	public void sonarVars(){
		//Must pass this in at some point
		 startDirectory = "C:\\Users\\fz3\\SonarQube\\sonarqube-6.4\\sonarqube-6.4\\bin\\windows-x86-64";
		 //Must pass this in at some point
		 fileSendDirectory = "C:\\Users\\fz3\\workspace\\FizzBuzz";
		 //This is always this
		 startCommand = "StartSonar.bat";
		 //This is always this
		 sendCommand = "sonar-scanner";
	}
	
	
	
	public void fileVars(String projectname) {
		keyDescript = "# The project key";
		projKey = "sonar.projectKey=my:" + projectname;
		otherDescript = "# name, version, source folder";
		projName = "sonar.projectName=My " + projectname;
		projVersion = "sonar.projectVersion=" + "1.0";
		projSource = "sonar.sources=./src";
	}

	public String getKeyDescript() {
		return keyDescript;
	}

	public String getProjKey() {
		return projKey;
	}

	public String getOtherDescript() {
		return otherDescript;
	}

	public String getProjName() {
		return projName;
	}

	public String getProjVersion() {
		return projVersion;
	}

	public String getProjSource() {
		return projSource;
	}
	public String getStartDirectory(){
		return startDirectory;
	}
	
	public String getFileSendDirectory(){
		return fileSendDirectory;
	}
	
	public String getStartCommand(){
		return startCommand;
	}
	
	public String getSendCommand(){
		return sendCommand;
	}
}
