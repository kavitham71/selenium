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

public class WriteIntoExcelFile {
	File filename = null;
	FileInputStream input = null;
	Workbook wbook = null;
	Sheet sheetName = null;
	Row row = null;

	public void write(String filepath, String sheetname, String[] dataToWrite) {

		filename = new File(filepath);
		try {
			input = new FileInputStream(filename);
			wbook = new HSSFWorkbook(input);
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
			FileOutputStream output = new FileOutputStream(filename);
			wbook.write(output);
			output.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	}

	public void removeCells() {
		/*for (int i = 6; i < sheetName.getLastRowNum(); i++) {
			Row row1 = sheetName.getRow(i);
			System.out.println(row1.getRowNum());
			for (int j = 0; j < row1.getLastCellNum(); j++) {
				System.out.println(row1.getCell(j).getStringCellValue());
			}
		}*/
		// to remove cell values
		for (int i = 6; i < sheetName.getLastRowNum(); i++) {
			Row row1 = sheetName.getRow(i);
			/*for (int j = 0; j < row1.getLastCellNum(); j++) {
				Cell c = row1.getCell(j);
				row1.removeCell(c);
			}*/
			sheetName.removeRow(row1);
		}
	}
	public void writeIntoExistedRow(String filepath, String sheetname, String[] dataToWrite) {
		
		filename = new File(filepath);
		
		try {
			input = new FileInputStream(filename);
			wbook = new HSSFWorkbook(input);
			// System.out.println("working upto here");
			sheetName = wbook.getSheet(sheetname);
			int rowCount = sheetName.getLastRowNum() - sheetName.getFirstRowNum();
			System.out.println("Rowcount is : " + rowCount);

			row = sheetName.getRow(0);

			for (int i = 0; i <=sheetName.getLastRowNum()-1; i++) {
				
				Row row1;
				try {
					row1 = sheetName.getRow(i);
					
					//System.out.println(row1.getRowNum());
					if(row1!=null) {

						for (int j = 0; j < row1.getLastCellNum(); j++) {
							// System.out.println(row.getCell(j).getCellComment());
							System.out.println(row1.getCell(j).getStringCellValue());
							//if(row1.getCell(j)==null& row1.getCell(j+1)==null)
							/*if(row1.getCell(j).getStringCellValue().isEmpty()) {
								System.out.println("Coming here");
								 Cell new1= row1.createCell(j);
								
								//Cell new1=row1.getCell(j);
								new1.setCellValue(dataToWrite[j]);
							}*/
						}
					}
					if(row1==null){
						
								System.out.println("Coming here");
								Row newRow1 = sheetName.createRow(i);
								 

								for (int j = 0; j < row.getLastCellNum(); j++) {
									
									Cell new1= newRow1.createCell(j);
									System.out.println("Coming here2");

									//Cell new1=row1.getCell(j);
									new1.setCellValue(dataToWrite[j]);
								}

						}
						
					}
					
					
				 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*	
				for (int j = 0; j < row1.getLastCellNum(); j++) {
					// System.out.println(row.getCell(j).getCellComment());
					System.out.println(row1.getCell(j).getStringCellValue());
					//if(row1.getCell(j)==null& row1.getCell(j+1)==null)
					if(row1.getCell(j).getStringCellValue().isEmpty()) {
						System.out.println("Coming here");
						 Cell new1= row1.createCell(j);
						
						//Cell new1=row1.getCell(j);
						new1.setCellValue(dataToWrite[j]);
					}
				}*/
				
				
			}
			input.close();
			FileOutputStream output = new FileOutputStream(filename);
			wbook.write(output);
			output.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Starting point");

		WriteIntoExcelFile writeObject = new WriteIntoExcelFile();
		System.out.println("Creating object for class");
		String filepath = System.getProperty("user.dir") + "/src/main/java/ExcelReadAndWrite/exportfile1.xls";
		System.out.println("Getting filepath" + filepath);

		String[] valueToWrite = { "Mr k", "Vizag" };
		
		//writeObject.write(filepath, "sheet1Demo", valueToWrite);
		writeObject.removeCells();
		//writeObject.writeIntoExistedRow(filepath, "sheet1Demo", valueToWrite);

	}

}
