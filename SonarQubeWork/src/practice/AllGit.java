package practice;

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

	public AllGit(String localPathValue, String remotePathValue) {
		// Assigns the localPath the value passed in
		localPath = localPathValue;
		// Assigns the remotePath a value. May have to passed in from main class
		// when SonarQube work is made into a Maven project
		remotePath = remotePathValue;
		// In case localPath is null...
		try {
			// Assigns the localRepo the value passed in
			localRepo = new FileRepository(localPath + "/.git");
		}
		// Print off the following statement
		catch (IOException e) {
			// Let us know that error occured here
			System.out.println("Something happened in method initialize");
		}
		// Assign git the value of the new repo
		git = new Git(localRepo);
	}

	/**
	 * This method creates a new local repository. Creates it but through
	 * BareRepository error
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
			System.out.println("Something happened in createLocRepo");
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
			System.out.println("Something happened in createClone");
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
			if (!myfile.createNewFile()) {
				//Prints this out if new file is not created
				System.out.println("Bad stuff in addFile");
			}
			// Adds the new file to the localrepo
			git.add().addFilepattern("/CruzCaliber.txt").call();

		}
		// Print off the following statement
		catch (GitAPIException | IOException e) {
			// Inform something went wrong in this method
			System.out.println("Something went wrong in addFile");
		}
	}

	/**
	 * This method adds a comment to a push or added file
	 */
	public void addComments() {
		// In case the Git is a dud
		try {
			// Add the comment to the git
			git.commit().setMessage("Added myfile").call();
		}
		// ...print the following command
		catch (GitAPIException e) {
			// Inform something went wrong with the commit
			System.out.println("Something went wrong in addComments");
		}
	}

	/**
	 * This method pushes changes in local repository up to remote one
	 */
	public void pushIt() {
		// In case the git is a dud
		try {
			// Push it to the limit!
			git.push().call();
		}
		// ...print the following statement
		catch (GitAPIException e) {
			// Inform if something went wrong in this method
			System.out.println("Something went wrong in pushIt");
		}
	}

	/**
	 * Tracks the master branch
	 */
	public void trackMaster() {
		// In case git is a dud...
		try {
			// Creates tracking master
			git.branchCreate().setName("master").setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM)
					.setStartPoint("origin/master").setForce(true).call();
			// Prints out what details of branch tracking
			System.out.println("Now tracking master in repository at " + localRepo.getDirectory()
					+ " from origin/master at " + remotePath);
		}
		// ...print off the following statement
		catch (GitAPIException e) {
			// Inform that something went wrong in trackMaster
			System.out.println("Something went wrong in trackMaster");
		}
	}

	/**
	 * Method pulls from remote repository
	 */
	public void testPull() {
		// In case Git is a dud
		try {
			// Pull it to the limit!...?
			git.pull().call();
		}
		// ...print off the following statement
		catch (GitAPIException e) {
			// Inform that something went wrong in testPull
			System.out.println("Something went wrong in testPull");
		}
	}

	/**
	 * Method that Closes repository
	 */
	public void closeRepo() {
		// closes the localRepo
		localRepo.close();
	}
}
