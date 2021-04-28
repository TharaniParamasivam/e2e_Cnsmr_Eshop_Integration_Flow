package com.ctl.it.qa.eshop.tools.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindAll;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ctl.it.qa.eshop.tools.common.utils.GlobalVariables;
import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

@SuppressWarnings("unused")
public class CustomerDetailsPage extends Page {

	@FindAll({		
		@FindBy(xpath = "//input[@id='firstName']"),
	    @FindBy(xpath = "//span[contains(text(),'Accounts')]")
	})
	public WebElementFacade firstNam;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElementFacade lastNam;

	@FindBy(id = "phoneNumber")
	public WebElementFacade phoneNum;

	@FindBy(xpath = "//input[@id='address']")
	public WebElementFacade showAddress;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElementFacade LetsGoButton;

	@FindBy(xpath = "//div[text()='No Results Found']")
	public WebElementFacade noMatchFoudText;

	@FindBy(xpath = ".//*[@id='addressLine']")
	public WebElementFacade street;

	@FindBy(xpath = ".//*[@id='floor']")
	public WebElementFacade unit;

	@FindBy(xpath = ".//*[@id='state']")
	public WebElementFacade state;

	@FindBy(xpath = ".//*[@id='city']")
	public WebElementFacade city;

	@FindBy(xpath = ".//*[@id='zipCode']")
	public WebElementFacade zipcode;

	@FindBy(xpath = "html/body/app/main/ctl-home/address/section/div/div[1]/div/form/div[2]/div/div/div[3]/div[1]/a")
	public WebElementFacade showalladdress;

	@FindBy(xpath = "html/body/app/main/multiplematchaddress/section/div/div/div/form/div[2]/div/div[3]/div[2]/div/ul/li[1]/label/input")
	public WebElementFacade selectradiobtn;

	@FindBy(xpath = "//button[@class='btn btn-primary activeBtn']")
	public WebElementFacade continuebtn;
//Nitish
	
	@FindBy(xpath = "//a[contains(text(),'Account or Order already exists')]")
	public WebElementFacade orderexists;
	
	@FindBy(xpath = "//a[contains(text(),'Start New Customer Order')]")
	public WebElementFacade newcustomer;	
	
	@FindBy(xpath = "(//input[@name='number'])[1]")
	public WebElementFacade accnumrbn;
			
	@FindBy(xpath = "//input[@id='accountNumber']")
	public WebElementFacade existsaaccnumr;
	
	
	@FindBy(xpath="//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']")
	public WebElementFacade btn_existacctclose;
	
	
	@FindBy(xpath="//input[@name='sessionCaller'])[1]")
	public WebElementFacade tbx_Interaction_Log_Caller_Name_Entry;
	
	@FindBy(xpath="//input[@class='slds-input slds-combobox__input'])[3]")
	public WebElementFacade select_Interaction_Log_subject;
	
	@FindBy(xpath="//input[@class='slds-input slds-combobox__input'])[2]")
	public WebElementFacade select_Interaction_Log_Reason_For_Call;
	
	@FindBy(xpath="//input[@class='slds-input slds-combobox__input'])[4]")
	public WebElementFacade select_Interaction_Log_Call_Disposition;
		
	@FindBy(xpath="//input[@class='slds-input slds-combobox__input'])[4]")
	public WebElementFacade select_Interaction_Log_Call_Disposition_Reason;
	
	
	@FindBy(xpath="//textarea[@name='descriptionValue'])[1]")
	public WebElementFacade txt_Interaction_Log_Action;
	
	@FindBy(xpath="//button[contains(text(),'Save')])[1])")
	public WebElementFacade btn_Interaction_Log_Save;
	
	@FindBy(xpath="//h2[@class='slds-text-heading_small'][contains(.,'The save was successful!')]")
	public WebElementFacade lbl_Interaction_Log_success_message;
	
	@FindBy(xpath="//button[@title='Yes']")
	public WebElementFacade btn_Interaction_Log_Yes;
	
			
	/**
	 * 
	 * ALL Below code Commented and will be removed Later as its belongs to SFC CONSOLE
	 */
	//Prem SFC Integeration Starts 
//	
//		@FindBy(xpath = "//input[@value='New Account']")
//		public WebElementFacade btn_createnew;
//		
//		@FindBy(xpath = "//img[@title='Account']")
//		public WebElementFacade link_account;
//		
//		@FindBy(xpath = "//input[contains(@id,'AccFirstName')]")
//		public static WebElementFacade tbx_account_first_name;
//		
//		@FindBy(xpath = "//input[contains(@id,'AccLastName')]")
//		public static WebElementFacade tbx_account_last_name;
//		
//		@FindBy(xpath = "//input[contains(@id,'AccPhone')]")
//		public static WebElementFacade tbx_phone_number;
//		
//		@FindBy(xpath = "//input[contains(@autocomplete,'street-address')]")
//		public static  WebElementFacade tbx_address_field;
//		
//		@FindBy(xpath = "//input[@value='Validate Address']")
//		public static WebElementFacade btn_validate_address;
//
//		@FindBy(css = "input[value = 'Save']")
//		public static WebElementFacade btn_save;
//		
//		@FindBy(xpath = "//span[@title='Close']")
//		public static WebElementFacade btn_close;
//		
//		@FindBy(xpath = "(//input[@value='Order (ESHOP)'])[1]")
//		public static WebElementFacade btn_order_eshop;
//
//		//Prem SFC Integeration Ends 
//		
//		
//		@FindBy(xpath = "//div[text()='Drag Footer Components Here']")
//		public WebElementFacade lbl_drag_footer_component_here;
//
//		@FindBy(xpath = "//span[text()='Close all primary tabs']")
//		public WebElementFacade lnk_close_all_primary_tabs;
//
//		@FindBy(xpath = "//span[text()='Pop out primary tabs']")
//		public WebElementFacade lnk_pop_out_primary_tabs;
//		
//		@FindBy(xpath = "(//div[@class='x-tab-tabmenu-right'])[1]")
//		public WebElementFacade btn_right_tab_menu;
//
//		@FindBy(xpath = "//span[contains(text(),'Accounts')]")
//		public WebElementFacade btn_account; 
//		
//		@FindAll({		
//			@FindBy(xpath = "//div[contains(text(),'Address & TN Live Help')]"),
//			@FindBy(xpath = "//a[contains(text(),'Address & TN Live Help')]")
//		})
//		public WebElementFacade address_avail_flag;
//				
//		@FindBy(xpath = "//select[@id='pageId:formId:pblock:FullAddr:SrPR:primaryResidence']")
//		public WebElementFacade select_own_house;	
	/**
	 * Xpaths Updated with SFC Lightning Version - Nitish
	 */
	@FindBy(xpath = "(//span[contains(text(),'Accounts')])[2]")
	public WebElementFacade btn_account;
	
	@FindBy(xpath = "//div[@title='New']")
	public WebElementFacade btn_createnew;
	
	@FindBy(xpath = "//div[@class='slds-context-bar__icon-action']/button")
	public WebElementFacade select_Account_dropdown;
	
	@FindBy(xpath = "(//span[contains(.,'Accounts')])[2]")
//	@FindBy(xpath = "(//span[contains(text(),'Accounts')])[2]")
	public WebElementFacade link_account;

	@FindBy(xpath = "(//*[contains(text(),'First Name')]/following::input)[1]")
	public  WebElementFacade tbx_account_first_name;

	@FindBy(xpath = "(//*[contains(text(),'First Name')]/following::input)[2]")
	public  WebElementFacade tbx_account_last_name;

	@FindBy(xpath = "(//*[contains(text(),'First Name')]/following::input)[3]")
	public  WebElementFacade tbx_phone_number;
	
	@FindBy( xpath = "(//*[contains(text(),'First Name')]/following::input)[5]")
	public WebElementFacade tbx_Email;
	
	@FindBy(xpath = "(//*[contains(text(),'First Name')]/following::input)[6]")
	public  WebElementFacade tbx_address_field;

	@FindBy(xpath = "(//input[@placeholder='Select an Option']") 
	public WebElementFacade select_an_option;

	@FindBy(xpath = "*//span[contains(text(),'Own')]")
	public WebElementFacade select_own_house;	
	
	@FindBy(xpath = "(//*[contains(text(),'First Name')]/following::input)[7]/following::button[2]")
	public  WebElementFacade btn_validate_address;

	@FindBy(xpath = "(//*[contains(text(),'First Name')]/following::input)[7]/following::button[1]")
	public  WebElementFacade btn_save;

	@FindBy(xpath = "(//button[contains(text(),'Order (eShop)')])[3]")
	public WebElementFacade btn_order_eshop;  
	
	@FindBy(xpath = "(//*[contains(text(),'First Name')]/following::input)[7]")
	public WebElementFacade ownorrent;


		
	@Override
	public WebElementFacade getUniqueElementInPage() {
		return firstNam;
	}

}
