package date_time_pickerExample ;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DateTimePicker {
	
	 @Test

	    public void dateTimePicker(){

		 System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
			
	        WebDriver driver = new ChromeDriver();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        driver.get("http://demo.guru99.com/test/");

	        //Find the date time picker control

	        WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

	        //Fill date as mm/dd/yyyy as 09/25/2013

	        dateBox.sendKeys("09252013");

	        //Press tab to shift focus to time field

	        dateBox.sendKeys(Keys.TAB);

	        //Fill time as 02:45 PM

	        dateBox.sendKeys("0245PM");

	    }

}