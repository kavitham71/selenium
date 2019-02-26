package parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ByDataprovider {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/V4/");
		
	}
	@Test(dataProvider="SearchProvider")
	public void testMethodA(String a, String value) {
		WebElement userName = driver.findElement(By.name("uid"));
		userName.sendKeys(a);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(value);
		WebElement login = driver.findElement(By.name("btnLogin"));
		login.click();
		WebElement text = driver.findElement(By.xpath("//table//tr[@class='heading3']"));
		
		 Assert.assertTrue(text.getText().toLowerCase().contains("manger id : mgr123"));
		
	}
	
	

}
