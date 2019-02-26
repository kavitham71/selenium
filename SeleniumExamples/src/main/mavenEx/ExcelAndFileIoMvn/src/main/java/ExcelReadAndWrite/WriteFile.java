package ExcelReadAndWrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WriteFile {
	File filename = null;
	FileInputStream input = null;
	Workbook wbook = null;
	Sheet sheetName = null;
	Row row = null;

	public void write(String filepath, String sheetname, String[] dataToWrite) {

		filename = new File(filepath);
		// System.out.println("File name: " + filename);

		try {
			input = new FileInputStream(filename);
			wbook = new HSSFWorkbook(input);
			// System.out.println("working upto here");
			sheetName = wbook.getSheet(sheetname);
			int rowCount = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
			System.out.println("Rowcount is : " + rowCount);

			row = sheetName.getRow(0);

			Row newRow = sheetName.createRow(rowCount + 1);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				Cell newcell = newRow.createCell(i);
				newcell.setCellValue(dataToWrite[i]);
			}
			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileOutputStream output = new FileOutputStream(filename);
			wbook.write(output);
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeCells() {
		// To display cell values
		for (int i = 6; i < sheetName.getLastRowNum(); i++) {
			Row row1 = sheetName.getRow(i);
			System.out.println(row1.getRowNum());
			for (int j = 0; j < row1.getLastCellNum(); j++) {
				// System.out.println(row.getCell(j).getCellComment());
				System.out.println(row1.getCell(j).getStringCellValue());
			}
		}
		// to remove cell values
		for (int i = 6; i < sheetName.getLastRowNum(); i++) {
			Row row1 = sheetName.getRow(i);
			for (int j = 0; j < row1.getLastCellNum(); j++) {
				// row1.getCell(j).removeCellComment();
				Cell c = row1.getCell(j);
				row1.removeCell(c);
			}
			
		}
		
	}

	public static void main(String[] args) {
		System.out.println("Starting point");

		WriteFile writeObject = new WriteFile();
		System.out.println("Creating object for class");
		String filepath = System.getProperty("user.dir") + "/src/main/java/ExcelReadAndWrite/exportfile1.xls";
		System.out.println("Getting filepath" + filepath);

		String[] valueToWrite = { "Mr k", "Vizag" };

		// writeObject.write(filepath, "sheet1Demo", valueToWrite);
		// writeObject.removeCells();
		

	}

}
