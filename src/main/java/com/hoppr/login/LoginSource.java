package com.hoppr.login;

import org.apache.xalan.xsltc.compiler.util.StringType;
import org.apache.xerces.xs.StringList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.hoppr.genericutils.ProjUtilLib;

public class LoginSource extends LoginPageObjects {
	WebDriver driver;
	private JavascriptExecutor js;

	public LoginSource(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String userName) {
		getUserName().clear();
		getUserName().sendKeys(userName);
	}

	public void enterPassword(String password) throws InterruptedException {
		getPassWord().clear();
		Thread.sleep(10000);
		getPassWord().sendKeys(password);

	}

	public void clickOnLoginButton() {
		getLoginbutton().click();
	}

	public void clickOndashBoard() {
		getDashboard().click();
	}

	public void clickOnonBoarding() {
		getOnBoarding().click();
	}

	public void clickOnEmployeeprofile() {
		getEmployeeProfile().click();
	}

	public void loginTohoppr(String un, String pw) throws InterruptedException {
		enterUsername(un);
		enterPassword(pw);
		clickOnLoginButton();
	}

	public void clickOnDate() {
		getDate().click();
	}

	public void clickOnFilter() {
		getFilter().click();
	}

	public void resetPassword(String email) throws InterruptedException {
		getForgotPassword().click();
		Thread.sleep(10000);
		getEmailadress().sendKeys(email);
		getSendPasswordResetLink().click();

	}

	public boolean isSucessMessageDisplayed() {

		boolean bool = getSuccessMessage().isDisplayed();
		if (bool) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDashboardDisplayed() {

		boolean bool = getDashBoard().isDisplayed();
		if (bool) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOnBoardingDisplayed() {

		boolean bool = getOnBoarding().isDisplayed();
		if (bool) {
			return true;
		} else {
			return false;
		}

	}

	public void clickOnpayroll() {
		getPayroll().click();

	}

	public void clickOnReimbursement() {
		getReimbursement().click();

	}

	public void clickOnApplyReimbursement() {
		getApplyReimbursement().click();

	}

	public String enterDescription() {

		ProjUtilLib.sendData(getDescription(), "food");
		return "food";
	}

	public void clickOnSubmit() {
		getSubmit().click();

	}

	public void clickOnEdit() {
		getSubmit().click();

	}

	public void clickOnApproveReimbursement() {
		getApproveReimbursement().click();
	}

}
