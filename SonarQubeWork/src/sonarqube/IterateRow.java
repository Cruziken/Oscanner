package ExcelRead;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class IterateRow {
	List sheetData = new ArrayList();
	public List iterate(XSSFSheet sheet) {
	Iterator rows = sheet.rowIterator();
    while (rows.hasNext()) {
        XSSFRow row = (XSSFRow) rows.next();
        Iterator cells = row.cellIterator();

        List data = new ArrayList();
        while (cells.hasNext()) {
            XSSFCell cell = (XSSFCell) cells.next();
            data.add(cell);
        }

        sheetData.add(data);
    }
return sheetData;
}
}

