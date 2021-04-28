package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.tools.steps.AccountInformationSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AccountInformationStepDefinition {

	@Steps
	AccountInformationSteps accountInformationSteps;

	@Given("^I decline customer email$")
	public void i_decline_customer_email() throws Throwable {

		accountInformationSteps.emailDeclineClick();

	}

	@Then("^I enter date \"([^\"]*)\" month \"([^\"]*)\" and year \"([^\"]*)\" of birth$")
	public void i_enter_date_month_and_year_of_birth(String date, String month, String year) throws Throwable {

		accountInformationSteps.dateOfBirth(date, month, year);

	}

	@Then("^I enter SSN number \"([^\"]*)\"$")
	public void i_enter_SSN_number(String ssn) throws Throwable {

		accountInformationSteps.ssnDetails(ssn);

	}

	@When("^I select credit as \"([^\\\"]*)\"$")
	public void i_select_credit_as(String args) throws Throwable {

		accountInformationSteps.creditCheck(args);

	}

	@When("^I click on account Continue button$")
	public void i_click_on_account_Continue_button() throws Throwable {

		accountInformationSteps.clickAccountInfoContinue();

	}

	@When("^I click again click Continue button on account$")
	public void i_click_again_click_Continue_button_on_account() throws Throwable {

		accountInformationSteps.clickAgainAfterPaymentAccountInfoContinue();
	}

	@And("^I click on payNow$")
	public void i_click_on_payNow1() throws Throwable {

		accountInformationSteps.payNowCredit();

	}

	@And("^I verify age is less than 18$")
	public void i_verify_age_less() throws Throwable {

		accountInformationSteps.verifyage();

	}

	// Nitish Pots
	@Then("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String smsno, String emailid) {
		accountInformationSteps.i_enter_email_and_sms_contacts(smsno, emailid);
	}

	@Then("^I change the billing address to \"([^\"]*)\"$")
	public void i_change_the_billing_address_to(String datapassed) {
		accountInformationSteps.change_billing_address(datapassed);
	}

	// ac31339 launch opus
	@And("^I cick Launch OPUS button$")
	public void i_click_on_launch_opus() throws Throwable {

		accountInformationSteps.lauchOpus();
	}
	
	
	@And("^I do prequalify directtv order$")
	public void i_do_prqualify_directtv_order() throws Throwable {

		accountInformationSteps.prqualify_directtv_order();
	}

}
