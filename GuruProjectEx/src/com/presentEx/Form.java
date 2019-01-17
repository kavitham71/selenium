package com.presentEx;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.openqa.selenium.*;		

public class Form {				
    public static void main(String[] args) {									
    	String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);

    	// declaration and instantiation of objects/variables		
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();					
        		
        String baseUrl = "http://demo.guru99.com/test/login.html";					
        driver.get(baseUrl);					

        // Get the WebElement corresponding to the Email Address(TextField)		
        WebElement email = driver.findElement(By.id("email"));							

        // Get the WebElement corresponding to the Password Field		
        WebElement pwd = driver.findElement(By.name("passwd"));							

        email.sendKeys("abc@gmail.com");					
        pwd.sendKeys("abcdefg");					
        System.out.println("Text Field Set");					
         
        // Deleting values in the text box		
        email.clear();			
        pwd.clear();			
        System.out.println("Text Field Cleared");					

        // Find the submit button		
        WebElement login = driver.findElement(By.id("SubmitLogin"));							
                    		
        // Using click method to submit form		
        email.sendKeys("abc@gmail.com");					
        pwd.sendKeys("abcdefg");					
        login.click();			
        System.out.println("Login Done with Click");					
        		
        //using submit method to submit the form. Submit used on password field		
        driver.get(baseUrl);					
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");							
        driver.findElement(By.name("passwd")).sendKeys("abcdefg");							
        driver.findElement(By.id("SubmitLogin")).submit();					
        System.out.println("Login Done with Submit");					
         
		//driver.close();		
        		
        driver.get("https://www.seleniumhq.org/download/");
        driver.findElement(By.cssSelector("a[title=\"Return to Selenium home page\"]")).click(); 
   		
    }		
}