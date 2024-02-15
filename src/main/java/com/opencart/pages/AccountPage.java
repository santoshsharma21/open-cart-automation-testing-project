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
 * @author Santosh Sharma
 *
 */
public class AccountPage {
	
	// initialize driver
	WebDriver driver;

	// page objects
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement logoutLinkTxt;
	
	// constructor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// action methods
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
//	public LogoutPage clickLogout() {
//		TestUtils.performClick(logoutLinkTxt);
//		return new LogoutPage(driver);
//	}
}
