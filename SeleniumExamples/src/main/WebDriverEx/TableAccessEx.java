package com.presentEx2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAccessEx {

	public static void main(String[] args) {
		
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 driver.get("file:///home/hostname/eclipse_projects2/selenium_ex/GuruProjectEx/lib/exampleFiles/tableaccess.html");
         // By predicating 
		 String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText(); 	
			        System.out.println(innerText); 
				//driver.close();
		
		// for Nested Table Access
	     driver.get("file:///home/hostname/eclipse_projects2/selenium_ex/GuruProjectEx/lib/exampleFiles/tableAccess2.html");
		 String innerText2 = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText(); 	
	     System.out.println(innerText2); 
			
	     // Using attributes as Predicates
	     driver.get("http://demo.guru99.com/test/newtours/");
	     String innerText3 = driver.findElement(By
	    			.xpath("//table[@width=\"270\"]/tbody/tr[4]/td"))
	    			.getText(); 		
	    		System.out.println(innerText3); 
				
				
	}

}


