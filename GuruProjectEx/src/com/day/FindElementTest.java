package com.day;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementTest {
	
	public static WebDriver driver;
	public static String browser;

	public static void main(String[] args) {
		PropertyEX.read();
		setbrowserConfig();
		runTest();
		//PropertyEX.write();

	}
	
	public static void setbrowserConfig() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);

		if (browser.contains("chrome")) {
			try {
				System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
				driver = new ChromeDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (browser.contains("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver",  projectPath +"/lib/Drivers/geckodriver/geckodriver");
				driver = new FirefoxDriver();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void runTest() {
		driver.get("http://demo.guru99.com/test/ajax.html");
		findElement();
		findElements();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	public static void findElement() {
		WebElement elmnt = driver.findElement(By.name("name")); 
		System.out.println (elmnt.getAttribute("value"));

		
	}
	public static void findElements() {
		List<WebElement> elements= driver.findElements(By.name("name"));
		
		System.out.println("No.of Elements: "+elements.size());
		for (int i=0; i<elements.size();i++){
		      System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
		}
		
	}

}
