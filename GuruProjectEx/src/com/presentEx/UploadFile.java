package com.presentEx;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFile {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);


		System.setProperty("webdriver.gecko.driver", projectPath + "/lib/Drivers/geckodriver/geckodriver");
		String baseUrl = "http://demo.guru99.com/test/upload/";
		WebDriver driver = new FirefoxDriver();

		driver.get(baseUrl);
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

		// enter the file path onto the file-selection input field
		uploadElement.sendKeys("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/exampleFiles/ex.html");

		// check the "I accept the terms of service" check box
		driver.findElement(By.id("terms")).click();

		// click the "UploadFile" button
		driver.findElement(By.name("send")).click();
		/*WebElement login = driver.findElement(By.id("submitbutton"));
		login.submit();*/
		System.out.println("Successfully uploaded");
		driver.close();

	}

}
