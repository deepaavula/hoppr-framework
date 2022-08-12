package com.hoppr.config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.hoppr.genericutils.ProjUtilLib;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTestManager {

	@SuppressWarnings("rawtypes")
	static Map extentTestMap = new HashMap();
	static ExtentReports extent = ExtentManager.getReporter();

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
	}

	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.startTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

		return test;
	}

	public static void fail(String message, WebDriver driver) throws IOException {
		try {
			ExtentTestManager.getTest().log(
					LogStatus.FAIL,
					message
							+ ExtentTestManager.getTest().addScreenCapture(
									ProjUtilLib.captureScreenshot(driver, com.hoppr.genericutils.ProjUtilLib.getMethodName())));
		} catch (WebDriverException | MalformedURLException e) {
			Log.info(e);
		}
	}

	public static void addScreenshot(String message,WebDriver driver) throws WebDriverException, IOException{
		ExtentTestManager.getTest().log(LogStatus.INFO, message+ExtentTestManager.getTest().addScreenCapture(
									ProjUtilLib.captureScreenshot(driver, ProjUtilLib.getMethodName())));
	}

	public static void pass(String message, WebDriver driver, boolean takeScreenShot) throws IOException {

		try {
			if (takeScreenShot) {
				ExtentTestManager.getTest().log(
						LogStatus.PASS,
						message
								+ ExtentTestManager.getTest().addScreenCapture(
										ProjUtilLib.captureScreenshot(driver, ProjUtilLib.getMethodName())));
			} else {
				ExtentTestManager.getTest().log(LogStatus.PASS, message);
			}
		} catch (WebDriverException | MalformedURLException e) {
			Log.info(e);
		}
	}

	public static void info(String message) {
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, message);

		} catch (WebDriverException e) {
			Log.info(e);
		}
	}

}