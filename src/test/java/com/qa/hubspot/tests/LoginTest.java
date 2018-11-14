package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginTest {
	public BasePage basepage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage; 
	

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		basepage = new BasePage();
		driver = basepage.init_driver(browser);
		prop = basepage.init_properties();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		
		System.out.println("before chk");
	}
	
	@Test(priority=1)
	public void verifyLogibPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
	    System.out.println("login page title is " +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	
	}
	
	@Test(priority=2)
	public void verifyForgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.verifyForgotMyPasswordLink());
	}
	
	@Test(priority=3)
	public void loginTest() {
    loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink());
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	
	}
	
	
	
	
}
