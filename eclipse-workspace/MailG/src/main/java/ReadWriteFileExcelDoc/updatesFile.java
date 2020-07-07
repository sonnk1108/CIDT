package ReadWriteFileExcelDoc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class updatesFile {
	public static void main(String [] args) throws IOException {
		Cell cell;
		String FilePath="C:\\Users\\Admin\\eclipse-workspace\\MailG\\Book1.xlsx";
		FileInputStream fis = new FileInputStream(FilePath);	
		Workbook wb = getWorkbook(fis,FilePath); //Tao mot doi tuong sheet
		org.apache.poi.ss.usermodel.Sheet sheet =wb.getSheetAt(0); 
		Iterator<Row> itr = sheet.iterator();   
		 int count = 0;
		//lấy danh sahcs row
		while(itr.hasNext()) {
			Row row=itr.next();
			count++; 
			try{
				cell= sheet.getRow(count).getCell(2);		
				cell.setCellValue(cell.getNumericCellValue()*2);
				}
			catch(NullPointerException e ){
				break;
			}
				
				cell.setCellValue(cell.getNumericCellValue()*2);
				
		}
		System.out.print(count);
		FileOutputStream out = new FileOutputStream(FilePath);
	    wb.write(out);
	}
	

	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		// Xác định xem file excel có đuôi xlsx hoặc xls 
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }
}
