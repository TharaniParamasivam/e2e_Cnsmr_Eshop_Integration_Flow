package com.ctl.it.qa.eshop.tests.stepdefinitions;

import com.ctl.it.qa.eshop.tools.steps.CustomerDetailsSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CustomerDetailsStepDefinition {

	@Steps
	CustomerDetailsSteps customerDetailsSteps;

	@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" in customer detail page$")
	public void i_enter_the_and_in_customer_detail_page(String env, String first, String last, String phone,
			String address) throws Throwable {

		/*if (env.equals(RunCukesTest.passedInEnv)) {
			customerDetailsSteps.searchAccount(env, first, last, phone, address);
			slf4jLogger.info(">>>>>>>>  Processing data row: Env=" + env + "; FName=" + first + "; LName=" + last
					+ "; Phone=" + phone + "; Address=" + address + " <<<<<<<<");
		} else { // Env value passed in is DIFFERENT FROM THE ONE ON THE DATA
					// ROW, HENCE SKIP THIS DATA ROW (e.g., E2E PASSED IN, BUT
					// DATA ROW HAS ITV2 IN IT)
			// AK..NOTE: DO NOT EXECUTE IF ENV PASSED IN DIFFERENT FROM THE ONE
			// IN THE DATA TABLE - hence commenting the line below to skio these
			// data-rows
			// customerDetailsSteps.searchAccount(env, first, last, phone,
			// address);
			slf4jLogger.info("<<<<<<<<  Skipping data row: Entered Customer Details for: Env=" + env + "; FName="
					+ first + "; LName=" + last + "; Phone=" + phone + "; Address=" + address + " >>>>>>>>");
		}*/

	}

	@Then("^I click let's go button$")
	public void i_click_let_s_go_button() throws Throwable {

		customerDetailsSteps.letsGoButton();

	}

	@Then("^I should get no match found text$")
	public void i_get_no_match_found() throws Throwable {

		customerDetailsSteps.noMatchFoundText();

	}

	@Then("^I should get more than one address field$")
	public void i_should_get_more_match_found() throws Throwable {

		customerDetailsSteps.checkNumOfAddress();

	}

	@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in customer detail page$")
	public void i_enter_the_in_customer_detail_page_a(String env1, String first1, String last1, String phone1)
			throws Throwable {

		/*if (env1.equals(RunCukesTest.passedInEnv)) {
			customerDetailsSteps.searchAccoundetails(env1, first1, last1, phone1);
			slf4jLogger.info(">>>>>>>>  Processing data row: Env=" + env1 + "; FName=" + first1 + "; LName=" + last1
					+ "; Phone=" + phone1);
		} else {
			slf4jLogger.info("<<<<<<<<  Skipping data row: Entered Customer Details for: Env=" + env1 + "; FName="
					+ first1 + "; LName=" + last1 + "; Phone=" + phone1);

		}*/

	}

	@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in address page$")
	public void i_enter_the_in_address_page(String street, String unit, String city, String state, String zip)
			throws Throwable {

		customerDetailsSteps.enterAddressdetails(street, unit, city, state, zip);

	}

	@Then("^I select Matched Address$")
	public void i_select_Matched_Address() throws Throwable {

		customerDetailsSteps.selectMatchAddress();

	}
	
	//Nitish
	

	@When("^I click on Account or Order already exists link$")
	public void i_click_on_Account_or_Order_already_exists_link() throws Throwable {
	    
		customerDetailsSteps.i_click_on_Account_or_Order_already_exists_link();
	}


	@Then("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" in existing order view page$")
	public void i_enter_the_and_in_existing_order_view_page(String env, String first, String last, String phone) throws Throwable {
		customerDetailsSteps.searchAccoundetails(env, first, last, phone);
		
	    
	}
	
	//Nitish MACD Scenarios
	
	//SFC Login
	
	@When("^I enter only the completed account \"([^\"]*)\"$")
	public void i_enter_only_the_completed_account(String completed_accountnum)  {
		customerDetailsSteps.enter_completed_account_number(completed_accountnum);
	}
	
	@Then("^I click on create new account$")
	public void i_click_on_create_new_account() {
	customerDetailsSteps.click_create_new_accountnew();
//		customerDetailsSteps.click_create_new_account();
	
	}

	@Then("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" in new acquisition page$")
	public void i_cretae_new_account(String first, String last, String phone,
			String address)  {
		customerDetailsSteps.create_new_account(first,last,phone,address);
	}
	
	//Prepaid Nitish
		@When("^I enter the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" in customer detail page$")
		public void i_enter_the_and_in_customer_detail_page(String first, String last, String phone, String address) {
				
			customerDetailsSteps.EnterPreapid_detailsoneshopage(first, last, phone, address);
			
		}
		
	@Then("^I validate the address and save it$")
	public void i_validate_the_address_and_save_it()  {
		customerDetailsSteps.validate_address();
	}

	@Then("^I click on order eshop button$")
	public void i_click_on_order_eshop_button() {
		customerDetailsSteps.click_order_eshop();
	}
	
	
	

}
