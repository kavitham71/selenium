package iTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterByITestContextInDataprovider {

WebDriver driver;
	
	@BeforeTest(groups={"A","B"})
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/hostname/eclipse_projects2/selenium_ex/FirstTestNGProject/lib/drivers/chromedriver/chromedriver");
		driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/V4/");
		
	}
	@Test(dataProvider="SearchProvider",groups="A")
	public void testMethodA(String a, String value) {
		WebElement userName = driver.findElement(By.name("uid"));
		userName.clear();
		userName.sendKeys(a);
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(value);
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
	
	/*@Test(dataProvider="SearchProvider",groups="B")
	public void testMethodB(String a, String value) {
		WebElement userName = driver.findElement(By.name("uid"));
		userName.clear();
		userName.sendKeys(a);
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys(value);
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
		
	}*/
	

	@DataProvider(name = "SearchProvider")
	public  Object[][] getDataFromDataprovider(ITestContext c) {
		Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
			System.out.println("Group name: "+group);
			
			if(group.equalsIgnoreCase("A")){
				groupArray = new Object[][] { 
					{ "mgr123", "mgr!23" }, { "b", "aa" }
					};
			break;	
			}
				else if(group.equalsIgnoreCase("B"))
				{
					groupArray = new Object[][] { { "mgr123", "mgr!23" }, { "d", "abc" }
						};
				}
			break;
		}
		return groupArray;		
		}
	


}








