package com.presentEx3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TooltipTestEx {

	public static void main(String[] args) {
		WebDriver driver;

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.seleniumhq.org/");
		String expectTooltip = "Selenium Projects";
		
		WebElement elmnt = driver.findElement(By.xpath(".//div[@id='header']/ul/li[5]/a"));
		
		//getting actual value 'title' attribute of the icon
		String actualTooltip = elmnt.getAttribute("title");
		System.out.println("ActualTooltip value : "+ actualTooltip);
		
		if(actualTooltip.equals(expectTooltip)) {
			System.out.println("pass the test");
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();


	}

}
