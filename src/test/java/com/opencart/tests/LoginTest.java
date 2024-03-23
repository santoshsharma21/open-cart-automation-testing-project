/**
 * 
 */
package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.dataprovider.TestDataProvider;
import com.opencart.pages.AccountPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.LoginPage;

/**
 * 
 */
public class LoginTest extends BaseClass {
	
	// pages
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		setupBrowser(browser);
	}

	@AfterMethod
	public void afterMethod() {
		quitBrowser();
	}
	
	@Test(priority = 0)
	public void testLoginLinkDisplay() {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		boolean status = homePage.isLoginLinkDisplayed();
		Assert.assertTrue(status);
	} 
	
	@Test(dataProvider = "valid_email_password", dataProviderClass = TestDataProvider.class, priority = 1)
	public void loginWithTrueEmailAndTruePassword(String email, String password) {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		accountPage = loginPage.performLoginWithValidData(email, password);
		String actualUrl = accountPage.getUrl();
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
		boolean status = actualUrl.equals(expectedUrl);
		Assert.assertTrue(status);
	} 
	
	@Test(dataProvider = "valid_email_invalid_password", dataProviderClass = TestDataProvider.class, priority = 2)
	public void loginWithTrueEmailAndFalsePassword(String email, String password) {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		loginPage.performLoginWithInvalidData(email, password);
		String actualError = loginPage.getErrorMessage();
		String expectedError = "Warning: No match for E-Mail Address and/or Password.";
		boolean status = actualError.equals(expectedError);
		Assert.assertTrue(status);
	}
	
	@Test(dataProvider = "invalid_email_valid_password", dataProviderClass = TestDataProvider.class, priority = 3)
	public void loginWithFalseEmailAndTruePassword(String email, String password) {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		loginPage.performLoginWithInvalidData(email, password);
		String actualError = loginPage.getErrorMessage();
		String expectedError = "Warning: No match for E-Mail Address and/or Password.";
		boolean status = actualError.equals(expectedError);
		Assert.assertTrue(status);
	}
	
	@Test(dataProvider = "invalid_email_password", dataProviderClass = TestDataProvider.class, priority = 4)
	public void loginWithFalseEmailAndFalsePassword(String email, String password) {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		loginPage.performLoginWithInvalidData(email, password);
		String actualError = loginPage.getErrorMessage();
		String expectedError = "Warning: No match for E-Mail Address and/or Password.";
		boolean status = actualError.equals(expectedError);
		Assert.assertTrue(status);
	}
}