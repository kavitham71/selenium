package com.presentEx;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseKeyboardEvents {
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");

		WebDriver driver = new ChromeDriver();

		
		 driver.get(baseUrl);
		 WebElement link_Home = driver.findElement(By.linkText("Hotels"));
		 WebElement td_Home =
		  driver.findElement(By.xpath("//html/body/div" + "/table/tbody/tr/td" +
		 "/table/tbody/tr/td" + "/table/tbody/tr/td" + "/table/tbody/tr"));
		  
		  Actions builder = new Actions(driver); 
		  Action mouseOverHome = builder.moveToElement(link_Home).build();
		 
		  String bgColor = td_Home.getCssValue("background-color");
		  System.out.println("Before hover: " + bgColor);
		  mouseOverHome.perform();
		  bgColor = td_Home.getCssValue("background-color");
		  System.out.println("After hover: " + bgColor); 
		  driver.close();
		 
		
	}

}
