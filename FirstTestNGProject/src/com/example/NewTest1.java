package com.example;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;			
import org.testng.Assert;			
import org.testng.annotations.Test;		

public class NewTest1 {
  
 
	  WebDriver driver;			

	    // Method 1: Open Brower say Firefox			
	    @Test (priority=1)			
	    public void openBrowser() {			
	  	  System.setProperty("webdriver.chrome.driver", "/home/vedams/Kavitha/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
	        driver = new ChromeDriver();				
	    }		

	    // Method 2: Launch Google.com			
	    @Test (priority=2)			
	    public void launchGoogle() {				
	        driver.get("https://www.google.com/");						
	    }		
      
	    // Method 3: Perform a search using "Gmail"			
	    @Test (priority=3)			
	    public void peformSearchAndClick1stLink() {				
	        driver.findElement(By.xpath(".//input[@title='Search']")).sendKeys("Gmail", Keys.ENTER);								
	    }		

	    // Method 4: Verify Google search page title.			
	    @Test (priority=4)			
	    public void GmailPageTitleVerification() throws Exception {		
	    	
	       // driver.findElement(By.xpath(".//*[@value='gmail']")).click();						
	        Thread.sleep(3000);		
	        Assert.assertEquals(driver.getTitle().contains("Gmail - Google Search"), true);				
	    }	
  }

	

	