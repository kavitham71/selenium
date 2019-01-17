package com.presentEx;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.annotations.VisibleForTesting;

public class XpathEx {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/lib/Drivers/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();		
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String baseUrl = "http://demo.guru99.com/v1/";					
        driver.get(baseUrl);
        
      /* WebElement email = driver.findElement(By.xpath("//input[@name='uid']"));
       email.click();
       email.sendKeys("hello@gmail.com");
       */
      
        // Ex1 for Not visible options
       
       /*   WebElement visible = driver.findElement(By.xpath("//label[@id='message18']"));
        System.out.println(visible.getTagName());
        */
       
       // Ex2. For Reset Option after Entering something
       
      /* WebElement reset = driver.findElement(By.xpath("//input[@name='btnReset']"));
       reset.click();
     */
       
       // Ex3. About Contains()
       
        /*WebElement submit = driver.findElement(By.xpath("//*[contains(@type,'sub')]"));
           submit.click();
           
           WebElement Password = driver.findElement(By.xpath("//*[contains(text(),'Password')]"));
		   System.out.println(Password.getText());
		    
		    
        WebElement linktext = driver.findElement(By.xpath("//*[contains(text(),'here')]"));
        linktext.click();
        
		           
           */
       
       

    
        //Ex4 . Contains again for hidden message
       List<WebElement> elements= driver.findElements(By.xpath("//*[contains(@id,'message')]"));
		
		System.out.println("No.of Elements: "+elements.size());
		for (int i=0; i<elements.size();i++){
		      System.out.println(" id value:" + elements.get(i).getAttribute("id"));
		      System.out.println(" text:" + elements.get(i).getText());

		}
		// Ex5. For and Condition 
        /* 
        WebElement Condition = driver.findElement(By.xpath("//input[@type='submit' and @name='btnLogin']"));
        Condition.click();

        // Ex6. For or Condtion Using Xpath
        WebElement Condition = driver.findElement(By.xpath("//input[@type='submit' or @name='btnReset']"));
        Condition.click();
         */
       // Ex7. For startwith() function
/*List<WebElement> et= driver.findElements(By.xpath("//label[starts-with(@id,'message')]"));
		
		System.out.println("No.of Elements: "+et.size());
		for (int i=0; i<et.size();i++){
		      System.out.println(" id value:" + et.get(i).getAttribute("id"));
		      System.out.println(" text:" + et.get(i).getText());

		}*/
		
		//Ex8. For Text() only with exact Text match
		
		WebElement visible = driver.findElement(By.xpath("//td[text()='UserID']"));
        System.out.println(visible.getTagName());
		
        // Ex9. xpath function : Following
 List<WebElement> follow1= driver.findElements(By.xpath("//*[@type='text']//following::input[1]"));
		
		System.out.println("No.of Elements for following: "+follow1.size());
		
		//Ex10. For child: 
		
List<WebElement> a1= driver.findElements(By.xpath("//*[@class='barone']/child::span"));
		
		System.out.println("No.of Elements for child: "+a1.size());
		
		// Ex11. For Preceeding
		
List<WebElement> p1= driver.findElements(By.xpath("//*[@type='submit']//preceding::input"));
		
		System.out.println("No.of Elements for preceeding: "+p1.size());
		for (int i=0; i<p1.size();i++){
		      System.out.println(" Preceeding name value:" + p1.get(i).getAttribute("name"));
		}
		
		// Ex 12. for Sibling
		
List<WebElement> s1= driver.findElements(By.xpath("//*[@type='submit']//following-sibling::input"));
		
		System.out.println("No.of Elements for Sibling: "+s1.size());
		for (int i=0; i<s1.size();i++){
		      System.out.println(" Sibling type value:" + s1.get(i).getAttribute("type"));
		}
		
		//Ex13. For Self
		WebElement self = driver.findElement(By.xpath("//*[@type='password']//self::input"));
		System.out.println(" Self name value: " + self.getAttribute("name"));
		
		//Ex14. For Parent
		
List<WebElement> parent1= driver.findElements(By.xpath("//*[@type='text']//parent::td"));
		
		System.out.println("No.of Elements for parent: "+parent1.size());
		for (int i=0; i<parent1.size();i++){
		      System.out.println(" parent type value:" + parent1.get(i).getAttribute("align"));
		}
		
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 driver.close(); 
	}
}

//Xpath=//*[@id='rt-feature']//parent::div
