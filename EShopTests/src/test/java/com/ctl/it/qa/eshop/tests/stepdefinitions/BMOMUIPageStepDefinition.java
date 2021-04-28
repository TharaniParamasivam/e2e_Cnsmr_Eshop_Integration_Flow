package com.ctl.it.qa.eshop.tests.stepdefinitions;

import org.junit.Assert;

import com.ctl.it.qa.eshop.tools.steps.BMOMUISteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BMOMUIPageStepDefinition {
	
	@Steps
	BMOMUISteps bmomuiSteps;
	
	 /** 
	    * Darshan- AC49667
	    * BM UI dashboard method
	    */
		@Given("^I should be on BM UI dashboard$")
		public void i_should_be_on_BM_UI_dashboard() {

			bmomuiSteps.BM_UI_OpenPage();

		}
		
		

		 /** 
		 * Darshan- AC49667
		 * BM UI Header Text
		 */
		@When("^I am in BM UI dashboard page$")
		public void i_am_in_BM_UI_dashboard_page() {
			try {
				bmomuiSteps.verfyBMuiHeader();
			} catch (Exception ex) {
				Assert.fail();
			}

		}
		
		 /** 
		 * Darshan- AC49667
		 * Click on Hamburger Icon
		 */
		
		@Then("^I click hamburger icon$")
		public void i_click_hamburger_icon() throws Throwable {

			bmomuiSteps.hamburgerIcon();

		}

		
		
		@Given("^I click on blue marble order management$")
		public void i_click_on_blue_marble_order_management() throws Throwable {

			bmomuiSteps.clickOnBMOM();
		}
		
		
		 /** 
		 * Darshan- AC49667
		 * Click on Manage Jeopardy
		 */
		@And("^I click on Manage Jeopardy$")
		public void i_click_on_Manage_Jeopardy() {

			bmomuiSteps.clickManageJeopardy();

		}
}
