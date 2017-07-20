package practice;
//import java.io.File;



import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.CreateBranchCommand.SetupUpstreamMode;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;

public class AllGit {
	// Creates a localPath String (where and what the local when will be called)
	// and a remotePath String(which repository I'm getting it from
	private String localPath, remotePath;
	// Creates an instance of Repository called localRepo
	private Repository localRepo;
	// Creates an instance of Git called git
	private Git git;

	/**
	 * This method Initializes the localPath and remotePath variables, the
	 * localRepo, and the Git instance
	 */
	public void initialize() {
		// Assigns the localPath a value. May have to passed in from main class
		// when SonarQube work is made into a Maven project
		localPath = "C:\\Users\\fz3\\SonarQube\\TheClone";
		// Assigns the remotePath a value. May have to passed in from main class
		// when SonarQube work is made into a Maven project
		remotePath = "https://github.com/Cruziken/SonarQube.git";
		// In case localPath is null...
		try {
			// Assigns the localRepo a value defined by localPath
			localRepo = new FileRepository(localPath + "/.git");
		}
		// Print off the following statement
		catch (IOException e) {
			// Let us know that error occured here
			System.out.println("Something happened in method init");
		}
		// Assign git the value of the new repo
		git = new Git(localRepo);
	}

	/**
	 * This method creates a new local repository
	 */
	public void createLocRepo() {
		// The new local Repository that will be created
		Repository newRepo;
		// In case the local path is null...
		try {
			// Assigns the new repo the value from the localPath
			newRepo = new FileRepository(localPath + ".git");
			// Creates this repository
			newRepo.create();
		}
		// Print the following statement
		catch (IOException e) {
			// Let us know that error occured here
			System.out.println("Something happened in testCreate");
		}
	}

	/**
	 * This method clones a remote repository to the local one on the machine
	 */
	public void createClone() {
		// In case the paths are null...
		try {
			// Sets the directory from the localPath, sets the remotePath,
			// clones the values from the remote repository to the local
			// repository
			Git.cloneRepository().setURI(remotePath).setDirectory(new File(localPath)).call();
		}
		// ...Print out the following statement
		catch (GitAPIException e) {
			// Let someone know error occured here
			System.out.println("Something happened in testClone");
		}
	}

	/**
	 * This method adds files to the local repository
	 */
	public void addFile() {
		// Assigns the instance of File the localPath plus file you want to
		// create
		File myfile = new File(localPath + "CruzCaliber.txt");
		// In case myfile is a dud...
		try {
			// Create the new file
			myfile.createNewFile();
			// Adds the new file to the localrepo
			git.add().addFilepattern("myfile").call();
		}
		// Print off the following statement
		catch (GitAPIException | IOException e) {
			// Inform something went wrong in this method
			System.out.println("Something went wrong in testAdd");
		}
	}

	public void testCommit() {
		try {
			git.commit().setMessage("Added myfile").call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testPush() {
		try {
			git.push().call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testTrackMaster() {
		try {
			git.branchCreate().setName("master").setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM)
					.setStartPoint("origin/master").setForce(true).call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testPull() throws IOException, GitAPIException {
		git.pull().call();
	}
}
