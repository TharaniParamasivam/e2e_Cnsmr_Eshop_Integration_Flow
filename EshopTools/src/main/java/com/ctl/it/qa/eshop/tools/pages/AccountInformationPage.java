package com.ctl.it.qa.eshop.tools.pages;


import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class AccountInformationPage extends Page {

	@FindBy(xpath = "//input[@id='decline-email' and @type='checkbox']/following-sibling::label")
	public WebElementFacade emailDeclines;

	@FindBy(xpath = "//input[@title='Yes' and @name='usercheck']")
	public WebElementFacade creditCheckYes;

	@FindBy(xpath = "//input[@title='Month']")
	public WebElementFacade monthDB;

	@FindBy(xpath = "//input[@title='Day']")
	public WebElementFacade dayDB;

	@FindBy(xpath = "//input[@title='Year']")
	public WebElementFacade yearDB;

	@FindBy(xpath = "//input[@title='SSN']")
	public WebElementFacade ssn;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade clickContinue;
	
	@FindBy(xpath="//button[contains(text(),'Pay Now')]")
    public WebElementFacade payNow;
	
	@FindBy(xpath="//input[@title='No']")
    public WebElementFacade creditCheckNo;

	@FindBy(xpath="//div[text()='Applicant less than 18 yrs old']")
	public WebElementFacade lessAgePopup;
	
	// Nitish
		@FindBy(xpath="//input[@name='emailAddress']")
		public WebElementFacade emailAddress;
		
		@FindBy(xpath="//input[@name='smsNumber']")
		public WebElementFacade smsno;
	// UAT Billing Address
		

		
		@FindBy(xpath="//a[contains(text(),'Change Billing Address')]")
		public WebElementFacade Change_Billing_Address;
		
		@FindBy(xpath="(//select[@name='address type'])[1]")
		public WebElementFacade Select_street;
		
		@FindBy(xpath="(//strong[contains(text(),'Additional Info (optional)')]/following::div/div/input)[1]")
		public WebElementFacade add_info;
		
		@FindBy(xpath="(//strong[contains(text(),'Additional Info (optional)')]/following::div/div/input)[2]")
		public WebElementFacade Street_address;
		
		@FindBy(xpath="(//strong[contains(text(),'Additional Info (optional)')]/following::div/div/input)[4]")
		public WebElementFacade city;
		
		@FindBy(xpath="(//strong[contains(text(),'Additional Info (optional)')]/following::div/div/input)[5]")
		public WebElementFacade zipcode;
		
		@FindBy(xpath="(//select[@name='address type'])[2]")
		public WebElementFacade Select_state;
		
		@FindBy(xpath="//button[contains(text(),'Validate')]")
		public WebElementFacade validate;
		
		@FindBy(xpath="//button[contains(text(),'Save Billing Address')]")
		public WebElementFacade save_billing_address;
		
		// UAT Billing Address
		
		@FindBy(xpath="//button[contains(text(),'is correct')]")
		public WebElementFacade validate_customer_info;

		@FindBy(xpath="//strong[contains(text(),'No deposit required')]")
		public WebElementFacade info_nodeposit;
		
		@FindBy(xpath="//a[contains(text(),'Find payment location')]")
		public WebElementFacade payment_location;
		
		//ac31339  launch opus button /////////
		@FindBy(xpath="//button[contains(text(),'Launch OPUS')]")
		public WebElementFacade btn_launch_opus;
		
		@FindBy(xpath="//label[contains(text(),'Retail')]")
		public WebElementFacade radio_located_retail;
		
		@FindBy(xpath="(//input[@name='ctlemployee'])[2]")
		public WebElementFacade radio_customer_ctl_employee; // No Radio Button Selected
		
		@FindBy(xpath="//select[@name='selectedLocation']")
		public WebElementFacade select_location;
		
		@FindBy(xpath="(//button[contains(text(),'Continue')])[2]")
		public WebElementFacade btn_continue_location;
		
		@FindBy(xpath = "//label[contains(.,'Bypass Credit Check')]")
		public WebElementFacade Bypass_Credit_Check;
		
	@Override
	public WebElementFacade getUniqueElementInPage() {
		
		return ssn;
	}	


	
}
