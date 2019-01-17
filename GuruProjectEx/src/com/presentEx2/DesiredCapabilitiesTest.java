package com.presentEx2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		//it is used to define Chrome capability 
		/* DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 capabilities.setCapability(CapabilityType.BROWSER_NAME , "Chrome");
		 capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 capabilities.setCapability(CapabilityType.PLATFORM_NAME, "windows");
		 */
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 capabilities.setCapability("marionette", true);
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		System.setProperty("webdriver.gecko.driver",  projectPath +"/lib/Drivers/geckodriver/geckodriver");
		 driver = new FirefoxDriver(capabilities);
	//	 System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
		// driver = new ChromeDriver(capabilities);
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.get("http://gmail.com");
			 System.out.println("Successful completed");
			 System.out.println("browser name: " +capabilities.getBrowserName());
			 System.out.println("Version " +capabilities.getVersion());
			 System.out.println("platform " +capabilities.getPlatform());
			 System.out.println("capability name" +capabilities.getCapability(projectPath));
			 System.out.println("class"+capabilities.getClass());
			 
			 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 driver.close();
			 
	}

}










