package practice;

import java.io.File;
import java.io.IOException;

public class AbsolutePather {

		/**
		 * This method takes a String filename and returns the absolute path of the
		 * file passed to it
		 * 
		 * @param filename
		 * @return
		 */
		public String getAbsPath(String filename) {
			/*
			// Creates a string called path that'll house our absolute file name
			String path = "";
			// Creates a boolean bool which is true
			boolean bool;
			// In case there is no filename string to turn into a file...
			try {
				// create new file out of passed filename String
				File file = new File(filename);

				// returns true if the file exists
				bool = file.exists();

				// if file exists
				if (bool) {
					// get absolute path
					path = file.getParent();
				} 

			}
			// Catch the exception
			catch (Exception e) {

				// if any error occurs
				System.out.println("Absolute path went rouge");
			}
			// Return the absolute path of the filename
			return path;  */
			

	    	    File file = new File(filename);

	    	    String absolutePath = file.getAbsolutePath();
	    	    System.out.println("File path : " + absolutePath);

	    	    String filePath = absolutePath.
	    	    	     substring(0,absolutePath.lastIndexOf(File.separator));
	    	    System.out.println(filePath);
	    	    return filePath;

	    

	    	}
	}

