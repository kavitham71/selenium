package com.gurupackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchToAlert {
	
	    public static void main(String[] args) {
			System.setProperty("webdriver.gecko.driver", "/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/Drivers/geckodriver/geckodriver");
	        WebDriver driver = new FirefoxDriver();
	        String alertMessage = "";

	        driver.get("http://jsbin.com/usidix/1");
	        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
	        alertMessage = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();
	       
	        System.out.println(alertMessage);
	        
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver.quit();
	       
	    }
	}


