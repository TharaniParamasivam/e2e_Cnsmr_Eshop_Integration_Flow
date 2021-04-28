package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.tools.steps.PrepaidAccountInformationSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class PrepaidAccountInformationStepDefinition {

	@Steps
	PrepaidAccountInformationSteps prepaidaccountinformationsteps;
	
	
	@Then("^I should be on Prepaid Account Information Page for Prepaid Order$")
	public void i_should_be_on_Prepaid_Account_Information_Page_for_Prepaid_Order() {
		prepaidaccountinformationsteps.on_Prepaid_Account_Page();
	}

	@Then("^I enter \"([^\"]*)\" and \"([^\"]*)\" for Prepaid Order$")
	public void i_enter_and_for_Prepaid_Order(String emailid, String smsno) {
		prepaidaccountinformationsteps.enter_email_sms_for_Prepaid(emailid, smsno);
	}

	@Then("^I click on account Continue button for Prepaid Order$")
	public void i_click_on_account_Continue_button_for_Prepaid_Order() {
		prepaidaccountinformationsteps.Continue_button_click_for_Prepaid_Order();
	}

	@Then("^I Make Payement for Prepaid Order \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_Make_Payement_for_Prepaid_Order(String cardname, String cardnumber, String zipcode) {
		prepaidaccountinformationsteps.i_Make_Payement_for_Prepaid_Order(cardname, cardnumber, zipcode);
	}
}
