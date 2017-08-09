package sonarqube;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

	public class DirectoryScanner {
		//private static File folder = new File("C:\\Users\\fz3\\workspace");
				private static String dirContent;
				private static int numOfSubfolders;
				private static String directPath;
				private static List<String> subPaths;
				 private static List<String> subPathFake;
				//public static void listFilesForFolder(final File folder) {
				  /*  for (final File fileEntry : folder.listFiles()) {
				        if (fileEntry.isDirectory()) {
				            listFilesForFolder(fileEntry);
				        } else {
				            System.out.println(fileEntry.getName());
				        }
				    } */
				//public static void main(String[] args){
				//	listFolders();
					
				//}
				public DirectoryScanner(String directPather){
					 //directPath = "C:\\Users\\fz3\\workspace";
					directPath=directPather;
					 listFolders();
				}
				public void doSB(String content){
					StringBuilder sb = new StringBuilder();
					String dot = ".";
					for (int i = 1; i < 18; i++){
						sb.append(content);
						sb.append(dot);
						sb.append(i);
					}
				}
				 public List<String> listFolders(){
					 File directory = new File(directPath);
				        //get all the files from a directory
				        File[] fList = directory.listFiles();
				        subPathFake = new ArrayList<String>();
				        for (File file : fList){
				            if (file.isDirectory()){
				            	 dirContent= file.getName();
				            	// System.out.println(dirContent);
				            	// while (dirContent!=null){
				            	 //arrayIt(dirContent);
				            	 subPathFake.add(dirContent);
				            	// System.out.println(subPathFake.size());
				          
				            	// }
				            	}
				          //  System.out.println(subPathFake.size());
				            
				           
				            
				         
				        }
				        
				     
				               // dirArray[i]= dirContent;
				                //System.out.println(dirContent);
				        //System.out.println(dirContent);
				       // return dirContent;
						System.out.println("I am here");
						//System.out.println(dirContent);
						return subPathFake;}
				 public <T> List<T> magicalListGetter() {
					    return new ArrayList<T>();
					}    
				        
				        //System.out.println(dirArray);
		               // System.out.println(dirContent);
				        //return dirContent;
				    
				public static void arrayIt(List<String> sub){
					//String[] directC = new String[numDirect(directPath)];
					//int number = numOfSubfolders;
		            //for (int i = 0; i<1; i++){
					//directC[i]= dirContent;
					//int i =0;
					//i++;
					
					//while (i<number){
					subPaths= (sub);
					
		            //}
				
					 } 
				 
				 public static int numDirect(String directoryName) {
				 File dir = new File(directoryName);
				 numOfSubfolders = 0;
				 File listDir[] = dir.listFiles();
				 for (int i = 0; i < listDir.length; i++) {
				     if (listDir[i].isDirectory()) {
				             numOfSubfolders++;
				         }
				/* String[] dirArray= new String[numOfSubfolders];
				 for (int j = 0; j < dirArray.length; i++){ 
				 //listFolders(directoryName);
				 }
				 System.out.println("No of dir " + numOfSubfolders); 
				 }
				 }*/
				 }
				return numOfSubfolders;
				 }
				 public List<String> getSubPaths(){
					 return subPaths;
				 }
				 }
				    
			
				
				
				    
				//listFilesForFolder(folder);}
