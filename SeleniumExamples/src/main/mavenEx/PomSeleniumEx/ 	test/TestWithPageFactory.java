
47 lines (29 sloc) 1.23 KB
package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFactoryEx.Guru99HomePage;
import PageFactoryEx.Guru99Login;

public class TestWithPageFactory {
	WebDriver driver;
	Guru99Login loginObject;
	Guru99HomePage homepageObject;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/V4/");
		
	}
	
	@Test(priority=0)

    public void test_Home_Page_Appear_Correct(){  

		loginObject = new Guru99Login(driver);  //Create Login Page object

    String loginPageTitle = loginObject.getLoginTitle();  
   

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));//Verify login page title

    loginObject.login("mgr123", "mgr!23"); //login to application

    homepageObject = new Guru99HomePage(driver); // go the next page

    //Verify home page

    Assert.assertTrue(homepageObject.GetUserName().toLowerCase().contains("manger id : mgr123"));

    }

}
