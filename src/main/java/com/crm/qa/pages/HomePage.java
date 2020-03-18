package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.testUtil.TestUtil;

public class HomePage extends TestBase{
	@FindBy(xpath="//span[contains(@class, 'user-display')]")
	WebElement userNameLbl;
	
	@FindBy(xpath="//*[contains(text(),'Home')]")
	WebElement HomeLink;
	
	@FindBy(xpath="//*[contains(text(),'Calendar')]")
	WebElement CalendarLink;
	
	@FindBy(xpath="//*[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//*[contains(text(),'Companies')]")
	WebElement CompaniesLink;
	
	@FindBy(xpath="//*[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//*[contains(text(),'Cases')]")
	WebElement CasesLink;
	
	@FindBy(xpath="//*[contains(text(),'Calls')]")
	WebElement CallsLink;
	
	@FindBy(xpath="//*[contains(text(),'Documents')]")
	WebElement documentsLink;
	
	@FindBy(xpath="//*[contains(text(),'Email')]")
	WebElement EmailLink;
	
	@FindBy(xpath="//*[contains(text(),'Campaigns')]")
	WebElement CampaignsLink;
	
	@FindBy(xpath="//*[contains(text(),'Forms')]")
	WebElement FormsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean userNameLabelDisplay() {
		return userNameLbl.isDisplayed();
	}
	
	public boolean verifyHomeLink() {
		return HomeLink.isDisplayed();
	}
	
	public boolean verifyCalendarLink() {
		return CalendarLink.isDisplayed();
	}
	
	public boolean verifyContactsLink() {
		return ContactsLink.isDisplayed();
	}
	
	public boolean verifyCompaniesLink() {
		return CompaniesLink.isDisplayed();
	}
	
	public boolean verifyDealsLink() {
		return dealsLink.isDisplayed();
	}
	
	public boolean verifyTasksLink() {
		return TasksLink.isDisplayed();
	}
	
	public boolean verifyCasesLink() {
		return CasesLink.isDisplayed();
	}
	
	public boolean verifyCallsLink() {
		return CallsLink.isDisplayed();
	}
	
	public boolean verifyDocumentsLink() {
		return documentsLink.isDisplayed();
	}
	
	public boolean verifyEmailLink() {
		return EmailLink.isDisplayed();
	}
	
	public boolean verifyCampaignsLink() {
		return CampaignsLink.isDisplayed();
	}
	
	public boolean verifyFormsLink() {
		return TasksLink.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		ContactsLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		return new ContactsPage();
	}

}
