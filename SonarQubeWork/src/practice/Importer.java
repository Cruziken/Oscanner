package practice;

public class Importer {
	
	public void importIt(){
		String filena= "FizzBuzz";
		AbsolutePather myAbsPather = new AbsolutePather();
		if (filena!=null){
		String abspath= myAbsPather.getAbsPath(filena);
		  String[] command = {"CMD", "/C", "dir"};
	        ProcessBuilder probuilder = new ProcessBuilder( command );
	        //You can set up your work directory
	        probuilder.directory(new File(abspath));
	        
	        Process process = null;
			try {
				process = probuilder.start();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        
	        //Read out dir output
	        InputStream is = process.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	        String line;
	        System.out.printf("Output of running %s is:\n", Arrays.toString(command));
	        try {
				while ((line = br.readLine()) != null) {
				    System.out.println(line);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	        //Wait to get exit value
	        try {
	            int exitValue = process.waitFor();
	            System.out.println("\n\nExit Value is " + exitValue);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	
	}
}
