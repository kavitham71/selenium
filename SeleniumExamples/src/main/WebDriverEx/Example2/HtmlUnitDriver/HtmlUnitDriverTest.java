
38 lines (23 sloc) 1 KB
package htmlUnitDriver;

import java.lang.reflect.Field;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

public class HtmlUnitDriverTest {

	public static void main(String[] args) throws Exception {

		//HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);

		HtmlUnitDriver driver = new HtmlUnitDriver();

		driver.get("http://seleniumhq.org");

		System.out.println("Title is:" + driver.getTitle());

		WebClient webClient = (WebClient)get(driver, "webClient");
		System.out.println("Browser verison: " + webClient.getBrowserVersion());
		System.out.println("Is Edge: " + webClient.getBrowserVersion().isEdge());
		System.out.println("Is Chrome: " + webClient.getBrowserVersion().isChrome());

		driver.quit();

	}

	public static Object get(Object object, String field) throws Exception {
		Field f = object.getClass().getDeclaredField(field);
		f.setAccessible(false);
		return f.get(object);
	}

}
