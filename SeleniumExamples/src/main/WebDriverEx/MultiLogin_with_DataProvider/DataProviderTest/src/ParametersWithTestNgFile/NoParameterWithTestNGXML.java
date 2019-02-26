package ParametersWithTestNgFile;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NoParameterWithTestNGXML {
	
	WebDriver driver;
    
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://demo.guru99.com/V4/");
		
	}
    @Test(testName="testGuru")
    public void testNoParameter() throws InterruptedException{
        String a = "guru99";
        String values = "india";
        
        /*driver.get("https://google.com");
        WebElement searchText = driver.findElement(By.name("q"));
        //Searching text in google text box
        searchText.sendKeys(searchKey);
        
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
                System.out.println("Thread will sleep now");
        
        Thread.sleep(3000);
        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
        //verifying the value in google search box
        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));*/
        
        WebElement userName = driver.findElement(By.name("uid"));
		userName.clear();
		userName.sendKeys(a);
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(values);
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
