/**
 * 
 */
package com.opencart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author Santosh Sharma
 *
 */
public class AccountPage extends BasePage {
	
	// page objects
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement logoutLinkTxt;
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement MyAccountLinktxt;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
	private List<WebElement> MyAccountOptions;
	
	// constructor
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	// page action methods
	public String getUrl() {
		return performGetCurrentPageUrl(driver);
	}
	
	public void clickMyAccountOptions() {
		performClick(MyAccountLinktxt);
	}
	
	public LogoutPage performLogoutFromColumnOpt() {
		performClick(logoutLinkTxt);
		return new LogoutPage(driver);
	}
	
	public LogoutPage performLogoutFromMyAccountOpt() {
		performSelectByVisibleText(MyAccountOptions, "Logout");
		return new LogoutPage(driver);
	}
}