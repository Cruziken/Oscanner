package ExcelRead;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class ShowExcData{
private static XSSFCell excelvals = null;
/*private static String name = null;
private static String college = null;
private static String majors = null;
private static String Ra = null;
private static String title = null;
private static String abstracts = null;
private static String value = null;*/
public static FindAndReplace myFinder = null;
public ShowExcData(FindAndReplace myFinders) {
	myFinder = myFinders;
}

public void showExelData(List data, String directory) {
	//
	// Iterates the data and prints it out to the console.
	    	//Creates a for loop that will iterate for the number of rows we have in the excel file
	    	for (int i = 0; i < data.size(); i++) {
	    	// Creates a list out of data in each row
	        List list = (List) data.get(i);
	        //Creates a for loop that iterates for the number of values in each row
	        
	        for (int j = 0; j < list.size(); j++) {
	        	//Saves each value from the row into a variable called employee id
	        	System.out.println(j);
	            excelvals = (XSSFCell) list.get(j);
	            System.out.println("We here in show Excel data");
	            //value =excelvals.getRichStringCellValue().getString();
	            //System.out.println(value);
	            
	           if (j==0) {
	            	String name = excelvals.getRichStringCellValue().getString();
	            	//name = name.replaceAll("%", "\\%");
	            	myFinder.setAuthor(name);
	            	System.out.println(name);
	            }
	            else if (j==1) {
	            	
	            	String college = excelvals.getRichStringCellValue().getString();
	            	//college = college.replaceAll("%", "\\%");
	            	myFinder.setCollege(college);
	            	System.out.println(college);
	            }
	            else if (j==2) {
	            	String majors = excelvals.getRichStringCellValue().getString();
	            	//majors = majors.replaceAll("%", "\\%");
	            	myFinder.setMajor(majors);
	            	System.out.println(majors);
	            }
	            else if (j==3) {
	            	String Ra = excelvals.getRichStringCellValue().getString();
	            	//Ra = Ra.replaceAll("%", "\\%");
	            	myFinder.setMentor(Ra);
	            	System.out.println(Ra);
	            }
	            else if (j==4) {
	            	String title = excelvals.getRichStringCellValue().getString();
	            	//title = title.replaceAll("%", "\\%");
	            	title = title.replace("%", ("^^^^005c"+"^^^^0025"));
	            	title = title.replace("&",  ("^^^^005c"+ "^^^^0026"));
	            	myFinder.setTitle(title);
	            	System.out.println(title);
	            }
	            else if (j==5)  {
	            	String abstracts = excelvals.getRichStringCellValue().getString();
	            	//StringBuilder quotes = new StringBuilder().append("\"");
	            	//abstracts = abstracts.replace('"', ("^^^^0022"));
	            	//abstracts = abstracts.replace(quotes, "Let us go");
	            	//Format curly quotes: beginning
	            	abstracts = abstracts.replace( "\u201c", "^^^^201c" );  // 147
	            	//Format curly quotes: end
	            	abstracts = abstracts.replace( "\u201d", "^^^^201d" );  // 148
	            	
	            	abstracts = abstracts.replace("%", ("^^^^005c"+"^^^^0025"));
	            	abstracts = abstracts.replace("\u2019", "^^^^2019");
	            	//Format ampersand &
	            	abstracts = abstracts.replace("&", ("^^^^005c"+ "^^^^0026"));
	            	myFinder.setAbstracts(abstracts);
	            	System.out.println(abstracts);
	            	myFinder.replaceVals(directory);
	            }
	            else {
	            	System.out.println("This should work");
	            }
	           //myVals.closeIt();
	           // storeVars(name, college, majors, Ra, title, abstracts);
	            //System.out.print("Life is Great");
	            //Prints out each value in the row 
	   /* 	}
	    }
}
	        public void storeVars (String names, String colleges, String major, String advisor, String titles, String abstrac) {
	        	myVals.propsWriter(names);
	        	myVals.propsWriter(colleges);
	        	myVals.propsWriter(major);
	        	myVals.propsWriter(advisor);
	        	myVals.propsWriter(titles);
	        	myVals.propsWriter(abstrac);
	        	myVals.closeIt();
	       
} */
	        }
	    	}
	    
}
}

