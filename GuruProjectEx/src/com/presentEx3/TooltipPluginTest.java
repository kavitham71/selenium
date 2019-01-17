package com.presentEx3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TooltipPluginTest {

	public static void main(String[] args) {
		WebDriver driver;

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		System.setProperty("webdriver.firefox.marionette",  projectPath +"/lib/Drivers/geckodriver/geckodriver");
		driver = new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/test/tooltip.html");
		String expectTooltip = "What's new in 3.2";
		
		WebElement elmnt = driver.findElement(By.xpath(".//*[@id=\"download_now\"]"));
		
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(elmnt);
		builder.moveToElement(elmnt).build().perform();
		
		WebElement tooltip = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
		String actualtooltip = tooltip.getText();
		if(actualtooltip.equals(expectTooltip)) {
			System.out.println("Test passed in Plugin tooltips");
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
//.//*[@class='box']/div/a