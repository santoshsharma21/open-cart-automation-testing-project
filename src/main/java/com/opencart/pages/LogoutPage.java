/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.utilities.TestUtils;

/**
 * 
 */
public class LogoutPage {

	// initialize webdriver
	WebDriver driver;

	// page objects
	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	private WebElement logoutMsg;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continueBtn;

	// constructor
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page action methods
	public String getLogoutMsg() {
		return TestUtils.getInnerText(logoutMsg);
	}
	
	public HomePage clickContinue() {
		TestUtils.performClick(continueBtn);
		return new HomePage(driver);
	}
}
