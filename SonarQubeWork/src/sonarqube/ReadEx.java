package ExcelRead;



import org.apache.poi.xssf.usermodel.XSSFSheet;


public class ReadEx {
private static String filename = null;
private static XSSFSheet sheet = null;
private static String directory = null;


		public static void startIt() {
			ToLaTeX myLua = new ToLaTeX();
			FindAndReplace myFind = new FindAndReplace(myLua);
			
			//ValuesWriter myValues = new ValuesWriter(); 
			ShowExcData myExceldata = new ShowExcData(myFind);
			IterateRow myIterator = new IterateRow();
			ReadExcel myReadExcel = new ReadExcel();
			sheet = myReadExcel.readExc(filename);
			      myExceldata.showExelData(myIterator.iterate(sheet), directory);
		}
			        
		 
	    
	    public static void main(String[] path) {
	// An excel file name. You can create a file name with a full
	// path information.
	    	 filename = path[0];
	    	 directory = path[1];
	         startIt();

	    }
}

