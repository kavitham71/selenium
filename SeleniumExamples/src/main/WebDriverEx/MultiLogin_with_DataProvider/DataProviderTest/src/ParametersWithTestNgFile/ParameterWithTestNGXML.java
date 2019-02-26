package ParametersWithTestNgFile;

import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterWithTestNGXML {
	
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://demo.guru99.com/V4/");
		
	}
	
	
    @Test
    @Parameters({"a","values"})
    public void testParameterWithXML( @Optional("Abc")String a1,String values2) throws InterruptedException{

    	 WebElement userName = driver.findElement(By.name("uid"));
 		userName.clear();
 		userName.sendKeys(a1);
 		WebElement password = driver.findElement(By.name("password"));
 		password.clear();
 		password.sendKeys(values2);
 		//WebElement login = driver.findElement(By.name("btnLogin"));
 		//login.click();
 		//WebElement text = driver.findElement(By.xpath("//table//tr[@class='heading3']"));
 		
 		 //Assert.assertTrue(text.getText().toLowerCase().contains("manger id : mgr123"));
 		try {
 			Thread.sleep(2000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		System.out.println("username: " + userName.getAttribute("value"));
 		System.out.println("Password : "+ password.getAttribute("value"));
 	

}
   
    }




	
