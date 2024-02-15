/**
 * 
 */
package com.opencart.pages;

import java.util.List;

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
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement MyAccountLinktxt;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
	private List<WebElement> MyAccountOptions;
	
	// constructor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// action methods
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void clickMyAccountOptions() {
		TestUtils.performClick(MyAccountLinktxt);
	}
	
	public LogoutPage performLogoutFromColumnOpt() {
		TestUtils.performClick(logoutLinkTxt);
		return new LogoutPage(driver);
	}
	
	public LogoutPage performLogoutFromMyAccountOpt() {
		TestUtils.selectByVisibleTxt(MyAccountOptions, "Logout");
		return new LogoutPage(driver);
	}
}