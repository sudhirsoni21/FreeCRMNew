package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class LoginPageTest extends TestBase{
		MainPage mainPage;
		LoginPage loginPage;
		HomePage homePage;		
		
		public LoginPageTest() {
			super();
		}
		
	@BeforeMethod
	public void setup() {
		Initialization();
		mainPage = new MainPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage = mainPage.clickOnLoginButton();
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest() {
		String loginPageTitle = loginPage.getPageTitle();
		Assert.assertEquals(loginPageTitle, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void forgetPasswordLinkDisplayTest() {
		Assert.assertTrue(loginPage.forgetPasswordLinkDisplay());
	}
	
	@Test(priority=3)
	public void LoginToCRMTest() {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		System.out.println(username);
		System.out.println(password);
		homePage = loginPage.login(username, password);
		Assert.assertTrue(homePage.userNameLabelDisplay());;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}

