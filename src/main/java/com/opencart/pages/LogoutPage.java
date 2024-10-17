/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class LogoutPage extends BasePage {

	// page objects
	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	private WebElement logoutMsg;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continueBtn;

	// constructor
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	// page action methods
	public String getLogoutMsg() {
		return performGetInnerText(logoutMsg);
	}
	
	public HomePage clickContinue() {
		performClick(continueBtn);
		return new HomePage(driver);
	}
}