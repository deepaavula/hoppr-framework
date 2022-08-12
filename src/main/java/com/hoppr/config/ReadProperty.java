package com.hoppr.config;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	public static String sSuiteName;
	public static String sBuildName;

	public enum BrowserType {
		FIREFOX, CHROME, IE, SAFARI, OPERA
	}

	public enum OSType {
		WINDOWS, LINUX, MAC, OTHER
	}

	public enum OSArchType {
		x86, x64
	}

	public enum ApplicationDetails {
		URL, USERNAME, PASSWORD, SUPER_USER, SUPER_PWD
	}

	public enum DBDetails {
		DBSERVER, DBNAME, DBPORT, USERNAME, PASSWORD
	}

	private static final String DEFAULT_PROP_FILENAME = "configuration.properties";
	public static Properties properties = new Properties();
	private static String testRoot = System.getProperty("testRoot");
	private static String testResultVideos, testResultScreenshots, testConfigFile, testJavascriptErrors;

	static {

		try {
			FileInputStream in = null;
			if (testRoot == null) {
				testRoot = System.getProperty("user.dir");
			}

			testConfigFile = System.getProperty("testConfigFile");
			if (testConfigFile == null) {
				in = new FileInputStream(testRoot + File.separator + DEFAULT_PROP_FILENAME);
			} else {
				in = new FileInputStream(testRoot + File.separator + testConfigFile);
			}
			properties.load(in);
			in.close();

			// directory to store video
			testResultVideos = System.getProperty("testResultVideos");
			if (testResultVideos == null)
				testResultVideos = testRoot + File.separator + "target" + File.separator + "failsafe-reports"
						+ File.separator + "videos";

			// directory to store screenshot
			testResultScreenshots = System.getProperty("testResultScreenshots");
			if (testResultScreenshots == null)
				testResultScreenshots = testRoot + File.separator + "target" + File.separator + "failsafe-reports"
						+ File.separator + "screenshots";

			// directory to store javascript error log
			testJavascriptErrors = System.getProperty("javascriptErrors");
			if (testJavascriptErrors == null)
				testJavascriptErrors = testRoot + File.separator + "target" + File.separator + "firefox-javascript-errors";

		} catch (IOException e) {
			System.err.println("Failed to read: " + testConfigFile);
		}
	}

	
	/**
	 * Parameter in testConfig.properties or System env
	 */
	public static BrowserType getBrowserType() {
		String sBrowser = properties.getProperty("browser");
		if (sBrowser.equalsIgnoreCase("CHROME")) {
			return BrowserType.CHROME;
		} else if (sBrowser.equalsIgnoreCase("IE")) {
			return BrowserType.IE;
		} else if (sBrowser.equalsIgnoreCase("FIREFOX")) {
			return BrowserType.FIREFOX;
		} else if (sBrowser.equalsIgnoreCase("SAFARI")) {
			return BrowserType.SAFARI;
		} else if (sBrowser.equalsIgnoreCase("OPERA")) {
			return BrowserType.OPERA;
		}
		return null;

	}

	public static OSType getOSType() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows")) {
			return OSType.WINDOWS;
		} else if (osName.contains("Linux")) {
			return OSType.LINUX;
		} else if (osName.contains("Mac")) {
			return OSType.MAC;
		} else {
			System.err.println("Error: Unable to determine OS of the automation machine:" + osName);
		}
		return OSType.OTHER;

	}

	

	/**
	 * Optional parameter in testConfig.properties or System env
	 */
	public static boolean isCaptureScreenshot() {
		String env_captureScreenshot = System.getProperty("capture.screenshot");
		String prop_captureScreenshot = String.valueOf(properties.getProperty("capture.screenshot"));
		if (env_captureScreenshot != null)
			return (env_captureScreenshot.trim().equalsIgnoreCase("true")) ? true : false;
		else if (prop_captureScreenshot != null)
			return (prop_captureScreenshot.trim().equalsIgnoreCase("true")) ? true : false;
		else
			return false;
	}
	public static String getLoggerLevel() {
		String env_level = System.getProperty("logger.level");
		String prop_level = String.valueOf(properties.getProperty("logger.level"));
		if (env_level != null)
			return env_level.trim();
		else if (prop_level != null)
			return prop_level.trim();
		else
			return null;
	}

		public static String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}


	


}




