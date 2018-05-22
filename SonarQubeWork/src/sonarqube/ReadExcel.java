package ExcelRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	// Create an ArrayList to store the data read from excel sheet.
	private static XSSFSheet sheet = null;

    
    public XSSFSheet readExc(String filename) {
    	List sheetData = new ArrayList();
    FileInputStream fis = null;
// Create a FileInputStream that will be use to read the
// excel file.
        try {
			fis = new FileInputStream(filename);
// Create an excel workbook from the file system.
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
// Get the first sheet on the workbook.
         sheet = workbook.getSheetAt(0);
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 System.out.println("Hello World");
 return sheet;
}
}