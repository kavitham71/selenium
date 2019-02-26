package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class ReadWriteExcel {
	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook wbook;
	HSSFSheet sheet;
	HSSFCell cell;
	
	@BeforeTest
	public void TestSetUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://test2.bookingcommerce.com/en/member/login");
		wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void ReadData() throws Exception {
		File src = new File("/home/hostname/eclipse_projects2/selenium_ex/ExcelAndFileIoMvn/src/main/java/example/bookingFile.xls");
		
		FileInputStream input = new FileInputStream(src);
		wbook = new HSSFWorkbook(input);
		sheet = wbook.getSheetAt(0);
		
		for(int i=1; i<=sheet.getLastRowNum();i++) {
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(cell.CELL_TYPE_STRING);
			driver.findElement(By.xpath("/html/body/my-app/ng-component/div/div[2]/div/div/form/div[1]/input")).sendKeys(cell.getStringCellValue());
			
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(cell.CELL_TYPE_STRING);
			System.out.println(cell.getStringCellValue());
			driver.findElement(By.xpath("/html/body/my-app/ng-component/div/div[2]/div/div/form/div[2]/input")).sendKeys(cell.getStringCellValue());
			
			cell = sheet.getRow(i).getCell(6);
			System.out.println(cell.getStringCellValue());
			
		}
		
	}
	public void writeDate() throws Exception{
		File src = new File("/home/hostname/eclipse_projects2/selenium_ex/ExcelAndFileIoMvn/src/main/java/example/bookingFile.xls");
		FileInputStream input = new FileInputStream(src);
		wbook = new HSSFWorkbook(input);
		sheet = wbook.getSheetAt(0);
		for(int i=1; i<=sheet.getLastRowNum();i++) {
			
			FileOutputStream output = new FileOutputStream(src);
			System.out.println("Entering into this method");
			String msg = "Data IMportes Successfully";
			sheet.getRow(i).createCell(6).setCellValue(msg);
			FileOutputStream output1 = new FileOutputStream(src);

			wbook.write(output1);
			output1.close();
			driver.close();
			
		}

	}

}
