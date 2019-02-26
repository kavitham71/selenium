

package PageFactoryEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Guru99Login {
	WebDriver driver;

	@FindBy(name = "uid")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(className = "barone")
	WebElement titleText;

	@FindBy(name = "btnLogin")
	WebElement login;

	public Guru99Login(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);

	}

	public void setUser(String username) {
		userName.sendKeys(username);

	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);

	}

	public void clickLogin() {
		login.click();

	}
	
	public String getLoginTitle() {
		return titleText.getText();
	}
	
	public void login(String username, String pwd) {
		this.setUser(username);
		this.setPassword(pwd);
		this.clickLogin();
		
	}

}
