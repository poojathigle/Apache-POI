package exceloperations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	
	public static void writeExcel(List<Trigger> listTrigger, File filePath) throws IOException {
		
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Report");
	    int rowCount = 0;
	    
	    Row firstRow = sheet.createRow(rowCount);
	    writeColumnTitles(firstRow, sheet);	//function to set the header Row
	    for (Trigger aTrigger : listTrigger) {
	        Row row = sheet.createRow(++rowCount);
	        writeTrigger(aTrigger, row);
	    }
	    try {
	    	FileOutputStream outputStream = new FileOutputStream(filePath);
	    	//keep limit of i > number of columns
	    	for (int i=0; i<5; i++){
	    		   sheet.autoSizeColumn(i);   
	    		}
	        workbook.write(outputStream);
	    	//closing the Stream  
			outputStream.close();  
			//closing the workbook  
			workbook.close();
	    }
	    catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeColumnTitles(Row firstRow, Sheet sheet) {
		CellStyle style = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		font.setBold(true);
		style.setFont(font);
		
		Cell cell = firstRow.createCell(0);
		cell.setCellStyle(style);
		cell.setCellValue("ServerName");
		
		cell = firstRow.createCell(1);
		cell.setCellStyle(style);
		cell.setCellValue("TriggerName");
		
		cell = firstRow.createCell(2);
		cell.setCellStyle(style);
		cell.setCellValue("Comments by developer");
	}

	private static void writeTrigger(Trigger aTrigger, Row row) {
	    Cell cell = row.createCell(0);
	    cell.setCellValue(aTrigger.getServerName());
	 
	    cell = row.createCell(1);
	    cell.setCellValue(aTrigger.getTriggerName());
	 
	    cell = row.createCell(2);
	    cell.setCellValue(aTrigger.getComments());
	}

} //End of class WriteExcel

class Trigger {
	
	private String serverName;
    private String triggerName;
    private String comments;
 
    public Trigger() { 
    	  this.serverName = null;
          this.triggerName = null;
          this.comments = null;
    }
 
    public Trigger( String sname, String tName, String c) {
        this.serverName = sname;
        this.triggerName = tName;
        this.comments = c;
    }
    // getters and setters
    public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}// End of class Trigger
