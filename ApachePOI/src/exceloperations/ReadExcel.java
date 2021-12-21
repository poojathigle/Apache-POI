package exceloperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	private static Workbook getWorkBook(FileInputStream file, String File_Name) throws IOException {
		
		Workbook workBook = null;
		if(File_Name.endsWith("xlsx"))
			workBook = new XSSFWorkbook(file);
		else if(File_Name.endsWith("xls"))	
			workBook = new HSSFWorkbook(file);
		else throw new IllegalArgumentException("Not an Excel file !");
		return workBook;
	}

	public static String [][] getArray(String File_Name) throws Exception {
		String [][] table = null;
		try {
			FileInputStream file = new FileInputStream(new File(File_Name));
			Workbook workbook = getWorkBook(file, String.valueOf(File_Name));
		    workbook.setMissingCellPolicy(Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			Sheet sheet = workbook.getSheetAt(0);	//read first sheet in the Spreadsheet
			// if the file has more than one sheets
			//	use while(sheets.hasNext()) { }
		
			int NumberOfRows = sheet.getLastRowNum()+1;
			int NumberOfColumns = sheet.getRow(0).getLastCellNum();
			table = new String[NumberOfRows][NumberOfColumns];
			//System.out.println(NumberOfRows+" "+NumberOfColumns);

			for (int rowNum = 0; rowNum <= NumberOfRows; rowNum++) {
			   Row row = sheet.getRow(rowNum);
			   if (row == null) {
			      // This whole row is empty
			      continue;
			   }
			   int lastColumn = row.getLastCellNum();
			   for (int colNum = 0; colNum < lastColumn; colNum++) {
			      Cell cell = row.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
			      table[rowNum][colNum] = String.valueOf(cell);
			   }
			}
			workbook.close();
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return table;
	}
	
	public static void Print2DArray(String[][]array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if (String.valueOf(array[i][j]).equalsIgnoreCase("null")) {
			         // The spreadsheet is empty in this cell
					System.out.print("     \t");
			      } else {
			    	  System.out.print(array[i][j]+"\t");
			      }
			}
			System.out.println();
		}
	}

}
