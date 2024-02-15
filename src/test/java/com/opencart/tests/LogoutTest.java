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
import com.opencart.pages.LogoutPage;

/**
 * 
 */
public class LogoutTest extends BaseClass {
	
	// pages
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	LogoutPage logoutPage;
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		setupBrowser(browser);
	}

	@AfterMethod
	public void afterMethod() {
		quitBrowser();
	}
	
	@Test(dataProvider = "valid_email_password", dataProviderClass = TestDataProvider.class, priority = 0)
	public void validateLoginFromMyaccountOptions(String username, String password) {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		accountPage = loginPage.performLoginWithValidData(username, password);
		accountPage.clickMyAccountOptions();
		logoutPage = accountPage.performLogoutFromMyAccountOpt();
		String actualLogoutMsg = logoutPage.getLogoutMsg();
		String expectedLogoutMsg = "Account Logout";
		boolean status = actualLogoutMsg.equalsIgnoreCase(expectedLogoutMsg);
		Assert.assertTrue(status);
	}
	
	@Test(dataProvider = "valid_email_password", dataProviderClass = TestDataProvider.class, priority = 1)
	public void validateLoginFromColumn(String username, String password) {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		accountPage = loginPage.performLoginWithValidData(username, password);
		logoutPage = accountPage.performLogoutFromColumnOpt();
		String actualLogoutMsg = logoutPage.getLogoutMsg();
		String expectedLogoutMsg = "Account Logout";
		boolean status = actualLogoutMsg.equalsIgnoreCase(expectedLogoutMsg);
		Assert.assertTrue(status);
	}
}