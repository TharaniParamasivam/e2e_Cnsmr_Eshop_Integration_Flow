package com.ctl.it.qa.eshop.tools.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class OrderSummaryPage extends Page{

	@FindBy(id = "selectYes")
	public WebElementFacade selectYes;

	@FindBy(xpath = "//button[contains(text(),'Submit Order')]")
	public WebElementFacade submitOrder;

	/*@FindBy(xpath = "//h2[contains(text(),'Order Submitted')]")
	public WebElementFacade orderSubmittedverification;*/
	
	@FindBy(xpath = "(//h2)[1]")
	public WebElementFacade orderSubmittedverification;
	
	@FindBy(xpath = "//textarea[@title='Remarks']")
	public WebElementFacade remarks;

	@FindBy(xpath = "//span[@class='notes-received']")
	public WebElementFacade notes;
	
	@FindBy(xpath="//p[strong[text()='Order Number']]")
	public WebElementFacade orderNumberText;
	
	@FindBy(xpath="//p[strong[text()='Account Number']]")
	public WebElementFacade accountNumberText;
	
	@FindBy(xpath="//p[contains(text(),'Activation date & appointment ')]")
	public WebElementFacade activationDate;
	
	@FindBy(xpath="//p[contains(text(),'Service Address ')]")
	public WebElementFacade serviceAddress;
	
	//Nitish
		@FindBy(xpath="//button[contains(text(),'Start New Order')]")
		public WebElementFacade neworder;
		
		@FindBy(xpath = "(//input[@name='number'])[1]")
		public WebElementFacade accnumrbn;
				
		@FindBy(xpath = "//input[@id='accountNumber']")
		public WebElementFacade existsaaccnumr;
			
		@FindBy(xpath = "//strong[contains(text(),'Additional Order Remarks')]/following::textarea")
		public WebElementFacade Additional_Order_Remarks;
		
		@FindBy(xpath = "//button[contains(text(),'View RCCs > ')]")
		public WebElementFacade btn_View_RCCs;

		@FindBy(xpath = "//button[contains(text(),'Acknowledge')]")
		public WebElementFacade btn_Acknowledge; 
		
		@FindBy(xpath = "//h2[contains(text(),'Order Summary')]")
		public WebElementFacade lbl_Order_Summary; 
		
		@FindBy(xpath = "//button[text()='Acknowledge RCCs']")
		public WebElementFacade btn_Acknowledge_RCCs; 
		
		@FindBy(xpath = "//span[text()='Still must Acknowledge RCCs']")
		public WebElementFacade lbl_Still_Acknowledge_RCCs; 
		
		@FindBy(xpath = "//span[text()='Close']")
		public WebElementFacade btn_RCCs_Close; 
		
		@FindBy(xpath = "//span[text()='Acknowledged']")
		public WebElementFacade lbl_Still_Acknowledged_RCCs;
		
		@FindBy(xpath = "//td[text()='Confirmation Letter']")
		public WebElementFacade lbl_Review_RCCs;
		
		@FindBy (xpath = "(//Strong)[3]")
		public WebElementFacade Product_label;
		
		@FindBy (xpath = "//select[@name='Environment']")
		public WebElementFacade Environment;
		
		@FindBy (xpath = "//input[@type='text']")
		public WebElementFacade Order_number;
				
		@FindBy (xpath = "//input[@type='submit']")
		public WebElementFacade Submit;
		
	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return btn_View_RCCs;
	}


}
