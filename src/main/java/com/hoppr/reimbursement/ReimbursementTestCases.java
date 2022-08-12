package com.hoppr.reimbursement;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hoppr.config.ExtentReporterNG;
import com.hoppr.config.ExtentTestManager;
import com.hoppr.config.Log;
import com.hoppr.config.ReadProperty;
import com.hoppr.genericutils.FatoryUtility;
import com.hoppr.login.LoginSource;
import com.relevantcodes.extentreports.ExtentTest;
@Listeners(ExtentReporterNG.class)
public class ReimbursementTestCases extends ReimbursementLoginSourcePage {
	ExtentTest test;
	
	 public ReimbursementTestCases() {
       super(getDriver());
   }
   private LoginSource loginSource;
   private ReimbursementLoginSourcePage reimbursementLoginSourcePage;
   String actual = null;
   boolean bool=false;
   @Test(description = "applying for reimbursement ", priority = 1)
   
    public void applyreimbursement() throws Exception {
       ExtentTestManager.info("Login with valid Username Password  ");
       loginSource = (LoginSource) FatoryUtility.getObject("loginSource");
       ExtentTestManager.info("Enter valid UserName And Password");
      loginSource.loginTohoppr(ReadProperty.getProperty("userName"),ReadProperty.getProperty("password"));
      reimbursementLoginSourcePage = (ReimbursementLoginSourcePage) FatoryUtility.getObject("reimbursementLoginSourcePage");
      Thread.sleep(2000);
      bool=loginSource.isDashboardDisplayed();
      bool=loginSource.isOnBoardingDisplayed();
      reimbursementLoginSourcePage.clickOnpayroll();
      Thread.sleep(2000);
      reimbursementLoginSourcePage.clickOnReimbursement();
      
      reimbursementLoginSourcePage.clickOnApplyReimbursement();
      Thread.sleep(2000);
      reimbursementLoginSourcePage.enterDescription();
      
      reimbursementLoginSourcePage.clickOnSave();
      Thread.sleep(2000);
      reimbursementLoginSourcePage.clickOnAddExpense();
      Thread.sleep(2000);
      reimbursementLoginSourcePage.clickOnCategory();
      reimbursementLoginSourcePage.enterAmount();
      
      reimbursementLoginSourcePage.getAttachedFile();
      reimbursementLoginSourcePage.getRemark();
      reimbursementLoginSourcePage.getSave();
    //  reimbursementLoginSourcePage.clickOnEdit();
      
      //reimbursementLoginSourcePage.clickOnApproveReimbursement();
      try {
          Assert.assertTrue(bool);
          ExtentTestManager.pass("successfully login to hoppr", getDriver(),true);
      } catch (Exception e) {
          ExtentTestManager.fail(" login is not successfull", getDriver());
          Log.info(e);
          Assert.fail();
      }
   
   }

  // @Test(description = "apply reimbursement in add expensive ", priority = 2)
   
    public void addexpensive() throws Exception {
       ExtentTestManager.info("Login with valid Username Password  ");
       loginSource = (LoginSource) FatoryUtility.getObject("loginSource");
       ExtentTestManager.info("Enter valid UserName And Password");
      loginSource.loginTohoppr(ReadProperty.getProperty("userName"),ReadProperty.getProperty("password"));
      reimbursementLoginSourcePage = (ReimbursementLoginSourcePage) FatoryUtility.getObject("reimbursementLoginSourcePage");
      Thread.sleep(2000);
      bool=loginSource.isDashboardDisplayed();
      bool=loginSource.isOnBoardingDisplayed();
      reimbursementLoginSourcePage.clickOnpayroll();
      Thread.sleep(2000);
      reimbursementLoginSourcePage.clickOnReimbursement();
      
      reimbursementLoginSourcePage.clickOnApplyReimbursement();
      reimbursementLoginSourcePage.clickOnCategory();
      reimbursementLoginSourcePage.enterAmount();
      reimbursementLoginSourcePage.clickOnSave();
      reimbursementLoginSourcePage.clickOnAddExpense();
    //  reimbursementLoginSourcePage.clickOnEdit();
      
      //reimbursementLoginSourcePage.clickOnApproveReimbursement();
      
      try {
          Assert.assertTrue(bool);
          ExtentTestManager.pass("successfully login to hoppr", getDriver(),true);
      } catch (Exception e) {
          ExtentTestManager.fail(" login is not successfull", getDriver());
          Log.info(e);
          Assert.fail();
      }//
   }
}
   
  
  


