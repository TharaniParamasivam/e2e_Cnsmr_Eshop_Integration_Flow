package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.tools.steps.PrePaidWebServiceSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PrePaidWebServiceStepDefinition {
	
	@Steps
	PrePaidWebServiceSteps prepaidwebservicesteps;
	
		
	@Given("^I want to execute service \"([^\"]*)\"$")
	public void i_want_to_execute_service(String url) {
		prepaidwebservicesteps.execute_service(url);
	}

	@When("^I submit the GET request$")
	public void i_submit_the_GET_request() {
		prepaidwebservicesteps.GET_request();   
	 
	}

	@When("^I submit the POST request$")
	public void i_submit_the_POST_request() {
		prepaidwebservicesteps.POST_request(); 
	}

	@When("^I validate status code$")
	public void i_validate_status_code() {
		prepaidwebservicesteps.status_code();
	}    
		
	@Then("^I validate status code \"([^\"]*)\"$")
		public void i_validate_status_code(int passedstatuscode) {
		prepaidwebservicesteps.status_code(passedstatuscode);
	}
	
	@When("^I pass the data as parameters in a file \"([^\"]*)\"$")
	public void i_pass_the_data_as_parameters_in_a_file(String fileLocation) throws Exception {
			prepaidwebservicesteps.input_paramaters_from_file(fileLocation);	
	}
	
	
	@Then("^I submit the GET request with Parameters \"([^\"]*)\"$")
	public void i_submit_the_GET_request_with_Parameters(String parameters) {
		prepaidwebservicesteps.submit_the_GET_request_with_Parameters(parameters);
	}
	
	@Then("^I validate the object data \"([^\"]*)\"$")
	public void i_validate_the_object_data(String data) {
		prepaidwebservicesteps.validate_the_object_data(data);
	}
}
