package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class MainPage extends TestBase{
	
	@FindBy (xpath="//a[@href='https://ui.freecrm.com']")
	WebElement LoginBtn;
	
	@FindBy (xpath="//*[contains(@title, 'free crm home')]")
	WebElement CRMLogo;
	
	public MainPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCRMLogo() {
		return CRMLogo.isDisplayed();
	}
	
	public LoginPage clickOnLoginButton() {
		Assert.assertTrue(LoginBtn.isEnabled());
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		LoginBtn.click();
		return new LoginPage();
	}

}
