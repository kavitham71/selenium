package mailMultiLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import parameterTypeINDataprovider.DataproviderClass;


public class Login {

 WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
	}
	@Test(dataProvider="SearchProvider",dataProviderClass=DataproviderClass.class)
	public void login(String a, String values) {
		WebElement userMail = driver.findElement(By.id("identifierId"));
		userMail.clear();
		userMail.sendKeys(a,Keys.ENTER);
		
		WebElement password = driver.findElement(By.name("password"));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.elementToBeClickable(password));
		password.clear();
		password.sendKeys(values,Keys.ALT);
		

		System.out.println("username: " + userMail.getAttribute("value"));
		System.out.println("Password : "+ password.getAttribute("value"));
		
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		
		driver.findElement(By.xpath("//span[@class=\"gb_cb gbii\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
		
	}

}



	


