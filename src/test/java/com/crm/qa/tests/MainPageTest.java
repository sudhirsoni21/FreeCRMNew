package com.crm.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;

public class MainPageTest extends TestBase{
	
	MainPage mainPage;
	LoginPage loginPage;

	public MainPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		mainPage = new MainPage();
	}
	
	@Test(priority=1)
	public void VerifyPageTitleTest() {
		String sPageTitle = mainPage.getPageTitle();
		System.out.println(sPageTitle);
		Assert.assertEquals(sPageTitle, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=2)
	public void VerifyCRMLogoTest() {
		boolean logoPresent = mainPage.verifyCRMLogo();
		Assert.assertTrue(logoPresent);
	}
	
	@Test(priority=3)
	public void ClickOnLoginButtonTest() {
		loginPage = new LoginPage();
		loginPage = mainPage.clickOnLoginButton();
		Assert.assertTrue(loginPage.loginButtonDisplay());
	}
	
	@Test(priority=4)
	public void getCountOfLinksOnMainPage() {
		int noOfLinks;
		noOfLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Total Number of Links in Main Page are "+ noOfLinks);
	}
	
	@Test(priority=5)
	public void getTextForAllLinksOnMainPage() {
		int noOfLinks;
		List <WebElement> linkList =driver.findElements(By.tagName("a"));
		noOfLinks = linkList.size();
		System.out.println("Total Number of Links in Main Page are "+ noOfLinks);
		for (int i=0; i<noOfLinks; i++) {
			System.out.println(linkList.get(i).getText());
		}
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
