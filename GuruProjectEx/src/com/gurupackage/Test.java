package com.gurupackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
		// declaration & instantiation of objects/variables
		System.setProperty("webdriver.gecko.driver", "/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/Drivers/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();// -> Driver Object Instantiation

		String baseUrl = "http://demo.guru99.com/test/newtours/";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";
		
		String tagName = "";//
		
		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();
		
		tagName = driver.findElement(By.name("userName")).getTagName();//
		System.out.println(tagName);
		
		//System.out.println(driver.getPageSource());//it will displays like html details
		
		System.out.println(driver.getCurrentUrl());// display URl of current page 

		driver.navigate().refresh(); 
		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		// close Fire fox
		driver.close();

	}

}
