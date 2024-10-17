/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class RegistrationSuccessPage extends BasePage {
	
	// page objects
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement acttRegistrationSuccessTxt;
	
	// constructor
	public RegistrationSuccessPage(WebDriver driver) {
		super(driver);
	}
	
	// page action method
	public String validateRegistrationAccount() {
		return performGetInnerText(acttRegistrationSuccessTxt);
	}
}