package com.maintest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webdriver.*;

@Test
public class MainTest {
	WebDriverSetup wbObject;

	@BeforeTest
	public void call() {
		wbObject = new WebDriverSetup();
		wbObject.setUp();
	}

	public void test() {

		String eTitle = "Demo Guru99 Page";
		String aTitle = "";
		// launch Chrome and redirect it to the Base URL
		wbObject.driver.get("http://demo.guru99.com/test/guru99home/");
		// Maximizes the browser window
		wbObject.driver.manage().window().maximize();
		// get the actual value of the title
		aTitle = wbObject.driver.getTitle();
		// compare the actual title with the expected title
		/*if (aTitle.equals(eTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}*/
		 Assert.assertEquals(aTitle,eTitle);
		 System.out.println("Test Passed");
		 
		// close browser
		wbObject.driver.close();

	}

}
