@EShopSoapWebService
Feature: CDS BAID Response

  @NoWebServiceTest
  Scenario Outline: CDS BAID Response details
    Given I provide request details and "<serviceURL>"
    When I run SOAP UI request
    Then I get response details

    Examples: 
      | serviceURL                                                                                  |
      | https://cxg7i.test.intranet/test2/soap/service/RetrieveCustomerData?wsdl                    |
     #| http://cds-e2e.test.intranet/CustomerDataService-1.0/soap/service/RetrieveCustomerData?wsdl |
