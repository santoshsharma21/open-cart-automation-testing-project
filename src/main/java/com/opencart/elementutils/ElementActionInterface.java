/**
 * 
 */
package com.opencart.elementutils;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 */
public interface ElementActionInterface {

	// click action
	public void performClick(WebElement element);

	// javascript click
	public void performJavaScriptExeClick(WebElement element, WebDriver driver);

	// sendKeys action
	public void performSendKey(WebElement element, String key);

	// drop-down action
	public void performSelectByVisibleText(WebElement element, String key);
	
	// drop-down without select
	public void performSelectByVisibleText(List<WebElement> element, String key);

	// select value from list
	public void performSelectFromOption(List<WebElement> elements, String key);

	// return text from element
	public String performGetInnerText(WebElement element);

	// return current page url
	public String performGetCurrentPageUrl(WebDriver driver);
	
	// method verify element is displayed
	public boolean performIsDisplay(WebElement element);
}