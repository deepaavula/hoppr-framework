package com.hoppr.genericutils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import org.apache.xerces.dom.DOMConfigurationImpl;

import com.hoppr.config.Driver;
import com.hoppr.config.ExtentManager;
import com.hoppr.config.ExtentTestManager;
import com.hoppr.config.Log;
import com.hoppr.config.ReadProperty;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basepage {

	private static WebDriver driver;

	ExecutorService executor = Executors.newFixedThreadPool(5);

	static ExtentReports extent;
	static ExtentTest test;

	public ExtentReports getExtent() {
		return extent;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public void init() throws InterruptedException, MalformedURLException, UnknownHostException, AWTException {

		if (driver == null) {
			driver = new Driver().getDriver();
			driver.manage().window().maximize();
			driver.navigate().to(ReadProperty.getProperty("baseURL"));
			Thread.sleep(10000);
			

		}
	}

	@AfterSuite
	public void tear() {
		try {
			if (driver != null) {
				driver.close();
				Thread.sleep(100);
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			Log.info(e);
			System.out.println("Something went wrong while quiting the driver, but ignoring and continueing ..");
		}
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTestManager.startTest(method.getName());
		//DOMConfigurationImpl.configure("log4j.xml");
	}

	@AfterMethod
	protected void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
		}
		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
	}

}




