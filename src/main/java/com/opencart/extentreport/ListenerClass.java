/**
 * 
 */
package com.opencart.extentreport;

import java.awt.Desktop;
import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.opencart.base.BaseClass;
import com.opencart.utilities.TestUtils;

/**
 * @author Santosh Sharma
 *
 */
public class ListenerClass extends ReportManager implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		setupExtentReport(context);
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = reports.createTest(result.getName());
		extentTest.assignAuthor("SANTOSH");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				extentTest.assignCategory(result.getMethod().getGroups());
				extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - PASS", ExtentColor.GREEN));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String throwableMsg = result.getThrowable().getMessage().replaceAll(" ", "<br>");
			String formatedMsg = "<details>  <summary> Show Detail </summary>" + throwableMsg + " </details>";
			try {
				extentTest.assignCategory(result.getMethod().getGroups());
				extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAIL", ExtentColor.RED));
				String path = TestUtils.captureScreen(result.getName(), BaseClass.driver);
				extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				extentTest.fail(MarkupHelper.createLabel(formatedMsg, ExtentColor.RED));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			String throwableMsg = result.getThrowable().getMessage().replaceAll(" ", "<br>");
			String formatedMsg = "<details>  <summary> Show Detail </summary>" + throwableMsg + " </details>";
			try {
				extentTest.assignCategory(result.getMethod().getGroups());
				extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - SKIP", ExtentColor.YELLOW));
				extentTest.skip(MarkupHelper.createLabel(formatedMsg, ExtentColor.YELLOW));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		closeReport();

		String reportLoc = reportPath;
		File rprt = new File(reportLoc);
		try {
			Desktop.getDesktop().browse(rprt.toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
