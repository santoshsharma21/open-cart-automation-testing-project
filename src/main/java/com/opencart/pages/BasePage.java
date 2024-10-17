/**
 * 
 */
package com.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.opencart.elementutils.ElementActionMethod;

/**
 * 
 */
public class BasePage extends ElementActionMethod {
	
	// webdriver instance
	protected WebDriver driver;
	
	// constructor
	public BasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}