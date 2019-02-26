package com.presentEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class accessDropDown {
	
 public static void main(String[] args) { 
	 String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
	    String baseURL = "http://demo.guru99.com/test/newtours/register.php";
	    WebDriver driver = new ChromeDriver();	
		driver.get(baseURL);

		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("ANTARCTICA");

		//Selecting Items in a Multiple SELECT elements
		driver.get("http://jsbin.com/osebed/2");
		Select fruits = new Select(driver.findElement(By.id("fruits")));
		fruits.selectByVisibleText("Banana");
		fruits.selectByIndex(1);
 }
}