package com.generalExample;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.mailCreate.CreateAccount;
import com.mailCreate.FromEx;
import com.mailCreate.GetData;

public class EmiCalculator {
	
	public static WebDriver driver;
	public static String browser;
	public static String chromedriver_path;
	public static String firefoxdriver_path;
	public static String projectpath;
	static Properties prop = new Properties();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		read();
		setbrowserConfig();
		runTest();
		

	}
	
	public static void read() {
		InputStream input;
		try {
			input = new FileInputStream("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/configFile/generalConfig.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			browser = prop.getProperty("browser");
			chromedriver_path = prop.getProperty("chrome_driver_path");
			firefoxdriver_path = prop.getProperty("firefox_driver_path");
			projectpath = prop.getProperty("user_dir");
			

		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setbrowserConfig() {
		if(browser.contains("chrome")) {
			try {
				
				System.setProperty("webdriver.chrome.driver", projectpath+chromedriver_path);
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(browser.contains("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver", projectpath+firefoxdriver_path);
				driver = new FirefoxDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void runTest() throws InterruptedException {
		driver.get("https://emicalculator.net/");
		calculate();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
	private static void calculate() throws InterruptedException {
		// TODO Auto-generated method stub
		Actions actions = new Actions(driver);
		
		WebElement loadSliderCircle = driver.findElement(By.cssSelector("#loanamountslider >span"));
		WebElement interestSliderCircle = driver.findElement(By.cssSelector("#loaninterestslider >span"));
		WebElement tenureSliderCircle = driver.findElement(By.cssSelector("#loantermslider >span"));
		
		actions.dragAndDropBy(loadSliderCircle, 83, 0).build().perform();
		Thread.sleep(2000);
		actions.dragAndDropBy(interestSliderCircle, 88, 0).build().perform();
		Thread.sleep(2000);
		actions.dragAndDropBy(tenureSliderCircle, -111, 0).build().perform();
		Thread.sleep(2000);
		
		WebElement emiAmount = driver.findElement(By.cssSelector("#emiamount >p >span"));
		System.out.println(emiAmount.getText());

		
	}

}
