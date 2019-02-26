package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoA {
	@Test
	public void run() {
		
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");

		WebDriver driver = new ChromeDriver();
		Reporter.log("The browser is now open");;
		
		driver.get("https://www.google.com");
		Reporter.log("the google website is open now");
	    
		driver.findElement(By.name("q")).sendKeys("hello");
		Reporter.log("the Data entered now ");
	}

}
