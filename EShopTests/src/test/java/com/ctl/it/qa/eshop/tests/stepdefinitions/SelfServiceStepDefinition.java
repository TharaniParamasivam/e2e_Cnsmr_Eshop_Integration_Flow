package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.tools.steps.SelfServiceSteps;

import cucumber.api.java.en.Then;

public class SelfServiceStepDefinition {
	SelfServiceSteps selfServiceSteps;
	
	@Then("I login to MYA and add the account")
	public void i_login_to_MYA_and_add_the_account() {
		selfServiceSteps.mya_URL_OpenPage();	    
	}
	
	@Then("I Make payment using MYA {string},{string},{string},{string}")
	public void i_Make_payment_using_MYA(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

}
