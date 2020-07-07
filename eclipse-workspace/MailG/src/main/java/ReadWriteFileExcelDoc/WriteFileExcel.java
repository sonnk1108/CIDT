package ReadWriteFileExcelDoc;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class WriteFileExcel {
	public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_Name = 1;
    public static final int COLUMN_INDEX_salary = 2;
    public static final int COLUMN_INDEX_Destination = 3;
	private static CellStyle cellStyleFormatNumber = null;
	public void Add(ArrayList<human> man)  throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("My Books");
        
        int rowIndex=0;
        writeHeader(sheet, rowIndex);
		rowIndex++;
        for (human manList : man) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(manList, row);
            rowIndex++;
        }
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);
        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) {
            workbook.write(outputStream);
        }	
	}

	private void autosizeColumn(Sheet sheet, int lastColumn ) {
		for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }		
	}

	private void writeHeader(Sheet sheet, int rowIndex) {
		// TODO Auto-generated method stub
		CellStyle cellStyle = createStyleForHeader(sheet);
        
        // Create row
        Row row = sheet.createRow(rowIndex);
         
        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_ID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Id");
 
        cell = row.createCell(COLUMN_INDEX_Name);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Name");
 
        cell = row.createCell(COLUMN_INDEX_salary);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Salary");
 
        cell = row.createCell(COLUMN_INDEX_Destination);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Destination");
 
		
	}
	private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
		 Font font = sheet.getWorkbook().createFont();
	        font.setFontName("Times New Roman"); 
	        font.setBold(true);
	        font.setFontHeightInPoints((short) 14); // font size
	        font.setColor(IndexedColors.WHITE.getIndex()); // text color
	 
	        // Create CellStyle
	        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
	        cellStyle.setFont(font);
	        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
	        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        cellStyle.setBorderBottom(BorderStyle.THIN);
	        return cellStyle;
    }

	private void writeBook(human manList, Row row) {
		 if (cellStyleFormatNumber == null) {
	            // Format number
	            short format = (short)BuiltinFormats.getBuiltinFormat("#,##0");
	            // DataFormat df = workbook.createDataFormat();
	            // short format = df.getFormat("#,##0");
	             
	            //Create CellStyle
	            Workbook workbook = row.getSheet().getWorkbook();
	            cellStyleFormatNumber = workbook.createCellStyle();
	            cellStyleFormatNumber.setDataFormat(format);
	        }
	         
	        Cell cell = row.createCell(COLUMN_INDEX_ID);
	        cell.setCellValue(manList.getId());
	 
	        cell = row.createCell(COLUMN_INDEX_Name);
	        cell.setCellValue(manList.getName());
	 
	        cell = row.createCell(COLUMN_INDEX_salary);
	        cell.setCellValue(manList.getSalary());
	        cell.setCellStyle(cellStyleFormatNumber);
	 
	        cell = row.createCell(COLUMN_INDEX_Destination);
	        cell.setCellValue(manList.getDestination());
	         
	    	
	}
	

}
 