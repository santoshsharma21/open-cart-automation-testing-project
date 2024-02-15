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
public class RegisterPage {

	// initialize driver
	WebDriver driver;

	// page webelements
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
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page action methods
	public RegistrationSuccessPage registerAccountWithValidData(String fname, String lname, String email, String phone,
			String password) {
		TestUtils.performSendKey(firstNameTxtBox, fname);
		TestUtils.performSendKey(lastNameTxtBox, lname);
		TestUtils.performSendKey(emailTxtBox, email);
		TestUtils.performSendKey(telephoneTxtBox, phone);
		TestUtils.performSendKey(passwordTxtBox, password);
		TestUtils.performSendKey(passwordConfirmTxtBox, password);
		TestUtils.performClick(privacyCheckBox);
		TestUtils.performClick(continueBtn);
		return new RegistrationSuccessPage(driver);
	}

	public void registerAccountWithExistingEmail(String fname, String lname, String email, String phone, String password) {
		TestUtils.performSendKey(firstNameTxtBox, fname);
		TestUtils.performSendKey(lastNameTxtBox, lname);
		TestUtils.performSendKey(emailTxtBox, email);
		TestUtils.performSendKey(telephoneTxtBox, phone);
		TestUtils.performSendKey(passwordTxtBox, password);
		TestUtils.performSendKey(passwordConfirmTxtBox, password);
		TestUtils.performClick(privacyCheckBox);
		TestUtils.performClick(continueBtn);
	}
	
	public void registerAccountWithInvalidPassConfirm(String fname, String lname, String email, String phone, String password) {
		TestUtils.performSendKey(firstNameTxtBox, fname);
		TestUtils.performSendKey(lastNameTxtBox, lname);
		TestUtils.performSendKey(emailTxtBox, email);
		TestUtils.performSendKey(telephoneTxtBox, phone);
		TestUtils.performSendKey(passwordTxtBox, password);
		TestUtils.performSendKey(passwordConfirmTxtBox, password + "s");
		TestUtils.performClick(privacyCheckBox);
		TestUtils.performClick(continueBtn);
	}

	public boolean verifyRegistrationWithExistingEmail(String expectedStr) {
		String actualStr = WarningMsg.getText();
		boolean status = actualStr.equalsIgnoreCase(expectedStr);
		return status;
	}

	public boolean verifyRegistrationWithInvalidPassConfirm(String expectedStr) {
		String actualStr = errorMsg.getText();
		boolean status = actualStr.equalsIgnoreCase(expectedStr);
		return status;
	}
}