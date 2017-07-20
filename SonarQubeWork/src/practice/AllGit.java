package practice;
//import java.io.File;
//import java.io.IOException;

//import org.eclipse.jgit.api.CloneCommand;
//import org.eclipse.jgit.api.Git;
//import org.eclipse.jgit.api.errors.GitAPIException;
//import org.eclipse.jgit.internal.storage.file.FileRepository;
//import org.eclipse.jgit.lib.Repository;


public class AllGit {
	public void pull(){
		/*private String localPath, remotePath;
	private Repository localRepo;
	private Git git;

	public void init() {
		localPath = "C:\\Users\\fz3\\SonarQube\\TheClone";
		remotePath = "https://github.com/Cruziken/SonarQube.git";
		try {
			localRepo = new FileRepository(localPath + "/.git");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		git = new Git(localRepo);
	}

	public void testCreate() {
		Repository newRepo;
		try {
			newRepo = new FileRepository(localPath + ".git");
			newRepo.create();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testClone() {
		try {
			Git.cloneRepository().setURI(remotePath).setDirectory(new File(localPath)).call();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testAdd() {
		File myfile = new File(localPath + "C:\\Users\\fz3\\workspace\\FizzBuzz\\CruzCaliber.txt");
		try {
			myfile.createNewFile();
			git.add().addFilepattern("myfile").call();
		} catch (GitAPIException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
}		} */
	}
}
