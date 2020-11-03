package com.qa.hubspot.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.util.constants;
import com.qa.hubspot.util.Elementutil;

public class ContactsPage extends BasePage {

	Elementutil elementUtil;
	private WebDriver driver;
	
	private By header = By.cssSelector("span.private-dropdown__item__label");
	private By createContactPrimary = By.xpath("//span[text()='Create contact']");
	private By emailId = By.xpath("//input[@data-field='email']");
	private By firstName = By.xpath("//input[@data-field='firstname']");
	private By lastName = By.xpath("//input[@data-field='lastname']");
	private By ContactOwner = By.xpath("//span[text()='Raja Lakshmi']");
	private By jobTitle = By.xpath("//textarea[@data-field='jobtitle']");
	private By createContactSecondary = By.xpath("(//span[text()='Create contact'])[position()=2]");
	private By contactsBackLink = By.xpath("(//*[text()='Contacts'])[position()=2]");
	
	
	public ContactsPage(WebDriver driver) {
		elementUtil = new Elementutil(driver);
		this.driver = driver;
	}
	
	public String getConatctsPageTitle() {
		return elementUtil.waitForPageTitlePresent(constants.CONTACTS_PAGE_TITLE, 10);
	}
	
	public String getContactsPageHeaderValue() {
		return elementUtil.doGetText(header);
	}
	
	public void createContact(String emailId, String firstName, String lastName, String jobTitle) {
		
		elementUtil.waitForElementToBeLocated(createContactPrimary, 10);
		elementUtil.doClick(createContactPrimary);
		
		elementUtil.waitForElementToBeLocated(this.emailId, 5);
		elementUtil.doSendKeys(this.emailId, emailId);
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		
		elementUtil.waitForElementToBeLocated(this.ContactOwner, 15);
		elementUtil.waitForElementToBeLocated(this.jobTitle, 15);
		elementUtil.doSendKeys(this.jobTitle, jobTitle);
		
		elementUtil.clickWhenReady(createContactSecondary, 10);
		elementUtil.waitForElementToBeLocated(this.contactsBackLink, 20);
		elementUtil.clickWhenReady(contactsBackLink, 20);
		
	}



	}

