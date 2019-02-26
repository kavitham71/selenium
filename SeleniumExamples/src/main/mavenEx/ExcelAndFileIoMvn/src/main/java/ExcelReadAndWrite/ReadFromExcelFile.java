package ExcelReadAndWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadFromExcelFile {
	
	public void readExcel(String filepath, String sheetname) {
		
		FileInputStream input = null;
		Workbook wbook = null;
		File file = new File(filepath);
		try {
			input = new FileInputStream(file); // FileNotFoundExecption
			wbook = new HSSFWorkbook(input); //IoException
			System.out.println("sending input to the HSSFWorkbook");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheetfile = wbook.getSheet(sheetname);
		System.out.println("reading sheet from workbook i.e excel fiel");
		
		System.out.println("finding no.of rows");
		int rowCount = sheetfile.getLastRowNum() - sheetfile.getFirstRowNum();
		System.out.println("Rowcount is : "+ rowCount);
		System.out.println("No.of rows: "+sheetfile.getPhysicalNumberOfRows());
		System.out.println("No.of Coloumns: "+sheetfile.getRow(0).getLastCellNum());

		System.out.println("print cell values:"+"\n");
		for(int i=0; i < rowCount+1; i++) {
			Row row = sheetfile.getRow(i);
			for(int j=0; j<row.getLastCellNum();j++) {
				System.out.print(row.getCell(j).getStringCellValue()+" || ");
				
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		ReadFromExcelFile object = new ReadFromExcelFile();
		System.out.println(System.getProperty("user.dir"));
		String path =  System.getProperty("user.dir")+"/src/main/java/ExcelReadAndWrite/exportfile1.xls";
		object.readExcel(path, "sheet1Demo");
		
	}

}
