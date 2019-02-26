package com.mailCreate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FromEx {
	public static WebDriver driver;
	public static String browser;
	public static String projectpath;

	public static void main(String[] args) {
		GetData.read();
		setbrowserConfig();
		runTest();
	}
	public static void setbrowserConfig() {
		if(browser.contains("chrome")) {
			try {
				
				System.setProperty("webdriver.chrome.driver", projectpath+"/lib/Drivers/chromedriver/chromedriver");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(browser.contains("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver", projectpath+"/lib/Drivers/geckodriver/geckodriver");
				driver = new FirefoxDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void runTest() {
		driver.navigate().to("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		addEntries();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	public static void addEntries() {
		driver.findElement(By.id("firstName")).sendKeys("");
		WebElement TxtContent = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/div/span"));
		TxtContent.getText(); 
		Object obj= new Object(); 
		obj=driver.findElement(By.id("firstName")); 
		System.out.println("obj value"+obj);
		  if(obj==null)
		  {
		   System.out.println(TxtContent);   //Comparing First Name Blank Field.
		  }
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 

}
