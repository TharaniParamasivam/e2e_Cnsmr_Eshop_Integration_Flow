package com.ctl.it.qa.eshop.tools.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.eshop.tools.common.utils.GlobalVariables;
import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class CustomizeServicePage extends Page {

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade continueAgainButton;

	@FindBy(xpath = "//span[contains(text(),'Customize Services')]")
	public WebElementFacade customizeServicePage;
	
	//Nitish Pots
		@FindBy(xpath = "//a[@class='nav-link']")
		public WebElementFacade Homephoneeuipaddon;
		
		@FindBy(xpath = "//tab[@class='tab-pane active']//input[@id='0_0_items']")
		public WebElementFacade screenprotect;
		
		@FindBy(xpath = "//input[@id='0_0_items']")
		public WebElementFacade euip_1;
		
		@FindBy(xpath = "//input[@id='0_1_items']")
		public WebElementFacade euip_2;
		
		@FindBy(xpath = "//input[@id='0_2_items']")
		public WebElementFacade euip_3;
		
		@FindBy(xpath = "//div[@class='accordion-toggle']//span[contains(text(),'Listing')]")
		public WebElementFacade listingToggle;
		
		@FindBy(xpath = "//select[@formcontrolname='selectedOption']")
		public WebElementFacade listingOptionsdrpDown;

		@FindBy(xpath = "//button[contains(text(),'OK, Got it')]")
	    public WebElementFacade OrderdisclosuresAccept;
				
		///////////// PORT TN   ac31339
		@FindBy(xpath = "// input [@formcontrolname='PortingNumber']")
	    public WebElementFacade port_number;
		
		@FindBy(xpath = "//input[@value='yes']")
	    public WebElementFacade radio_yes;
		
		@FindBy(xpath = "//input[@value='no']")
		public WebElementFacade radio_no;
		
		@FindBy(xpath = "// button [contains (text(),'Confirm TN')]")
	    public WebElementFacade btn_confirm_tn;
		
		@FindBy(xpath = "// button [contains(text(),'Verified')]")
		public WebElementFacade btn_verified;
		
		@FindBy(xpath = "// button [contains(text(),'Start Over')]")
		public WebElementFacade btn_start_over;

		@FindBy(xpath = "//img[contains(@src,'loading_large')]")
		public WebElementFacade img_large_loader;

		
		
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return customizeServicePage;
	}
}
