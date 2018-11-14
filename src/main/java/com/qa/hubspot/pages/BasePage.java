package com.qa.hubspot.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.util.Constants;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String browser) {
		if(browser.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vibhas\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vibhas\\Downloads\\geckodriver-v0.23.0-win64\\geckodriver.exe");
	        driver= new FirefoxDriver();
	        
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		
		return driver;
	}
	
  public Properties init_properties() {
	  
	  prop=new Properties();
	  try {
		FileInputStream ip=new  FileInputStream("C:\\Users\\vibhas\\eclipse-workspace\\kumarirashmi_pom\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
	    prop.load(ip);
	  
	  } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return prop;
	  
	  
	  
  }
}
