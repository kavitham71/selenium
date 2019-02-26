package com.presentEx2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesEx2 {

	public static void main(String[] args) {
		WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver",  projectPath +"/lib/Drivers/geckodriver/geckodriver");
		FirefoxOptions options = new FirefoxOptions(capabilities);
		options.setCapability(CapabilityType.PLATFORM_NAME, "windows");
		//options.get("http://gmail.com");
		
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
		


	}

}
