package com.hoppr.genericutils;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.ParseException;


import com.hoppr.config.Log;

public class ProjUtilLib extends Basepage {
	final static String filePath = System.getProperty("user.dir") + "/test-output/";
	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static boolean bool = false;

	public static String captureScreenshot(WebDriver driver, String sTestname) throws WebDriverException, IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;

	}

	public static String getMethodName() {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[ste.length - 1].getMethodName();
	}

	public static void waitForElement(WebDriver driver, WebElement element, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Log.info(e);
		}
	}

	public static void implicitWait(int newWaittime_InSeconds) {

		getDriver().manage().timeouts().implicitlyWait(newWaittime_InSeconds, TimeUnit.SECONDS);
	}

	public static void sendData(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);

	}

	public static void clickOnElement(WebElement element) {
		waitForElement(element, 20);
		element.click();

	}

	public static String getText(WebElement element) {
		waitForElement(element, 20);
		return element.getText();

	}

	public static int getSize(List<WebElement> element) {
		waitForElement(element.get(0), 20);
		return element.size();
	}

	public static void waitForElement(WebElement element, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {

		}
	}

	public static void selectDropdownbyText(WebElement element, String value) {
		waitForElement(element, 20);
		Select objSelect = new Select(element);
		implicitWait(10);
		objSelect.selectByVisibleText(value);

	}

	public static boolean isElementDisplayed(WebElement element) {
    	waitForElement(element, 20);
    	 bool = element.isDisplayed();
		if (bool) {
			return true;
		} else {
			return false;
		}
	}
	public static String generateRandomString() {
		StringBuilder randStr = new StringBuilder();
		int RANDOM_STRING_LENGTH = 6;
		String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
			int number = getRandomCharLengthForString();
			char ch = CHAR_LIST.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString();
	}
	
	public static int getRandomCharLengthForString() {
		int randomInt;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public static String getRandomString() {
		String rndStr = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
		return rndStr;

	}



    public static String getDsrdPrvsDate(String dateObj, int noOfdaysBack) throws ParseException {
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		cal.setTime(df.parse(dateObj));
		cal.add(Calendar.DAY_OF_YEAR, -noOfdaysBack);
		Date oneDayBefore = cal.getTime();
		return df.format(oneDayBefore);
	}


	
}



