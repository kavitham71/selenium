package com.gurupackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class example {

	public static void main(String[] args) {
		
		/*System.setProperty("webdriver.gecko.driver", "/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/Drivers/geckodriver/geckodriver");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.popuptest.com/popuptest2.html");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.close();
		driver.quit();*/
		System.setProperty("webdriver.gecko.driver", "/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/Drivers/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Deprecated")).click();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.close(); 

	}

}
