package com.ctl.it.qa.eshop.tools.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.pages.SelfServicePage;
import com.ctl.it.qa.staf.Steps;

import net.thucydides.core.annotations.Step;

public class SelfServiceSteps extends Steps{
	
	private final Logger slf4jLogger = LoggerFactory.getLogger(SelfServiceSteps.class);
	
	SelfServicePage selfServicePage;
	@Step
	public void mya_URL_OpenPage() {

		try {
			selfServicePage.openAt(envData.getFieldValue("MYAurl"));
			selfServicePage.maximize();
			slf4jLogger.info("Open SFC application URL: " + envData.getFieldValue("MYAurl") + " successfully");
		} catch (Exception e) {
			slf4jLogger.error("Error opening SFC application URL: " + envData.getFieldValue("MYAurl") + ": Error: "
					+ e.getMessage());
		}
	}
	
	@Step
	public void MYA_() {
		selfServicePage.signIn.click();
		selfServicePage.enterCredentials("Valid");
		slf4jLogger.info("Entered credentials successfully");
	}


}
