package practice;

/**
 * This class is THE data class for this package
 * 
 * @author fz3
 *
 */
public class Variables {
	// Creates String variables concerned with sonar-properties file
	private String keyDescript, projKey, otherDescript, projName, projVersion, projSource;
	// Creates String variables concerned with command prompt commands
	private String startDirectory, fileSendDirectory, startCommand, sendCommand;

	/**
	 * This method contains the commands and directory values to run through
	 * command prompt
	 */
	public void sonarVars() {
		// Must pass this in at some point
		startDirectory = "C:\\Users\\fz3\\SonarQube\\sonarqube-6.4\\sonarqube-6.4\\bin\\windows-x86-64";
		// Must pass this in at some point
		fileSendDirectory = "C:\\Users\\fz3\\git\\SonarQube-Practice\\SonarQubeWork";
		// This is always this
		startCommand = "StartSonar.bat";
		// This is always this
		sendCommand = "sonar-scanner";
	}

	/**
	 * This method contains the values for the desired content to send to
	 * sonar-properties file
	 */
	public void fileVars(String projectname) {
		// Assigns the value of keyDescript
		keyDescript = "# The project key";
		// Assigns the value of projKey
		projKey = "sonar.projectKey=my:" + projectname;
		// Assigns the value of otherDescript
		otherDescript = "# name, version, source folder";
		// Assigns the value of projName
		projName = "sonar.projectName=My " + projectname;
		// Assigns the value of projVersion
		projVersion = "sonar.projectVersion=" + "1.0";
		// Assigns the value of projSource
		projSource = "sonar.sources=./src";
	}

	/**
	 * This method returns the value of keyDescript
	 * 
	 * @return
	 */
	public String getKeyDescript() {
		// returns keyDescript
		return keyDescript;
	}

	/**
	 * This method returns the value of projKey
	 * 
	 * @return
	 */
	public String getProjKey() {
		// returns projKey
		return projKey;
	}

	/**
	 * This method returns the value of otherDescript
	 * 
	 * @return
	 */
	public String getOtherDescript() {
		// returns otherDescript
		return otherDescript;
	}

	/**
	 * This method returns the value of projName
	 * 
	 * @return
	 */
	public String getProjName() {
		// returns projName
		return projName;
	}

	/**
	 * This method returns the value of projVersion
	 * 
	 * @return
	 */
	public String getProjVersion() {
		// returns projVersion
		return projVersion;
	}

	/**
	 * This method returns the value of projSource
	 * 
	 * @return
	 */
	public String getProjSource() {
		// returns projSource
		return projSource;
	}

	/**
	 * This method returns the value of startDirectory
	 * 
	 * @return
	 */
	public String getStartDirectory() {
		// returns startDirectory
		return startDirectory;
	}

	/**
	 * This method returns the value of fileSendDirectory
	 * 
	 * @return
	 */
	public String getFileSendDirectory() {
		// returns fileSendDirectory
		return fileSendDirectory;
	}

	/**
	 * This method returns the value of startCommand
	 * 
	 * @return
	 */
	public String getStartCommand() {
		// returns startCommand
		return startCommand;
	}

	/**
	 * This method returns the value of sendCommand
	 * 
	 * @return
	 */
	public String getSendCommand() {
		// returns sendCommand
		return sendCommand;
	}
}
