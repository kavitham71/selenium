package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.example2.SeleniumModulesEx;

public class PropertyEx {
    static Properties prop = new Properties();

	public static void main(String[] args) {
		readProperties();
		writeProperties();
	}
	public static void readProperties() {
		
		try {
			InputStream input = new FileInputStream("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/Example2/src/config/config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			SeleniumModulesEx.browser= prop.getProperty("browser");
			//System.out.println(SeleniumModulesEx.browser);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void writeProperties() {
		
		try {
		OutputStream output = new FileOutputStream("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/Example2/src/config/config.properties");
			prop.setProperty("browser","firefox");
			//prop.setProperty("result", "pass");
			prop.store(output, null);
			System.out.println(prop.getProperty("browser"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
