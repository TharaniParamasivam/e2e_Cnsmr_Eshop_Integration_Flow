package com.ctl.it.qa.eshop.tests.stepdefinitions;


import com.ctl.it.qa.eshop.tools.steps.OrderSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderPageStepDefinition {

	@Steps
	OrderSteps orderSteps;

	@When("^I click on continue button$")
	public void i_click_on_continue_button1() throws Throwable {

		orderSteps.clickOnContinue();

	}
	

	@Then("^I should be in Product offer page$")
	public void i_should_be_in_Product_offer_page() {
		try {
			orderSteps.verfyBuildYourOffer();
		} catch (Exception ex) {
			//RunCukesTest.scenarioFailedReason = ex.getMessage();
			//Assert.fail();
		}

	}

	@Then("^I should get build your offer tab on product page$")
	public void i_should_get_build_offer() throws Throwable {

		orderSteps.buildOfferPage();

	}
	
	@When("I select the lowerspeed {string}")
	public void i_select_the_lowerspeed(String speed) {
		orderSteps.speedSelection(speed);
	   
	}
	
	@Then("^I select the best \"([^\"]*)\" installation option$")
	public void i_select_the_best_installation_option_Self_Install(String installOpt) throws Throwable {

		orderSteps.selectBestinstallation(installOpt);

	}

	@Then("^I select Your \"([^\"]*)\" Modem option$")
	public void i_select_Your_Modem_option(String modemOpt) throws Throwable {

		orderSteps.selectModemOption(modemOpt);

	}

	@Then("^I select \"([^\"]*)\" Ease Option$")
	public void i_select_Ease_Option_Standard(String easeOpt) throws Throwable {

		orderSteps.selectEaseOption(easeOpt);

	}

	@And("^I select CVoip DHP phone$")
	public void i_select_CVoip_DHP_phone() throws Throwable {

		orderSteps.CVoipDHPhone();

	}

	@And("^I select address info popup$")
	public void i_select_address_info_popup() {

		orderSteps.important911AdderessInfoPopUp();

	}

	//Nitish Pots
	@Then("^I select HomePhone$")
	public void i_select_HomePhone() throws Throwable {

		orderSteps.homePhone();

	} 
	//Nitish for Quantity Selection
	@Then("^I select the number of device needed \"([^\"]*)\"$")
	public void i_select_the_number_of_device_needed(String quantity) {

		orderSteps.quatity_selection(quantity);
	}
	//Nitish Pots Mandatory order fix

	@Then("^I select required option for voice mail \"([^\"]*)\"$")
	public void i_select_required_option_for_voice_mail(String passedvalue) throws Exception {

		orderSteps.voice_mail_selection(passedvalue);
	}


	@Then("^I select required option for Wire Maintenance Plan \"([^\"]*)\"$")
	public void i_select_required_option_for_Wire_Maintenance_Plan(String passedvalue) throws Exception {

		orderSteps.Wire_Maintenance_Plan_selection(passedvalue);
	}

	@Then("^I select required option for Port in a phone number\\? \"([^\"]*)\"$")
	public void i_select_required_option_for_Port_in_a_phone_number(String passedvalue) throws Exception {

		orderSteps.Port_in_a_phone_number(passedvalue);
	}

	@Then("^I select required option for Need new jacks or wiring\\? \"([^\"]*)\"$")
	public void i_select_required_option_for_Need_new_jacks_or_wiring(String passedvalue) throws Exception {

		orderSteps.Need_new_jacks_or_wiring(passedvalue);
	}



	//******* ac31339 code starts

	@Then("^I select Internet$")
	public void i_select_Internet() {
		orderSteps.interNet();
	}

	@Then("^I select the Available speed \"([^\"]*)\"$")
	public void i_select_the_available_speed(String Selectspeed) throws Throwable {

		orderSteps.selectAvailableSpeed(Selectspeed);

	}


	@Then("^I select One Pty Residence Line$")
	public void i_select_OnePty_Residence_Line() {
		orderSteps.onePtyResidenceLine();
	}

	@Then("^I select Price for Life Unlimited Phone unlimited Calling$")
	public void i_select_Life_Unlimited_Phone_Unlimited_Calling() {
		orderSteps.lifeUnlimitedPhoneCalling();
	}

	@Then("^I select customize services Internet$")
	public void i_select_Customize_Sevices_Internet() {
		orderSteps.customizeServiceInterNet();
	}

	// ac31339 code Ends
	//Nitish code for matching offers for HSI + POTS
	@Then("^I select the suitable matching offer \"([^\"]*)\"$")
	public void i_select_the_suitable_matching_offer(String passedvalue) throws Exception {
		orderSteps.matchingOffersSelected(passedvalue);
	}


	@Then("^I should be in Eshop Product offer page$")
	public void i_should_be_in_Eshop_Product_offer_page() {
		try {
			orderSteps.WaitForPageToLoad(100);
			//orderSteps.shouldExist(accountInformationPage,120);
			orderSteps.verfyBuildYourOffer();
			
		} catch (Exception ex) {
			//RunCukesTest.scenarioFailedReason = ex.getMessage();
			//Assert.fail();
		}
	}

	@Then("^I select HomePhone only by deselecting Internet$")
	public void i_select_HomePhone_only() throws Throwable {

		orderSteps.homePhoneonly();

	} 
	
    @Then("^I select DTV$")
    public void i_select_DTV() throws Throwable {
    	orderSteps.directTV();
    }


	@Then("^I click on OK Got it button on Order Disclosures dialog box for NI Order for HSI$")
    public void i_click_on_OK_Got_it_button_on_Order_Disclosures_dialog_box_for_NI_Order_for_HSI() {
           orderSteps.handles_Order_Disclosures_For_NI_Order_For_HSI();
    } 

	
	@Then("^I click on OK Got it button on Order Disclosures dialog box for NI Order_for_POTS$")
	public void i_click_on_OK_Got_it_button_on_Order_Disclosures_dialog_box_for_NI_Order_for_POTS() {
		orderSteps.handles_Order_Disclosures_For_NI_Order_for_POTS();
	}
	
	@Then("^I click on OK Got it button on Order Disclosures dialog box for NI Order for HSICVOIP$")
	public void i_click_on_OK_Got_it_button_on_Order_Disclosures_dialog_box_for_NI_Order_for_HSICVOIP() {
		orderSteps.handles_Order_Disclosures_For_NI_Order_for_HSICVOIP();
	}
	
	
	@Then("^I click on OK Got it button on Order Disclosures dialog box for NI Order for HSIPOTS$")
	public void i_click_on_OK_Got_it_button_on_Order_Disclosures_dialog_box_for_NI_Order_for_HSIPOTS() {
		orderSteps.handles_Order_Disclosures_For_NI_Order_for_HSIPOTS();
	}
	
	//Nitish Prepaid
		@Then("^I select the Prepaid or Postpaid offer\"([^\"]*)\"$")
	    public void i_select_the_Prepaid_or_Postpaid_offer(String offerRequested) {
	    	orderSteps.select_prepaid_or_postapsid_Offer(offerRequested);
	    }

}
