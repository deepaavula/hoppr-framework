package com.hoppr.login;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hoppr.genericutils.Basepage;

public class LoginPageObjects extends Basepage {

	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	private WebElement userName;
	
	@FindBy(xpath = "//body/div[@id='root']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]/span[1]")
	private WebElement onBoarding;
	
	@FindBy(xpath = "//span[contains(text(),'Payroll')]")
	private WebElement payroll;
	
	@FindBy(xpath = "//span[text()='Reimbursement']")
	private WebElement reimbursement;
	
	@FindBy(xpath = "//span[text()='Approve Reimbursement')]")
	private WebElement approveReimbursement;
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Your Password?')]")
	private WebElement forgotPassword;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailadress;

	@FindBy(xpath = "//button[contains(text(),'Send Password Reset Link')]")
	private WebElement sendPasswordResetLink;
	
	@FindBy(xpath = "//div[contains(text(),'We have e-mailed your password reset link!')]")
	private WebElement successMessage;
	
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement Dashboard;
	
	
	
	@FindBy(xpath = "//body/div[@id='root']/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")
	private WebElement filter;
	
	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]/span[1]")
	private WebElement employeeProfile;
	
	@FindBy(xpath = "//span[contains(text(),'Apply Reimbursement')]")
	private WebElement applyReimbursement;
	
	@FindBy(xpath = "//span[contains(text(),'Edit')]")
	private List<WebElement>edit;
	
	@FindBy(xpath = "//div[@id='category']")
	private WebElement category;
	
	@FindBy(xpath = "//label[contains(text(),'Amount')]")
	private WebElement amount;
	
	@FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
	private WebElement date;
	
	@FindBy(xpath = "//label[text()='Description']")
	private WebElement description;
	
	@FindBy(xpath = "//input[@id='contained-button-file']")
	private WebElement attachedFile;
	
	@FindBy(xpath = "//label[text()='Remark']")
	private WebElement remark;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//button[text()='Back']")
	private WebElement back;
	
	@FindBy(xpath = "//button[text()=' Close']")
	private WebElement close;
	
	
	
	
	
	
	
	
	
	
	
	
	

	public WebElement getBack() {
		return back;
	}



	public WebElement getClose() {
		return close;
	}



	public List<WebElement> getEdit() {
		return edit;
	}



	public WebElement getDescription() {
		return description;
	}



	public WebElement getAttachedFile() {
		return attachedFile;
	}



	public WebElement getRemark() {
		return remark;
	}



	public WebElement getSubmit() {
		return submit;
	}



	public WebElement getReimbursement() {
		return reimbursement;
	}

	

	

	public WebElement getCategory() {
		return category;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getApplyReimbursement() {
		return applyReimbursement;
	}

	public WebElement getPayroll() {
		return payroll;
	}

	

	public WebElement getApproveReimbursement() {
		return approveReimbursement;
	}

	public WebElement getEmployeeProfile() {
		return employeeProfile;
	}

	public WebElement getOnBoarding() {
		return onBoarding;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getDashboard() {
		return Dashboard;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getDashBoard() {
		return Dashboard;
	}

	public WebElement getEmailadress() {
		return emailadress;
	}

	public WebElement getSendPasswordResetLink() {
		return sendPasswordResetLink;
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	

	

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getForgotPassword() {
		return forgotPassword;
	}

	

	

}