package com.ctl.it.qa.eshop.tools.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.pages.OrderPage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class OrderSteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(OrderSteps.class);
	OrderPage orderPage;

	@Step
	public void clickOnContinue() {
		orderPage.shouldExist(orderPage, 50);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", orderPage.continueButton);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		js1.executeScript("arguments[0].click();", orderPage.continueButton);
		slf4jLogger.info("Clicked Continue");
		waitABit(5000);
		if (orderPage.OrderdisclosuresAccept.isCurrentlyVisible()) {
			JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
			js2.executeScript("arguments[0].scrollIntoView();", orderPage.OrderdisclosuresAccept);
			JavascriptExecutor js3 = (JavascriptExecutor) getDriver();
			js3.executeScript("arguments[0].click();", orderPage.OrderdisclosuresAccept);
			// orderPage.OrderdisclosuresAccept.click();
			slf4jLogger.info("Clicked on OK, Got it on Order Discolosures pop up");
		}

		else if (orderPage.lbl_title_Order_Disclosures_NI_HSICVOIP.isCurrentlyVisible()) {

			orderPage.lbl_title_Order_Disclosures_NI_HSICVOIP.click();

			for (int i = 0; i < 2; i++) {
				orderPage.lbl_title_Order_Disclosures_NI_HSICVOIP.sendKeys(Keys.TAB);
			}
			waitABit(2000);
			JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
			js2.executeScript("arguments[0].scrollIntoView();", orderPage.OrderdisclosuresAccept);
			JavascriptExecutor js3 = (JavascriptExecutor) getDriver();
			js3.executeScript("arguments[0].click();", orderPage.OrderdisclosuresAccept);
			// orderPage.OrderdisclosuresAccept.click();
			slf4jLogger.info("Clicked on OK, Got it on Order Discolosures pop up");

		} else {
			slf4jLogger.info("No Order Discolosures pop up is available");
		}
	}

	@Step
	public void verfyBuildYourOffer() throws InterruptedException {
		orderPage.shouldExist(orderPage, 90);
		String buildOrderText = "Build your Offer";
		Assert.assertTrue(orderPage.buildYourOffer.getText().trim().contains(buildOrderText));
		slf4jLogger.info("Verified build your offer page");
		slf4jLogger.info("The Tittle of the Page is   " + orderPage.getTitle());
		slf4jLogger.info("We are now in Enironment name as   " + orderPage.getCurrentEnvironment());
		slf4jLogger.info("URL name as   " + getDriver().getCurrentUrl());

	}

	@Step
	public void selectBestinstallation(String install) {
		slf4jLogger.info("Enter installation");
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		waitABit(2000);
		 orderPage.bestInstallationOptionDrpdwn.selectByIndex(2);

		//orderPage.bestInstallationOptionDrpdwn.selectByValue(install);
		slf4jLogger.info("Selected the option " + install);
	}

	@Step
	public void speedSelection(String speed) {

		slf4jLogger.info("Select Speed");
		System.out.println(speed);
		try {
		waitABit(1000);
		WebElement speedSelection = getDriver().findElement(By.xpath("//span[contains(text(),'"+speed+"')]/ancestor::label/span/input"));
		waitABit(5000);
		speedSelection.click();	
		}
		catch(StaleElementReferenceException e)
		{
			WebElement speedSelection = getDriver().findElement(By.xpath("//span[contains(text(),'"+speed+"')]/ancestor::label/span/input"));
			waitABit(2000);
			speedSelection.click();
		}
		
		slf4jLogger.info("Speed selection" + speed);
		// orderPage.bestInstallationOptionDrpdwn.selectByIndex(1);

	}

	@Step
	public void selectModemOption(String modem) {
		orderPage.yourModemDrpdwn.waitUntilClickable();
		// orderPage.yourModemDrpdwn.selectByValue(modem);
		orderPage.yourModemDrpdwn.selectByIndex(1);
		slf4jLogger.info("Selected the option " + modem);
	}

	@Step
	public void selectEaseOption(String ease) {
		orderPage.easeDrpdwn.waitUntilClickable();
		// orderPage.easeDrpdwn.selectByValue(ease);
		orderPage.easeDrpdwn.selectByIndex(1);
		slf4jLogger.info("Selected the option " + ease);
	}

	@Step
	public void buildOfferPage() throws InterruptedException {
		try {
			orderPage.shouldExist(orderPage, 120);
			Thread.sleep(10000);
			boolean flag = orderPage.buildYourOffer.getText().contains("Build your Offer");
			Assert.assertTrue(flag);
			slf4jLogger.info("verified build your offer page");
		} catch (Exception e) {
			Thread.sleep(5000);
			boolean flag = orderPage.buildYourOffer.getText().contains("Build your Offer");
			Assert.assertTrue(flag);
		}
	}

	@Step
	public void CVoipDHPhone() throws InterruptedException {
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		Actions act = new Actions(getDriver());
		act.moveToElement(orderPage.addPhoneDHP).click().build().perform();
		act.moveToElement(orderPage.digitalDHP).click().build().perform();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected CVOIP/DHP and offers retrived");
	}

	/*
	 * @Step public void important911AdderessInfoPopUp() { waitABit(5000);
	 * List<WebElement> wb = getDriver().findElements((By.
	 * xpath("//h3[text()='Required Disclosure']/following-sibling::div//input")));
	 * for (int i = 0; i < wb.size(); i++) { waitABit(5000); JavascriptExecutor jse
	 * = (JavascriptExecutor) getDriver();
	 * jse.executeScript("arguments[0].click();", wb.get(i)); break; }
	 * waitABit(5000); List<WebElement> productOptions =
	 * getDriver().findElements((By.xpath(
	 * "//div[@class='modalbody']/following-sibling::div//button[1]"))); for (int i
	 * = 0; i < productOptions.size(); i++) { WebElement product =
	 * productOptions.get(i); JavascriptExecutor jse = (JavascriptExecutor)
	 * getDriver(); jse.executeScript("arguments[0].click();", product);
	 * slf4jLogger.info("CVoipDHPhone selected successfully"); break; }
	 * orderPage.scrolling.waitUntilNotVisible(); }
	 */

	// Nitish changes
	@Step
	public void important911AdderessInfoPopUp() {
		waitABit(3000);
		orderPage.acceptcondition.click();
		waitABit(3000);
		orderPage.acceptcondition.sendKeys(Keys.TAB);
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", orderPage.Seeprodoptions);
		// orderPage.Seeprodoptions.click();
		waitABit(3000);
		slf4jLogger.info("911 validation successfully done");
	}

	// Nitish pots
	@Step
	public void homePhone() {
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		Actions act = new Actions(getDriver());
		act.moveToElement(orderPage.addPhoneDHP).click().build().perform();
		act.moveToElement(orderPage.HomePhone).click().build().perform();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected Home Phone and offers retrived");

	}

	// Quantity Selection - Nitish
	public void quatity_selection(String quantity) {

		orderPage.selectDeviceQuantity.waitUntilClickable();
		orderPage.selectDeviceQuantity.selectByVisibleText(quantity);
		slf4jLogger.info("Selected " + quantity + " from Quantity");
	}

	// ac31339 code starts

	@Step
	public void selectAvailableSpeed(String Selectspeed) {
		slf4jLogger.info("Select required Speed");
		orderPage.buildYourOffer.waitUntilClickable();
		WebElement availableSpeedRadioButton = getDriver()
				.findElement(By.xpath("//span[contains(text(),'" + Selectspeed + "')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
		jse2.executeScript("arguments[0].click();", availableSpeedRadioButton);
		slf4jLogger.info("Selected the Speed");
	}

	@Step
	public void interNet() {

		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		orderPage.internetIcon.waitUntilClickable();
		waitABit(2000);
		orderPage.internetIcon.click();
		slf4jLogger.info("Selected Internet Option");
		orderPage.retriveoption.click();
		slf4jLogger.info("Clicked on Internet and retrive");

	}

	@Step
	public void onePtyResidenceLine() {
		orderPage.onePtyresidenseLine.click();
		slf4jLogger.info("Selected One Pty Residence Line");
	}

	@Step
	public void lifeUnlimitedPhoneCalling() {

		if (!orderPage.unlimitedHomePhoneCaling.isCurrentlyEnabled()) {
			slf4jLogger.info("Selected Life Unlimited Phone Unlimited Calling");
		} else {
			orderPage.unlimitedHomePhoneCaling.click();
			slf4jLogger.info("Selected Life Unlimited Phone Unlimited Calling");
		}

	}

	@Step
	public void customizeServiceInterNet() {
		orderPage.cutomize_service_interneticon.click();
		slf4jLogger.info("Selected Customize Services Internet Option");
		waitABit(1000);
	}

	// ac31339 code Ends

	// Pots mandatory fields Selection - Nitish>>>>>
	@Step
	public void voice_mail_selection(String passedvalue) {
		waitABit(1000);
		orderPage.voicemail.waitUntilClickable();
		orderPage.voicemail.selectByVisibleText(passedvalue);
		slf4jLogger.info("Selected " + passedvalue + " option from voice mail");

	}

	@Step
	public void Wire_Maintenance_Plan_selection(String passedvalue) {
		orderPage.wireplanmaintenace.waitUntilClickable();
		orderPage.wireplanmaintenace.selectByVisibleText(passedvalue);
		slf4jLogger.info("Selected " + passedvalue + " option from wire plan maintenace");

	}

	@Step
	public void Port_in_a_phone_number(String passedvalue) {
		orderPage.portphonenumber.waitUntilClickable();
		orderPage.portphonenumber.selectByVisibleText(passedvalue);
		slf4jLogger.info("Selected " + passedvalue + " option from port phone number");

	}
	// Pots mandatory fields Selection - Nitish<<<<<<<

	// Jacks or wiring fields Selection - Nitish>>>>>>
	@Step
	public void Need_new_jacks_or_wiring(String passedvalue) {
		orderPage.jacksorWiring.waitUntilClickable();
		// orderPage.jacksorWiring.selectByVisibleText(passedvalue);
		orderPage.jacksorWiring.selectByIndex(1);
		slf4jLogger.info("Selected " + passedvalue + " option from jacks or Wiring");

	}
	// Jacks or wiring fields Selection - Nitish<<<<<<<<<<<

	// Matching Offers HSI + POTS - Nitish>>>>>>>>>>
	@Step
	public void matchingOffersSelected(String passedvalue) {

		Boolean flag = passedvalue.contentEquals("Essential Home Phone");
		if (flag) {
			try {
				orderPage.EssentialHomePhone.waitUntilClickable();
				orderPage.EssentialHomePhone.click();
				slf4jLogger.info("Selected Essential Home Phone Matching Offer");
			} catch (Exception e) {
				slf4jLogger.info(
						"Issues found Need to be checked Here but Selected Essential Home Phone with Unlimited LD Matching Offer By Default Value");
			}
		}

		else {
			try {
				orderPage.HomePhoneUnlimited.waitUntilClickable();
				orderPage.HomePhoneUnlimited.click();
				slf4jLogger.info("Selected Essential Home Phone with Unlimited LD Matching Offer");
			} catch (Exception e) {
				slf4jLogger.info(
						"Issues found Need to be checked Here but Selected Essential Home Phone with Unlimited LD Matching Offer By Default Value");
			}

		}

	}
	// Matching Offers HSI + POTS - Nitish<<<<<<<<<<

	@Step
	public void homePhoneonly() {
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		waitABit(5000);
		orderPage.addPhoneDHP.click();
		orderPage.HomePhone.click();
		orderPage.internetIcon.click();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected HomePhone only by deselecting Internet and offers retrived");

	}

	/**
	 * Step to handle the Order Disclosures pop up whenever they pop up for HSI for
	 * NI Order
	 */
	@Step
	public void handles_Order_Disclosures_For_NI_Order_For_HSI() {
		handle_Order_Disclosures_For_NI_Order_For_HSI();
	}

	/**
	 * Method to handle the Order Disclosures pop up whenever they pop up for HSI
	 * for NI order
	 */
	public void handle_Order_Disclosures_For_NI_Order_For_HSI() {

		if (orderPage.lbl_Order_Disclosures_NI_HSI.isPresent()) {
			orderPage.btn_Order_Disclosures_NI_HSI_OK_Got_It.click();
			slf4jLogger.info(
					"-----------OK Got it button clicked in Order Disclosures Tab for NI order for HSI--------------------");
		} else {
			slf4jLogger.info(
					"-----------Order Disclosures Tab is not present for for NI order for HSI--------------------");
		}

	}

	/**
	 * Step to handle the Order Disclosures pop up whenever they pop up for POTS for
	 * NI Order
	 */
	@Step
	public void handles_Order_Disclosures_For_NI_Order_for_POTS() {
		handle_Order_Disclosures_For_NI_Order_for_POTS();
	}

	/**
	 * Method to handle the Order Disclosures pop up whenever they pop up for POTS
	 * for NI order
	 */
	public void handle_Order_Disclosures_For_NI_Order_for_POTS() {

		if (orderPage.lbl_Order_Disclosures_NI_POTS.isPresent()) {
			orderPage.btn_Order_Disclosures_NI_POTS_OK_Got_It.click();
			slf4jLogger.info(
					"-----------OK Got it button clicked in Order Disclosures Tab for NI order for HSI--------------------");
		} else {
			slf4jLogger.info(
					"-----------Order Disclosures Tab is not present for for NI order for HSI--------------------");
		}
	}

	/**
	 * Step to handle the Order Disclosures pop up whenever they pop up for HSICVOIP
	 * for NI Order
	 */
	@Step
	public void handles_Order_Disclosures_For_NI_Order_for_HSICVOIP() {
		handle_Order_Disclosures_For_NI_Order_for_HSICVOIP();
	}

	/**
	 * Method to handle the Order Disclosures pop up whenever they pop up for
	 * HSICVOIP for NI order
	 */
	public void handle_Order_Disclosures_For_NI_Order_for_HSICVOIP() {

		if (orderPage.lbl_Order_Disclosures_NI_HSICVOIP.isPresent()) {
			orderPage.btn_Order_Disclosures_NI_HSICVOIP_OK_Got_It.click();
			slf4jLogger.info(
					"-----------OK Got it button clicked in Order Disclosures Tab for NI order for HSI--------------------");
		} else {
			slf4jLogger.info(
					"-----------Order Disclosures Tab is not present for for NI order for HSI--------------------");
		}
	}

	/**
	 * Step to handle the Order Disclosures pop up whenever they pop up for HSIPOTS
	 * for NI Order
	 */
	@Step
	public void handles_Order_Disclosures_For_NI_Order_for_HSIPOTS() {
		handle_Order_Disclosures_For_NI_Order_for_HSIPOTS();
	}

	/**
	 * Method to handle the Order Disclosures pop up whenever they pop up for
	 * HSICVOIP for NI order
	 */
	public void handle_Order_Disclosures_For_NI_Order_for_HSIPOTS() {

		if (orderPage.lbl_Order_Disclosures_NI_HSIPOTS.isPresent()) {
			orderPage.btn_Order_Disclosures_NI_HSIPOTS_OK_Got_It.click();
			slf4jLogger.info(
					"-----------OK Got it button clicked in Order Disclosures Tab for NI order for HSI--------------------");
		} else {
			slf4jLogger.info(
					"-----------Order Disclosures Tab is not present for for NI order for HSI--------------------");
		}
	}

	// ac31339
	@Step
	public void directTV() {
		orderPage.bestInstallationOptionDrpdwn.waitUntilClickable();
		Actions act = new Actions(getDriver());
		act.moveToElement(orderPage.addTV).click().build().perform();
		act.moveToElement(orderPage.directTV).click().build().perform();
		orderPage.retriveoption.click();
		slf4jLogger.info("Selected Home Phone and offers retrived");

	}

	// Nitish
	@Step
	public void select_prepaid_or_postapsid_Offer(String offerRequested) {
		try {
			WebElement offer = getDriver().findElement(By.xpath("//div[contains(text(),'" + offerRequested + "')]"));
			JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
			jse2.executeScript("arguments[0].click();", offer);
			slf4jLogger.info(offerRequested + "  Offer Selected");

		} catch (NoSuchElementException e) {

			slf4jLogger.info("Exception Occured");
			WebElement offer = getDriver().findElement(By.xpath("(//div[contains(text(),'Internet')])[4]"));
			JavascriptExecutor jse2 = (JavascriptExecutor) getDriver();
			jse2.executeScript("arguments[0].click();", offer);
			slf4jLogger.info("Unable to find the Requested Offer so selected - " + offer.getText());
			slf4jLogger.info("Exception Caught");
		}

	}

}
