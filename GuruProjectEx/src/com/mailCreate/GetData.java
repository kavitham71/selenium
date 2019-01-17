package com.mailCreate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class GetData {
	static Properties prop = new Properties();

	public static void main(String[] args) {
		
		read();
		//write();
	}
	
	public static void read() {
		InputStream input;
		try {
			input = new FileInputStream("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/configFile/config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			CreateAccount.browser = prop.getProperty("browser");
			CreateAccount.chrome_driver_path = prop.getProperty("chrome_driver_path");
			CreateAccount.firefox_driver_path = prop.getProperty("firefox_driver_path");
			CreateAccount.projectpath = prop.getProperty("user_dir");
			CreateAccount.FirstName =prop.getProperty("FirstName");
			CreateAccount.LastName = prop.getProperty("LastName");
			CreateAccount.username = prop.getProperty("username");
			CreateAccount.password_xpath = prop.getProperty("password_xpath");
			CreateAccount.password = prop.getProperty("password");
			CreateAccount.confirmPassword_xpath = prop.getProperty("confirmPassword_xpath");
			CreateAccount.confirmPassword = prop.getProperty("confirmPassword");
			CreateAccount.click_Next_Button_Path = prop.getProperty("click_Next_Button_Path");
			CreateAccount.mobile_number_xpath = prop.getProperty("mobile_number_xpath");
			CreateAccount.mobile_number = prop.getProperty("mobile_number");
			CreateAccount.recover_Email_id = prop.getProperty("recover_Email_id_xpath");
			CreateAccount.recover_Email_id = prop.getProperty("recover_Email_id");
			FromEx.browser = prop.getProperty("browser");
			FromEx.projectpath = prop.getProperty("user_dir");
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void write() {
		OutputStream output;
		try {
			output = new FileOutputStream("/home/vedams/Kavitha/eclipse_projects2/selenium_ex/GuruProjectEx/lib/configFile/config.properties");
			System.out.println(prop.setProperty("ready", "value"));
			prop.store(output,null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
