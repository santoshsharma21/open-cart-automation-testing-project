/**
 * 
 */
package com.opencart.tests;

import org.testng.Assert;
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
	
	// page instance
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	
	@Test(dataProvider = "valid_email_password", dataProviderClass = TestDataProvider.class, priority = 0)
	public void loginWithValidEmailAndPassword(String email, String password) {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		accountPage = loginPage.performLoginWithValidData(email, password);
		String actualUrl = accountPage.getUrl();
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
		boolean status = actualUrl.equals(expectedUrl);
		Assert.assertTrue(status);
	} 
	
	@Test(dataProvider = "valid_email_invalid_password", dataProviderClass = TestDataProvider.class, priority = 1)
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
	
	@Test(dataProvider = "invalid_email_valid_password", dataProviderClass = TestDataProvider.class, priority = 2)
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
	
	@Test(dataProvider = "invalid_email_password", dataProviderClass = TestDataProvider.class, priority = 3)
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