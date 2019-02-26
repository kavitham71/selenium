package com.myexample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver",
				"/home/hostname/eclipse_projects2/selenium_ex/GuruProjectEx/lib/Drivers/geckodriver/geckodriver");
		WebDriver driver = new FirefoxDriver();

		String baseUrl = "http://gmail.com";
		String expectedTitle = "Gmail";
		String actualTitle = "";
		String tagName = "";

		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		// tagName = driver.findElement(By.name("identifier")).getTagName();//

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input#identifierId")).sendKeys("mail-Id@gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("identifierNext")).click(); 

		// driver.findElement(By.xpath("//div[@class=\"Xb9hP\"]")).sendKeys("your password");

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("password");

		driver.findElement(By.id("passwordNext")).click();

	
		
		System.out.println(tagName);

		System.out.println(driver.getCurrentUrl());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();

	}

}
