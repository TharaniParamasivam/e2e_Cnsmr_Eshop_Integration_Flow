package com.ctl.it.qa.eshop.tools.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class SchedulingPage extends Page{


	@FindBy(xpath = "//*[@id='calImg']")
	public WebElementFacade datePickerD;

	@FindBy(xpath = "//datepicker[@class='ng-untouched ng-valid ng-dirty']")
	public WebElementFacade datePickerCalendar;

	@FindBy(xpath = "//*[@id='datepicker--281-11']/button/span")
	public WebElementFacade dateToPick;

	@FindBy(xpath = "//button[contains(text(),'Assign Date')]")
	public WebElementFacade assignToDate;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	public WebElementFacade continueInCalendar;

	@FindBy(xpath="//h3[text()='Earliest available appointment']")
	public WebElementFacade earliestAppointmentText;

	@FindBy(xpath="//button[contains(text(),'Reserve It')]")
	public WebElementFacade reserveBtn;

	@FindBy(id="weekCalText")
	public WebElementFacade reservableAppoitmentDate;

	@FindBy(xpath="//label[contains(text(),'Due Date')]/following-sibling::div[1]/label")
	public WebElementFacade updatedDueDate;

	@FindBy(xpath="//*[@title='Driving Directions']")
	public WebElementFacade driverComment;

	@FindBy(xpath="//*[@title='Additional Comments']")
	public WebElementFacade additionalComment;

	@FindBy(xpath="//div[label[contains(text(),'Due Date')]]/div[1]/label")
	public WebElementFacade duteDateTxt;

	//Shaik

	@FindBy(xpath="//label[@id='weekCalText']")
	public WebElementFacade appointment;

	@FindBy(xpath="//span[contains(@class,'weekinfo')]")
	public WebElementFacade txt_appointdate;

	@FindBy(xpath="//button[contains(text(),'Reserve It')]")
	public WebElementFacade btn_ReserveIt_WeeklyCal;

	@FindBy(xpath="//img[contains(@class,'cursor-pointer') and contains(@src,'right')]")
	public WebElementFacade btn_rightArrow_WeeklyCal;

	@FindBy(xpath="//img[@id='calImg']//parent::div")
	public WebElementFacade btn_Due_Date_POTS;

	@FindBy(xpath="//button[text()='Assign Date']")
	public WebElementFacade btn_Assign_Date_POTS_Only;
	
	@FindBy(xpath="(//button//i)[2]")
	public WebElementFacade btn_Right_Arrow_POTS_Only;
	
	@FindBy(xpath="//button[contains(@id,'datepicker')]")
	public WebElementFacade txt_Appointment_Date;
	
	@FindBy(xpath = "//button[contains(text(),'OK, Got it')]")
	public WebElementFacade OrderdisclosuresAccept;
//AC64192
	@FindBy(xpath = "//a[@id='changeAddress']")
    public WebElementFacade    changeBillingAddressLink;
	
	@FindBy(xpath="//button[contains(text(),'Validate')]")
    public WebElementFacade validateButton;
	
	
	@FindBy(xpath="//button[contains(text(),'Ship to this Address')]")
    public WebElementFacade shipToThisAddress;
	
	
	
	//button[contains(text(),'Continue')][2]

	@Override
	public WebElementFacade getUniqueElementInPage() {
		return (WebElementFacade) continueInCalendar;
	}


}
