/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Santosh Sharma
 *
 */
public class LoginPage extends BasePage {

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
		super(driver);
	}
	
	// action methods
	public AccountPage performLoginWithValidData(String email, String password) {
		performSendKey(emailTextBox, email);
		performSendKey(passwordTextBox, password);
		performClick(loginBtn);
		return new AccountPage(driver);
	}
	
	public void performLoginWithInvalidData(String email, String password) {
		performSendKey(emailTextBox, email);
		performSendKey(passwordTextBox, password);
		performClick(loginBtn);
	}
	
	public String getErrorMessage() {
		return performGetInnerText(errorTxt);
	}
}