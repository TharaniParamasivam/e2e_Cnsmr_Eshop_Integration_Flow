@EshopTestScripts @EShopSatandaloneOrderCompletionSanity
Feature: Order Creation and Order Completion

  @HSIPOTS_NI_E2E_Shakeout_Postpaid_LC
  Scenario Outline: Create a HSI + POTS Postpaid Order and Provisioning it
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    And I select HomePhone
    When I select the lowerspeed "<Speed>"
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    Then I select the number of device needed "<Device Quantity>"
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on continue button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Bypass Credit Check"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I use mongo DB to fetch backend data
    Then I save the Order and Ban in the excel_sheet
    Then I complete the order in websop
    ### Use "<ToolENV>" Values as Test1,Test2,Test3,Test4,Dev1,Dev2,Dev3,Dev4
    Then I Use Web Tool to Complete Provisioning of the Order in Env "<ToolENV>","<territory>"
    Then I check for the billing Status as Success in MongoDB

    Examples: 
      |territory| firstName | lastName | phoneNo    | Matching Offers              | PostPaid Offer                      | Speed                      | address                                      | Installation_option | Modem_Option | Ease_Option | email     | SMSNo      | Date | Month | Year | SSN       | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       | ToolENV |
   	 | LQ | BERRY     | TOMS     | 4029986730 | Home Phone with Unlimited LD | PFL CenturyLink High Speed Internet |  HSI Up to 40 Mbps/3 Mbps | 2319 10TH ST,CORALVILLE,IA 52241,USA | Standard | Purchase     | Basic       | testhundredsixty@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION |Test1 |
   # | LC | THOMAS    | MOSAIC   | 4029986730 | Home Phone with Unlimited LD | PFL CenturyLink High Speed Internet | HSI Up to 30 Mbps/1.5 Mbps |306 W AZURE AVE,NORTH LAS VEGAS,NV 89031,USA | Standard            | Purchase     | Basic       | t@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 2 devices       | No         | No                    | No                      | No Work Is Needed ($0)    | ESHOP ORDER TEST BY AUTOMATION | Test1   |


  @HSI_NI_E2E_Shakeout_Prepaid_LQ
  Scenario Outline: Create a HSI LQ Prepaid Order and Provisioning it
   Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
    Then I select the Prepaid or Postpaid offer"<PrePaid Offer>"
   # And I select address info popup
    When I select the lowerspeed "<Speed>"    
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    #And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on continue button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I should be on Prepaid Account Information Page for Prepaid Order
    And I enter "<email>" and "<SMSNo>" for Prepaid Order
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I click on account Continue button for Prepaid Order
    And I Make Payement for Prepaid Order "<cardName>" "<cardNumber>" "<zip code>"
    And I click on account Continue button for Prepaid Order
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I save the Order and Ban in the excel_sheet

    # Use "<ToolENV>" Values as Test1,Test2,Test3,Test4,Dev1,Dev2,Dev3,Dev4
    #Then I Use Web Tool to Complete Provisioning of the Order in Env "<ToolENV>"
    #Then I check for the billing Status as Success in MongoDB
    Examples: 
     |territory | firstName | lastName | phoneNo    | address                              | PrePaid Offer                  | Speed              | email                         | SMSNo      | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | cardName         | cardNumber       | zip code | Device Quantity | Additional Order Remarks         | ToolENV |
      | LC | Tabby     | Tall's   | 4029986730 | 1693 GARFIELD AVE,DUBUQUE,IA 52001,USA | CenturyLink Internet (PREPAID) | HSI Up to 15 Mbps/750 Kbps | TestHundredfiftyseven@Ctl.com | 4029986730 | Tech Install ($99) | Lease        | Basic       |   01 |    01 | 1990 | Nitish Pattanaik | 6011471593914630 |    52001 | 2 devices       | ESHOP PREPAID TEST BY AUTOMATION | Test1   |
