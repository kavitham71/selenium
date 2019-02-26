package com.maintest;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.webdriver.WebDriverSetup;

//import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Test
public class FluentWaitEx {
	
	WebDriverSetup wbObject;
	@BeforeTest
	public void call() {
		wbObject = new WebDriverSetup();
		wbObject.setUp();
	}
	public void test() {

		String eTitle = "Demo Guru99 Page";
		String aTitle = "";
		wbObject.driver.get("http://demo.guru99.com/test/guru99home/");
		wbObject.driver.manage().window().maximize();
		aTitle = wbObject.driver.getTitle();
		 Assert.assertEquals(aTitle,eTitle);
		 System.out.println("Test Passed");
		 
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(wbObject.driver)							
					.withTimeout(30, TimeUnit.SECONDS) 			
					.pollingEvery(5, TimeUnit.SECONDS) 			
					.ignoring(NoSuchElementException.class);
			WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
			
				public WebElement apply(WebDriver driver ) {
					return driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div/h4/a"));
				}
			});
			//click on the selenium link
			clickseleniumlink.click();
		 
		// close browser
		wbObject.driver.close();

	}



}
