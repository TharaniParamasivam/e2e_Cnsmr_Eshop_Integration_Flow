package com.ctl.it.qa.eshop.tools.steps;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.pages.BMOMUIPage;
import com.ctl.it.qa.staf.Steps;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Step;

public class BMOMUISteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(BMOMUISteps.class);
	BMOMUIPage bmomuiPage;
	
	 /** 
	 * Darshan- AC49667
	 * BM UI Opening URL
	 */
	@Step
	public void BM_UI_OpenPage() {

		try {
			bmomuiPage.openAt(envData.getFieldValue("bmom-url"));
			bmomuiPage.maximize();
			slf4jLogger.info("Open Eshop application URL: " + envData.getFieldValue("bmom-url") + " successfully");
		} catch (Exception e) {
			slf4jLogger.error("Error opening Eshop application URL: " + envData.getFieldValue("bmom-url") + ": Error: "
					+ e.getMessage());
		}
	}
	
	 /** 
	 * Darshan- AC49667
	 * Verify BM UI Header Text
	 */
	@Step
	public void verfyBMuiHeader() throws InterruptedException {
		
		waitABit(2000);
		String blueMarbleText = "Blue Marble";
		Assert.assertTrue(bmomuiPage.blueMarble.getText().contains(blueMarbleText));
		slf4jLogger.info("Verified blue marble page");
		slf4jLogger.info("Now in Eshop Environment  " + bmomuiPage.getCurrentEnvironment());
		slf4jLogger.info("Eshop URL for Current Environment is   " + getDriver().getCurrentUrl());
	}
	
	@Step
	public void hamburgerIcon() {
		waitABit(2000);
		bmomuiPage.hamburgerOption.click();
		slf4jLogger.info("clicked on to 'Ham Burger' option");
		waitABit(5000);
	}
	
	/** 
	 * Darshan- AC49667
	 * Click on BM OM
	 */
	@Step
	public void clickOnBMOM() {
		
		if(bmomuiPage.clickBMOM.isEnabled()){
			bmomuiPage.clickBMOM.click();
			slf4jLogger.info("Clicked on Blue Marble Order Management");
		}
		
		waitABit(5000);
		
	}
	

	/** 
	 * Darshan- AC49667
	 * Click on Manage Jeopardy
	 */
	
	public void clickManageJeopardy() {
		
		waitABit(5000);
		if(bmomuiPage.clickBMOM.isCurrentlyVisible()) {
			bmomuiPage.manageJeopardyText.click();
			slf4jLogger.info("Clicked on Manage Jeopardy");
		}
		waitABit(2000);
	} 
	
	

	
	
}
