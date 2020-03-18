package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.testUtil.TestUtil;

public class HomePageTest extends TestBase {
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public HomePageTest()  {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		mainPage = new MainPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
		loginPage = mainPage.clickOnLoginButton();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyLoggedInUserNameTest() {
		Assert.assertTrue(homePage.userNameLabelDisplay());
	}
	
	@Test(priority=2)
	public void verifyHomeLinkTest() {
		Boolean HomePageLink = homePage.verifyHomeLink();
		Assert.assertTrue(HomePageLink);
	}
	
	@Test(priority=3)
	public void verifyCalendarLinkTest() {
		Assert.assertTrue(homePage.verifyCalendarLink());
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		Assert.assertTrue(homePage.verifyContactsLink());
	}
	
	@Test(priority=5)
	public void verifyCompaniesLinkTest() {
		Assert.assertTrue(homePage.verifyCompaniesLink());
	}
	
	@Test(priority=6)
	public void verifyDealsLinkTest() {
		Assert.assertTrue(homePage.verifyDealsLink());
		}
	
	@Test(priority=7)
	public void verifyTasksLinkTest() {
		Assert.assertTrue(homePage.verifyTasksLink());
		}
	
	@Test(priority=8)
	public void verifyCasesLinkTest() {
		Assert.assertTrue(homePage.verifyCasesLink());
		}
	
	@Test(priority=9)
	public void verifyCallsLinkTest() {
		Assert.assertTrue(homePage.verifyCallsLink());
		}
	
	@Test(priority=10)
	public void verifydocumentsLinkTest() {
		Assert.assertTrue(homePage.verifyDocumentsLink());
		}
	
	@Test(priority=11)
	public void verifyEmailLinkTest() {
		Assert.assertTrue(homePage.verifyEmailLink());
	}
	
	@Test(priority=12)
	public void verifyCompaniesLink() {
		Assert.assertTrue(homePage.verifyCompaniesLink());
	}
	
	@Test(priority=13)
	public void verifyFormsLink() {
		Assert.assertTrue(homePage.verifyFormsLink());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
