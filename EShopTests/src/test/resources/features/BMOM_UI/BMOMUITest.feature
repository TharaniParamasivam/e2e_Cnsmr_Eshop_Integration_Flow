@BMUITestScript
Feature: BMOM UI Manage Jeopardy Validation

  #TC
  @BMUITestScript
  Scenario Outline: BMOM UI Manage Jeopardy Validation and Rectifying it
    Given I should be on BM UI dashboard
    When I am in BM UI dashboard page
    Then I click hamburger icon
    And I click on blue marble order management
    And I click on Manage Jeopardy
    
    
    Examples: 
      | firstName | lastName | phoneNo    | address                              | PostPaid Offer          | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      | Brent     | Mayes    | 4029986730 | 3066 SHADY LN,LITTLETON,CO 80126,USA | PFL Internet up to 140M | Standard            | Purchase     | Basic       |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  # | Brent     | Mayes    | 4029986730 | 2319 10TH ST,CORALVILLE,IA 52241,USA | PFL CenturyLink High Speed Internet | Standard            | Purchase Lease    | Basic       |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |
