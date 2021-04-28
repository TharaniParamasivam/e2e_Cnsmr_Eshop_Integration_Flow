package com.ctl.it.qa.eshop.tests.stepdefinitions;

import org.junit.Assert;

import com.ctl.it.qa.eshop.tools.steps.SchedulingSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SchedulingPageStepDefinition {

	@Steps
	SchedulingSteps schedulingSteps;

	@Then("^I enter dueDate$")
	public void i_enter_dueDate() throws Throwable {

		schedulingSteps.dueDateSelection();

	}

	@Then("^I click on continue button of scheduling page$")
	public void i_click_on_continue_button_of_scheduling_page() throws Throwable {

		schedulingSteps.clickOnContinue();

	}

	@Then("^I should get earliest available appointment text$")
	public void i_should_get_earliest_appointment() {

		schedulingSteps.verifyEarliestAppoitmentText();

	}

	@And("^I click to reserve appointment$")
	public void i_click_to_reserve_appoitment() {

		schedulingSteps.reserveAppointment();

	}

	@Then("^I enter Driving Directions \"([^\"]*)\"comments$")
	public void i_enter_Driving_Directions_comments(String driverComment) throws Throwable {

		schedulingSteps.DriverComments(driverComment);

	}

	@Then("^I enter Additional \"([^\"]*)\" comments$")
	public void i_enter_Additional_comments(String AddComment) throws Throwable {

		schedulingSteps.AdditionalComments(AddComment);

	}

	@Then("^reserve date should display as due date$")
	public void reserve_due_date_display_as_due_date() {

		schedulingSteps.verifyDueDateUpdate();
	}
	
	@And("^I get the update dute date$")
	public void i_get_update_due_date() throws InterruptedException {
		schedulingSteps.getDueDate();
	}
	
	@Then("^I select the provided due date for installation \"([^\"]*)\"$")
	public void i_select_the_provided_due_date_for_installation(String passedDate) throws Exception {
	   
		System.out.println(passedDate);
		schedulingSteps.enterdate(passedDate);
	}

	@Then("^I select the provided due date for installation for POTS only\"([^\"]*)\"$")
	public void i_select_the_provided_due_date_for_installation_for_POTS_only(String passedDate) throws Exception {
		System.out.println(passedDate);
		schedulingSteps.enterDateForPOTSOnly(passedDate);
	}
	//Ac64192
	@Then("I click on change billing address link$")
    public void i_click_on_change_billing_link() throws Exception {
        schedulingSteps.clickChangeBillingLink();
    }
	
	  @Then("I click validate button$")
	    public void i_click_validate_button() {
	        schedulingSteps.clickValidateButton();
	    }
	  @Then("I click on Ship to this address button$")
	    public void i_click_on_ship_to_this_address_button() {
	        schedulingSteps.clickShipToThisAddressButton();
	    }
	
	
	
	

}
