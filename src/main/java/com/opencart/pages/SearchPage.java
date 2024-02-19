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
 * 
 */
public class SearchPage {
	
	// initialize driver
	WebDriver driver;
	
	// page web-elements
	@FindBy(xpath = "//img[@title='iMac']")   
	private WebElement imacImg;
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noSearchProductMsg;
	
	@FindBy(xpath = "//img[@title='iPhone']")  
	private WebElement iphoneImg;
	
	@FindBy(xpath = "//a[normalize-space()='Samsung Galaxy Tab 10.1']")
	private WebElement prdWitMultipelName;
	
	// constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// page action methods
	public boolean verifyValidSearch() {
		return TestUtils.performIsDispalyed(imacImg);
	}
	
	public String getSearchResultMessage() {
		return TestUtils.getInnerText(noSearchProductMsg);
	}
	
	public boolean verifySearchCaseInsensitiveName() {
		return TestUtils.performIsDispalyed(iphoneImg);
	}
	
	public String verifySearchWithMultipleKeyword() {
		return TestUtils.getInnerText(prdWitMultipelName); 
	}
}
