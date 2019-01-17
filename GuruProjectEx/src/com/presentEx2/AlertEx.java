package com.presentEx2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertEx {
	
	public static void main(String[] args) {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("http://demo.guru99.com/test/delete_customer.php");	
		 driver.findElement(By.name("cusid")).sendKeys("abc123");	
		 driver.findElement(By.name("submit")).submit();
		 
		// Switching to Alert and need to import Alert class     
	        Alert alert = driver.switchTo().alert();
	        
	    // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();
	        System.out.println(alertMessage);   // Displaying alert message	
	        
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	        // Accepting alert		
	        alert.accept();		
		 
	        //driver.close();

	}

}
