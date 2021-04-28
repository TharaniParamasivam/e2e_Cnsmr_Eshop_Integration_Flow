package com.ctl.it.qa.eshop.tools.steps;

//import org.apache.tools.ant.taskdefs.Expand;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.pages.AccountInformationPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class AccountInformationSteps extends Steps{

	private final Logger slf4jLogger = LoggerFactory.getLogger(AccountInformationSteps.class);

	AccountInformationPage accountInformationPage;
	
	@Step
	public void emailDeclineClick() throws InterruptedException {
		accountInformationPage.shouldExist(accountInformationPage,120);
		accountInformationPage.emailDeclines.click();
		slf4jLogger.info("Email check decline");
	}

	@Step
	public void dateOfBirth(String date,String month,String Year) throws InterruptedException {
		waitABit(2000);
		accountInformationPage.monthDB.sendKeys(date);
		accountInformationPage.dayDB.sendKeys(date);
		accountInformationPage.yearDB.sendKeys(Year);
//		accountInformationPage.yearDB.click();
//		waitABit(1000);
		slf4jLogger.info("Entered date,month and year in DOB");
	}

	@Step
	public void creditCheck(String args) {
        if(args.equalsIgnoreCase("Yes")) {
        	waitABit(5500);
        	accountInformationPage.creditCheckYes.click();
        	slf4jLogger.info("selected credit check as Yes");
        }
        else if(args.equalsIgnoreCase("No")) {
        	waitABit(5500);
        	accountInformationPage.creditCheckNo.click();
        	slf4jLogger.info("selected credit check as NO");
        }
        else if(args.equalsIgnoreCase("Bypass Credit Check")) {
        	waitABit(5500);
			accountInformationPage.Bypass_Credit_Check.click();
			slf4jLogger.info("selected credit check as Bypass Credit Check");
		}

 }


	@Step
	public void clickAccountInfoContinue() throws InterruptedException {
		WaitForPageToLoad(100);
		accountInformationPage.clickContinue.click();
		slf4jLogger.info("clicked on continue button in account information page");
		if(accountInformationPage.validate_customer_info.isCurrentlyEnabled()) {
	    	accountInformationPage.validate_customer_info.waitUntilClickable();
			accountInformationPage.validate_customer_info.click();
			slf4jLogger.info("Validated Customer Credit Information");
	    }
		
	}

	@Step
	public void ssnDetails(String ssn) throws InterruptedException {
		WaitForPageToLoad(120);
		accountInformationPage.ssn.sendKeys(ssn);
		slf4jLogger.info("Entered SSN number");
	}
	
	@Step
	public void payNowCredit() throws InterruptedException{
		accountInformationPage.payNow.waitUntilClickable();
		accountInformationPage.payNow.click();
		slf4jLogger.info("clicked PayNow button");
    }

	@Step
	public void verifyage() throws InterruptedException{
		String ageMessage = accountInformationPage.lessAgePopup.getText();
		boolean flag = ageMessage.contains("Applicant less than 18 yrs old");
		Assert.assertTrue(flag);
		slf4jLogger.info("clicked PayNow button");
    }

	public void clickAgainAfterPaymentAccountInfoContinue() {
		try {
			waitABit(15000);
			boolean Paymentflag = accountInformationPage.payment_location.isCurrentlyVisible();
			slf4jLogger.info("value Paymentflag    "+Paymentflag);
			if (Paymentflag) {	
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].click();", accountInformationPage.clickContinue);
				slf4jLogger.info("clicked on continue button in account information page on try block for Payment Deposits");
			}
			else {	
					boolean nodepositflag = accountInformationPage.info_nodeposit.isDisplayed();
					slf4jLogger.info("value no deposits    "+nodepositflag);
					if (nodepositflag) {
						JavascriptExecutor js = (JavascriptExecutor) getDriver();
						js.executeScript("arguments[0].click();", accountInformationPage.clickContinue);
						slf4jLogger.info("clicked on continue button in account information page on try block for Non Payment Deposit");
				}			
			}
		} catch (Exception e) {
			/*waitABit(5000);
			Actions actions = new Actions(getDriver());
			actions.moveToElement(accountInformationPage.clickContinue).click();
			actions.build().perform();*/
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].click();", accountInformationPage.clickContinue);
			slf4jLogger.info("clicked on continue button in account information page on catch block");
		}
	}
	@Step
	public void i_enter_email_and_sms_contacts(String email, String sms) {
		accountInformationPage.emailAddress.type(email);
		accountInformationPage.smsno.type(sms);
		slf4jLogger.info("Entered emailid and sms no.");
	}

	@Step
	public void change_billing_address(String datapassed) {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", accountInformationPage.Change_Billing_Address);
		accountInformationPage.add_info.sendKeys("attn Deana Pillot");
		accountInformationPage.Select_street.selectByIndex(1);
		accountInformationPage.Street_address.sendKeys("555 LAKE BORDER DR");
		accountInformationPage.city.sendKeys("APOPKA");
		accountInformationPage.Select_state.selectByVisibleText("Florida");
		accountInformationPage.zipcode.sendKeys("32703");
		waitABit(3000);
		accountInformationPage.validate.click();
		waitABit(5000);
		accountInformationPage.save_billing_address.click();
		
		slf4jLogger.info("Billing address changed to -- "+datapassed);
	}
	
	//ac31339  prequalify directtv order 
	@Step
	public void lauchOpus() throws InterruptedException{
		accountInformationPage.btn_launch_opus.click();
		slf4jLogger.info("clicked Launch Opus button");
    }

	@Step   // 
	public void prqualify_directtv_order() throws InterruptedException{
		waitABit(20000);
		accountInformationPage.radio_located_retail.click();
		slf4jLogger.info("clicked Retail radio button");
		waitABit(1000);
		accountInformationPage.select_location.selectByIndex(1);
		slf4jLogger.info("Selected value from location dropdown");
		waitABit(3000);
		accountInformationPage.radio_customer_ctl_employee.click();
		slf4jLogger.info("Clicked  No from radio button");
		waitABit(1000);
		accountInformationPage.btn_continue_location.click();
		slf4jLogger.info("Clicked  continue button on Prequalified Direct TV window");
		waitABit(3000);
		
    }
	
}
