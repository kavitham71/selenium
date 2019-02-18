TEst cases for Selenium JAVA

**Selenium :**
- is a free (open source) automated testing suite for web applications.


**Features :**
 - Flexible and extensible
 - Multiple lang. Supported
 - Supports multiple browsers & platforms.

**Selenium Suite Of Tools (Components) :**
 - Selenium RC (depreciated) - Remote Control
 - Selenium IDE
 - Selenium Grid
 - Selenium WebDriver

**Prerequisites for selenium WebDriver :** 
 - Java  (must need JAV8 or higher For selenium-3)
   $ java -version
   $ javac -version
 - Eclipse
 - Selenium jar files 
    From http://www.seleniumhq.org/download/  → select Java download link.
    - For selenium jar files , download the following: 
      1) selenium-server-3.9.1.zip
      2) selenium-server-standalone-3.9.1.jar      
 - Browser based drivers
 
**Working with Drivers :** 
 - Download Chrome/Firefox Driver
 - Add Chrome/Firefox driver in Eclipse
 - Add to Script in Eclipse IDE.
   - For Chrome:
 - >   System.setProperty(“webdriver.chrome.driver ”, “ location of chrome driver”); 
 - >   Webdriver driver = new ChromeDriver();
   - For Firefox:
     System.setProperty(“webdriver.firefox.driver ”, “ location of firefox driver”);
     Webdriver driver = new FirefoxDriver();
 - Run And Validate.



