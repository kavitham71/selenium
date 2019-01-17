package firsttestng_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	public  WebDriver driver;
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "/home/vedams/Kavitha/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		String expectTitle = "Selenium - Web Browser Automation";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, expectTitle);
		driver.close();
	  
  }
}
