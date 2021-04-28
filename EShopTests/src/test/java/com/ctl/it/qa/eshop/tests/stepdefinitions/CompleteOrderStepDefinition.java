package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.tools.steps.CompleteTomBillingOrderSteps;
import com.ctl.it.qa.eshop.tools.steps.FFWFCompleteOrderSteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CompleteOrderStepDefinition {
	
	@Steps
	CompleteTomBillingOrderSteps completeordersteps;
	@Steps
	FFWFCompleteOrderSteps ffwfcompleteordersteps;
	
	@Then("^I Should Complete the Backend Tasks FFWF TOM and Billing as Completed$")
	public void i_Should_Complete_the_Backend_Tasks_FFWF_TOM_and_Billing_as_Completed() {
	   
		//ffwfcompleteordersteps.FFWFTaskCompleteManager();
		ffwfcompleteordersteps.FFWFTaskCompleteManager2();
		completeordersteps.Complete_TOM_and_Billing_Tasks();
		
	}
	
	@Then("^I wake up remote computer to be ready to complete websop tasks as a precaution step$")
	public void i_wake_up_remote_computer_to_be_ready_to_complete_websop_tasks_as_a_precaution_step() {
		completeordersteps.wake_up_remote_computer();
	}
	
	@Then("^I Should Complete the Backend Task FFWF$")
	public void then_I_Should_Complete_the_Backend_Task_FFWF() {
		ffwfcompleteordersteps.FFWFTaskCompleteManager2();
	}


	@Then("^I Should Complete the Backend LC Martens Task$")
	public void then_I_Should_Complete_the_Backend_LC_Martens_Task() throws Exception  {
		completeordersteps.complete_LC_Martenes_Task();
	}
	
	@Then("^I check for the billing Status as Success in MongoDB$")
	public void i_check_for_the_billing_Status_as_Success_in_MongoDB() {
		ffwfcompleteordersteps.check_for_the_billing_Status_as_Success_in_MongoDB();
	}

	
	
}
