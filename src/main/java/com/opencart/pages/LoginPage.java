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
public class LoginPage {

	// initialize driver
	WebDriver driver;
	
	// page objects
	@FindBy(id = "input-email")
	private WebElement emailTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorTxt;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// action methods
	public AccountPage performLoginWithValidData(String email, String password) {
		TestUtils.performSendKey(emailTextBox, email);
		TestUtils.performSendKey(passwordTextBox, password);
		TestUtils.performClick(loginBtn);
		return new AccountPage(driver);
	}
	
	public void performLoginWithInvalidData(String email, String password) {
		TestUtils.performSendKey(emailTextBox, email);
		TestUtils.performSendKey(passwordTextBox, password);
		TestUtils.performClick(loginBtn);
	}
	
	public String getErrorMessage() {
		return TestUtils.getInnerText(errorTxt);
	}
}
