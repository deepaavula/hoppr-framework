package com.hoppr.config;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public WebDriver driver = null;

	@AfterClass
	public void clean() {
		driver.quit();
	}

	public WebDriver getDriver() throws MalformedURLException {

		String browser = ReadProperty.getProperty("browser");
		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 1);
				prefs.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
			} 
		}
		return driver;
	}

}


