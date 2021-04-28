@EshopPrepaid @EShopWebService
Feature: Prepaid Webservice

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement : Check if user is able to Retrive Order Details Successfully.
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                                                                                             | Data_Validation                     |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet |               200 | /customerOrder/getOrderDetailsByDueDateRangeBan?startFinalDueDate=2019-11-15T11%3A45%3A43.090Z&endFinalDueDate=2019-11-16T11%3A45%3A43.090Z&page=1&size=10 | NEWINSTALL~HSI~ORN-9523647160034779 |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet |               200 | /customerOrder/getOrderDetailsByDueDateRangeBan?ban=680657934&page=1&size=1                                                                                | NEWTALL~HSI                         |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to activatePrepaidAccount
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                       | FileLocation                                      | Succeesstatuscode |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet/bsi/prepaid/activatePrepaidAccount | ../EshopTools/TestData/ActivatePrepaidaccount.txt |               201 |

  @TEST_OMBOMPA-2211
  Scenario Outline: Prepaid Services : Check if user is able to get prepaid quote from prepaid services based on orn number
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                                       | Data_Validation                   |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet |               200 | /bsi/prepaid/fetchPrepaidQuote/ORN-35920378979054766 | PPB11038269~ORN-35920378979054766 |

  @TEST_OMBOMPA-2212
  Scenario Outline: Prepaid Services : Check if user is able to get prepaid discounts based on BAID
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                               | Data_Validation      |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet |               200 | /bsi/prepaid/getPrepaidDiscounts/PPB11038269 | D00002~D00001~D00003 |

  @TEST_OMBOMPA-2213
  Scenario Outline: Prepaid Services : Check if user is able to get ReserveBaid Service
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters              | Data_Validation |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet |               201 | /bsi/prepaid/getReserveBaid | PPB11040439     |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to prepaidEstimate
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                                | FileLocation                                | Succeesstatuscode |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet/bsi/prepaid/prepaidEstimate | ../EshopTools/TestData/Prepaidestimates.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to updateprepaidaccountstatus
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                           | FileLocation                                   | Succeesstatuscode |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet/bsi/prepaid/updatePrepaidAccountStatus | ../EshopTools/TestData/Updateaccountstatus.txt |               404 |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to update Prepaid Account Offer Update service
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                   | FileLocation                                  | Succeesstatuscode |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet/bsi/prepaid/updateAccountOffer | ../EshopTools/TestData/updateaccountoffer.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to update Prepaid Update Account Notes Service
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                          | FileLocation                                  | Succeesstatuscode |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet/bsi/prepaid/updateAccountNotesService | ../EshopTools/TestData/updateaccountnotes.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to update Prepaid Update Address service
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                              | FileLocation                             | Succeesstatuscode |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet/bsi/prepaid/updateAddress | ../EshopTools/TestData/updateaddress.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to Get prepaid quote from prepaid services based on orn number
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                                       | Data_Validation |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet |               200 | /bsi/prepaid/fetchPrepaidQuote/ORN-20504256567969431 | EP0015          |

  @WebServiceTest1
  Scenario Outline: Prepaid Services : Check if user is able to GetAccountDetails Service
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                  | FileLocation                                 | Succeesstatuscode |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet/bsi/prepaid/getAccountDetails | ../EshopTools/TestData/getAccountDetails.txt |               200 |

  @WebServiceTest1
  Scenario Outline: FFWF : Check if user is able to post FFWF
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                             | FileLocation                        | Succeesstatuscode |
      | https://bmp-ffwf-business-service-test4.kubemdc-test.corp.intranet/bsi/postOrderToFFWF | ../EshopTools/TestData/PostFFWF.txt |               500 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to Cyber security  Activation
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                | FileLocation                            | Succeesstatuscode |
      | https://dvarom-cs-activationservice-dev.kubemdc-test.corp.intranet/v1/csActivationService | ../EshopTools/TestData/CSActivation.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve details from Martens
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                              | FileLocation                           | Succeesstatuscode |
      | https://bmp-tom-orchestrator-business-service-test1.kubemdc-test.corp.intranet/bsi/TomOrchestratorBusinessService/getMartensOrderStatus | ../EshopTools/TestData/Tom_Martens.txt |               201 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve details from TOM using PONR
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                                   | FileLocation                        | Succeesstatuscode |
      | https://bmp-tom-orchestrator-business-service-test1.kubemdc-test.corp.intranet/bsi/TomOrchestratorBusinessService/serviceOrder/getPONRStatus | ../EshopTools/TestData/Tom_PONR.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve details from Post TOM Service order
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                                   | FileLocation                                   | Succeesstatuscode |
      | https://bmp-tom-orchestrator-business-service-test1.kubemdc-test.corp.intranet/bsi/TomOrchestratorBusinessService/serviceOrder/getPONRStatus | ../EshopTools/TestData/TomServiceorderpost.txt |               500 |

  @WebServiceTest1
  Scenario Outline: ProvisionOrder Service : Check if user is able to Reprocess Kafka message by ban
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                                  | FileLocation                                   | Succeesstatuscode |
      | https://bmp-provisioning-order-business-service-test1.kubemdc-test.corp.intranet/provisionServiceOrderRepository/reProcessKafkaMessageByBan | ../EshopTools/TestData/kafkareprocessbyban.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve external response details from
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                 | FileLocation                                        | Succeesstatuscode |
      | https://bmp-order-management-process-test4.kubemdc-test.corp.intranet/v1/ordermanagement/order/v1/externalResponseFromFFWF | ../EshopTools/TestData/externalresponefrom FFWF.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve external response details from CVOIP
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                  | FileLocation                                          | Succeesstatuscode |
      | https://bmp-order-management-process-test1.kubemdc-test.corp.intranet/v1/ordermanagement/order/v1/externalResponseFromCVOIP | ../EshopTools/TestData/externalresponsefrom CVOIP.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve external response details from CPE
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                | FileLocation                                        | Succeesstatuscode |
      | https://bmp-order-management-process-test1.kubemdc-test.corp.intranet/v1/ordermanagement/order/v1/externalResponseFromCPE | ../EshopTools/TestData/externalresponsefrom CPE.txt |               500 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve external response details from TOM
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                | FileLocation                                        | Succeesstatuscode |
      | https://bmp-order-management-process-test4.kubemdc-test.corp.intranet/v1/ordermanagement/order/v1/externalResponseFromTOM | ../EshopTools/TestData/externalresponsefrom TOM.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve external response details from TOMRecord
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                      | FileLocation                                        | Succeesstatuscode |
      | https://bmp-order-management-process-test4.kubemdc-test.corp.intranet/v1/ordermanagement/order/v1/externalResponseFromTOMRecord | ../EshopTools/TestData/externalresponsefrom TOM.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to retrieve external response details from TOM ASYNC Process
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                | FileLocation                                        | Succeesstatuscode |
      | https://bmp-order-management-process-test4.kubemdc-test.corp.intranet/v1/ordermanagement/order/v1/processTOMAsyncResponse | ../EshopTools/TestData/externalresponsefrom TOM.txt |               200 |

  @WebServiceTest1
  Scenario Outline: SFC Updates : Check if user is able to retrieve Update Existing OrderStatusUpdate(s) in SFDC
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                              | FileLocation                           | Succeesstatuscode |
      | https://bmp-order-status-update-business-service-test1.kubemdc-test.corp.intranet/bsi/OrderStatusUpdate/v1/updateStatus | ../EshopTools/TestData/SFC Updates.txt |               200 |

  @WebServiceTest1
  Scenario Outline: SFC Create : Check if user is able to Update Existing OrderStatusUpdate(s) in SFDC
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                             | FileLocation                          | Succeesstatuscode |
      | https://bmp-order-status-update-business-service-test1.kubemdc-test.corp.intranet/bsi/OrderStatusUpdate/v1/updateStatusByCustomerOrder | ../EshopTools/TestData/SFC Create.txt |               200 |

  @WebServiceTest1
  Scenario Outline: translationLookup : Check if user is able to Gets product name by rfsId
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                   | FileLocation                              | Succeesstatuscode |
      | https://bmp-translation-lookup-service-test1.kubemdc-test.corp.intranet/bsi/getRfsidProdInfo | ../EshopTools/TestData/ProductbyRFSID.txt |               200 |

  @WebServiceTest1
  Scenario Outline: translationLookup : Check if user is able to Gets priceplan by usoc
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                | FileLocation                               | Succeesstatuscode |
      | https://bmp-translation-lookup-service-test1.kubemdc-test.corp.intranet/bsi/getUsocPpInfo | ../EshopTools/TestData/Priceplanbyusoc.txt |               200 |

  @WebServiceTest1
  Scenario Outline: DataMappingService : Check if user is able to Fetch All DataMappingService by usoc
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                  | FileLocation                                   | Succeesstatuscode |
      | https://bmp-datamapping-business-service-test1.kubemdc-test.corp.intranet/serviceDataMapping/getByUsocRfsid | ../EshopTools/TestData/DataMapping by USOC.txt |               200 |

  @WebServiceTest1
  Scenario Outline: DataMappingService : Check if user is able to Fetch All DataMappingService by Id and Conditions
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                  | FileLocation                                 | Succeesstatuscode |
      | https://bmp-datamapping-business-service-test1.kubemdc-test.corp.intranet/serviceDataMapping/getDataMapping | ../EshopTools/TestData/DataMapping by ID.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get details by ORN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode |
      | https://bmp-prepaid-services-test2.kubemdc-test.corp.intranet |               200 |

  @WebServiceTest1
  Scenario Outline: DirectTVOrderingManagementService : Check if user is able to replicate dtv order
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code

    Examples: 
      | serviceURL                                                                                 | FileLocation                            | Succeesstatuscode |
      | https://bmp-directtv-om-service-test4.kubemdc-test.corp.intranet/dtvMgmt/replicateDtvOrder | ../EshopTools/TestData/ReplicateDTV.txt |               200 |

  @WebServiceTest1
  Scenario Outline: DirectTVOrderingManagementService : Check if user is able to Retrieve AT&T Order(s) created
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code

    Examples: 
      | serviceURL                                                                                | FileLocation                           | Succeesstatuscode |
      | https://bmp-directtv-om-service-test4.kubemdc-test.corp.intranet/dtvMgmt/retrieveDtvOrder | ../EshopTools/TestData/RetrieveDTV.txt |               200 |

  @WebServiceTest1
  Scenario Outline: RulesMappingService : Check if user is able to Fetch All USOCToFeatureCodeMapping
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code

    Examples: 
      | serviceURL                                                                                                                | FileLocation                                   | Succeesstatuscode |
      | https://bmp-rules-mapping-service-test4.kubemdc-test.corp.intranet/bsi/RulesAndMappingService/v1/USOCToFeatureCodeMapping | ../EshopTools/TestData/RulesMappingService.txt |               200 |

  @WebServiceTest1
  Scenario Outline: ISST : Check if user is able to Save the orders to ISST
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code

    Examples: 
      | serviceURL                                                                                                  | FileLocation                    | Succeesstatuscode |
      | https://bmp-isst-business-service-test4.kubemdc-test.corp.intranet/bsi/ISST/v1/createSalesOrderCompensation | ../EshopTools/TestData/Isst.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Bill Quote : Check if user is able to fetch Bill Quote using ORA
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code

    Examples: 
      | serviceURL                                                                               | FileLocation                         | Succeesstatuscode |
      | https://bmp-billquote-business-service-test4.kubemdc-test.corp.intranet/bsi/BillQuote/v1 | ../EshopTools/TestData/BillQuote.txt |               200 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get details by ORN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                                       | Data_Validation        |
      | https://bmp-prepaid-services-test2.kubemdc-test.corp.intranet |               200 | /bsi/prepaid/fetchPrepaidQuote/ORN-31925439912962410 | PPB11027555~55.5~MODEM |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get details by CSNO from TOM
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                                                         | Data_Validation |
      | https://bmp-tom-orchestrator-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/TomOrchestratorBusinessService/findByCustomerServiceOrderNumber?customerServiceOrderNumber=CSNO-19550687904306444 | Santhosh Gupta  |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get details by CSNO from TOM using USO Number
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                    | Data_Validation        |
      | https://bmp-tom-orchestrator-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/TomOrchestratorBusinessService/findByUSOOrderNumber?USOOrderNumber=N64709677 | CSNO-19549829502527019 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get Quote by ORA Number
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                                       | Data_Validation                  |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet |               200 | /bsi/prepaid/fetchPrepaidQuote/ORN-36175817659894908 | HSI Upto 140 Mbps/20 Mbps~EP0106 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get Prepaid discount by BAID Number
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                               | Data_Validation                      |
      | https://bmp-prepaid-services-test1.kubemdc-test.corp.intranet |               200 | /bsi/prepaid/getPrepaidDiscounts/PPB11038709 | Subscription Price Adjustment~D00004 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get provision details by BAN Number
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                       | Succeesstatuscode | GET_Parameters                                                                                 | Data_Validation     |
      | https://bmp-provisioning-order-business-service-test1.kubemdc-test.corp.intranet |               200 | /provisionServiceOrderRepository/findByBAN/billingAccountNumber?billingAccountNumber=680615036 | 680615036~N64709810 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get provision details by CON
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                       | Succeesstatuscode | GET_Parameters                                                                                | Data_Validation     |
      | https://bmp-provisioning-order-business-service-test1.kubemdc-test.corp.intranet |               200 | /provisionServiceOrderRepository/findByCON/customerOrderNumber?customerOrderNumber=1000065973 | 680615036~N64709810 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to get Jeopardy details by BAN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                             | Succeesstatuscode | GET_Parameters                                 | Data_Validation      |
      | https://bmp-jeopardy-business-service-test1.kubemdc-test.corp.intranet |               200 | /jeopardyRepository/getJeopardyByban/680615241 | 680615241~3036831791 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to Fetch ServiceOrder By orderReferenceNumber
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                        | Succeesstatuscode | GET_Parameters                                                                       | Data_Validation |
      | https://bmp-order-decomposition-business-service-test1.kubemdc-test.corp.intranet |               200 | /serviceOrder/fetchServiceOrderStatusInfo?orderReferenceNumber=ORN-36175817659894908 | COMPLETED       |

  @WebServiceTest1
  Scenario Outline: Check if user is able to Fetch ServiceOrder By CustomerOrderNumber
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                        | Succeesstatuscode | GET_Parameters                                                         | Data_Validation |
      | https://bmp-order-decomposition-business-service-test1.kubemdc-test.corp.intranet |               200 | /serviceOrder/findByCustomerOrderNumber?customerOrderNumber=1000065784 | HSI~20000       |

  @WebServiceTest111
  Scenario Outline: Check if user is able to Fetch CustomerOrderNumber By USO_ORDER_NUMBER
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                        | Succeesstatuscode | GET_Parameters                                            | Data_Validation |
      | https://bmp-order-decomposition-business-service-test1.kubemdc-test.corp.intranet |               200 | /serviceOrder/getBMOrderNumber?USO_ORDER_NUMBER=N64709870 |      1000066043 |

  @WebServiceTest1
  Scenario Outline: Check if user is able to Fetches the feature description by ORN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                             | Data_Validation           |
      | https://bmp-order-management-business-service-test1.kubemdc-test.corp.intranet |               200 | /customerOrder/getFeatureDescription/ORN-36175817659894908 | HSI Upto 140 Mbps/20 Mbps |

  @WebServiceTest1
  Scenario Outline: ServiceRegistry-Check if user is able to fetch All ServiceRegistry(s) by BAN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                | Data_Validation |
      | https://bmp-service-registry-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/serviceRegistry/getSRByBAN?ban=680615036 |      1000065973 |

  @WebServiceTest1
  Scenario Outline: ServiceRegistry-Check if user is able to Fetch All ServiceRegistryService(s) by customerOrderNumber and version
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                                      | Data_Validation |
      | https://bmp-service-registry-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/serviceRegistry/getSRByCustomerOrderNumberWithVersion?customerOrderNumber=1000066043&version=1 |      1000066043 |

  @WebServiceTest1
  Scenario Outline: ServiceRegistry-Check if user is able to Fetch All ServiceRegistryService(s) by CustomerServiceId
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                             | Data_Validation |
      | https://bmp-service-registry-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/serviceRegistry/getSRByCustomerServiceId?customerServiceId=CSID-19912044945962184_1_1 | VDSL2-PB        |

  @WebServiceTest1
  Scenario Outline: ServiceRegistry-Check if user is able to Fetch All ServiceRegistryService(s) CustomerServiceOrderNumber
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                                           | Data_Validation |
      | https://bmp-service-registry-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/serviceRegistry/getSRByCustomerServiceOrderNumber?customerServiceOrderNumber=CSNO-19912044945962184 | POSTPAID        |

  @WebServiceTest1
  Scenario Outline: ServiceRegistry-Check if user is able to Fetch All ServiceRegistryService(s) by customerServiceOrderNumber and version
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                                                                | Data_Validation |
      | https://bmp-service-registry-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/serviceRegistry/getSRByCustomerServiceOrderNumberWithVersion?customerServiceOrderNumber=CSNO-19912044945962184&version=1 |      1000066043 |

  @WebServiceTest1
  Scenario Outline: ServiceRegistry-Check if user is able to Fetch All ServiceRegistry(s) by TN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                               | Data_Validation |
      | https://bmp-service-registry-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/serviceRegistry/getSRByTN?tn=3036831966 |      1000011152 |

  @WebServiceTest1
  Scenario Outline: Account profile-Check if user is able to Calls eas-initBilling to fetch product/billing info
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                           | Succeesstatuscode | GET_Parameters                                                       | Data_Validation |
      | https://bmp-account-profile-service-test1.kubemdc-test.corp.intranet |               200 | /accountProfile/edsBillingComponents?ban=680626471&edsProductType=QW |       680626471 |

  @WebServiceTest1
  Scenario Outline: QCONNECT : Check if user is able to Fetch HSI Details from Service Registry by WTN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                  | Data_Validation |
      | https://bmp-qconnect-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/qConnect/v1?wtn=4023305893 |       680855514 |

  @WebServiceTest1
  Scenario Outline: UpdateEmailAccount : Check if user is able to Fetches API Information
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                         | Succeesstatuscode | GET_Parameters                   | Data_Validation       |
      | https://bmp-update-email-account-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/UpdateAccount/v1/getAPIInfo | Environment Variables |

  @WebServiceTest1
  Scenario Outline: DTV CORRECTIONS : Check if user is able to  DTV pp and fcs from the service collection based on the submarke
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                          | Succeesstatuscode | GET_Parameters                                        | Data_Validation |
      | https://bmp-dtv-correction-service-test1.kubemdc-test.corp.intranet |               200 | /dtvCorrection/dtvReferencePpfcs/?subMarketCode=A2761 | Market          |

  @WebServiceTest1
  Scenario Outline: DirectTVOrderingManagementService : Check if user is able to Retrieve customer’s DTV Order Info from BM database using the ORN
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                       | Succeesstatuscode | GET_Parameters                                                     | Data_Validation        |
      | https://bmp-directtv-om-service-test4.kubemdc-test.corp.intranet |               200 | /dtvMgmt/dtvOrderFromBM?orderReferenceNumber=ORN-36880838740368729 | 680647374~901949333973 |

  @WebServiceTest1
  Scenario Outline: DirectTVOrderingManagementService : Check if user is able to Retrieve Vendor locations
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                       | Succeesstatuscode | GET_Parameters           | Data_Validation                    |
      | https://bmp-directtv-om-service-test4.kubemdc-test.corp.intranet |               200 | /dtvMgmt/vendorLocations | CLINK CALL CENTER - JEFFERSON CITY |

  @WebServiceTest1
  Scenario Outline: LifeLine Service : Check if user is able to get Operation to get Qualifing Programs data
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                             | Succeesstatuscode | GET_Parameters                                   | Data_Validation |
      | https://bmp-lifeline-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/LifeLineConfigService/getQualProgramMaster/ | timestamp       |

  @WebServiceTest1
  Scenario Outline: LifeLine Service : Check if user is able to get Operation to get Non Recurring Credits data
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                             | Succeesstatuscode | GET_Parameters                                                  | Data_Validation |
      | https://bmp-lifeline-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/LifeLineConfigService/retrieveNonRecurringLLCreditsMaster/ | timestamp       |

  @WebServiceTest1
  Scenario Outline: LifeLine Service : Check if user is able to get Operation to get Recurring Credits data
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                             | Succeesstatuscode | GET_Parameters                                               | Data_Validation |
      | https://bmp-lifeline-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/LifeLineConfigService/retrieveRecurringLLCreditsMaster/ | timestamp       |

  @WebServiceTest1
  Scenario Outline: LifeLine Service : Check if user is able to get Operation to retrieve customer’s Lifeline information
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                             | Succeesstatuscode | GET_Parameters                                                                         | Data_Validation |
      | https://bmp-lifeline-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/LifeLineConfigService/retrievelifeLineConfig/?orderRefNumber=ORN-9992900161409011 | timestamp       |

  @WebServiceTest1
  Scenario Outline: LifeLine Service : Check if user is able to get Operation to retrieve customer’s Lifeline information
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                             | Succeesstatuscode | GET_Parameters                                                                                 | Data_Validation |
      | https://bmp-lifeline-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/LifeLineConfigService/retrievelifeLineConfigPresent/?orderRefNumber=ORN-28582699385614135 | timestamp       |

  @WebServiceTest1
  Scenario Outline: FFWF Service : Check if user is able to get Find Status(s) By CustomerOrderNumber
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                         | Succeesstatuscode | GET_Parameters                                                                 | Data_Validation                          |
      | https://bmp-ffwf-business-service-test1.kubemdc-test.corp.intranet |               200 | /bsi/getStatusByCustomerOrderNumber?customerOrderNumber=CSNO-19386793619951240 | statusEventTypeByCustomerOrderNumberList |

  @WebServiceTest1
  Scenario Outline: QConnect : Check if user is able to Fetch HSI Details from Service Registry by WTN.
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                    | Succeesstatuscode | GET_Parameters                  | Data_Validation |
      | https://bmp-qconnect-service-test4.kubemdc-test.corp.intranet |               200 | /bsi/qConnect/v1?wtn=4023311719 | content         |

  @WebServiceTest1
  Scenario Outline: AccountManagement : Check if user is able to Get Account details by ban.
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                       | Succeesstatuscode | GET_Parameters                        | Data_Validation |
      | https://bmp-account-management-business-service-test4.kubemdc-test.corp.intranet |               200 | /accountMgmt/getAccountByBAN680660235 |       680660235 |

  @WebServiceTest1
  Scenario Outline: EASOrchestrator : Check if user is able to Get Account details by ban.
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                               | Succeesstatuscode | GET_Parameters                                              | Data_Validation                            |
      | https://bmp-billing-order-orchestrator-business-service-test4.kubemdc-test.corp.intranet |               200 | /bsi/EASOrchestrator/EASOrchetrator/findByBan?ban=680660202 | 680660202~2000005331~A2883~ONE_TIME~JA6749 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to Fetches CustomerOrder By BAN & RequestedTelephoneNumber
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                  | FileLocation                              | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/getAllCustomerOrdersByBanAndTn | ../EshopTools/TestData/LCorderbyBanTn.txt |               200 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to Get BMPONR status by calling TOM
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                   | FileLocation                         | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/getBMPONRStatus | ../EshopTools/TestData/LC BMPONR.txt |               200 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to Get Customer Order by BAN/Customer Order Number/requestedTelephoneNumber
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                    | FileLocation                           | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/getCustomerOrder | ../EshopTools/TestData/LC getorder.txt |               200 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to Fetches CustomerOrder By BAN & CustomerOrderNumber
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                                               | FileLocation                         | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/getCustomerOrderByBANAndCustomerOrderNumber | ../EshopTools/TestData/LC BanCon.txt |               200 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to Get Customer Order Status by BAN/Customer Order Number/requestedTelephoneNumber
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                          | FileLocation                              | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/getCustomerOrderStatus | ../EshopTools/TestData/LC Orderstatus.txt |               200 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement : Check if user is able to Fetches the feature description by ORN.
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                            | Data_Validation                              |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet |               200 | /customerOrder/getFeatureDescription/ORN-9739713612644819 | Prem Modem 40_Up PurchTech Ins~HSI 940M/940M |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to get latest pending order
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                         | FileLocation                           | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/getLatestPendingOrder | ../EshopTools/TestData/LC Penorder.txt |               200 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement : Check if user is able to Retrive Order Details Successfully.
    Given I want to execute service "<serviceURL>"
    Then I submit the GET request with Parameters "<GET_Parameters>"
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                     | Succeesstatuscode | GET_Parameters                                                                                                                                             | Data_Validation |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet |               200 | /customerOrder/getOrderDetailsByDueDateRangeBan?startFinalDueDate=2019-11-15T11%3A45%3A43.090Z&endFinalDueDate=2019-11-16T11%3A45%3A43.090Z&page=1&size=10 | NEWINSTALL~HSI  |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet |               200 | /customerOrder/getOrderDetailsByDueDateRangeBan?ban=680657934&page=1&size=1                                                                                | NEWINSTALL~HSI  |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to Fetch the current Progress Status of ServiceOrder
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                          | FileLocation                                | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/getOrderProgressStatus | ../EshopTools/TestData/LC Orderprogress.txt |               200 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is able to Create Customer Order(s)
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                       | FileLocation                                      | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/createCustomerOrder | ../EshopTools/TestData/LC Createcustomerorder.txt |               201 |

  @WebServiceTest1
  Scenario Outline: LC POSTPAID - OrderManagement  : Check if user is Fetches All Products and Services
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"

    Examples: 
      | serviceURL                                                                                                       | FileLocation                                      | Succeesstatuscode |
      | https://bmp-order-management-business-service-test4.kubemdc-test.corp.intranet/customerOrder/createCustomerOrder | ../EshopTools/TestData/LC Createcustomerorder.txt |               201 |

  @WebServiceTest1
  Scenario Outline: LQ POSTPAID - Kafka Adapter Service  : Check if user is able to Publish message to Kafka Topic
    Given I want to execute service "<serviceURL>"
    When I pass the data as parameters in a file "<FileLocation>"
    Then I submit the POST request
    Then I validate status code "<Succeesstatuscode>"
    Then I validate the object data "<Data_Validation>"

    Examples: 
      | serviceURL                                                                                      | FileLocation                           | Succeesstatuscode |  | Data_Validation                                             |
      | https://bmp-kafka-adapter-test4.kubemdc-test.corp.intranet/kafkaservice/sendmessagetokafkatopic | ../EshopTools/TestData/Kafka Topic.txt |               200 |  | ProvisioningOrder Message is Succesfully Published to Topic |
