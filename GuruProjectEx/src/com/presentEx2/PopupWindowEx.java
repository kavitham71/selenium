package com.presentEx2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PopupWindowEx {

	public static void main(String[] args) {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 driver.get("http://demo.guru99.com/popup.php");			
	    // driver.manage().window().maximize();	
	     String MainWindow=driver.getWindowHandle();

	     driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
	     
	     // To handle all new opened window.				
         Set<String> string1=driver.getWindowHandles();		
         Iterator<String> iterator1=string1.iterator();	
         
         while(iterator1.hasNext())			
         {		
             String ChildWindow=iterator1.next();		
             		
             if(!MainWindow.equalsIgnoreCase(ChildWindow))			
             {    		
                  
                     // Switching to Child window
                     driver.switchTo().window(ChildWindow);	                                                                                                           
                     driver.findElement(By.name("emailid"))
                     .sendKeys("abc123@gmail.com");                			
                     
                     driver.findElement(By.name("btnLogin")).click();			
                                  
 			// Closing the Child Window.
                         driver.close();		
             }		
         }		
         // Switching to Parent window i.e Main Window.
             driver.switchTo().window(MainWindow);		

	}

}
