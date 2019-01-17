package com.example2;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.PropertyEx;

public class SeleniumModulesEx {

	public static String browser;
	static WebDriver driver;

	/*public static void setBrowser(String browser2) {
		// browser = browser2;

	}*/

	public static void setbrowserConfig() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/lib/chromedriver/chromedriver");
			driver = new ChromeDriver();
		}
		if (browser.contains("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver", projectPath + "/lib/geckodriver/geckodriver");
				driver = new FirefoxDriver();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void runTest() {
		driver.get("http://seleniumhq.org");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	public static void main(String[] args) {
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter any browser name from chrome, firefox");
	//	String browser = sc.next();
		// SeleniumModulesEx obj = new SeleniumModulesEx();
		// obj.setBrowser(browser);
		// obj.setbrowserConfig();
		// obj.runTest();
		// setBrowser(browser);
*/		
		PropertyEx.readProperties();
		setbrowserConfig();
		runTest();
		PropertyEx.writeProperties();

	}

}
