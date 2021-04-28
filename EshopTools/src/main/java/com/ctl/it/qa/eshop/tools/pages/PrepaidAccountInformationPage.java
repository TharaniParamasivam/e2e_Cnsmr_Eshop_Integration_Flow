package com.ctl.it.qa.eshop.tools.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public  class PrepaidAccountInformationPage extends Page{

	
	@FindBy(xpath="//div[contains(text(),'PrePaid Account Information')]")
	public WebElementFacade Prepaid_Account_Label;
	
	@FindBy(xpath="//input[@name='emailAddress']")
	public WebElementFacade emailAddress;
	
	@FindBy(xpath="//input[@name='smsNumber']")
	public WebElementFacade smsno;
	
	@FindBy(xpath="//label[contains(text(),'Username')]/following-sibling::div/span/input")
	public WebElementFacade username_input;
	
	@FindBy(xpath = "//input[@title='Month']")
	public WebElementFacade monthDB;

	@FindBy(xpath = "//input[@title='Day']")
	public WebElementFacade dayDB;

	@FindBy(xpath = "//input[@title='Year']")
	public WebElementFacade yearDB;
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade PrepaidContinue;
	
	@FindBy(xpath="//button[contains(text(),'Pay Now')]")
    public WebElementFacade payNow;
	
	@FindBy(xpath="//*[contains(text(),'Make a Payment')]")
	public WebElementFacade makePaymentPageText;
	
	@FindBy(id="NameOnCard")
	public WebElementFacade NameOnCard;
	
	@FindBy(name="cardNum")
	public WebElementFacade cardNumBox;
	
	@FindBy(id="expiryMonth")
	public WebElementFacade expiryMonthdrpDwn;
	
	@FindBy(id="expiryYear")
	public WebElementFacade expiryYearDrpdwn;
	
	@FindBy(name="cardZip")
	public WebElementFacade zipCodeBox;
	
	@FindBy(id="TermsAndCon")
	public WebElementFacade tncCheckBox;
	
	@FindBy(id="ValidatePaymentInfo")
	public WebElementFacade nextButton;
	
//	@FindBy(id="submitCard")
//	public WebElementFacade submitBtn;
	
	@FindBy(id="submitPayment")
	public WebElementFacade submitBtn;
	
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return Prepaid_Account_Label;
	}

}
