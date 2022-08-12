package com.hoppr.reimbursement;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.hoppr.config.ExtentReporterNG;
import com.hoppr.genericutils.ProjUtilLib;
import com.hoppr.login.LoginPageObjects;
import com.hoppr.login.LoginSource;

public class ReimbursementLoginSourcePage  extends ReimbursementPageObjects{
	
	
			WebDriver driver;
			private JavascriptExecutor js;
			
			public ReimbursementLoginSourcePage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			
			
			
			public void clickOndashBoard(){
				getDashboard().click();
			}
			public void clickOnonBoarding(){
				getOnBoarding().click();
			}
			public void clickOnEmployeeprofile(){
				getEmployeeProfile().click();
			}
			
				
				
			
			
			public void clickOnDate(){
				getDate().click();
			}
			public void clickOnFilter(){
				getFilter().click();
			}
			
			
		public boolean isDashboardDisplayed() {
				
				boolean bool=getDashBoard().isDisplayed();
				if(bool) {
					return true;		
			}
				else {
					return false;
				}
		}
		public boolean isOnBoardingDisplayed() {
			
			boolean bool=getOnBoarding().isDisplayed();
			if(bool) {
				return true;		
		}
			else {
				return false;
			}
			
		}
		public void clickOnpayroll(){
			getPayroll().click();
			
		}
		public void clickOnReimbursement(){
			getReimbursement().click();
			
		}
		public void clickOnApplyReimbursement (){
			getApplyReimbursement().click();
			
		}

		
		public String enterDescription() throws InterruptedException {
			Thread.sleep(10000);
			ProjUtilLib.clickOnElement(getDescription());

			ProjUtilLib.sendData(getDescription(), "travel");

			return "travel";
		}
		public void clickOnSave(){
			
			ProjUtilLib.clickOnElement(getSave());
		}
       public void clickOnAddExpense(){
			
			ProjUtilLib.clickOnElement(getAddExpense());
		}

		
		
       public void clickOnCategory(){
			
			ProjUtilLib.clickOnElement(getCategory());
			ProjUtilLib.sendData(getCategory(), "food");
		}
       public String enterAmount() throws InterruptedException {
			Thread.sleep(10000);
			ProjUtilLib.clickOnElement(getAmount());

			ProjUtilLib.sendData(getAmount(), "500");
			return "500";
		}
       public String enterRemark() throws InterruptedException {
			
			ProjUtilLib.clickOnElement(getRemark());
			ProjUtilLib.clickOnElement(getAttachedFile());
			ProjUtilLib.sendData(getRemark(), "bill is not avaible");
			return "bill is not avaible";
		}
       
		public void clickOnApproveReimbursement(){
			getApproveReimbursement().click();
		}

			
		}
			
			
			
			
			
			




