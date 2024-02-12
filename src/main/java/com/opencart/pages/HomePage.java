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
public class HomePage {
	
	// initialize driver
	WebDriver driver;

	// page objects
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountLink;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
	private List<WebElement> accountOptions;
	
	// constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// action methods
	public void clickMyAccount() {
		myAccountLink.click();
	}

	public LoginPage selectLogin() {
		TestUtils.selectByVisibleTxt(accountOptions, "Login");
		return new LoginPage(driver);
	}

	public RegisterPage selectRegister() {
		TestUtils.selectByVisibleTxt(accountOptions, "Register");
		return new RegisterPage(driver);
	}
}
