@EshopTestScripts @HSI_NI_LC_Sanity
Feature: Order Creation and Order Completion

  @HSI_LC
  Scenario Outline: Create a HSI LC Postpaid Order
    Given I should be on SFC login screen
    When I enter username and password
    Then I click on create new account
    Then I enter the "<firstName>" "<lastName>" "<phoneNo>" and "<address>" in new acquisition page
    Then I validate the address and save it
    Then I click on order eshop button
    Then I should be in Eshop Product offer page
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
    Then I Should Complete the Backend Task FFWF
    Then I Should Complete the Backend LC Martens Task

    Examples: 
      | firstName | lastName | phoneNo    | address                      | PostPaid Offer          | Installation_option | Modem_Option | Ease_Option | Date | Month | Year | SSN       | card             | zip code | Device Quantity | Additional Order Remarks       |
      | Brent     | Mayes    | 4029986730 | 1715 Shoup ST,SALMON,ID,8346 | PFL Internet up to 140M | Standard            | Lease        | Basic       |   02 |    02 | 1987 | 666601283 | 4485389438108352 |    37638 | 2 devices       | ESHOP ORDER TEST BY AUTOMATION |

  @LC_Order_Retrive
  Scenario Outline: LC POSTPAID - OrderManagement : Check if user is able to Retrive Order Details Successfully.
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                              | Data_Validation |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet |               200 | /customerOrder/getOrderDetailsByDueDateRangeBan?ban=680657934&page=1&size=1 | NEWINSTALL~HSI  |

  @LC_Get_Service_Registry
  Scenario Outline: LC & LQ - Service Registry - Get Service Registry by customerServiceId or TN or BAN or Service Status  : Check if user is able to Fetch All ServiceRegistryService(s)
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                    | FileLocation                     | Succeesstatuscode |
      | https://bmp-service-registry-business-service-test4.kubemdc-test.corp.intranet/bsi/serviceRegistry/getServiceRegistryWithPCSR | ../EshopTools/TestData/PCSR.json |               200 |
