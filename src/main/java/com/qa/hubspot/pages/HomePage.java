package com.qa.hubspot.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.util.constants;
import com.qa.hubspot.util.Elementutil;

public class HomePage extends BasePage{

	WebDriver driver;
	Elementutil elementUtil;
	
	private By header = By.cssSelector("h1.private-header__heading");
	private By accountName = By.className("account-name ");
	private By settingsIcon = By.id("navSetting");
	private By parentContactsMenu = By.id("nav-primary-contacts-branch");
	private By subContactsMenu = By.id("nav-secondary-contacts");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new Elementutil(driver);
	}
	
	public String getHomePageTitle() {
		return elementUtil.waitForPageTitlePresent(constants.HOME_PAGE_TITLE, 10);
	}
	
	public String getHomePageHeaderValue() {
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	public String getUserAccountName() {
		if(elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}
	
	public boolean isExistSettingsIcon() {
		return elementUtil.doIsDisplayed(settingsIcon);
	}
	
	
	public ContactsPage gotoContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts() {
		elementUtil.waitForElementToBeLocated(parentContactsMenu, 10);
		elementUtil.doClick(parentContactsMenu);
		elementUtil.clickWhenReady(subContactsMenu, 10);
	}
	
	

	}

