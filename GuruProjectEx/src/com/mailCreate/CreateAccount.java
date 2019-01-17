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

public class CreateAccount {
	public static WebDriver driver;
	public static String browser;
	public static String chrome_driver_path;
	public static String firefox_driver_path;
	public static String projectpath;
	public static String FirstName;
	public static String LastName;
	public static String username;
	public static String password;
	public static String confirmPassword;
	public static String mobile_number;
	public static String recover_Email_id;
	public static String password_xpath;
	public static String confirmPassword_xpath;
	public static String mobile_number_xpath;
	public static String click_Next_Button_Path;
	public static String recover_Email_id_xpath;
	
	public static void main(String[] args) {
		GetData.read();
		setbrowserConfig();
		runTest();
		
	}
	
	public static void setbrowserConfig() {
		if(browser.contains("chrome")) {
			try {
				
				System.setProperty("webdriver.chrome.driver", projectpath+chrome_driver_path);
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(browser.contains("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver", projectpath+firefox_driver_path);
				driver = new FirefoxDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void runTest() {
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
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
		driver.findElement(By.id("firstName")).sendKeys(FirstName, Keys.ALT);
		driver.findElement(By.id("lastName")).sendKeys(LastName,Keys.ALT);
		driver.findElement(By.id("username")).sendKeys(username, Keys.ALT);
		
		WebElement pwd = driver.findElement(By.xpath(password_xpath));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(pwd));
		pwd.sendKeys(password,Keys.ALT);
		
		WebElement cnfpwd = driver.findElement(By.xpath(confirmPassword_xpath));
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(cnfpwd));
		cnfpwd.sendKeys(confirmPassword,Keys.ALT);
		
		driver.findElement(By.xpath(click_Next_Button_Path)).click();
		
		WebElement mblno = driver.findElement(By.xpath(mobile_number_xpath));
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.elementToBeClickable(mblno));
		//mblno.sendKeys(mobile_number,Keys.ALT);
		
		driver.findElement(By.xpath(click_Next_Button_Path)).click();
		driver.findElement(By.xpath(recover_Email_id_xpath)).sendKeys(recover_Email_id, Keys.ALT);
		
		/*WebElement fname= driver.findElement(By.id("firstName"));
		fname.sendKeys("Kavitha");
		WebElement lname= driver.findElement(By.id("lastName"));
		lname.sendKeys("m");
		WebElement uname= driver.findElement(By.id("username"));
		uname.sendKeys("kavim");*/
	} //RveJvd snByac

}
