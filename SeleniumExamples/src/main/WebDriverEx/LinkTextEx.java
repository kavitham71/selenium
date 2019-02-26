package com.presentEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTextEx {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
		String baseUrl = "http://demo.guru99.com/test/link.html";
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		driver.findElement(By.linkText("click here")).click();
		System.out.println("title of page is: " + driver.getTitle());

		// second Example: Using Partial linkText

		// driver.get(baseUrl);
		driver.navigate().back();
		driver.findElement(By.partialLinkText("here")).click();
		System.out.println("Title of page is: " + driver.getTitle());
		//driver.quit();

		// Link text Inside and outside block:

		String baseUrl2 = "http://demo.guru99.com/test/block.html";

		driver.get(baseUrl2);
		driver.findElement(By.partialLinkText("Inside")).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Outside")).click();
		System.out.println(driver.getTitle());
		driver.quit();

	}

}