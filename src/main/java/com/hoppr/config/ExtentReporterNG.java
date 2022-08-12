package com.hoppr.config;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

public class ExtentReporterNG extends TestListenerAdapter implements IReporter {

	private static ReadProperty read = new ReadProperty();
	ITestContext context;
	public static ExtentReports parentExtent = null; // to be removed
	public static ExtentTest test = null; // to be removed

	public void onTestFailure(ITestResult result) {
		buildDetailedNodes(LogStatus.FAIL, result, ExtentTestManager.getTest());
	}

	public void onTestSuccess(ITestResult result) {
		buildDetailedNodes(LogStatus.PASS, result, ExtentTestManager.getTest());
	}

	public void onTestSkipped(ITestResult result) {
		buildDetailedNodes(LogStatus.SKIP, result, ExtentTestManager.getTest());
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		ExtentManager.getReporter().addSystemInfo("Selenium Version", ReadProperty.getProperty("seleniumVersion"))
				.addSystemInfo("Environment", ReadProperty.getProperty("environment"));
		ExtentManager.getReporter().config().documentTitle("hoppr automation web Report").reportName("Config Functional")
				.reportHeadline("hoppr Web Automation - Config Functional Results");

		ExtentManager
				.getReporter()
				.assignProject(read.getProperty("project"))
				.config()
				.insertJs(
						"var t = $('.tests-quick-view table'); for (var i = 4; i < 8; i++) { t.find('th:nth-child(' + i + '), td:nth-child(' + i + ')').hide(); } t.find('th:nth-child(9), td:nth-child(9)').hide();");

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				context = r.getTestContext();
			}
		}

		for (String s : Reporter.getOutput()) {
			ExtentManager.getReporter().setTestRunnerOutput(s);
		}

		ExtentManager.getReporter().flush();

	}

	private void buildDetailedNodes(LogStatus status, ITestResult result, ExtentTest test) {
		ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
		ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
		for (String group : result.getMethod().getGroups())
			ExtentTestManager.getTest().assignCategory(group);
		String message = "Test " + status.toString().toLowerCase() + "ed";
		if (result.getThrowable() != null)
			message = "<pre>" + result.getThrowable().getMessage() + "</pre>";
		ExtentTestManager.getTest().log(status, message);
		// ExtentTestManager.getTest().assignCategory(read.getBuildName());
		ExtentTestManager.getTest().setDescription(result.getMethod().getDescription());
		ExtentManager.getReporter().endTest(test);

		for (String s : Reporter.getOutput()) {
			ExtentManager.getReporter().setTestRunnerOutput(s);
		}

	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}