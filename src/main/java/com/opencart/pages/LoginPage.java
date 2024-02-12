/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eshop.pages.AccountPage;

/**
 * @author Santosh Sharma
 *
 */
public class LoginPage {

	// initialize driver
	WebDriver driver;
	
	// page objects
	@FindBy(id = "input-email")
	WebElement emailTextBox;

	@FindBy(id = "input-password")
	WebElement passwordTextBox;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorTxt;

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// action methods
	public AccountPage performLogin(String email, String password) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		loginBtn.click();
		return new AccountPage(driver);
	}
	
	public String getErrorMessage() {
		return errorTxt.getText();
	}
}
