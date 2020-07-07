package ReadWriteFileExcelDoc;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;  
public class ReadExcels {
	public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_Name = 1;
    public static final int COLUMN_INDEX_salary = 2;
    public static final int COLUMN_INDEX_Destination = 3;
	public static void main(String []args) throws IOException {
		//Tạo danh sách đối tượng human 
		ArrayList <human> ListMan = new ArrayList();
		File file= new File("C:\\Users\\Admin\\eclipse-workspace\\MailG\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);	
		Workbook wb = getWorkbook(fis,"C:\\Users\\Admin\\eclipse-workspace\\MailG\\Book1.xlsx"); //Tao mot doi tuong sheet
		org.apache.poi.ss.usermodel.Sheet sheet =wb.getSheetAt(0); 
		Iterator<Row> itr = sheet.iterator();   
		//lấy danh sahcs row
		while(itr.hasNext()) {
			Row row=itr.next();
			human man= new human();
			// Lấy itr cho tất cả các sheet còn lại
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext())   {
				Cell cell = cellIterator.next(); 
				//tạo đối tượng cellvalue 
				Object cellValue = getCellValue(cell);
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex)    {
				case COLUMN_INDEX_ID:
                    man.setId( (String) getCellValue(cell));
                    break;
				case COLUMN_INDEX_Name: 
					man.setName((String) getCellValue(cell));
					break;
				case COLUMN_INDEX_salary: 
					man.setSalary(((String) getCellValue(cell)));
				
				case 	COLUMN_INDEX_Destination: 
					man.setDestination((String) getCellValue(cell));
					break;
				}

				}
			ListMan.add(man);
	
		}
		for(human a: ListMan) {
			System.out.println(" "+a.getSalary());
		}
		WriteFileExcel Writex= new WriteFileExcel();
		Writex.Add(ListMan);
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
	 private static Object getCellValue(Cell cell) {
	        org.apache.poi.ss.usermodel.CellType cellType = cell.getCellTypeEnum();
	        Object cellValue = null;
	        switch (cellType) {
	        case BOOLEAN:
	            cellValue = cell.getBooleanCellValue();
	            break;
	        case FORMULA:
	            Workbook workbook = cell.getSheet().getWorkbook();
	            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
	            cellValue = Double.toString(evaluator.evaluate(cell).getNumberValue());
	            break;
	        case NUMERIC:
	        	 //cellValue = cell.getNumericCellValue();
	        	cellValue = String.valueOf((int)cell.getNumericCellValue());
	            break;
	        case STRING:
	            cellValue = cell.getStringCellValue();
	            break;
	        case _NONE:
	        case BLANK:
	        case ERROR:
	            break;
	        default:
	            break;
	        }
	 
	        return cellValue;
	    }
}
