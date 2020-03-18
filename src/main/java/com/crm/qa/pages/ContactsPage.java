package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.testUtil.TestUtil;

public class ContactsPage extends TestBase{	
	
	@FindBy(xpath="//div[contains(@class, 'ui header item mb5 light-black')]")
	WebElement contactslbl;
	
	@FindBy(xpath="//*[text()= 'sudhir soni']")
	WebElement createNewContactlbl;
	
	@FindBy(xpath="//button[text()='Show Filters']")
	WebElement showFilterBtn;
	
	@FindBy(xpath="//button[text()='Export']")
	WebElement exportBtn;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement newBtn;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstNameTxt;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastNameTxt;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement middleNameTxt;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement companyTxt;
	
	@FindBy(xpath="//label[@for='tags']")
	WebElement tagsTxt;
	
	@FindBy(xpath="//*[@name='category']")
	WebElement categorySel;
	
	@FindBy(xpath="//*[@name='status']")
	WebElement statusSel;
	
	@FindBy(name="do_not_call")
	WebElement doNotCallOpt;
	
	@FindBy(name="do_not_text")
	WebElement doNotTextOpt;	
	
	@FindBy(name="do_not_email")
	WebElement doNotEmailOpt;
	
	@FindBy(xpath="//button[contains(text(), 'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[contains(text(), 'Cancel')]")
	WebElement cancelBtn;
	
	@FindBy(xpath="//div[@name='action']")
	WebElement actionDropDown;
	
	@FindBy(xpath="//div[@role='button']")
	WebElement actionButton;
	
	@FindBy(xpath="//div[@class='actions']//child::button[text()='Delete']")
	WebElement actionDeleteBtn;
	
	@FindBy(xpath="//div[@class='actions']//child::button[text()='Cancel']")
	WebElement actionCancelBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactslbl.isDisplayed();
	}
	
	public boolean verifyShowFiltersButtonExists() {
		return showFilterBtn.isDisplayed();
	}
	
	public boolean verifyExportButtonExists() {
		return exportBtn.isDisplayed();
	}
	
	public boolean verifyNewButtonExists() {
		return newBtn.isDisplayed();
	}
	
	public void clickOnNewButton() {
		newBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	}
	
	public void chooseYesOrNoOption(WebElement weYesOrNoBtn, String YesOrNo) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",weYesOrNoBtn);
		Actions action = new Actions(driver);
		if (YesOrNo.matches("Yes")) {
			//doNotCallOpt.click();
			action.moveToElement(weYesOrNoBtn).click().perform();
		}
	}
	
		
	public void selectValueFromDropDown(WebElement weParent, String sType, String sName, String sValue) {
		List<WebElement> category;
		weParent.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.MILLISECONDS);
		if (sType.contentEquals("text")){
			category = driver.findElements(By.xpath("//*[text()='"+sName+"']//div"));	
		}		
		else {
			category = driver.findElements(By.xpath("//*[@"+sType+"='"+sName+"']//div"));
		}
		
		for (int i=0;i<category.size(); i++) {
			WebElement element = category.get(i);
			String menu = element.getText();
			if (menu.contentEquals(sValue)) {
				element.click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	}
	
	public void fillNewContactsForm(String sFirstName, String sLastName, String sMiddleName, String sCompany, String sTags, String sCategory, String sStatus, String sDoNotCall, String sDoNotText, String sDoNotEmail) {
		sendKeys(driver, firstNameTxt, 10, sFirstName);
		sendKeys(driver, lastNameTxt, 5, sLastName);
		sendKeys(driver, middleNameTxt, 5, sMiddleName);
		//companyTxt.sendKeys(sCompany);
		//tagsTxt.sendKeys(sTags);
		selectValueFromDropDown(categorySel, "name", "category", sCategory);
		selectValueFromDropDown(statusSel, "name", "status", sStatus);
		chooseYesOrNoOption(doNotCallOpt,sDoNotCall);
		chooseYesOrNoOption(doNotTextOpt,sDoNotText);
		chooseYesOrNoOption(doNotEmailOpt,sDoNotEmail);	
		ClickOnSaveButton();
	}
	
	public void selectContactByName(String sName) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//td[text()='"+sName+"']//parent::tr[@class]//preceding-sibling::td[@class]//div//input[@type='checkbox']"))).click().perform();
	}
	
	public void ClickOnSaveButton() {
		saveBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	}
	
	public void ClickOnCancelButton() {
		cancelBtn.click();
	}
	
	public void deleteSelectedContact() throws InterruptedException {
		selectValueFromDropDown(actionDropDown,"class","visible menu transition","Delete");
		clickOn(driver, actionButton,20);
		clickOn(driver, actionDeleteBtn,20);
		Thread.sleep(2000);
	}
	
	//This method will Explicitly wait for given timeout for webEliment to be visible
		public static void sendKeys(WebDriver driver, WebElement webElement, int timeOut, String sValue) {
			new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(webElement));
			webElement.sendKeys(sValue);;
		}
	
	//This method will Explicitly wait for given timeout for webEliment to be clickable
	public static void clickOn(WebDriver driver, WebElement webElement, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
	}
}
