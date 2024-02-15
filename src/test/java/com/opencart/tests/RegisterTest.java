package com.opencart.tests;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencart.base.BaseClass;
import com.opencart.pages.HomePage;
import com.opencart.pages.RegisterPage;
import com.opencart.pages.RegistrationSuccessPage;
import com.opencart.utilities.ConfigReader;
import com.opencart.utilities.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RegisterTest extends BaseClass {
	
	// pages
	ConfigReader config;
	Faker faker;
	HomePage homePage;
	RegisterPage registerPage;
	RegistrationSuccessPage registrationSuccessPage;

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
	public void testRegisterLinkDisplay() {
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		boolean status = homePage.isRegisterLinkDisplayed();
		Assert.assertTrue(status);
	}

	@Test(priority = 1)
	public void testValidRegistration() {
		faker = new Faker();
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		registerPage = homePage.selectRegister();
		registrationSuccessPage = registerPage.registerAccountWithValidData(faker.name().firstName(),
				faker.name().lastName(), faker.internet().emailAddress(), TestUtils.getRandomNumAsString(10),
				faker.internet().password());
		boolean status = registrationSuccessPage.validateRegistrationAccount("Your Account Has Been Created!");
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void testRegistrationWithExistingEmail() {
		config = new ConfigReader();
		faker = new Faker();
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		registerPage = homePage.selectRegister();
		registerPage.registerAccountWithExistingEmail(faker.name().firstName(),
				faker.name().lastName(), config.getEmailId(), TestUtils.getRandomNumAsString(10),
				faker.internet().password());
		boolean status = registerPage.verifyRegistrationWithExistingEmail("Warning: E-Mail Address is already registered!");
		Assert.assertTrue(status);
	}

	@Test(priority = 3)
	public void testRegistrationWithInvalidPasswordConfirmation() {
		faker = new Faker();
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		registerPage = homePage.selectRegister();
		registerPage.registerAccountWithInvalidPassConfirm(faker.name().firstName(),
				faker.name().lastName(), faker.internet().emailAddress(), TestUtils.getRandomNumAsString(10),
				faker.internet().password());
		boolean status = registerPage.verifyRegistrationWithInvalidPassConfirm("Password confirmation does not match password!");
		Assert.assertTrue(status);
	}
}