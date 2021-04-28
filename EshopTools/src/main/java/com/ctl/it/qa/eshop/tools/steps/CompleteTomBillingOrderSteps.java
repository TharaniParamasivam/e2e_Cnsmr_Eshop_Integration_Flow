package com.ctl.it.qa.eshop.tools.steps;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import com.ctl.it.qa.bm.utils.BMUtils;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;



import java.io.FileReader;
import java.io.PrintWriter;


  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;


public class CompleteTomBillingOrderSteps extends Steps {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2771232118946892926L;
	String orderNumber = OrderSummarySteps.ordernum;
	private final Logger slf4jLogger = LoggerFactory.getLogger(CompleteTomBillingOrderSteps.class);
	public static String dbURI = null;
	public static MongoClient mongoClient;
	public static String CSNO = null;
	public static String WEBSOP = null;
	public static String tran_id = null;
	public static String time_stamp = null;
	public static String orn = null;
	public static String url = "https://bmp-order-management-process-test4.kubemdc-test.corp.intranet/v1/ordermanagement/order/v1/externalResponseFromTOM";
	public static String file = "..\\EshopTools\\TestData\\martens.json";
	public static int passedstatuscode=200;
	
	@Step
	public void complete_LC_Martenes_Task() throws Exception
	{
		slf4jLogger.info("MONGO DB Connection Started");
		dbURI = "mongodb://BMP_rep:BMP_rep_ctl123@vlmddmong01.dev.intranet:26000";
		mongoClient = new MongoClient(new MongoClientURI(dbURI)); 
		slf4jLogger.info("MONGO DB connection established successfully");
        //waitABit(10000);
		getCSNOfromSR();
		//waitABit(5000);
		WEBSOPfromTOM();
		getTSnTIDfromOD(OrderSummarySteps.ordernum);
		mongoClient.close();
		slf4jLogger.info("MONGO DB connection closed successfully");
		slf4jLogger.info("MONGO DB Connection Ended");
		complete_Martenes();
		
	}
	
	public void complete_Martenes() throws Exception
	{
		Object obj = new JSONParser().parse(new FileReader("..\\EshopTools\\TestData\\martens.json"));
		JSONObject jo = (JSONObject) obj;
		
        JSONArray dataList = (JSONArray) jo.get("orders");
        jo.put("customerServiceOrderNumber", CSNO);
        jo.put("timestamp",time_stamp );
        jo.put("transactionId", tran_id);
        PrintWriter pw = new PrintWriter("..\\EshopTools\\TestData\\martens.json"); 
       
        for(Object projectObj: dataList.toArray()){
            JSONObject project = (JSONObject)projectObj;
            String abc = (String) project.get("orderNumber");
            project.put("orderNumber", WEBSOP);
           // pw.write(project.toJSONString()); 
        }
        
          
          
          pw.write(jo.toJSONString()); 
          
          pw.flush(); 
          pw.close();

        PrePaidWebServiceSteps web = new PrePaidWebServiceSteps();
        slf4jLogger.info("Completing the LC Martens task");
        web.execute_service(url);
        web.input_paramaters_from_file(file);
        slf4jLogger.info("Martens file request executed");
        web.POST_request();
        web.status_code(passedstatuscode);
	}
	
	public void getCSNOfromSR() {
		String CSNO = SR(OrderSummarySteps.accountnum);
		slf4jLogger.info("CSNO is received successfully   "+CSNO);
	}
	public String SR(String BAN)
	{

		DB db = mongoClient.getDB("BMP_SERVICEREGISTRY_4");
		DBCollection tableDetails = db.getCollection("serviceRegistryData");
		BasicDBObject queryDetails = new BasicDBObject();
		queryDetails.put("ban",BAN);
		DBCursor cursorDetails =tableDetails.find(queryDetails);
		DBObject oneDetails;
		boolean Name=cursorDetails.hasNext();
		//this loop will take care if query db with timeout of 4 Mins
		a:
			for(int i=1;i<=24;i++) {
				cursorDetails =tableDetails.find(queryDetails);
				System.out.println("Time iteration  "+i);
				if(!cursorDetails.hasNext()) {
					waitABit(10000);
					System.out.println("Data in mongo Db   "+cursorDetails.hasNext());  
				}
				else{
					cursorDetails =tableDetails.find(queryDetails);
					while(cursorDetails.hasNext()){
						if((cursorDetails.next().get("provisioningChannel").toString().equals("TOM"))){
							System.out.println("Entered if block");
							break a;
						}
						else{
							waitABit(10000); 
						}
					}
				}
			}
		System.out.println("out of the loop"); 
		while(cursorDetails.hasNext())
		{ 
			oneDetails=cursorDetails.next();   
			String PC=oneDetails.get("provisioningChannel").toString();
			if(PC.equals("TOM"))
			{
				String OT=oneDetails.get("orderType").toString();
				if(OT.equals("NEWINSTALL"))
				{
					CSNO=oneDetails.get("customerServiceOrderNumber").toString();
					System.out.println("The NI CSNO for TOM is   "+CSNO);
					break;
				}
			}

		}
		return CSNO;

	}

	public void WEBSOPfromTOM() throws InterruptedException {
		String WEBSOP = TOM(CSNO); 
		slf4jLogger.info("WEBSOP is received successfully   "+WEBSOP);
	}
	public static String TOM(String CSNO1) throws InterruptedException
	{
		DB db1 = mongoClient.getDB("BMP_TOMORCHESTRATOR_4");
		DBCollection tableDetails1 = db1.getCollection("serviceOrderStatusReference");
		BasicDBObject queryDetails1 = new BasicDBObject();
		queryDetails1.put("customerServiceOrderNumber", CSNO);
		DBCursor cursorDetails1 =tableDetails1.find(queryDetails1);
		DBObject oneDetails1;

		while(cursorDetails1.hasNext())
		{ 
			oneDetails1=cursorDetails1.next(); 
			oneDetails1 = (DBObject) oneDetails1.get("provisioningServiceStatusRequest");
			oneDetails1  = (DBObject) oneDetails1.get("orders");
			oneDetails1  = (DBObject) oneDetails1.get("0");
			WEBSOP  = oneDetails1.get("orderNumber").toString();
			System.out.println("The NI Websop # is  "+WEBSOP);
			break;
		}
		return WEBSOP;
	}
	
	public void getTSnTIDfromOD(String ordernum) {
		
		DB db1 = mongoClient.getDB("BMP_ORDERDECOMPOSITION_4");
		DBCollection tableDetails1 = db1.getCollection("serviceOrder");
		BasicDBObject queryDetails1 = new BasicDBObject();
		queryDetails1.put("_id", CSNO);
		DBCursor cursorDetails1 =tableDetails1.find(queryDetails1);
		DBObject oneDetails1;

		while(cursorDetails1.hasNext())
		{ 
			oneDetails1=cursorDetails1.next(); 
			oneDetails1 = (DBObject) oneDetails1.get("translatedOrder");
			oneDetails1  = (DBObject) oneDetails1.get("provisioningServiceRequest");
			tran_id  = oneDetails1.get("transactionId").toString();
			System.out.println("The Transaction id is  "+tran_id);
			time_stamp  = oneDetails1.get("timestamp").toString();
			System.out.println("The Time stamp is  "+time_stamp);
			break;
		}
	}
	
	
	//Jar file websop order completion by Tara Kibler
	@Step
	public void Complete_TOM_and_Billing_Tasks() 
		{	
			String BillingStatus=null;
			String TOMStatus=null;
				System.out.println("Order No. is  "+orderNumber);
				waitABit(10000);
		        String env = Page.currentEnvironment.getKey();
		          if (env.equals("TEST4")) {
		        	  env="E2E";
		          } 
		          else if(env.equals("TEST1")) {
		        	  env="Test1";
		          }
		          else if(env.equals("TEST2")) {
		        	  env="Test2";
		          }
		          System.out.println("Current Environment is   "+env);
		          String numberOfDays = "2";
		          String sFFWF = "false";
		          String sTOM = "true";
		          String sBilling = "true";
		          boolean cpFFWF = false;
		          if (sFFWF.equals("true"))
		                cpFFWF = true;
		          boolean cpTOM = false;
		          if (sTOM.equals("true"))
		                cpTOM = true;
		          boolean ckBilling = false;
		          if (sBilling.equals("true"))
		        	  ckBilling = true;          
		          if (OrderSummarySteps.Product.equals("CENTURYLINK INTERNET"))
		        	  ckBilling = false;
		          System.out.println("Going to run test with " + orderNumber + env + numberOfDays + sFFWF + sTOM + ckBilling);

		          String ban = BMUtils.getBANforOrderNumber(env, orderNumber);
		          if (ban.length() < 1) {
		                System.out.println("Unable to retrieve BAN");
		                return;
		          }

		          List<String[]> serviceRegistryData = BMUtils.getServiceRegistryData(env, orderNumber);

		          String response = "";
//Not Required As not Completing FFWF with this Jar
		          try {
		                if (cpFFWF) {
		                      System.out.println("Searching for FFWF Ids... Please wait...");
		                      response = BMUtils.completeFFWFEntries(env, ban, orderNumber, serviceRegistryData);
		                      System.out.println(response);

		                           }
		                // If the box to complete the TOM order is checked...
		                if (cpTOM) {
		                      String filePathString = "\\\\co5325gwebsop3\\Test_Tools\\TOM\\tom.cfg";
		                      File f = new File(filePathString);
		                      if (!f.exists()) {
		                            System.out.println(
		                                        "Cannot get config info.  Is co5325gwebsop3 asleep?  Wake with http://vwodsema001/WRA/");
		                           return;
		                                      }
		                      System.out.println("Searching for TOM Orders... Please wait...");
		                      List<String> customerServiceOrderNumbers = new ArrayList<String>();
		                      int USOcount = 0;
		                      for (String[] record : serviceRegistryData) {
		                            String customerServiceOrderNumber = record[4];
		                      if (!customerServiceOrderNumbers.contains(customerServiceOrderNumber)) {
		                                                customerServiceOrderNumbers.add(customerServiceOrderNumber);
		                            List<String> USOOrderNumbers = BMUtils.getUSOOrderNumberByCSNO(env, customerServiceOrderNumber);
		                            for (String USOOrderNumber : USOOrderNumbers) {
		                                  USOcount++;
		                                  response = BMUtils.completeTOMOrder(env, ban, USOOrderNumber, orderNumber, "2");
		                                  TOMStatus=response;
		                                  System.out.println(response);
		                                  System.out.println("The TOM Response Value :"+TOMStatus);
		                                                                         }
		                                                                                           }
		                                                                   }
		                      if (USOcount < 1)
		                        System.out.println("Could not find any TOM orders to complete");        
		                         }
		                if (ckBilling) {
		                	System.out.println("The Raw Billing Response Value :"+response);
		    				System.out.println("Retrieving billing information... Please wait...");
		    				Thread.sleep(30000L);
		    				response = BMUtils.checkBillingEntries(env, orderNumber);
		    				System.out.println("The Raw Billing Response Recived :"+response);
		    				if (response.equals(""))
		    					response = "Billing successful";
		    				System.out.println("The Billing Response Recived :"+response);
		    				BillingStatus=response;
		    				System.out.println("The Billing Status is :"+BillingStatus);
		    			}
		          }
		    		 catch (Exception e) {
		    			String errorMessage = e.toString();
		    			System.out.println(errorMessage);		
		          }
		          // assertEquals("TOM completion has been Failed", "TOM completion successfully sent.", TOMStatus);
		          //if (ckBilling) {
		          //assertEquals("Billing has been Failed", "Billing successful", BillingStatus);
		         // }              
		}	

	@Step
	public void wake_up_remote_computer() {
		Set<String> allWindows=getDriver().getWindowHandles();
		if(allWindows.size() >= 2) {
			Iterator<String> windowIterator=allWindows.iterator();
			String parentWindow=windowIterator.next();
			String childWindow=windowIterator.next();
			System.out.println(allWindows);
			getDriver().switchTo().window(parentWindow);
		waitABit(3000);
		System.out.println("Trying to Wake up Remote Computer ...");
		//getDriver().navigate().to("http://vwodsema001/WRA/");
		getDriver().get("http://vwodsema001/WRA/");
		waitABit(1000);
		getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("co5325gwebsop3");
		waitABit(1000);
		getDriver().findElement(By.xpath("//input[@type='submit']")).click();
		waitABit(1000);
		getDriver().findElement(By.xpath("//input[@value='Wake']")).click();
		waitABit(5000);
		getDriver().navigate().back();
		getDriver().navigate().back();
		getDriver().navigate().back();
		waitABit(1000);
		System.out.println("... Remote Computer Wake up Successful");
			getDriver().switchTo().window(childWindow);
		}
		else {
			System.out.println("Remote Computer Wake up By New Tab ....");
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.open()");
			Set<String> allWindows1=getDriver().getWindowHandles();
			Iterator<String> windowIterator=allWindows1.iterator();
			String parentWindow=windowIterator.next();
			String childWindow=windowIterator.next();
			System.out.println(allWindows);
			getDriver().switchTo().window(childWindow);
			getDriver().get("http://vwodsema001/WRA/");
			waitABit(1000);
			getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("co5325gwebsop3");
			waitABit(1000);
			getDriver().findElement(By.xpath("//input[@type='submit']")).click();
			waitABit(1000);
			getDriver().findElement(By.xpath("//input[@value='Wake']")).click();
			waitABit(5000);
			getDriver().switchTo().window(parentWindow);
			System.out.println(".... Remote Computer Wake up Successful");
		}
	}

	
}



