package practice;

public class Variables {
	private String keyDescript;
	private String projKey;
	private String otherDescript;
	private String projName;
	private String projVersion;
	private String projSource;

	public void vars(String projectname) {
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
}
