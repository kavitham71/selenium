package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.simplepomex.Guru99HomePage;
import com.simplepomex.Guru99Login;

public class TestLoginWithSamplePom {

    WebDriver driver;

    Guru99Login objLogin;

    Guru99HomePage objHomePage;

    @BeforeTest

    public void setup(){
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");

    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct(){  //Create Login Page object

    objLogin = new Guru99Login(driver);

    String loginPageTitle = objLogin.getLoginTitle();  //Verify login page title
   

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    objLogin.loginToGuru99("mgr123", "mgr!23"); //login to application

    objHomePage = new Guru99HomePage(driver); // go the next page

    //Verify home page

    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }
    
}
