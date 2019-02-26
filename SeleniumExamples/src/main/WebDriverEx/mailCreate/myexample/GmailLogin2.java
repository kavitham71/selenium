package com.myexample;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class GmailLogin2 {
	public static void main(String[] args)  {

		System.setProperty("webdriver.gecko.driver",
				"/home/username/eclipse_projects2/selenium_ex/GuruProjectEx/lib/Drivers/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("your mail-Id", Keys.ENTER);
		
		//driver.findElement(By.name("password")).sendKeys("PASSWORD",Keys.ENTER); --> Working
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement password = driver.findElement(By.className("whsOnd"));
		
		//WebElement password = driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("password");
		driver.findElement(By.id("passwordNext")).click();
		
		
		driver.close();
		
		
	}

}


