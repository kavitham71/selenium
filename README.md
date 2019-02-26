# Selenium Demo 


# *Selenium Webdriver:*
   This Repository Contains Selenium basic Introduction and WebDriver Code Examples .
## **What is mean by Selenium ?** <br/>

    Selenium is a free (open source) automated testing suite for web applications.


## **What are Features ?**

 - Flexible and extensible
 - Multiple lang. Supported
 - Supports multiple browsers & platforms.

## **What are Selenium Suite Of Tools (Components) ?**

 - Selenium RC (depreciated) - Remote Control
 - Selenium IDE
 - Selenium Grid
 - Selenium WebDriver -->Now Working on it

## **What you need ?** 

 - Java  ( JAV8 or higher For selenium-3)
 
 - Eclipse
 - Selenium jar files 
   [Download selenium For java](http://www.seleniumhq.org/download/ )
    - For selenium jar files , download the following: 
      1) selenium-server-3.9.1.zip
      2) selenium-server-standalone-3.9.1.jar      
 - Browser based drivers (Firefox Driver, Google Chrome Driver)
 
## **How to Work with Drivers ?** 

 - Download Chrome/Firefox Driver
   - For Chrome:
      System.setProperty(“webdriver.chrome.driver ”, “ location of chrome driver”); <br/>
      Webdriver driver = new ChromeDriver();
   - For Firefox:
     System.setProperty(“webdriver.firefox.driver ”, “ location of firefox driver”); <br/>
     Webdriver driver = new FirefoxDriver();
## **Headless Browsers:**
   The browserws without a head or GUI are known as *_"Headless browsers"_* <br/>
   i.e  We can not see anything on screen, programs runs at backend only. the programs can accrs the web pages but do not show them to the user.
  #### **Ex:** PhantomJS, Html Unit Browser, trifleJS, SlimerJS, Zombie.js.


## **What are WebElements ?** <br/>
   Web Elements are used to interact with webpages.Web Element is a class . <br/>
   We can get it from  “org.openqa.selenium.*” Package. <br/>
   We can Instantiate Web Element Object as Folows:  <br/>
   ###### **WebElement myelement = driver.findElement(By.id(“username”));**  <br/>
   ###### **myelement.sendKeys(“Give a Username‘);**

   ### **Types of WebElements** <br/>
   1) FindElement
   2) FindElements
   
   #### **FindElement :**
   - FindElement used to identify a (one) web element uniquely. By using ID, Name, Class Name, Link Text, Partial Link Text, Tag Name and XPATH ,we can find WebElements.
   - The command returns the web element that matches the first most element within the web page.
   - Find Element command throws NoSuchElement exception if it does not find the element matching the criteria.<br/>
    Syntax: <br/>
       WebElement elmntName = driver.findElement(By.LocatorStrategy("LocatorValue")); <br/>

   Locator Value= is the unique value using which a web element can be identified.


   #### **FindElements command** <br/>
   - Find Elements command is used to uniquely identify the list of web elements within the web page. 
   - This command returns a list of web elements that match the criteria.
   - It takes By object as the parameter and returns a list of web elements. It returns an empty list if there are no elements found using the given locator strategy and locator value. <br/>
    Syntax: <br/>
     List<WebElement> elementName = driver.findElements(By.LocatorStrategy("LocatorValue"));


## Types of Waits?
- Implicit wait : Used to tell to  the WebDriver to wait for certain amount of time before it throws a "No Such Element Exception".  
- Explicit wait : Used to tell the WebDriver to wait for certain conditions (Expected Conditions) , before throwing an "ElementNotVisibleException" exception.It can be applied only for specified elements.

 

## Examples with:

  - Basic 
  - Mouse hover
  - Drag & Drop
  - Upload File
  - Roght& Double Click
  - Alert
  - Dynamic Table
  - Broken links
  - Drag & Drop
  - Draggable
  - Selectable
  - Actionable
  - multiple login and Others..


