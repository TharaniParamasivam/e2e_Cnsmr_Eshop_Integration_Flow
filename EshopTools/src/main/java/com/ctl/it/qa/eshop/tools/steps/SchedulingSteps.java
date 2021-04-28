package com.ctl.it.qa.eshop.tools.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.pages.SchedulingPage;
import com.ctl.it.qa.staf.Steps;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class SchedulingSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(SchedulingSteps.class);

	SchedulingPage schedulingPage;
	public static String actualDueDate;

	public void dueDateSelection() {

		schedulingPage.datePickerD.click();

		schedulingPage.assignToDate.click();
		slf4jLogger.info("Clicked on assign date");

	}

	public void clickOnContinue() {

		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", schedulingPage.continueInCalendar);
		slf4jLogger.info("Clicked on continue calendar button");
		waitABit(3000);
		if(schedulingPage.OrderdisclosuresAccept.isCurrentlyVisible()) {
			schedulingPage.OrderdisclosuresAccept.click();
			slf4jLogger.info("Clicked on OK, Got it on Order Discolosures pop up");
		}
	}

	public void verifyEarliestAppoitmentText() {
		schedulingPage.shouldExist(schedulingPage, 90);
		boolean flag = schedulingPage.earliestAppointmentText.getText().contains("Earliest available appointment");
		Assert.assertTrue(flag);
		slf4jLogger.info("Verified earliest appointment date");
	}

	public void reserveAppointment() {
		schedulingPage.shouldExist(schedulingPage, 150);
		try{
		((JavascriptExecutor) getDriver()).executeScript("scroll(0,250);");
		if(schedulingPage.reserveBtn.isDisplayed()){	
			slf4jLogger.info("Reserve button click1");
			schedulingPage.reserveBtn.click();
			slf4jLogger.info("Clicked on reserve button");
		}}
		
		catch(Exception e){
		
		
			slf4jLogger.info("Reserve button is not available Just click and Continue");
		
	} }


	public void verifyDueDateUpdate() {
		String[] reservableDueDate = schedulingPage.reservableAppoitmentDate.getText().split(" ");
		String updatedDueDateText = schedulingPage.updatedDueDate.getText();
		boolean flag = updatedDueDateText.contains(reservableDueDate[1].substring(0, 3))
				&& updatedDueDateText.contains(reservableDueDate[2].substring(0, 1));
		Assert.assertTrue(flag);
		slf4jLogger.info("Verified due date updated or not");
	}

	public void DriverComments(String driverComment) {

		schedulingPage.driverComment.sendKeys(driverComment);

	}

	public void AdditionalComments(String addComment) {

		schedulingPage.additionalComment.sendKeys(addComment);

	}

	public void getDueDate() throws InterruptedException {
		actualDueDate = schedulingPage.duteDateTxt.getText();
	}

	public void enterdate(String passedDate) {

		String month=passedDate.substring(0, 3);
//		String date=passedDate.substring(3, 5);
		
		char[] ch = passedDate.toCharArray();
		StringBuilder stbuilder = new StringBuilder();
		for(char c : ch){
			if(Character.isDigit(c)){
				System.out.println(c);
				stbuilder=stbuilder.append(c);
			}
		}
		String date=stbuilder.toString();


//		schedulingPage.shouldExist(schedulingPage, 120);
		((JavascriptExecutor) getDriver()).executeScript("scroll(0,250);");
		waitABit(3000);
//		schedulingPage.appointment.click();
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();",schedulingPage.appointment);
		waitABit(3000);
		select_date(month,date);   // Oct or Nov

		slf4jLogger.info("Appointment is selected successfully");



	}

	public void select_date(String mnt, String date){

		String UI_Date = schedulingPage.txt_appointdate.getText();

		if(UI_Date.contains(mnt)){
			select_date(date);   
		}else{
			while(!UI_Date.contains(mnt)){
//				schedulingPage.btn_rightArrow_WeeklyCal.click();
				JavascriptExecutor js = (JavascriptExecutor)getDriver();
				js.executeScript("arguments[0].click();",schedulingPage.btn_rightArrow_WeeklyCal);
				waitABit(50);
				UI_Date = schedulingPage.txt_appointdate.getText();
			}
			select_date(date);
		} 
	}

	public void select_date(String date){
		String CellDate= null;
		do{
			for(int i=1; i<=7;i++){
				CellDate = getDriver().findElement(By.xpath("//table/thead/tr/th["+i+"]/div[2]")).getText();
				// System.out.println(CellDate+"  "+date);
				if(CellDate.equals(date)){ 
					getDriver().findElement(By.xpath("//table/tbody/tr[1]/td["+i+"]")).click();
					waitABit(4000);
					schedulingPage.btn_ReserveIt_WeeklyCal.click();
					waitABit(2000);
//					if(getDriver().findElement(By.xpath("//div[contains(text(),'Please select timeslot!!!')]")).isDisplayed()){
//						getDriver().findElement(By.xpath("//table/tbody/tr[1]/td["+i+"]")).click();
//						schedulingPage.btn_ReserveIt_WeeklyCal.click();
//					}
					break;
				}else if(i==7)
				{
//					schedulingPage.btn_rightArrow_WeeklyCal.click();
					JavascriptExecutor js = (JavascriptExecutor)getDriver();
					js.executeScript("arguments[0].click();",schedulingPage.btn_rightArrow_WeeklyCal);
					waitABit(5000);
				}
			}
		}while(!CellDate.equals(date));

	}

	/**
	 * Step to Enter Due date for POTS only in Scheduling page
	 */
	@Step
	public void enterDateForPOTSOnly(String passedDate) {

		String month=passedDate.substring(0, 3);
//		String date=passedDate.substring(3, 5);
		char[] ch = passedDate.toCharArray();
		StringBuilder stbuilder = new StringBuilder();
		for(char c : ch){
			if(Character.isDigit(c)){
				System.out.println(c);
				stbuilder=stbuilder.append(c);
			}
		}
		String date=stbuilder.toString();
		
		((JavascriptExecutor) getDriver()).executeScript("scroll(0,250);");
		waitABit(10000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();",schedulingPage.btn_Due_Date_POTS);
//		schedulingPage.btn_Due_Date_POTS.click();
		waitABit(2000);
		select_date_For_POTS_Only(month,date); 
		slf4jLogger.info("Appointment is selected successfully");
	}

	/**
	 * Method to select Due date for POTS only in Scheduling page
	 */
	public void select_date_For_POTS_Only(String mnt, String date){

		String UI_Date = schedulingPage.txt_Appointment_Date.getText();

		if(UI_Date.contains(mnt)){
			select_date_For_POTs(date);   
		}else{
			while(!UI_Date.contains(mnt)){
				schedulingPage.btn_Right_Arrow_POTS_Only.click();
				waitABit(1000);
				UI_Date = schedulingPage.txt_Appointment_Date.getText();
			}
			select_date_For_POTs(date);
		} 
	}
	
	/**
	 * Method to select date for POTS only in Scheduling page
	 */
	public void select_date_For_POTs(String date){
		String CellDate= null;
		do{
			List<WebElement> list = getDriver().findElements(By.xpath("//table/tbody/tr/td")); 
			for(WebElement ele :list){
				CellDate = ele.getText();
				System.out.println(CellDate+"  "+date);
				if(CellDate.equals(date)){ 
					ele.click();
					schedulingPage.btn_Assign_Date_POTS_Only.click();
					break;
				}
			}
		}while(!CellDate.equals(date));

	}
	
	public void clickChangeBillingLink(){
//        schedulingPage.shouldExist(schedulingPage, 60);
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();",schedulingPage.changeBillingAddressLink);
//        schedulingPage.changeBillingAddressLink.click();
        slf4jLogger.info("Clicked Change link sucessfully");
        waitABit(2000);
	}
        public void clickValidateButton(){
//            schedulingPage.shouldExist(schedulingPage, 120);
            waitABit(2000);
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
    		js.executeScript("arguments[0].click();",schedulingPage.validateButton);
//            schedulingPage.validateButton.click();
            slf4jLogger.info("Clicked Validate button");
            waitABit(2000);
        }
        
        public void clickShipToThisAddressButton(){
            
            waitABit(5000);
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
    		js.executeScript("arguments[0].click();",schedulingPage.shipToThisAddress);
//            schedulingPage.shipToThisAddress.click();
            slf4jLogger.info("Clicked Ship To This Address Button");
            waitABit(2000);
        }
	
	
	
	
	
}
