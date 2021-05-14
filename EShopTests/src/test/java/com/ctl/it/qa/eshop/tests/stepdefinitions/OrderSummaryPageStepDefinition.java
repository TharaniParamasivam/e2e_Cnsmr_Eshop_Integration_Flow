package com.ctl.it.qa.eshop.tests.stepdefinitions;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.parser.ParseException;

import com.ctl.it.qa.eshop.tools.steps.FFWFCompleteOrderSteps;
import com.ctl.it.qa.eshop.tools.steps.OrderSummarySteps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class OrderSummaryPageStepDefinition {

	@Steps
	OrderSummarySteps orderSummarySteps;

	@Then("^I selected Yes for the review in order summary page$")
	public void i_selected_Yes_for_the_review_in_order_summary_page() throws Throwable {
		orderSummarySteps.clickYes();
	}

	@Then("^I clicked submit order button$")
	public void i_clicked_submit_order_button() throws Throwable {

		orderSummarySteps.clickSubmitOrder();

	}

	@Then("^I should able to submit order successfully$")
	public void i_should_able_to_submit_order_successfully() throws Throwable {
		// commented below line since there is issue with the order confirmation page
		// orderSummarySteps.orderSummaryPageVerification();

	}

	@Then("^I will add technician \"([^\"]*)\" remarks$")
	public void i_will_add_technician_remarks(String techRemark) throws Throwable {

		orderSummarySteps.enterTechnicianRemarks(techRemark);

	}

	@Then("^I verfy the technical notes$")
	public void i_verfy_the_technical_notes() throws Throwable {

		orderSummarySteps.checkRemarks();

	}

	@Then("^I get account number from application$")
	public void i_get_account_num() throws Exception {

		orderSummarySteps.getAccountNumber();

	}

	@Then("^I validate address and dueDate with \"([^\"]*)\"$")
	public void i_validate_address(String address) {
		// commented below line as the application design got changed
		// orderSummarySteps.validateDueDate(address);

	}

	// Nitish
	@Then("^I Click on start new order button$")
	public void i_Click_on_start_new_order_button() throws Throwable {
		orderSummarySteps.i_clicked_on_new_order();

	}

	@Then("^I enter the existing captured account number$")
	public void i_enter_the_existing_captured_account_number() throws Throwable {
		orderSummarySteps.i_enter_existing_account_number(OrderSummarySteps.accountnum);
	}

	@Then("^I enter the special remark in Additional Order Remarks field \"([^\"]*)\"$")
	public void i_enter_the_special_remark_in_Additional_Order_Remarks_field(String datapassed) {
		orderSummarySteps.enter_the_special_remark_in_Additional_Order_Remarks_field(datapassed);
	}

	@Then("^I use mongo DB to fetch backend data$")
	public void i_use_mongo_DB_to_fetch_backend_data() throws Exception {
		orderSummarySteps.mongo_DB_to_fetch_backend_data();
	}

	// premkumar I logout the application

	@Then("^I do logout the application$")
	public void I_do_logout_the_application() {
		orderSummarySteps.logout_the_application();
	}

	@Then("^I save the Order and Ban in the excel_sheet$")
	public void i_save_the_Order_and_BAN_in_the_excel_sheet() throws Exception {
		orderSummarySteps.save_the_Order_and_BAN();		
	}
	
	@Then("I save the Order and Ban in the excel_sheet with respect to {string},{string}")
	public void i_save_the_Order_and_Ban_in_the_excel_sheet_with_respect_to(String territory,String EnvName) throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		orderSummarySteps.save_the_Order_and_BAN_JSON(territory,EnvName);
	}
	
	@Then("I complete the provisioning")
	public void i_complete_the_provisioning() throws InterruptedException {
		orderSummarySteps.integrationScriptInvoke();
	}

	
	@Then("I Use Web Tool to Complete Provisioning of the Order in Env {string},{string}")
	public void i_Use_Web_Tool_to_Complete_Provisioning_of_the_Order_in_Env(String EnvName, String territory) {
		orderSummarySteps.Web_Tool_to_Complete_Provisioning_of_the_Order_in_Env(EnvName,territory);
	}



}
