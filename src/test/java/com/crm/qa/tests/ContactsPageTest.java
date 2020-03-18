package com.crm.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MainPage;
import com.crm.qa.testUtil.TestUtil;

public class ContactsPageTest extends TestBase{
	
	MainPage mainPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		mainPage = new MainPage();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		
		loginPage = mainPage.clickOnLoginButton();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();		
	}
	
	@Test(priority=1)
	public void verifyContactsPageTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void verifyHideFilterButtonExistsTest() {
		Assert.assertTrue(contactsPage.verifyShowFiltersButtonExists());
	}
	
	@Test(priority=3)
	public void verifyExportButtonExistsTest() {
		Assert.assertTrue(contactsPage.verifyExportButtonExists());
	}
	@Test(priority=4)
	public void verifyNewButtonExistsTest() {
		Assert.assertTrue(contactsPage.verifyNewButtonExists());
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object testData[][] = TestUtil.getCRMTestData("Contacts");
		return testData;
	}
	
	@Test(priority=5,dataProvider="getCRMTestData")
	public void fillCreateNewContactsFormTest(String sFirstName, String sLastName, String sMiddleName, String sCompany, String sTags, String sCategory, String sStatus, String sDoNotCall, String sDoNotText, String sDoNotEmail) {
		contactsPage.clickOnNewButton();
		contactsPage.fillNewContactsForm(sFirstName, sLastName, sMiddleName, sCompany, sTags, sCategory, sStatus, sDoNotCall, sDoNotText, sDoNotEmail);
		String createdNewContactLbl = (sFirstName+" "+sLastName);
		System.out.println(createdNewContactLbl);
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()= '"+createdNewContactLbl+"']")).isDisplayed());
	}
	
	@Test(priority=6,dataProvider="getCRMTestData")
	public void deleteContactsTest(String sFirstName, String sLastName, String sMiddleName, String sCompany, String sTags, String sCategory, String sStatus, String sDoNotCall, String sDoNotText, String sDoNotEmail) throws InterruptedException {
		String sContact = (sFirstName+" "+sMiddleName+" "+sLastName);
		contactsPage.selectContactByName(sContact);
		contactsPage.deleteSelectedContact();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
