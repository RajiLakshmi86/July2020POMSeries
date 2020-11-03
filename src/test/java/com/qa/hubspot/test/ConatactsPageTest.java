package com.qa.hubspot.test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.Base.BaseTest;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.constants;
import com.qa.hubspot.util.excelutil;


public class ConatactsPageTest extends BaseTest {
	WebDriver driver;
	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browserName) {
		basePage = new BasePage();
		prop = basePage.init_prop();
		prop.setProperty("browser", browserName);
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

	}
	@BeforeClass
	public void homePageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contactsPage = homePage.gotoContactsPage();
	}

	@Test(priority = 2)
	public void verifyContactsPageTitleTest() {
		String title = contactsPage.getConatctsPageTitle();
		System.out.println("contacts page title is: " + title);
		Assert.assertEquals(title, constants.CONTACTS_PAGE_TITLE, constants.CONTACTS_TITLE_ERROR_MESSG);
	}

	@Test(priority = 1)
	public void verifyContactsPageHeaderTest() {
		String header = contactsPage.getContactsPageHeaderValue();
		System.out.println("contacts page header is : " + header);
		Assert.assertEquals(header, constants.CONTACTS_PAGE_HEADER);
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = excelutil.getTestData(constants.CONTACTS_SHEET_NAME);
		return data;
	}

	@Test(priority = 3, dataProvider = "getContactsTestData")
	public void createContactTest(String emailId, String firstName, String lastName, String jobTitle) {
		contactsPage.createContact( emailId, firstName, lastName, jobTitle);
	}

}