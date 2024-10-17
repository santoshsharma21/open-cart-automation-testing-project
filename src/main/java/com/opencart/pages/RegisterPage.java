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
public class RegisterPage extends BasePage {

	// page objects
	@FindBy(id = "input-firstname")
	private WebElement firstNameTxtBox;

	@FindBy(id = "input-lastname")
	private WebElement lastNameTxtBox;

	@FindBy(id = "input-email")
	private WebElement emailTxtBox;

	@FindBy(id = "input-telephone")
	private WebElement telephoneTxtBox;

	@FindBy(id = "input-password")
	private WebElement passwordTxtBox;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmTxtBox;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyCheckBox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement WarningMsg;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement errorMsg;

	// constructor
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// page action methods
	public RegistrationSuccessPage registerAccountWithValidData(String fname, String lname, String email, String phone,
			String password) {
		performSendKey(firstNameTxtBox, fname);
		performSendKey(lastNameTxtBox, lname);
		performSendKey(emailTxtBox, email);
		performSendKey(telephoneTxtBox, phone);
		performSendKey(passwordTxtBox, password);
		performSendKey(passwordConfirmTxtBox, password);
		performClick(privacyCheckBox);
		performClick(continueBtn);
		return new RegistrationSuccessPage(driver);
	}

	public void registerAccountWithExistingEmail(String fname, String lname, String email, String phone, String password) {
		performSendKey(firstNameTxtBox, fname);
		performSendKey(lastNameTxtBox, lname);
		performSendKey(emailTxtBox, email);
		performSendKey(telephoneTxtBox, phone);
		performSendKey(passwordTxtBox, password);
		performSendKey(passwordConfirmTxtBox, password);
		performClick(privacyCheckBox);
		performClick(continueBtn);
	}
	
	public void registerAccountWithInvalidPassConfirm(String fname, String lname, String email, String phone, String password) {
		performSendKey(firstNameTxtBox, fname);
		performSendKey(lastNameTxtBox, lname);
		performSendKey(emailTxtBox, email);
		performSendKey(telephoneTxtBox, phone);
		performSendKey(passwordTxtBox, password);
		performSendKey(passwordConfirmTxtBox, password + "s");
		performClick(privacyCheckBox);
		performClick(continueBtn);
	}

	public String verifyRegistrationWithExistingEmail() {
		return performGetInnerText(WarningMsg);
	}

	public String verifyRegistrationWithInvalidPassword() {
		return performGetInnerText(errorMsg);
	}
}