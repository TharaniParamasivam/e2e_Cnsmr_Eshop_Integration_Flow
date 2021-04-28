@EshopPrepaidScripts @EShopPrepaid
Feature: PrePaid Eshop User Automation

  @EShopPrepaidNITrial
  Scenario Outline: PrePaid Eshop User Account Creation with HSI Product
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    #Then I should get build your offer tab on product page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    #Then I add the equipments in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I enter "<email>" and "<SMSNo>"
    #And I change the billing address to "attn Deana Pillot 555 LAKE BORDER DR, AOPKA, FL, 32703"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    #And I enter SSN number "<SSN>"
    #And I select credit as "Yes"
    And I click on account Continue button
    And I click on payNow
    And I should be at make payment page
    And I fill all card details as "<card>" and "<zip code>"
    And I click submit button on verify InformationPage
    And I click again click Continue button on account
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                            | email       | SMSNo      | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | Device Quantity | Additional Order Remarks         |
      | Jones     | Smith    | 4029986730 | 8832 S CARR WAY,LITTLETON,CO 80128 | Ctl@Ctl.com | 4029986730 | STANDARD            | LEASE        | BASIC       |   02 |    02 | 1987 | 2 devices       | ESHOP PREPAID TEST BY AUTOMATION |

  @EShopPrepaidNI11Trial
  Scenario Outline: Eshop PrePaid Order Creation with HSI Product
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    Then I select the Available speed "<Select_speed>"
    Then I select the Prepaid or Postpaid offer"<PrePaid Offer>"
    #Then I should get build your offer tab on product page
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
    #And I select "<Ease_Option>" Ease Option
    Then I select the number of device needed "<Device Quantity>"
    And I click on continue button
    Then I should be in customize service page
    #Then I add the equipments in customize service page
    And I click again on contine button
    And I click to reserve appointment
    And I click on continue button of scheduling page
    And I should be on Prepaid Account Information Page for Prepaid Order
    And I enter "<email>" and "<SMSNo>" for Prepaid Order
    #And I change the billing address to "attn Deana Pillot 555 LAKE BORDER DR, AOPKA, FL, 32703"
    And I enter date "<Date>" month "<Month>" and year "<Year>" of birth
    #And I enter SSN number "<SSN>"
    #And I select credit as "Yes"
    And I click on account Continue button for Prepaid Order
    And I Make Payement for Prepaid Order "<cardName>" "<cardNumber>" "<zip code>"
    And I click on account Continue button for Prepaid Order
    And I selected Yes for the review in order summary page
    Then I enter the special remark in Additional Order Remarks field "<Additional Order Remarks>"
    Then I clicked submit order button
    Then I get account number from application

    Examples: 
      | firstName | lastName | phoneNo    | address                            | PrePaid Offer                  | Select_speed             | email            | SMSNo      | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | cardName         | cardNumber       | zip code | Device Quantity | Additional Order Remarks         |
      | Jones     | Smith    | 4029986730 | 8832 S CARR WAY,LITTLETON,CO 80128 | CenturyLink Internet (PREPAID) | HSI Up to 60 Mbps/5 Mbps | Ctli9999@Ctl.com | 4029986730 | STANDARD            | LEASE        | BASIC       |   01 |    01 | 1990 | Nitish Pattanaik | 4485389438108352 |    37638 | 2 devices       | ESHOP PREPAID TEST BY AUTOMATION |

  @EShop_Prepaid_HSI_NI_Order
  Scenario Outline: Eshop PrePaid Order Creation with HSI Product
    Given I should be on Eshop login screen
    When I enter username and password
    And I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in customer detail page
    Then I click let's go button
    Then I should be in Product offer page
    Then I select the Available speed "<Select_speed>"
    Then I select the Prepaid or Postpaid offer"<PrePaid Offer>"
    Then I select the best "<Installation_option>" installation option
    And I select Your "<Modem_Option>" Modem option
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
    Then I Should Complete the Backend Tasks FFWF TOM and Billing as Completed

    Examples: 
      | firstName | lastName  | phoneNo    | address                            | PrePaid Offer                  | Select_speed             | email            | SMSNo      | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | cardName         | cardNumber       | zip code | Device Quantity | Additional Order Remarks         |
      | Nitish    | Pattanaik | 4029986730 | 8832 S CARR WAY,LITTLETON,CO 80128 | CenturyLink Internet (PREPAID) | HSI Up to 60 Mbps/5 Mbps | Ctli9999@Ctl.com | 4029986730 | Standard           | LEASE        | BASIC       |   01 |    01 | 1990 | Nitish Pattanaik | 4485389438108352 |    37638 | 2 devices       | ESHOP PREPAID TEST BY AUTOMATION |
