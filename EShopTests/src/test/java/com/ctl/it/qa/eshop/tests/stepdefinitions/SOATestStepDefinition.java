package com.ctl.it.qa.eshop.tests.stepdefinitions;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.http.client.ClientProtocolException;
import org.xml.sax.SAXException;

import com.ctl.it.qa.eshop.tools.steps.SOATestServiceSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SOATestStepDefinition {
	
	@Steps
	SOATestServiceSteps soatestservicesteps;
	
		
	@Given("^I provide request details and \"([^\"]*)\"$")
	public void i_provide_request_details_and(String URL) throws ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException, TransformerException, ParserConfigurationException, SAXException {
		soatestservicesteps.GetRequestandURL(URL);
	    
	}

	@When("^I run SOAP UI request$")
	public void i_run_SOAP_UI_request() {
		soatestservicesteps.runSOAPUI();
	    
	}

	@Then("^I get response details$")
	public void i_get_response_details() {
		soatestservicesteps.getreponse();
	    
	}
}
