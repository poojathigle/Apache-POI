package exceloperations;

import java.io.File;
import java.util.List;

public class mainClass {
	//path to input file 
	private static final String File_Path = "E:/JavaPractice/ApachePOI/data/inputFile.xlsx";
	//path of output file
	private static final File fileName = new File("E:/JavaPractice/ApachePOI/data/outputFile.xlsx");

	public static void main(String[] args) {
		// Read Excel
		try {
			String [][] table = ReadExcel.getArray(File_Path);
			ReadExcel.Print2DArray(table);
		
		//Write Excel
			List<Trigger> listOfTriggers = ExampleTriggers.getListOfTriggers();
			WriteExcel.writeExcel(listOfTriggers, fileName);
			System.out.println("\nExcel file generated successfully!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
