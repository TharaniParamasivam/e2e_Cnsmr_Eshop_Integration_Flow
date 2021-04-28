package com.ctl.it.qa.eshop.tools.steps;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.pages.CustomerDetailsPage;
import com.ctl.it.qa.staf.Steps;
import com.google.common.collect.Iterators;

import net.thucydides.core.annotations.Step;

@SuppressWarnings("unused")
public class CustomerDetailsSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(CustomerDetailsSteps.class);

	CustomerDetailsPage customerDetailsPage;

	@Step
	public void searchAccount(String env, String first, String last, String phone, String address) {
		customerDetailsPage.shouldExist(customerDetailsPage, 120);
		customerDetailsPage.firstNam.type(first);
		customerDetailsPage.lastNam.sendKeys(last);
		customerDetailsPage.phoneNum.sendKeys(phone);
		customerDetailsPage.showAddress.sendKeys(address);
		slf4jLogger.info("Entered the following Customer details for Env=" + env + ": firstName=" + first
				+ ", lastName=" + last + " ,PhoneNumber=" + phone + " and address=" + address);

	}

	@Step
	public void letsGoButton() {
		waitABit(2000);
		customerDetailsPage.LetsGoButton.click();
		slf4jLogger.info("clicked on to 'Let's Go' button");

	}

	@Step
	public void noMatchFoundText() {
		customerDetailsPage.noMatchFoudText.waitUntilVisible();
		WaitForPageToLoad(10);
		slf4jLogger.info("address no match text validation");
		waitABit(5000);
		boolean flag = customerDetailsPage.noMatchFoudText.getText().contains("No Results Found");
		Assert.assertTrue(flag);
	}

	@Step
	public void checkNumOfAddress() {
		List<WebElement> ele = getDriver()
				.findElements(By.xpath("//input[@id='optionsRadiosAll']/following-sibling::span[1]"));
		slf4jLogger.info("num of address =" + ele.size());
		for (int i = 0; i < ele.size(); i++) {

			slf4jLogger.info(ele.get(i).getText());
		}
	}

	@Step
	public void enterAddressdetails(String street, String unit, String city, String state, String zip) {

		customerDetailsPage.shouldExist(customerDetailsPage, 120);
		customerDetailsPage.showalladdress.click();
		customerDetailsPage.street.type(street);
		customerDetailsPage.unit.type(unit);
		customerDetailsPage.city.type(city);
		customerDetailsPage.zipcode.type(zip);
		customerDetailsPage.state.selectByValue(state);
		slf4jLogger.info("Entered the following Address details for Street=" + street + ", Unit=" + unit + ", City="
				+ city + " ,State=" + state + " ,Zipcode=" + zip);
		waitABit(5000);
	}

	@Step
	public void searchAccoundetails(String env, String first, String last, String phone) {
		customerDetailsPage.shouldExist(customerDetailsPage, 120);
		customerDetailsPage.firstNam.type(first);
		customerDetailsPage.lastNam.type(last);
		customerDetailsPage.phoneNum.type(phone);
		slf4jLogger.info("Entered the following Customer details for Env=" + env + ": firstName=" + first
				+ ", lastName=" + last + " ,PhoneNumber=" + phone);

	}

	@Step
	public void selectMatchAddress() {
		customerDetailsPage.selectradiobtn.click();
		slf4jLogger.info("clicked on radio button and select addresss");
		customerDetailsPage.continuebtn.click();
		slf4jLogger.info("clicked on continue button");

	}

	// Nitish

	@Step
	public void i_click_on_Account_or_Order_already_exists_link() {
		customerDetailsPage.shouldExist(customerDetailsPage, 120);
		customerDetailsPage.orderexists.click();
		slf4jLogger.info("clicked on Account or Order already exists link");
		customerDetailsPage.shouldBeVisible(customerDetailsPage.newcustomer);
		slf4jLogger.info("Start New Customer Order is visible");

	}

	// Nitish MACD Completed Account Number as Input
	public void enter_completed_account_number(String completed_accountnum) {

		customerDetailsPage.accnumrbn.click();
		customerDetailsPage.existsaaccnumr.sendKeys(completed_accountnum);
		slf4jLogger.info("Entered completed account number");

	}

	/**
	 * 
	 * ALL Below code Commented and will be removed Later as its belongs to SFC
	 * CONSOLE
	 */
	// // Prem SFC Starts
	// public void click_create_new_account() {
	// customerDetailsPage.WaitForPageToLoad(30);
	// customerDetailsPage.shouldExist(customerDetailsPage,60);
	// //pop_out_primary_tabs();
	// pop_out_primary_tabs();
	// //close_all_primary_tab();
	// //waitABit(5000);
	// //pop_out_primary_tabs();
	// //waitABit(10000);
	// //customerDetailsPage.btn_account.click();
	// getDriver().switchTo().frame("ext-comp-1005");
	// //waitABit(5000);
	// int iframes_Count = getDriver().findElements(By.tagName("iframe")).size();
	// System.out.println("Frames Count for create new button " + iframes_Count);
	// //waitABit(5000);
	// customerDetailsPage.btn_createnew.click();
	// /*
	// * WebDriverWait wait = new WebDriverWait(getDriver(), 60);
	// * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.
	// * xpath("//iframe[@name='ext-comp-1005']")));
	// */
	// //waitABit(10000);
	// // customerDetailsPage.link_account.click();
	// slf4jLogger.info("Clicked create new account");
	// getDriver().switchTo().defaultContent();
	// }
	//
	//
	// @Step
	// public void create_new_account(String firstName, String lastName, String
	// contactNum, String address)
	// {
	// int iframes_Count =getDriver().findElements(By.tagName("iframe")).size();
	// System.out.println("Frames Count for Account creation "+iframes_Count);
	// WebElement
	// frameElement=getDriver().findElement(By.xpath("//iframe[contains(@src,'ServiceAddressCreation')]"));
	// //iframe[@id='ext-comp-1050']
	// if(frameElement.isDisplayed()){
	// String frameName=frameElement.getAttribute("name");
	// System.out.println("Account creation Frame name is " +frameName);
	// getDriver().switchTo().frame(frameName);
	// WebDriverWait wait = new WebDriverWait(getDriver(),30);
	// wait.until(ExpectedConditions.visibilityOf(customerDetailsPage.address_avail_flag));
	// waitABit(1000);
	// customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
	// System.out.println("Entered First Name and ALL Looks Good");
	// customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
	// customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
	// customerDetailsPage.tbx_address_field.type(address);
	// waitABit(1000);
	// slf4jLogger.info("Entered the following Customer details for firstName=" +
	// firstName + ", lastName=" + lastName + " ,PhoneNumber=" + contactNum + " and
	// address=" + address);
	//
	//
	// }else{
	// System.out.println("Frame is Not Available");
	// }
	// //********* Auto suggestion Handler Premkumara
	// String expected_address=address.trim();
	// List<WebElement> ss =
	// getDriver().findElements(By.xpath("//*[@id='suggestions']/option"));
	// WebElement input_address =
	// getDriver().findElement(By.xpath("//input[@id='oneLineAddressField']"));
	// if (ss.size() > 0) {
	// try {
	// //input_address.clear();
	// List<WebElement> address_collections =
	// getDriver().findElements(By.xpath("//*[@data-geoaddressid]"));
	// for(int i=0;i<address_collections.size();i++) {
	// String actualTxt =address_collections.get(i).getAttribute("value");
	// System.out.println("Actual address "+ actualTxt);
	// if(actualTxt.contains(expected_address)) {
	// waitABit(1000);
	// Actions action = new Actions(getDriver());
	// action.moveToElement(address_collections.get(1)).click().build().perform();
	// input_address.sendKeys(actualTxt);
	// waitABit(1000);
	// input_address.sendKeys(Keys.ENTER);
	// waitABit(1000);
	// }else {
	// slf4jLogger.info("Invalid Address");
	// }
	// }
	// } catch (Exception e) {
	//
	// }
	//
	// } else {
	//
	// System.out.println("Address is Empty");
	// }
	//
	//
	// }
	//
	//
	// @Step
	// public void validate_address() {
	// waitABit(3000);
	// customerDetailsPage.select_own_house.selectByIndex(1);
	// slf4jLogger.info("selected own Option ");
	// waitABit(1000);
	// customerDetailsPage.btn_validate_address.click();
	// slf4jLogger.info("Clicked Address Validate Address Button");
	// WebElement loading_img =
	// getDriver().findElement(By.xpath("//img[@src='/img/loading.gif']"));
	// WebDriverWait wait = new WebDriverWait(getDriver(), 60);
	// wait.until(ExpectedConditions.invisibilityOf(loading_img));
	// WebElement input_radio_matchaddress =
	// getDriver().findElement(By.xpath("//input[@data-exactmatch='Yes']"));
	// input_radio_matchaddress.click();
	// slf4jLogger.info("Clicked Yes Radio Match Address Button");
	// wait.until(ExpectedConditions.invisibilityOf(loading_img));
	// customerDetailsPage.btn_save.click();
	// if(customerDetailsPage.btn_close.isCurrentlyEnabled()){
	// customerDetailsPage.btn_close.click();
	// slf4jLogger.info("Clicked Close pop up Address Button");
	// }
	//
	// wait.until(ExpectedConditions.invisibilityOf(loading_img));
	// getDriver().switchTo().defaultContent();
	// }
	//
	// //click_order_eshop
	// @Step
	// public void click_order_eshop() {
	//
	// //pop_out_primary_tabs();
	//
	// //WebElement
	// frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'/a08R00')]"));
	// //-------PP1
	// WebElement
	// frameElement_eshop=getDriver().findElement(By.xpath("//iframe[contains(@src,'/a084N0')]"));
	// //-------PROD
	//
	// /*
	// * List<WebElement> list =
	// *
	// getDriver().findElements(By.xpath("//*[contains(@src,'a0')]"));//------------
	// * PP2 WebElement frameElement_eshop1 = list.get(list.size()-1);
	// */
	//
	//// String frameName1=frameElement_eshop.getAttribute("name");
	//// slf4jLogger.info("Frame Name: " +frameName1);
	//
	// if(frameElement_eshop.isDisplayed()){
	// String frameName=frameElement_eshop.getAttribute("name");
	// System.out.println("Account creation Frame name is " +frameName);
	// getDriver().switchTo().frame(frameName);
	// //waitABit(000);
	// System.out.println("Frame is Available in SFC Account Page");
	// //waitABit(2000);
	// customerDetailsPage.btn_order_eshop.click();
	// slf4jLogger.info("Clicked Order Eshop Button");
	// //System.out.println("Reached Frame >>>> ");
	// //waitABit(2000);
	// }
	// waitABit(5000);
	// Set<String> allWindows=getDriver().getWindowHandles();
	//// System.out.println("Window size "+allWindows.size());
	// Iterator<String> windowIterator=allWindows.iterator();
	// String parentWindow=windowIterator.next();
	// String childWindow=windowIterator.next();
	// getDriver().switchTo().window(childWindow);
	// getDriver().manage().window().maximize();
	// slf4jLogger.info("Launched Eshop Application and New URL is
	// "+getDriver().getCurrentUrl());
	// }
	//
	// // Prem SFC Ends
	//
	//
	// //Prem handle Frames
	// public void switchtoFrame(String frame) {
	// try{
	// getDriver().switchTo().window(getDriver().getWindowHandle());
	// getDriver().switchTo().frame(frame);
	// }catch(Exception e){
	//
	// }
	// }
	//
	// public WebElement switch_To_Frame(WebElement element, String...
	// attributeName) {
	// String frame="";
	// getDriver().switchTo().defaultContent();
	// List<WebElement> lstFrames = getDriver().findElements(By.tagName("iframe"));
	// for (WebElement we : lstFrames) {
	// if(attributeName.length==0){
	// frame = we.getAttribute("id");
	// }else{
	// frame = we.getAttribute("name");
	// }
	// switchtoFrame(frame);
	// if (element.isDisplayed()) {
	//
	// System.out.println(" Expected Element is available .......");
	// break;
	//
	// }
	// getDriver().switchTo().defaultContent();
	//
	// }
	// return element;
	// }
	//
	// public void close_all_primary_tab() {
	// try{
	// //waitABit(20000);
	// customerDetailsPage.btn_right_tab_menu.click();
	// customerDetailsPage.withTimeoutOf(20,
	// TimeUnit.SECONDS).waitFor(customerDetailsPage.lnk_close_all_primary_tabs).click();
	// }catch(Exception e){
	// System.out.println("No Tab is opened when user is logged in");
	// }
	// }
	//
	// public void pop_out_primary_tabs() {
	// try {
	// customerDetailsPage.btn_right_tab_menu.click();
	// String parentHandle = getDriver().getWindowHandle();
	//
	// System.out.println("parent window id is " + parentHandle);
	// //waitABit(10000);
	// /* customerDetailsPage.withTimeoutOf(20, TimeUnit.SECONDS)
	// .waitFor(customerDetailsPage.lnk_pop_out_primary_tabs).click();*/
	// if(customerDetailsPage.lnk_pop_out_primary_tabs.isCurrentlyEnabled()){
	// customerDetailsPage.lnk_pop_out_primary_tabs.click();
	// waitABit(10000);
	// Set<String> allWindows = getDriver().getWindowHandles();
	// System.out.println("Window size >>>>>>>>>> " + allWindows.size());
	// if (allWindows.size() > 1) {
	//
	// Iterator<String> windowIterator = allWindows.iterator();
	// String parentWindow = windowIterator.next();
	// String childWindow = windowIterator.next();
	// // getDriver().switchTo().window(childWindow);
	// getDriver().switchTo().window(childWindow);
	// System.out.println("Child window is >>> "+childWindow);
	// //waitABit(3000);
	// getDriver().switchTo().window(childWindow).close();
	// System.out.println("child window is closed..... ");
	// getDriver().switchTo().window(parentWindow);
	// //waitABit(5000);
	// System.out.println("Switch to Parent window ........ ");
	// } else {
	//
	// System.out.println("Single window ");
	// }
	// }
	//
	// // customerDetailsPage.withTimeoutOf(20,
	// //
	// TimeUnit.SECONDS).waitFor(customerDetailsPage.lbl_drag_footer_component_here);
	// // Set<String>windowHandles= getDriver().getWindowHandles();
	// // Iterator<String>iterator=windowHandles.iterator();
	//
	// // code to close child window ///
	//
	//
	// customerDetailsPage.withTimeoutOf(20, TimeUnit.SECONDS)
	// .waitFor(customerDetailsPage.lnk_pop_out_primary_tabs).click();
	// // customerDetailsPage.withTimeoutOf(20,
	// //
	// TimeUnit.SECONDS).waitFor(customerDetailsPage.lbl_drag_footer_component_here);
	// // Set<String>windowHandles= getDriver().getWindowHandles();
	// // Iterator<String>iterator=windowHandles.iterator();
	//
	// // code to close child window ///
	// Set<String> allWindows = getDriver().getWindowHandles();
	// System.out.println("Window size " + allWindows.size());
	// if (allWindows.size() > 1) {
	//
	// Iterator<String> windowIterator = allWindows.iterator();
	// String parentWindow = windowIterator.next();
	// String childWindow = windowIterator.next();
	// // getDriver().switchTo().window(childWindow);
	// getDriver().switchTo().window(childWindow);
	// getDriver().close();
	// System.out.println("child window is closed..... ");
	// } else {
	//
	// System.out.println("Single window ");
	// }
	//
	//
	// /*
	// * while(iterator.hasNext()){ String handle=iterator.next();
	// * if(!(handle.equals(parentHandle))){
	// * getDriver().switchTo().window(handle).close();
	// * System.out.println("Closed child window ..... "); //
	// * getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.
	// * CONTROL +"w"); waitABit(3000);
	// * iterator=getDriver().getWindowHandles().iterator(); int
	// * size=Iterators.size(iterator); if(size==1){ break; }else{
	// * getDriver().close(); break; } } }
	// */
	//
	//
	//
	// // getDriver().switchTo().window(parentHandle);
	// //waitABit(5000);
	//
	// }catch(Exception e){
	// System.out.println("driver instance is not moved back to parent window");
	// }
	// }

	// Prepaid Nitish
	@Step
	public void EnterPreapid_detailsoneshopage(String first, String last, String phone, String address) {
		customerDetailsPage.shouldExist(customerDetailsPage, 60);
		customerDetailsPage.firstNam.type(first);
		customerDetailsPage.lastNam.sendKeys(last);
		customerDetailsPage.phoneNum.sendKeys(phone);
		customerDetailsPage.showAddress.sendKeys(address);
		slf4jLogger.info("Entered the following Customer details for Env= firstName=" + first + ", lastName=" + last
				+ " ,PhoneNumber=" + phone + " and address=" + address);

	}

	public void closeExistingAcct()

	{

		try {
			List<WebElement> accountLink = getDriver()
					.findElements(By.xpath("//a[@class='tabHeader slds-context-bar__label-action ']"));
			for (int i = 0; i < accountLink.size(); i++) {
				accountLink.get(i).click();
				waitABit(3000);
				List<WebElement> closeButton = getDriver().findElements(By.xpath(
						"//button[@class='slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container']"));
				int closeButtonSize = closeButton.size();
				System.out.println(closeButtonSize);
				try {
					for (WebElement closeButtonIndividual : closeButton) {
						Set<String> allWindows = getDriver().getWindowHandles();
						Iterator<String> windowIterator = allWindows.iterator();
						String parentWindow = windowIterator.next();
						String childWindow = windowIterator.next();
						getDriver().switchTo().window(childWindow);
						closeButtonIndividual.click();
						slf4jLogger.info("clicked on close button for childwindow");
						waitABit(1000);
						getDriver().switchTo().window(parentWindow);
					}

				} catch (Exception e) {
					System.out.println("no multiple window present");
				}

				waitABit(2000);
				try {
					SFC_AlertHandling();
					waitABit(5000);
					customerDetailsPage.shouldBeVisible(customerDetailsPage.tbx_Interaction_Log_Caller_Name_Entry);
					customerDetailsPage.tbx_Interaction_Log_Caller_Name_Entry.type("NewAcct");
					customerDetailsPage.select_Interaction_Log_subject.selectByIndex(3);
					customerDetailsPage.select_Interaction_Log_Reason_For_Call.selectByIndex(2);
					customerDetailsPage.select_Interaction_Log_Call_Disposition.selectByIndex(2);
					customerDetailsPage.select_Interaction_Log_Call_Disposition_Reason.selectByIndex(2);
					customerDetailsPage.txt_Interaction_Log_Action.type("FinalText");
					customerDetailsPage.btn_Interaction_Log_Save.isDisplayed();
					customerDetailsPage.btn_Interaction_Log_Save.click();
					String successMessage = customerDetailsPage.lbl_Interaction_Log_success_message.getText();
					if (successMessage.equalsIgnoreCase("The save was successful!")) {
						System.out.println("saved successfully.Existing Account closed");
					} else {

						System.out.println("Not saved successfully");
					}

				} catch (Exception e) {
					System.out.println("Control not passed to parent window");
				}

			}

		} catch (Exception e) {
			System.out.println("No exsiting account to close");
		}

	}

	/**
	 * Code Updated with SFC Lightning Version - Nitish
	 */
	@Step
	public void click_create_new_account() {
		waitABit(25000);
		boolean Tab = false;
		try {
			Tab = getDriver().findElement(By.xpath("(//span[@class='title slds-truncate'])[1]")).isDisplayed();
		} catch (Exception e) {
		}
		if (Tab) {
			// System.out.println("Tab ");
			try {
				// case1
				waitABit(5000);
				SFC_AlertHandling();
				getDriver().findElement(By.xpath("(//span[@class='title slds-truncate'])[2]")).click();
				waitABit(2000);
				SFC_AlertHandling();
				waitABit(2000);
				System.out.println(" Reached this method SFC_AlertHandling.....  ");

				// Commented By Prem //
				/*
				 * WebElement
				 * IL=getDriver().findElement(By.xpath("//*[contains(text(),'Interaction Log')]"
				 * )); JavascriptExecutor js = (JavascriptExecutor) getDriver();
				 * js.executeScript("arguments[0].scrollIntoView();", IL); waitABit(5000);
				 * getDriver().findElement(By.xpath(
				 * "//input[@name='Call_Disposition_Reason__c']")).click(); waitABit(2000);s
				 * getDriver().findElement(By.xpath("//*[@data-value='HSI']")).click();
				 * waitABit(2000);
				 * getDriver().findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys(
				 * "Closed"); waitABit(5000);
				 * getDriver().findElement(By.xpath("//button[@type='submit']")).click();
				 * waitABit(2000);
				 * getDriver().findElement(By.xpath("//button[@title='Close Tab']")).click();
				 */

				// Commented By Prem //
				waitABit(5000);

				// case2
				// getDriver().findElement(By.xpath("(//span[@class='title
				// slds-truncate'])[1]")).click();
				// SFC_AlertHandling();
				// waitABit(2000);
				// WebElement
				// IL=getDriver().findElement(By.xpath("//span[contains(text(),'Interaction
				// Log')]"));
				// JavascriptExecutor js = (JavascriptExecutor) getDriver();
				// js.executeScript("arguments[0].scrollIntoView();", IL);
				// waitABit(5000);
				// getDriver().findElement(By.xpath("//input[@name='Call_Disposition_Reason__c']")).click();
				// waitABit(2000);
				// getDriver().findElement(By.xpath("//*[@data-value='HSI']")).click();
				// waitABit(2000);
				// getDriver().findElement(By.xpath("//*[@class='slds-textarea']")).sendKeys("Closed");
				// waitABit(5000);
				// getDriver().findElement(By.xpath("//button[@type='submit']")).click();
				// waitABit(2000);
				// getDriver().findElement(By.xpath("//button[@title='Close Tab']")).click();
				// waitABit(5000);
			} catch (Exception e) {
				System.out.println("Catch exection in TAB" + e);
			}
		}

		/**
		 * Handle account
		 */

		try {

			List<WebElement> btn_account = getDriver().findElements(By.xpath("//span[contains(text(),'Accounts')]"));

			WebElement btn_account1 = getDriver().findElement(By.xpath("(//span[contains(text(),'Accounts')])[2]"));

			System.out.println("Reached Acccount Button size >>>>>" + btn_account.size());
			int btn_size = btn_account.size();
			waitABit(5000);
			if (btn_size == 1) {
				System.out.println("Reached to click btn_account1");
				btn_account1.click();
			} else {

				WebElement btn_account_max = getDriver()
						.findElement(By.xpath("(//span[contains(text(),'Accounts')])[" + btn_size + "]"));
				// (//div[@class='accordion-toggle' and .//text()='" + toggleTxt + "'])
				waitABit(6000);
				btn_account_max.click();
				waitABit(6000);
			}

			// eshopsfcpage.EShop_Lighting_Researchbtn.click();
			// waitABit(15000);

		} catch (Exception ex) {
			System.out.println("Unable to click Account Button");
		}

		//

		slf4jLogger.info("Clicked Account Button on SFC Lightning Version");
		waitABit(5000);
		customerDetailsPage.btn_createnew.click();
		slf4jLogger.info("Clicked New Button on SFC Lightning Version");

	}

	/**
	 * Code for handling the drop downs - account
	 */

	@Step
	public void click_create_new_accountnew() {
//		waitABit(10000);
//		boolean Tab = false;
//		try {
//			Tab = getDriver().findElement(By.xpath("(//span[@class='title slds-truncate'])[1]")).isDisplayed();
//		} catch (Exception e) {
//		}
//		if (Tab) {
//			try {
//				waitABit(5000);
//				SFC_AlertHandling();
//				closeExistingAcct();
//				getDriver().findElement(By.xpath("(//span[@class='title slds-truncate'])[2]")).click();
//				waitABit(2000);
//				SFC_AlertHandling();
//				closeExistingAcct();
//				waitABit(2000);
//				System.out.println(" Reached this method SFC_AlertHandling.....  ");
//			} catch (Exception e) {
//				System.out.println("Catch exection in TAB" + e);
//			}
//			
//		} else {
//			closeExistingAcct();
//		}
		waitABit(1000);
		if (customerDetailsPage.link_account.isCurrentlyVisible()) {
			customerDetailsPage.link_account.click();
			slf4jLogger.info("Clicked Accounts button");
			waitABit(3000);
			customerDetailsPage.btn_createnew.click();
			waitABit(1000);
			slf4jLogger.info("Clicked New button to add the basic details");
		} 
		else if(customerDetailsPage.btn_createnew.isCurrentlyVisible())
		{
			customerDetailsPage.btn_createnew.click();
			waitABit(1000);
		}
		
		else {
			customerDetailsPage.select_Account_dropdown.click();
			waitABit(1000);
			customerDetailsPage.link_account.click();
			waitABit(1000);
			customerDetailsPage.btn_createnew.click();
			waitABit(1000);
			slf4jLogger.info("Clicked New button to add the basic details");
		}

	}

	/**
	 * Code Updated with SFC Lightning Version - Nitish
	 */
	@Step
	public void create_new_account(String firstName, String lastName, String contactNum, String email, String address) {
		waitABit(10000);
		customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
		customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
		customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
		customerDetailsPage.tbx_Email.sendKeys(contactNum);
		customerDetailsPage.tbx_address_field.sendKeys(address);
		slf4jLogger.info("Entered the following Customer details for firstName=" + firstName + " lastName=" + lastName
				+ " PhoneNumber=" + contactNum + " Email id=" + email + " and address=" + address);
		waitABit(10000);
		WebElement SelectAddress = getDriver().findElement(By.xpath("//*[@value='" + address + "']"));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(SelectAddress);
		actions.click().build().perform();
		slf4jLogger.info("Selected the Address " + address);

	}

	/**
	 * Code Updated with SFC Lightning Version - Nitish
	 */
	@Step
	public void create_new_account(String firstName, String lastName, String contactNum, String address) {
//		waitABit(8000);
//		customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
//		customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
//		customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
//		customerDetailsPage.tbx_address_field.sendKeys(address);
//		slf4jLogger.info("Entered the following Customer details for firstName=" + firstName + ", lastName=" + lastName
//				+ " ,PhoneNumber=" + contactNum + " and address=" + address);	
//		waitABit(2000);
////		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
//		WebElement SelectOption=getDriver().findElement(By.xpath("//input[contains(@placeholder,'Select an Option')]"));
////		js1.executeScript("arguments[0].scrollIntoView();", SelectOption);
//		Actions actions1 = new Actions(getDriver());
//		actions1.moveToElement(SelectOption).build().perform();
//		SelectOption.click();
//		getDriver().findElement(By.xpath("//span[@title='Own']")).click();
//		WebElement SelectAddress=getDriver().findElement(By.xpath("//*[@value='"+address+"']"));
//		Actions actions = new Actions(getDriver());
//		actions.moveToElement(SelectAddress);
//		waitABit(1000);
//		actions.click().build().perform();
//		slf4jLogger.info("Selected the Address "+address);
		
		
		waitABit(10000);
		customerDetailsPage.tbx_account_first_name.sendKeys(firstName);
		customerDetailsPage.tbx_account_last_name.sendKeys(lastName);
		customerDetailsPage.tbx_phone_number.sendKeys(contactNum);
		customerDetailsPage.tbx_address_field.sendKeys(address);
		slf4jLogger.info("Entered the following Customer details for firstName=" + firstName + ", lastName=" + lastName + " ,PhoneNumber=" + contactNum + " and address=" + address);
		waitABit(1000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		js1.executeScript("arguments[0].scrollIntoView();", customerDetailsPage.ownorrent);
		customerDetailsPage.ownorrent.click();
		getDriver().findElement(By.xpath("//span[@title='Own']")).click();
		slf4jLogger.info("selected Own Option");
		waitABit(2000);
		WebElement SelectAddress=getDriver().findElement(By.xpath("//option[@value='"+address+"']"));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(SelectAddress);
		waitABit(2000);
		actions.click().build().perform();
		slf4jLogger.info("Selected the Address "+address);
	}

	/**
	 * Code Updated with SFC Lightning Version - Nitish
	 */
	@Step
	public void validate_address() {
		waitABit(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", customerDetailsPage.btn_validate_address);
		customerDetailsPage.btn_validate_address.click();
		slf4jLogger.info("Clicked Validate Address Button");
		waitABit(6500);
		customerDetailsPage.btn_save.click();
		slf4jLogger.info("Clicked Save Button");
	}

	/**
	 * Code Updated with SFC Lightning Version - Nitish
	 */
	@Step
	public void click_order_eshop() {
		waitABit(7000);
		List<WebElement> e = getDriver().findElements(By.xpath("//button[contains(text(),'Order (eShop)')]"));
		int a = e.size();
		int i = 1;
		System.out.println("Order (eShop) button count >>>>>> " + e.size());
		// while(i<=a) {
		try {
			// WebElement
			// e1=getDriver().findElement(By.xpath("(//button[contains(text(),'Order
			// (eShop)')])["+i+"]"));
			// System.out.println(e1.getLocation().getX());
			// System.out.println(e1.getLocation().getY());
			// System.out.println(i);
			// if(i==a){
			// e1.click();

			/*
			 * waitABit(10000); WebElement e1=getDriver().findElement(By.
			 * xpath("//button[contains(text(),'Order (eShop)') and contains(@data-aura-rendered-by,';a')]"
			 * ));
			 * 
			 * waitABit(5000); JavascriptExecutor js = (JavascriptExecutor) getDriver();
			 * js.executeScript("arguments[0].scrollIntoView();", e1); JavascriptExecutor
			 * js1 = (JavascriptExecutor) getDriver();
			 * js1.executeScript("arguments[0].click();", e1);
			 */

			// break;
			// }
			// i++;

			slf4jLogger.info("Clicked Order Eshop Button");
			////////////////////// Code for Demo //

			waitABit(10000);
			List<WebElement> btn_Eshops = getDriver().findElements(
					By.xpath("//button[contains(text(),'Order (eShop)') and contains(@data-aura-rendered-by,';a')]"));
			waitABit(5000);
			WebElement btn_Eshop1 = getDriver().findElement(
					By.xpath("//button[contains(text(),'Order (eShop)') and contains(@data-aura-rendered-by,';a')]"));
			waitABit(3000);
			System.out.println("Reached Order ESHOP size >>>>>" + btn_Eshops.size());
			int btn_size = btn_Eshops.size();

			if (btn_size == 1) {
				waitABit(3000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView();", btn_Eshop1);
				JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
				js1.executeScript("arguments[0].click();", btn_Eshop1);

				// btn_Eshop1.click();
				System.out.println("Reached to click btn_Eshop1");
			} else {

				WebElement btn_Eshop_max = getDriver().findElement(By
						.xpath("(//button[contains(text(),'Order (eShop)') and contains(@data-aura-rendered-by,';a')])["
								+ btn_size + "]"));
				// (//div[@class='accordion-toggle' and .//text()='" + toggleTxt + "'])
				waitABit(4000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("arguments[0].scrollIntoView();", btn_Eshop_max);
				JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
				js2.executeScript("arguments[0].click();", btn_Eshop_max);

				// btn_Eshop_max.click();
				System.out.println("Reached to click btn_Eshop2");
				waitABit(6000);
			}

			// eshopsfcpage.EShop_Lighting_Researchbtn.click();
			// waitABit(15000);

			//////////////// Code for Demo //

		} catch (Exception ex) {
			System.out.println("Excetion caught :" + ex);
		}
		// }

		waitABit(30000);
		// WebElement
		// sfcframeeshop=getDriver().findElement(By.xpath("(//iframe[@title='accessibility
		// title'])[2]"));

		/*
		 * code updated by Prem
		 */

		List<WebElement> buildOfferPage_Frames = getDriver()
				.findElements(By.xpath("(//iframe[@title='accessibility title'])"));
		int buildOfferPage_Frames_size = buildOfferPage_Frames.size();

		System.out.println("Product offer page count >>>>> " + buildOfferPage_Frames.size());
		// int j=1;
		WebElement sfcframeeshop = getDriver()
				.findElement(By.xpath("(//iframe[@title='accessibility title'])[" + buildOfferPage_Frames_size + "]"));
		/**********/
		waitABit(10000);
		getDriver().switchTo().frame(sfcframeeshop);
		slf4jLogger.info("Eshop Application Frame Switched");
		// (//iframe[@title='accessibility title'])[2]
		// Set<String> allWindows=getDriver().getWindowHandles();
		// Iterator<String> windowIterator=allWindows.iterator();
		// String parentWindow=windowIterator.next();
		// String childWindow=windowIterator.next();
		// getDriver().switchTo().window(childWindow);
		// getDriver().manage().window().maximize();
		// slf4jLogger.info("Launched Eshop Application and New URL is
		// "+getDriver().getCurrentUrl());
	}

	/**
	 * Code Updated with SFC Lightning Version - Nitish
	 */
	@Step
	public void SFC_AlertHandling() {
		System.out.println("Reached >>>>>>>>>>>>>>>>>>>>>>> ");
		List<WebElement> alert = getDriver().findElements(By.xpath("//button[contains(text(),'Verified')]"));
		int size = alert.size();
		System.out.println(" Poup Size >>>>>>>>>>>>>     " + size);
		if (size > 0) {
			List<WebElement> alert1 = getDriver().findElements(By.xpath("//*[@data-key='close']"));
			int size1 = alert1.size();
			System.out.println("Alert Element size " + size);
			// This Condition Working Fully fine for Chrome Driver Version 79
			/*
			 * for(int i=0;i<size1;i++) { try { System.out.println("Alert iteration "+i);
			 * System.out.println(alert1.iterator().next().getAttribute("class"));
			 * alert1.iterator().next().click(); break; } catch(Exception e) {
			 * System.out.println("Exception Caught and Handled "+e); } }
			 */
			// This Condition Working Paritally fine for Chrome Driver Version 78
			// commended as of now.
			int j = 1;
			while (j <= size1) {
				System.out.println("Iteration of alert " + j);
				// if(size>=2) {
				try {
					slf4jLogger.info("Alert Displayed");
					WebElement alert2 = getDriver().findElement(By.xpath("(//*[@data-key='close'])[" + j + "]"));
					alert2.click();
					slf4jLogger.info("Alert Closed");
					// break;
				} catch (Exception e) {
					System.out.println("Exception caught for alert" + e);
				}
				System.out.println("Out of Try and Catch Block");
				// }
				j++;
			}
		} else {
			System.out.println("No Popup Displayed >>>> ");
		}
	}
}
