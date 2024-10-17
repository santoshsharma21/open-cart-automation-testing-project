package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.HomePage;
import com.opencart.pages.SearchPage;

public class SearchTest extends BaseClass {

	// page instance
	private HomePage homePage;
	private SearchPage searchPage;

	@Test(priority = 0)
	public void searchWithValidKeyword() {
		homePage = new HomePage(driver);
		searchPage = homePage.searchProduct("imac");
		boolean status = searchPage.verifyValidSearch();
		Assert.assertTrue(status);
	}

	@Test(priority = 1)
	public void searchForNonExistingProduct() {
		homePage = new HomePage(driver);
		searchPage = homePage.searchProduct("fitbit");
		String actualMsg = searchPage.getSearchResultMessage();
		String expectedMsg = "There is no product that matches the search criteria.";
		boolean status = actualMsg.contains(expectedMsg);
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void sarchWithoutProductName() {
		homePage = new HomePage(driver);
		searchPage = homePage.searchProduct("");
		String actualMsg = searchPage.getSearchResultMessage();
		String expectedMsg = "There is no product that matches the search criteria.";
		boolean status = actualMsg.contains(expectedMsg);
		Assert.assertTrue(status);
	}

	@Test(priority = 3)
	public void searchWithCaseInSensitiveProductName() {
		homePage = new HomePage(driver);
		searchPage = homePage.searchProduct("iPHoNe");
		boolean status = searchPage.verifySearchCaseInsensitiveName();
		Assert.assertTrue(status);
	}

	@Test(priority = 4)
	public void searchWithMultipleKeyword() {
		homePage = new HomePage(driver);
		searchPage = homePage.searchProduct("Samsung Galaxy");
		String actualPrdName = searchPage.verifySearchWithMultipleKeyword();
		String expectedPartialPrdtName = "Galaxy";
		boolean status = actualPrdName.contains(expectedPartialPrdtName);
		System.out.println("return multiple = " + actualPrdName);
		Assert.assertTrue(status);
	}
}