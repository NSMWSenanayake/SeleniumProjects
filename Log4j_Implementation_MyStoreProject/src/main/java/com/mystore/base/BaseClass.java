/**
 * 
 */
package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */
public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	//loadConfig method is to load the configuration
		@BeforeSuite
		public void loadConfig() {
			
			
			DOMConfigurator.configure("log4j.xml");
			

			try {
				prop = new Properties();
				System.out.println("Super constructor invoked");
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configurations\\config.properties");
				prop.load(ip);
				System.out.println("driver: "+ driver);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public void launchApp() {
			
			 String browserName = prop.getProperty("browser");
			 
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				// Set Browser to ThreadLocalMap
				driver=new ChromeDriver();
			} else if (browserName.contains("FireFox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
			}
			
			driver.manage().window().maximize();
			Action.implicitWait(driver,10);
			Action.pageLoadTimeOut(driver,30);
			driver.get(prop.getProperty("url"));
			
			
			
		}

}
