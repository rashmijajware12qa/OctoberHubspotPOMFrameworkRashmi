package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	//1 define pagefactory(page element)
	
	@FindBy(id="username")
	WebElement loginName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"hs-login\"]/div[1]/a/i18n-string")
	WebElement signUpLink;
	
	@FindBy(xpath = "//*[@id=\"password-description\"]/a/i18n-string")
	WebElement forgotMyPwdLink;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean verifyForgotMyPasswordLink() {
		return forgotMyPwdLink.isDisplayed();
		
	}
	public boolean verifySignUpLink() {
		return signUpLink.isDisplayed();
		
	}
	
	public HomePage doLogin(String username, String pwd) {
		loginName.sendKeys(username);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
		
	}

}
