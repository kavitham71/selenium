package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicExample {
	
	WebDriver driver;
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "/home/vedams/Kavitha/SeleniumExamples/Demo/drivers_path/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("http://www.edureka.co");
			search();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void search() {

	try {
		driver.findElement(By.id("search-inp")).sendKeys("Java");
		//Thread.sleep(3000);
		driver.findElement(By.className("typeahead__button")).click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		driver.close();
	}
	
}
	public static void main(String[] args) {
		
		BasicExample dayObj = new BasicExample();
		dayObj.invokeBrowser();
		

	}

}