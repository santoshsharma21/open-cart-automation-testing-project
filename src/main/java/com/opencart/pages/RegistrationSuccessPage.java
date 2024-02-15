/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 */
public class RegistrationSuccessPage {
	
	// page web-elements
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement acttRegistrationSuccessTxt;
	
	// constructor
	public RegistrationSuccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// page action method
	public boolean validateRegistrationAccount(String expectedText) {
		String actualtxt = acttRegistrationSuccessTxt.getText();
		boolean status = actualtxt.equalsIgnoreCase(expectedText);
		return status;
	}
}
