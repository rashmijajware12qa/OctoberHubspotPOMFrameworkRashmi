package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage; 
	public HomePage homePage;
	

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		basepage = new BasePage();
		driver = basepage.init_driver(browser);
		prop = basepage.init_properties();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		System.out.println("before chk");
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title is: "+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyHomePageHeader() {
		String header = homePage.getHomePageHeader();
		System.out.println("Home page header is: " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	@Test(priority=3)
	public void verifyCorrectLoggedInAccountNameTest() {
		String accountName=homePage.getLoggedInAccountName();
		System.out.println("Logged in Account Name is:  "+accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
	}
	
	

}
