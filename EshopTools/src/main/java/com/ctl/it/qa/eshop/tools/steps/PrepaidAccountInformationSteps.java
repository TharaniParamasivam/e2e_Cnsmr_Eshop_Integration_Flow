package com.ctl.it.qa.eshop.tools.steps;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.pages.AccountInformationPage;
import com.ctl.it.qa.eshop.tools.pages.CustomerDetailsPage;
import com.ctl.it.qa.eshop.tools.pages.PrepaidAccountInformationPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class PrepaidAccountInformationSteps extends Steps {

PrepaidAccountInformationPage prepaidaccountinformationpage;
AccountInformationPage accountInformationPage;

	
private final Logger slf4jLogger = LoggerFactory.getLogger(PrepaidAccountInformationSteps.class);
	

    @Step
	public void on_Prepaid_Account_Page() {
		
		prepaidaccountinformationpage.shouldExist(prepaidaccountinformationpage,60);
		slf4jLogger.info("On PrePaid Account Information Page");
		
	}

    @Step
	public void enter_email_sms_for_Prepaid(String emailid, String smsno) {
    	String[] splitemailid=emailid.split("@");
		System.out.println("email id" + splitemailid[0] +splitemailid[1]);
    	Random rand = new Random(); 
        int rand_int = rand.nextInt(100000); 
        System.out.println("Random Number  " +rand_int);
        String Comboemailid=splitemailid[0]+rand_int+"@"+splitemailid[1];
    	prepaidaccountinformationpage.emailAddress.type(Comboemailid);
    	slf4jLogger.info("Entered emailid "+Comboemailid+ " for Prepaid Order");
    	prepaidaccountinformationpage.smsno.type(smsno);
		slf4jLogger.info("Entered sms no. "+smsno+ " for Prepaid Order");
		
	}
    @Step
	public void Continue_button_click_for_Prepaid_Order() {
    	waitABit(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
    	js.executeScript("arguments[0].scrollIntoView();", prepaidaccountinformationpage.PrepaidContinue);
//		
//    	JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
//		js1.executeScript("arguments[0].click();", prepaidaccountinformationpage.PrepaidContinue);
    	prepaidaccountinformationpage.PrepaidContinue.click();
    	
    	slf4jLogger.info("clicked on continue button in account information page");
	}

    @Step
	public void i_Make_Payement_for_Prepaid_Order(String cardname, String cardnumber, String zipcode) {
    	
    	waitABit(3000);
		prepaidaccountinformationpage.payNow.waitUntilClickable();
		prepaidaccountinformationpage.payNow.click();
		slf4jLogger.info("clicked PayNow button");
		boolean flag = prepaidaccountinformationpage.makePaymentPageText.isDisplayed();
		slf4jLogger.info("flag value =" + flag);
		Assert.assertTrue(flag);
		slf4jLogger.info("Verified payment page For Prepaid Order");	
		getDriver().switchTo().frame(0);
		slf4jLogger.info("frame switched");
		prepaidaccountinformationpage.NameOnCard.sendKeys(cardname);
		prepaidaccountinformationpage.cardNumBox.sendKeys(cardnumber);
		prepaidaccountinformationpage.expiryMonthdrpDwn.selectByIndex(5);
		prepaidaccountinformationpage.expiryYearDrpdwn.selectByIndex(5);
		prepaidaccountinformationpage.zipCodeBox.clear();
		prepaidaccountinformationpage.zipCodeBox.sendKeys(zipcode);
		prepaidaccountinformationpage.tncCheckBox.click();
		slf4jLogger.info("Filled all the card details");
		prepaidaccountinformationpage.submitBtn.click();
		slf4jLogger.info("Clicked on to submit button For Prepaid Order");
		getDriver().switchTo().defaultContent();
		slf4jLogger.info("Out of Frame : Moved default");
	}
		
		
	}


