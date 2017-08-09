package sonarqube;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

	public class DirectoryScanner {
		
				private static String dirContent;
				private static String directPath;
				 private static List<String> subPaths;
				
				public DirectoryScanner(String directPather){
					 //directPath = "C:\\Users\\fz3\\workspace";
					directPath=directPather;
				}
				 public List<String> listFolders(){
					 File directory = new File(directPath);
				        //get all the files from a directory
				        File[] fList = directory.listFiles();
				        subPaths = new ArrayList<String>();
				        for (File file : fList){
				            if (file.isDirectory()){
				            	 dirContent= file.getName();
				            	 subPaths.add(dirContent);
				            	
				            	}
				        }
				        System.out.println("Number of subdirectories = " + subPaths.size());
						return subPaths;      
				           
				            
				         
				        }
				 }