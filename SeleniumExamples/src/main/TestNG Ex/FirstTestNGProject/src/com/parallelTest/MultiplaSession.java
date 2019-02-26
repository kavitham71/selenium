package com.parallelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class MultiplaSession {

	 @Test    
	    public void executSessionOne(){
	            //First session of WebDriver
		  System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
	            WebDriver driver = new ChromeDriver();
	            //Goto guru99 site
	            driver.get("http://demo.guru99.com/V4/");
	            //find user name text box and fill it
	            driver.findElement(By.name("uid")).sendKeys("Driver 1");
	            
	        }
	        
	    @Test    
	        public void executeSessionTwo(){
	            //Second session of WebDriver
	  	  System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
	        WebDriver driver = new ChromeDriver();
	            //Goto guru99 site
	        driver.get("http://demo.guru99.com/V4/");
	        //find user name text box and fill it
	        driver.findElement(By.name("uid")).sendKeys("Driver 2");
	        
	        }
	        
	    @Test    
	        public void executSessionThree(){
	            //Third session of WebDriver
	  	  System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
	        WebDriver driver = new ChromeDriver();
	            //Goto guru99 site
	        driver.get("http://demo.guru99.com/V4/");
	        //find user name text box and fill it
	        driver.findElement(By.name("uid")).sendKeys("Driver 3");
	        
	        }   
}
