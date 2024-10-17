package com.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencart.base.BaseClass;
import com.opencart.pages.HomePage;
import com.opencart.pages.RegisterPage;
import com.opencart.pages.RegistrationSuccessPage;
import com.opencart.utilities.ConfigReader;
import com.opencart.utilities.TestUtils;

public class RegisterTest extends BaseClass {
	
	// page instance
	private ConfigReader config;
	private Faker faker;
	private HomePage homePage;
	private RegisterPage registerPage;
	private RegistrationSuccessPage registrationSuccessPage;

	@Test(priority = 0)
	public void testValidRegistration() {
		faker = new Faker();
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		registerPage = homePage.selectRegister();
		registrationSuccessPage = registerPage.registerAccountWithValidData(faker.name().firstName(),
				faker.name().lastName(), faker.internet().emailAddress(), TestUtils.getRandomNumAsString(10),
				faker.internet().password());
		String actualString = registrationSuccessPage.validateRegistrationAccount();
		String expectedString = "Your Account Has Been Created!";
		boolean status = expectedString.equals(actualString);
		Assert.assertTrue(status);
	}

	@Test(priority = 1)
	public void testRegistrationWithExistingEmail() {
		config = new ConfigReader();
		faker = new Faker();
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		registerPage = homePage.selectRegister();
		registerPage.registerAccountWithExistingEmail(faker.name().firstName(),
				faker.name().lastName(), config.getProperty("email"), TestUtils.getRandomNumAsString(10),
				faker.internet().password());
		String actualString = registerPage.verifyRegistrationWithExistingEmail();
		String expectedString = "Warning: E-Mail Address is already registered!";
		boolean status = expectedString.equals(actualString);
		Assert.assertTrue(status);
	}

	@Test(priority = 2)
	public void testRegistrationWithInvalidPasswordConfirmation() {
		faker = new Faker();
		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		registerPage = homePage.selectRegister();
		registerPage.registerAccountWithInvalidPassConfirm(faker.name().firstName(),
				faker.name().lastName(), faker.internet().emailAddress(), TestUtils.getRandomNumAsString(10),
				faker.internet().password());
		String actualString = registerPage.verifyRegistrationWithInvalidPassword();
		String expectedString = "Password confirmation does not match password!";
		boolean status = expectedString.equals(actualString);
		Assert.assertTrue(status);
	}
}