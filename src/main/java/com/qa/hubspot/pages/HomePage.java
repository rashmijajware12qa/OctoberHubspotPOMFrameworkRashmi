package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.util.Constants;

public class HomePage extends BasePage {

	@FindBy(xpath="//span[@class='account-name ']")
	WebElement accountName;
	
	@FindBy(xpath = "//h1[text()='Marketing Dashboard']")
	WebElement homePageHeader;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(Constants.HOME_PAGE_TITLE));
		
		
		return driver.getTitle();
	}
	
	public String  getHomePageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homePageHeader));
		
		return homePageHeader.getText();
		
	}
	public String getLoggedInAccountName() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(accountName));
		return accountName.getText();
	}
}
