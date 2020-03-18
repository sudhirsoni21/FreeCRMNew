package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="email")
	WebElement emailAddressTxt;
	
	@FindBy(name="password")
	WebElement passwordTxt;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgetPasswordLink;
	
	//@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean forgetPasswordLinkDisplay() {
		return forgetPasswordLink.isDisplayed();
	}
	
	public boolean loginButtonDisplay() {
		return loginBtn.isDisplayed();
	}
	
	public HomePage login(String emailAddress, String password) {
		emailAddressTxt.sendKeys(emailAddress);
		passwordTxt.sendKeys(password);
		Assert.assertTrue(loginBtn.isEnabled());
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginBtn.click();
		return new HomePage();		
	}
	
	
		

}
