@EshopTestScripts @EShopDevStandaloneOrderCompletionSanity
Feature: Order Creation and Order Completion In Dev Env

  #TC
  @HSILQOrderCompletionEshopSanity @EshopDevSanity
  Scenario Outline: Create a HSI LQ Postpaid Order In Dev Env
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    Then I select the Prepaid or Postpaid offer"<PostPaid Offer>"
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    #Then I select specific equipments "Equipment" and "DSL Wall-Mount Filter~DSL In-Line Filter~HSI Wireless USB Adapter"
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I decline customer email
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I save the Order and Ban in the excel_sheet

    Examples: 
      | firstName | lastName | phoneNo    | address                               | PostPaid Offer          | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      | Brent     | Mayes    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | PFL Internet up to 140M | Standard            | Purchase     | Basic       |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  # | Brent     | Mayes    | 4029986730 | 2319 10TH ST,CORALVILLE,IA 52241,USA | PFL CenturyLink High Speed Internet | Standard            | Purchase Lease    | Basic       |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
  #TC
  @HSILCOrderCompletionEshopSanity
  Scenario Outline: Create a HSI LC Postpaid Order
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Eshop Product offer page
    Then I select the Prepaid or Postpaid offer"<PostPaid Offer>"
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    #And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    #Then I select specific equipments "Equipment" and "DSL Wall-Mount Filter~DSL In-Line Filter~HSI Wireless USB Adapter"
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I decline customer email
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I save the Order and Ban in the excel_sheet

    #Below step is precaution step.This can be used only once when executing in a suite or several features/scenarios by placing in first scenario/feature execution file
    # Then I wake up remote computer to be ready to complete websop tasks as a precaution step
    # Then I Should Complete the Backend Tasks FFWF TOM and Billing as Completed
    Examples: 
      | firstName | lastName | phoneNo    | address                              | PostPaid Offer                      | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      | Brent     | Mayes    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA | PFL CenturyLink High Speed Internet | Standard            | Purchase     | Basic       |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  #TC
  @HSICVOIPOrderCompletionEshopSanity @EshopDevSanity
  Scenario Outline: Create a HSI + CVOIP Postpaid Order In Dev Env
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Eshop Product offer page
    Then I select the Prepaid or Postpaid offer"<PostPaid Offer>"
    And I select CVoip DHP phone
    And I select address info popup
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I save the Order and Ban in the excel_sheet

    Examples: 
      | firstName | lastName | phoneNo    | address                               | PostPaid Offer          | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | Device Quantity | Additional Order Remarks       |
      | THOMAS    | HILLA    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | PFL Internet up to 140M | Standard            | Purchase     | Basic       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 3 devices       | ESHOP ORDER TEST BY AUTOMATION |

  #TC
  @HSIPOTS_Home_Phone_with_Unlimited_LDOrderCompletionEshopSanity @EshopDevSanity
  Scenario Outline: Create a HSI + POTS Postpaid Order In Dev Env
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Eshop Product offer page
    Then I select the Prepaid or Postpaid offer"<PostPaid Offer>"
    And I select HomePhone
    #And I select address info popup
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I save the Order and Ban in the excel_sheet

    Examples: 
      | firstName | lastName | phoneNo    | Matching Offers              | PostPaid Offer          | address                               | Installation_option | Modem_Option | Ease_Option | email       | SMSNo      | Date | Month | Year | SSN       | Device Quantity | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | THOMAS    | HILLA    | 4029986730 | Home Phone with Unlimited LD | PFL Internet up to 140M | 611 FENWICK DR,PAPILLION,NE 68046,USA | Standard            | Purchase     | Basic       | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | 2 devices       | No         | No                    | No                      | 1 Jack ($99)              | ESHOP ORDER TEST BY AUTOMATION |

  #TC
  @POTSonlyOrderCompletionEshopSanity @EshopDevSanity
  Scenario Outline: Create a POTS only Postpaid Order In Dev Env
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Eshop Product offer page
    Then I select the Prepaid or Postpaid offer"<PostPaid Offer>"
    And I select HomePhone only by deselecting Internet
    #And I select address info popup
    And I select Price for Life Unlimited Phone unlimited Calling
    Then I select required option for voice mail "<Voice Mail>"
    Then I select required option for Wire Maintenance Plan "<Wire Maintenance Plan>"
    Then I select required option for Port in a phone number? "<Port in a phone number?>"
    Then I select required option for Need new jacks or wiring? "<Need new jacks or wiring?>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    And I enter SSN number "<SSN>"
    And I select credit as "Yes"
    And I click on account Continue button
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application
    Then I save the Order and Ban in the excel_sheet

    Examples: 
      | firstName | lastName | phoneNo    | address                               | PostPaid Offer          | email       | SMSNo      | Date | Month | Year | SSN       | Voice Mail | Wire Maintenance Plan | Port in a phone number? | Need new jacks or wiring? | Additional Order Remarks       |
      | THOMAS    | HILLA    | 4029986730 | 611 FENWICK DR,PAPILLION,NE 68046,USA | PFL Internet up to 140M | Ctl@Ctl.com | 4029986730 |   02 |    02 | 1987 | 666446831 | No         | No                    | No                      | 1 Jack ($99)              | ESHOP ORDER TEST BY AUTOMATION |

  @EShop_Prepaid_HSI_NI_OrderEshopSanity
  Scenario Outline: Create a HSI LQ Prepaid Order and Provisioning it
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    Then I select the Available speed "<Select_speed>"
    Then I select the Prepaid or Postpaid offer"<PrePaid Offer>"
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    And I click again on contine button
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
    Then I wake up remote computer to be ready to complete websop tasks as a precaution step
    Then I Should Complete the Backend Tasks FFWF TOM and Billing as Completed

    Examples: 
      | firstName | lastName  | phoneNo    | address                                 | PrePaid Offer                  | Select_speed             | email        | SMSNo      | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | cardName         | cardNumber       | zip code | Device Quantity | Additional Order Remarks         |
      | Nitish    | Pattanaik | 4029986730 | 8832 S CARR WAY,LITTLETON,CO 80128, USA | CenturyLink Internet (PREPAID) | HSI Up to 60 Mbps/5 Mbps | Ctli@Ctl.com | 4029986730 | Standard            | Purchase     | Basic       |   01 |    01 | 1990 | Nitish Pattanaik | 4485389438108352 |    37638 | 2 devices       | ESHOP PREPAID TEST BY AUTOMATION |
