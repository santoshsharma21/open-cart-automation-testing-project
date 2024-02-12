/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eshop.pages.LogoutPage;

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
	public boolean validateLogin() {
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
		boolean status = false;
		if (expectedUrl.equals(driver.getCurrentUrl())) {
			status = true;
		}
		return status;
	}

	public String tempvalidateLogin() {
		return driver.getCurrentUrl();
	}

	public LogoutPage clickLogout() {
		logoutLinkTxt.click();
		return new LogoutPage(driver);
	}
}
