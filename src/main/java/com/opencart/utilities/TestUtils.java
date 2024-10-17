/**
 * 
 */
package com.opencart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtils {

	// method takes screenshot
	public static String captureScreen(String testName, WebDriver driver) throws IOException {
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String scrName = testName + "_" + dt + ".png";
		String destFile = System.getProperty("user.dir") + "/screenshots/" + scrName;

		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File sourceFile = scrshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(destFile));

		// for jenkins
		//String pathReportJenkins = "http://localhost:8080/job/opencart/ws/screenshots/" + scrName;

		return destFile;
		//return pathReportJenkins;
		
		
	}

	// method generate random ten digit num
	public static String getRandomNumAsString(int numLength) {
		return RandomStringUtils.randomNumeric(numLength);
	}
}