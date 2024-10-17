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
public class SearchPage extends BasePage {
	
	// page objects
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
		super(driver);
	}
	
	// page action methods
	public boolean verifyValidSearch() {
		return performIsDisplay(imacImg);
	}
	
	public String getSearchResultMessage() {
		return performGetInnerText(noSearchProductMsg);
	}
	
	public boolean verifySearchCaseInsensitiveName() {
		return performIsDisplay(iphoneImg);
	}
	
	public String verifySearchWithMultipleKeyword() {
		return performGetInnerText(prdWitMultipelName); 
	}
}