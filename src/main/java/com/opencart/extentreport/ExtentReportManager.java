/**
 * 
 */
package com.opencart.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.opencart.utilities.ConfigReader;

/**
 * @author Santosh Sharma
 *
 */
public class ExtentReportManager {

	public static ExtentSparkReporter sparkReport;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	ConfigReader cfg = new ConfigReader();

	public void setupExtentReport() {
		String dateTime = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String reportName = "Test-Report_" + dateTime + ".html";
		String destFolder = System.getProperty("user.dir") + "/test-report/" + reportName;

		sparkReport = new ExtentSparkReporter(destFolder);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Test Execution Report");
		sparkReport.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.AUTHOR,
				ViewName.CATEGORY, ViewName.DEVICE }).apply();

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReport);
		extentReports.setSystemInfo("Project Name", "Open Cart Testing");
		extentReports.setSystemInfo("Base URL", cfg.getUrl());
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java version", System.getProperty("java.version"));
	}

	public void closeExtentReport() {
		extentReports.flush();
	}
}
