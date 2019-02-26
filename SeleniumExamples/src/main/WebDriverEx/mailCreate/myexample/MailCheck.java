package com.myexample;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailCheck {

	public static WebDriver driver;
	//public static WebElement email;
	public static WebElement button;

	public static void main(String[] args) {
		start();
		mailIdCheck();
		clickEventMail();
		passwdCheck();
		clickEventPwd();
		// loginSuccessChk();
		logoutBtn();
		clickLogout();
	   // successLogoutChk();
		driver.close();
		
	}

	public static void start() {

		System.setProperty("webdriver.gecko.driver",
				"/home/hostname/eclipse_projects2/selenium_ex/GuruProjectEx/lib/Drivers/geckodriver/geckodriver");

		// TODO Auto-generated method stub
		// Initialize WebDriver
		driver = new FirefoxDriver();

		// Maximize Window
		driver.manage().window().maximize();

		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Navigate to Google webstites
		driver.get("https://www.gmail.com");
	}

	public static void mailIdCheck() {

		try {
			WebElement a1 = driver.findElement(By.xpath("//*[@id='identifierId']"));
			if(a1.isEnabled()) {
				System.out.println("---------Email exists -----------\n-------------");
				a1.sendKeys("your mail_id");
			}
		} catch (Throwable e) {
			System.out.println("EmaiId not found: " + e.getMessage());
		}
	}

	public static void clickEventMail() {
		driver.findElement(By.id("identifierNext")).click();
	}

	public static void clickEventPwd() {
		driver.findElement(By.id("passwordNext")).click();
	}

	public static void passwdCheck() {
		// Check whether Password field exists or not
		try {
			WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(password));
			password.sendKeys("your passowrd");
		} catch (NoSuchElementException e) {
			System.out.println("Password not found: " + e.getMessage());
		}
	}

	public static void loginSuccessChk() {
		// Check if login was proper or not
		try {
			WebElement GmailText = driver.findElement(By.xpath("//*[@id=':3b']"));
			String text = GmailText.getText();
			if (text.equals("Primary")) {
				System.out.println("----------Sucessfuln -------\n-----------------------");
			} else {
				System.out.println("----------Loginure ----------\n-----------------------");
			}
		} catch (Throwable e) {
			System.out.println("Inbox not found: " + e.getMessage());
		}
	}

	public static void logoutBtn() {
		// ===
		// Asserting and click on the Account link which contain Signout button.
		try {
			WebElement person = driver.findElement(By.xpath("//span[@class='gb_cb gbii']"));
			System.out.println("--------The Link Signout button exists ---------\n\n");
			person.click();
		} catch (Throwable e) {
			System.out.println("Link SignOut Button not found: " + e.getMessage());
		}
	}
	public static void clickLogout() {

		// Asserting and clicking on the Signout button.
		try {
			WebElement signout = driver.findElement(By.xpath("//*[@id='gb_71']"));
			System.out.println("--------LogOut button exists  ---------\n");
			signout.click();
		} catch (Throwable e) {
			System.out.println("LogOut button not found: " + e.getMessage());
		}
	}

	public static void successLogoutChk() {
		// Check whether Signout was proper or not.
		try {
			WebElement GmailText = driver.findElement(By.xpath("//divss = 'banner']/h1"));
			String text = GmailText.getText();
			if (text.equals("One account. All of Google.")) {
				System.out.println("----------Signwas successful -------");
			} else {
				System.out.println("----------Signwasn't successful ----------");
			}
		}

		catch (Throwable e) {
			System.out.println("Logout link not found: " + e.getMessage());
		}

	}
	
}
