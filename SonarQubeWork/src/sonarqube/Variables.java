package sonarqube;

/**
 * This class is THE data class for this package
 * 
 * 
 *
 */
public class Variables {
	// Creates String variables concerned with sonar-properties file
	private String keyDescript, projKey, otherDescript, projName, projVersion, projSource, projBin;
	// Creates String variables concerned with command prompt commands
	private String startDirectory, fileSendDirectory, startCommandWindows, startCommandLinux, sendCommandLinux,
			sendCommandWindows;

	/**
	 * This method contains the commands and directory values to run through
	 * command prompt
	 */
	public void sonarVars(String localRepoValue) {
		
		// Must pass this in at some point
		fileSendDirectory = localRepoValue;
		// This is always this
		startCommandWindows = "StartSonar.bat";
		// This is always this if you save it right
		sendCommandLinux = "/etc/sonar-scanner/bin/./sonar-scanner";
		//This is this
		sendCommandWindows = "C:\\Users\\b0c\\Desktop\\SonarQubeWork\\sonar-scanner\\bin\\sonar-scanner";
	}

	/**
	 * This method contains the values for the desired content to send to
	 * sonar-properties file
	 */
	public void fileVars(String projectname, String source) {
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
		projSource = "sonar.sources=" + source;
		setProjBin("sonar.java.binaries="+ source);
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
	public String getStartCommandLinux() {
		// returns startCommand
		return startCommandLinux;
	}
	/**
	 * this method returns the value of starCommandWindows
	 * @return
	 */
	public String getStartCommandWindows() {
		//returns startCommandWindows
		return startCommandWindows;
	}

	public String getSendCommandWindows() {
		return sendCommandWindows;
	}

	/**
	 * This method returns the value of sendCommandLinux
	 * 
	 * @return
	 */
	public String getSendCommandLinux() {
		// returns sendCommandLinux
		return sendCommandLinux;
	}

	/**
	 * This method returns the value of startCommand
	 * 
	 * @return
	 */
	public void setProjBin(String projBin) {
		this.projBin = projBin;
	}
	/**
	 * This method returns the value of startCommand
	 * 
	 * @return
	 */
	public String getProjBin() {
		return projBin;
	}
}
