package com.day;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyEX {
	static Properties prop = new Properties();

	public static void main(String[] args) {
		read();
		write();
	}
	public static void read() {
		try {
			InputStream input = new FileInputStream("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/configFile/config.properties");
			prop.load(input);
			String i = prop.getProperty("browser");
			System.out.println(i);
			/*String projectPath = prop.getProperty("user.dir");
			System.out.println(projectPath);*/
			FindElementTest.browser= prop.getProperty("browser");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void write() {
		try {
			OutputStream output = new FileOutputStream("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/configFile/config.properties");
				prop.setProperty("browser","firefox");
				//prop.setProperty("result", "pass");
				prop.store(output, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
