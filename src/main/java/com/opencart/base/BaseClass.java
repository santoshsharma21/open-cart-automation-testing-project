/**
 * 
 */
package com.opencart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.opencart.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Santosh Sharma
 *
 */
public class BaseClass {

	// initialize driver
	public static WebDriver driver;
	
	// ConfigReader instance
	private ConfigReader cfg;

	// setup browser
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		// maximize window
		driver.manage().window().maximize();

		// delete cookies
		driver.manage().deleteAllCookies();

		// launch url
		cfg = new ConfigReader();
		driver.get(cfg.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}