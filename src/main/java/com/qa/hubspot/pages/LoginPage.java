package com.qa.hubspot.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.util.constants;

import io.qameta.allure.Step;

import com.qa.hubspot.util.Elementutil;
public class LoginPage extends BasePage{

		// TODO Auto-generated method stub
		WebDriver driver;
		Elementutil elementUtil;
		
		//1. Page Locators: By locators
		
		By emailId = By.id("username");
		By password = By.id("password");
		By loginButton = By.id("loginBtn");
		By signUpLink = By.linkText("Sign up");
		
		//2. Create the constructor of the page class:
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new Elementutil(driver);
		}
		
		//3. page actions/page methods
		public String getLoginPageTitle() {
			return elementUtil.waitForPageTitlePresent(constants.LOGIN_PAGE_TITLE, 10);
		}
		
		public boolean isSignUpLinkExist() {
			return elementUtil.doIsDisplayed(signUpLink);
		}
		
		@Step("login with : {0} and {1}")
		public HomePage doLogin(String username, String pwd) {
			System.out.println("login with : " + username + " : " + pwd);
			elementUtil.doSendKeys(emailId, username);
			elementUtil.doSendKeys(password, pwd);
			elementUtil.doClick(loginButton);
			return new HomePage(driver);
		}
		

	}

