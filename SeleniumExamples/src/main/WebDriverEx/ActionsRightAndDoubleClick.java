package com.presentEx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
@Test
public class ActionsRightAndDoubleClick {
	
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/home/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	}
	
	public void runTest() {
		
		Actions action = new Actions(driver);
		WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
		action.contextClick(link).perform();
		WebElement element = driver.findElement(By.cssSelector(".context-menu-icon-edit"));
		element.click();
		
		//Alert alert = driver.switchTo().alert();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();
		
	}
}
