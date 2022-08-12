package com.hoppr.config;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager {

	static ExtentReports report;
	final static String filePath = System.getProperty("user.dir") + "/test-output/";
	

	public synchronized static ExtentReports getReporter() {
		if (report == null) {
			report = new ExtentReports(filePath + "hopprAutomationReport" + ".html", true, DisplayOrder.NEWEST_FIRST,
					NetworkMode.OFFLINE);
			report.addSystemInfo("Selenium Version", ReadProperty.getProperty("seleniumVersion"))
					.addSystemInfo("Environment", ReadProperty.getProperty("environment"))
					.addSystemInfo("Application",ReadProperty.getProperty("baseURL"))
					.addSystemInfo("Browser", ReadProperty.getProperty("browser"));
			report.assignProject(ReadProperty.getProperty("project"));
			
		}
		return report;

	}
}
