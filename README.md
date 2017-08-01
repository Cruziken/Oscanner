
<body>
<h1>SonarQube-Practice</h>
<h2>Configuring SonarQube</h2>
<h3> Downloading SonarQube Server </h3>
<p>Refer to <a href ="https://docs.sonarqube.org/display/SONAR/Get+Started+in+Two+Minutes">this link</a> on instructions on how to quickly utilitze SonarQube.To connect to the SonarQube server, you'll need to download and extract the following package (sonarqube 6.4): <a href = https://www.sonarqube.org/downloads/>Link</a> </br>
To start the server, go to the bin path of the server on your machine; /etc/sonarqube-6.4/bin/[OS]-x86-** or C://sonarsonarqube-6.4/bin/windows-x86-** and run "./sonar.sh console" on a Linux machine's shell or "StartSonar.bat" on a Windows machine shell. </br>
</p>
<h3> Downloading SonarQube Scanner </h3>
<p>To actual pass source code to the SonarQube server, you'll need the SonarQube scanner. There are numerous scanners to choose from (ex: Maven, Gradle, etc.) but in this demostration we utilized the default scanner, which can be downloaded for free <a href = "https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner">here</a>. In order to utilize the code in SonarQube-Practice save the file in a directory such as /etc/sonar-scanner/bin on Linux and C:\\User\\sonar-scanner\\bin on Windows. </br>
To pass a package, start from the directory of the program you want to send to get sent, create a <a href = "https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner">sonar-project.properties file</a> in that directory, and then from that directory in your os shell call /(bin path of sonar-scanner)/./sonar-scanner for Linux or C://(bin path for sonar-scanner)//sonar-scanner for Windows. </p>
<h2>Configuring JDK and JRE</h2>
<p>You'll need the Java Runtime Environment and Java Development Kit. Thier downloads respectively are the following: <a href ="http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html">JRE</a> and <a href ="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">JDK</a>. You may have to add the JDK's bin path as an environment variable in <a href ="https://www.java.com/en/download/help/path.xml"> a Windows operating system </a>. 
<h2>Running the program using code on SonarQue-Practice</h2>
<p>Clone and copy the source code and run in an IDE such as Eclipse, <a href = "http://www.cs.colostate.edu/helpdocs/eclipseCommLineArgs.html"> editing the Run-Time agruments as needed </a> or run through shell of os using sonarqube.jar file. For Windows and Linux change directories in shell to where the sonarqube.jar file is, and then type 
"java -jar sonarqube.jar (Path to file you that is your remote repo clone) (The remote repository you are cloning from) (name of the project) (path to the files within repository you want to send. Typing "." is a good bet if you just want it all scanned)". Of course, this only works if you have started the SonarQube server already. </p>

<h2> Running by synchronizing project to virtual machine</h2>

<h2>Gaining access to server</h2>

<h2> Further changes</h2>
