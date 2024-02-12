/**
 * 
 */
package com.opencart.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtils {

	// reuseable methods
	public static void selectByVisibleTxt(List<WebElement> elements, String txt) {
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(txt)) {
				element.click();
				break;
			}
		}
	}

	// method takes screenshot
	public static String captureScreen(String testName, WebDriver driver) throws IOException {
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String scrName = testName + "_" + dt + ".png";
		String destFile = System.getProperty("user.dir") + "/screenshots/" + scrName;

		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File sourceFile = scrshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(destFile));
		return destFile;
	}
}