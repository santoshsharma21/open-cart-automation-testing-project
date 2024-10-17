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
public class HomePage extends BasePage {

	// page objects
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountLink;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
	private List<WebElement> accountOptions;
	
	@FindBy(name = "search")
	private WebElement searchTxtBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchBtn;

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// action methods
	public void clickMyAccount() {
		performClick(myAccountLink);
	}

	public LoginPage selectLogin() {
		performSelectByVisibleText(accountOptions, "Login");
		return new LoginPage(driver);
	}

	public RegisterPage selectRegister() {
		performSelectByVisibleText(accountOptions, "Register");
		return new RegisterPage(driver);
	}
	
	public SearchPage searchProduct(String productName) {
		performSendKey(searchTxtBox, productName);
		performClick(searchBtn);
		return new SearchPage(driver);
	}
}