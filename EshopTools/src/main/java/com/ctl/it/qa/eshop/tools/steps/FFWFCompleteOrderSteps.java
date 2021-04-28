package com.ctl.it.qa.eshop.tools.steps;

import static org.junit.Assert.fail;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.Steps;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

//Nitish FFWF Task Completion Using Rest Assured API
public class FFWFCompleteOrderSteps extends Steps {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8376719004703026856L;
	static int Count=0;
	static MongoClient mongoClient = null;
	String dbURI = null;
	String CurrentEnvID = null;
	String env = null;
	@Step
	public String FFWFmongodata(String order) {
		{
			//String dbURI = null;
		     String FFWF0 = null;
		     String FFWF=null;
		     
		     dbURI = "mongodb://BMP_rep:BMP_rep_ctl123@vlmddmong01.dev.intranet:26000";
            mongoClient = new MongoClient(new MongoClientURI(dbURI)); 
			DB db = mongoClient.getDB("BMP_SERVICEREGISTRY_1");
			   DBCollection tableDetails = db.getCollection("serviceRegistryData");
			   BasicDBObject queryDetails = new BasicDBObject();
			   queryDetails.put("customerOrderNumber",order);
			   DBCursor cursorDetails =tableDetails.find(queryDetails);
			   DBObject oneDetails;
			   boolean Name=cursorDetails.hasNext();
			   System.out.println("Data in mongo Db   "+Name);
			   System.out.println("Start of the loop");
			   //this loop will take care if data are available or not in db with timeout of 4 Mins
			   for(int i=1;i<=24;i++) {
				   cursorDetails =tableDetails.find(queryDetails);
				   System.out.println("Time iteration  "+i);
				   if(!cursorDetails.hasNext()) {
				   waitABit(10000);
				   System.out.println("Data in mongo Db   "+cursorDetails.hasNext());  
				   }else {
					   break;
				   }
			   }
			   System.out.println("out of the loop");
			   while(cursorDetails.hasNext()) {
			      oneDetails=cursorDetails.next();   
			      String PC=oneDetails.get("provisioningChannel").toString();
			      if(PC.equals("FFWF"))
			      {
			         String OT=oneDetails.get("orderType").toString();
			        	         
			        	 Count++;
			        	 System.out.println("New Count  "+Count);
			                FFWF0=oneDetails.get("customerServiceOrderNumber").toString();
			                FFWF= FFWF0.substring(5);
			                System.out.println("The "+OT+" Order FFWF Transaction id is   "+FFWF);
			               
			   } 
			   }
			  mongoClient.close();
			  return FFWF;	
			   }
	}
		
	//Nitish FFWF Task Completion Using Rest Assured API
	@Step
	public void FFWFTaskCompleteManager() {
		{
			
			System.out.println("Trying to search for FFWF task with order #"+OrderSummarySteps.ordernum);
			String Transaction_id=FFWFmongodata(OrderSummarySteps.ordernum);
			int j=Count;
			if(j==0) {
				System.out.println("No FFWF Transaction Found to complete  "+j);
			}
			else {
				System.out.println("FFWF Transaction Found will complete it  "+j);
			
			for(int i=1;i<=j;i++) {
			//String Transaction_id="3944821371063727";
		    //String Transaction_id=FFWFmongodata(ban);
			RestAssured.baseURI = "https://cxg7i.test.intranet/test4/BMPOrderManagementProcess/v1/ordermanagement/order/v1/externalResponseFromFFWF";
			RestAssured.useRelaxedHTTPSValidation();  // ssl bypass
			RequestSpecification request = RestAssured.given().auth().preemptive().basic("tomdmn", "dD58ettB");
			request.header("Content-Type","application/json");
			BMShippingRequest bMShippingRequest=new BMShippingRequest();
			bMShippingRequest.setBan("string");
			bMShippingRequest.setDateOfSignOff("string");
			bMShippingRequest.setMacId("String");
			bMShippingRequest.setRepairInd("String");
			bMShippingRequest.setSerialNo("String");
			bMShippingRequest.setServiceGroup("S");
			bMShippingRequest.setSubServiceGroup("String");
			bMShippingRequest.setTimeOfSignOff("String");
			bMShippingRequest.setTrackingId("String");
			bMShippingRequest.setTransactionId("String");
			bMShippingRequest.setWtn("String");
			BmShippingRequestRoot bmShippingRequestRoot=new BmShippingRequestRoot();
			bmShippingRequestRoot.setBMShippingRequest(bMShippingRequest);
			bmShippingRequestRoot.setTransactionId(Transaction_id+"_"+i);
			//Gson gson=new GsonBuilder().setPrettyPrinting().create();
			Gson gson=new Gson();
			String requestjson=gson.toJson(bmShippingRequestRoot);
			System.out.println(requestjson);
			request.body(requestjson);
			Response response = request.post();
		
			int statusCode = response.getStatusCode();
			System.out.println("The status code recieved: " + statusCode);

			System.out.println("Response body: " + response.body().asString());
		}

			}
	}

	}
	
	
	//Nitish FFWF Task Completion Using MongoDB operations
	@Step
	public void FFWFOrderCompletion(String ordernumber) {
		System.out.println("The order for FFWF is "+ordernumber);
		dbURI ="mongodb://BMP_dba:BMP_dba_ctl123@vlmddmong01.dev.intranet:26000"; 
      mongoClient = new MongoClient(new MongoClientURI(dbURI)); 
		DB db = mongoClient.getDB("BMP_FFWF_"+CurrentEnvID);
		   DBCollection tableDetails = db.getCollection("fFWFPostEquipmentWrapper");
		   BasicDBObject queryDetails = new BasicDBObject();
		   queryDetails.put("customerOrderNumber",ordernumber);
		   DBCursor cursorDetails =tableDetails.find(queryDetails);
		   DBObject oneDetails;
		   boolean Name=cursorDetails.hasNext();
		   System.out.println("is Data in mongo Db avilable   "+Name);
		   System.out.println("Start of the loop");
		   //this loop will take care if data are available or not in db with timeout of 10 seconds Max Secondary loop
		   for(int i=1;i<=5;i++) {
			   cursorDetails =tableDetails.find(queryDetails);
			   System.out.println("Time iteration  "+i);
			   if(!cursorDetails.hasNext()) {
			   waitABit(2000);
			   System.out.println("is Data in mongo Db avilable Now "+cursorDetails.hasNext());  
			   }else {
				   break;
			   }
		   }
		   System.out.println("out of the loop");
		      oneDetails=cursorDetails.next();   
		      String ST=oneDetails.get("status").toString();
		      System.out.println("Current FFWF status is   "+ST);
		      String SD=oneDetails.get("shipDate").toString();
		      System.out.println("Current FFWF Date is   "+SD);
		      Date dNow = new Date( );
		      System.out.println("Current System Date: " + dNow);
		      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		      System.out.println("Formated Current Date: " + ft.format(dNow));
		      String UpdateDate=ft.format(dNow)+"T00:00:00.000Z";
		      System.out.println("New Date to be update in mongodb is  " + UpdateDate);
		      BasicDBObject OldDocument = new BasicDBObject().append("customerOrderNumber",OrderSummarySteps.ordernum);
		      BasicDBObject UpdatedDocument = new BasicDBObject();
		      UpdatedDocument.append("$set" ,new BasicDBObject().append("shipDate", UpdateDate));	     
		      tableDetails.updateMulti(OldDocument, UpdatedDocument);
		     System.out.println("Records Updated Succesfully");
		  mongoClient.close();
	}
	
	//Nitish FFWF Task Completion Verification
		@Step
		public void FFWFOrderCompletion_Verification(String ordernumber) {
			System.out.println("Waiting 1 minute for FFWF Tasks Completion");
			waitABit(60000);
			System.out.println("The order for FFWF Status Verifaction is "+ordernumber);
			dbURI ="mongodb://BMP_dba:BMP_dba_ctl123@vlmddmong01.dev.intranet:26000"; 
	        mongoClient = new MongoClient(new MongoClientURI(dbURI)); 
			DB db = mongoClient.getDB("BMP_FFWF_"+CurrentEnvID);
			   DBCollection tableDetails = db.getCollection("fFWFPostEquipmentWrapper");
			   BasicDBObject queryDetails = new BasicDBObject();
			   queryDetails.put("customerOrderNumber",ordernumber);
			   DBCursor cursorDetails =tableDetails.find(queryDetails);
			   DBObject oneDetails;
			      oneDetails=cursorDetails.next();   
			      String ST=oneDetails.get("status").toString();
			      System.out.println("Current FFWF status is   "+ST);
			      if(ST.equals("COMPLETED")) {
			    	  System.out.println("FFWF Status for Order # "+ordernumber+ " is COMPLETED");
			      }
			      else {
			    	  System.out.println("FFWF Status for Order # "+ordernumber+ " is "+ST);
			      }  
			  mongoClient.close();
		}
		
		//Nitish FFWF Task Completion Manager 
	@Step
	public void FFWFTaskCompleteManager2()
		{
		 String order = OrderSummarySteps.ordernum;
		  env = Page.currentEnvironment.getKey();
         if (env.equals("TEST4")) {
        	 CurrentEnvID="4";
         } 
         else if(env.equals("TEST1")) {
        	 CurrentEnvID="1";
         }
         else if(env.equals("TEST2")) {
        	 CurrentEnvID="2";
         }
         System.out.println("Current Environment id is  "+CurrentEnvID);
         
		     dbURI = "mongodb://BMP_rep:BMP_rep_ctl123@vlmddmong01.dev.intranet:26000";
            mongoClient = new MongoClient(new MongoClientURI(dbURI)); 
			DB db = mongoClient.getDB("BMP_SERVICEREGISTRY_"+CurrentEnvID);
			   DBCollection tableDetails = db.getCollection("serviceRegistryData");
			   BasicDBObject queryDetails = new BasicDBObject();
			   queryDetails.put("customerOrderNumber",order);
			   DBCursor cursorDetails =tableDetails.find(queryDetails);
			   boolean Name=cursorDetails.hasNext();
			   System.out.println("is Data in Mongo Db available  "+Name);
			   System.out.println("Start of the loop to Check availablity of Data in Mongodb");
			   //this loop will take care if data are available or not in db with timeout of 4 Mins
			   for(int i=1;i<=24;i++) {
				   cursorDetails =tableDetails.find(queryDetails);
				   System.out.println("Time iteration  "+i);
				   if(!cursorDetails.hasNext()) {
				   waitABit(10000);
				   System.out.println("is Data in Mongo Db available Now    "+cursorDetails.hasNext());  
				   }else {
					   waitABit(5000);
					   break;
				   }
			   }
			   System.out.println("out of the loop after Data availablity Check in Mongodb ");			   
			   queryDetails.clear();
			   queryDetails.put("customerOrderNumber",order);
			   queryDetails.put("provisioningChannel" ,"FFWF");
			   tableDetails.find(queryDetails);
				   int size= cursorDetails.size();
				   System.out.println("Current Data Size in DB  "+size);
				   if(size>=1) {
					   System.out.println("The FFWF task exist for this Order Number  "+order+ ", Hence will be Completing it");   
				          mongoClient.close();
				          FFWFOrderCompletion(order);
				          FFWFOrderCompletion_Verification(order);
				   }
				   else {
					   System.out.println("The FFWF order does not exist for this Order Number  "+order+ ", Hence Skipping it");   
				         mongoClient.close();
				   }	
				   
			   }
	
	//Nitish FFWF Task Disconnect
	@Step
	public void FFWFTaskDisconnectManager() {
		String order = OrderSummarySteps.ordernum;
		  env = Page.currentEnvironment.getKey();
       if (env.equals("TEST4")) {
      	 CurrentEnvID="4";
       } 
       else if(env.equals("TEST1")) {
      	 CurrentEnvID="1";
       }
       else if(env.equals("TEST2")) {
      	 CurrentEnvID="2";
       }
       System.out.println("The Disconnected order for FFWF is "+order);
		dbURI ="mongodb://BMP_dba:BMP_dba_ctl123@vlmddmong01.dev.intranet:26000"; 
     mongoClient = new MongoClient(new MongoClientURI(dbURI)); 
		DB db = mongoClient.getDB("BMP_FFWF_"+CurrentEnvID);
		   DBCollection tableDetails = db.getCollection("fFWFDisconnectWrapperRequest");
		   BasicDBObject queryDetails = new BasicDBObject();
		   queryDetails.put("customerOrderNumber",order);
		   DBCursor cursorDetails =tableDetails.find(queryDetails);
		   DBObject oneDetails;
		   boolean Name=cursorDetails.hasNext();
		   System.out.println("is Data in mongo Db available for Disconnected FFWF  "+Name);
		   System.out.println("Start of the loop");
		   //this loop will take care if data are available or not in db with timeout of 10 seconds Max Secondary loop
		   for(int i=1;i<=5;i++) {
			   cursorDetails =tableDetails.find(queryDetails);
			   System.out.println("Time iteration  "+i);
			   if(!cursorDetails.hasNext()) {
			   waitABit(4000);
			   System.out.println("is Data in mongo Db avilable Now "+cursorDetails.hasNext());  
			   if(i==5) {
				   System.out.println("No Data available for Disonnected FFWF Hence Skipping it for the order "+order);  
			   }
			   }else {
				   System.out.println("Disconneted FFWF Data available will complete it for the Order "+order);  
				     System.out.println("out of the loop");
				      oneDetails=cursorDetails.next();   
				      String ST=oneDetails.get("status").toString();
				      System.out.println("Current  FFWF status for Disconnect is "+ST);
				      String SD=oneDetails.get("shipDate").toString();
				      System.out.println("Current FFWF Date for Disconnect is  is   "+SD);
				      Date dNow = new Date( );
				      System.out.println("Current System Date: " + dNow);
				      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
				      System.out.println("Formated Current Date: " + ft.format(dNow));
				      String UpdateDate=ft.format(dNow)+"T00:00:00.000Z";
				      System.out.println("New Date to be update in mongodb for Disconnect is  " + UpdateDate);
				      BasicDBObject OldDocument = new BasicDBObject().append("customerOrderNumber",order);
				      BasicDBObject UpdatedDocument = new BasicDBObject();
				      UpdatedDocument.append("$set" ,new BasicDBObject().append("shipDate", UpdateDate));	     
				      tableDetails.updateMulti(OldDocument, UpdatedDocument);
				     System.out.println("Records Updated Succesfully for Disconnected Order");
				     break;
			   }
		   }
		   
		  mongoClient.close();
		
	}
	/*
	 * 
	 * Complete Order Web Tool Code - Nitish
	 */
	@Step
	public void check_for_the_billing_Status_as_Success_in_MongoDB() 		
		{
			 String order = OrderSummarySteps.ordernum;
			  env = Page.currentEnvironment.getKey();
	         if (env.equals("TEST4")) {
	        	 CurrentEnvID="4";
	         } 
	         else if(env.equals("TEST1")) {
	        	 CurrentEnvID="1";
	         }
	         else if(env.equals("TEST2")) {
	        	 CurrentEnvID="2";
	         }
	         System.out.println("Current Environment id is  "+CurrentEnvID);
	         System.out.println("Order Number is  "+order);
	         
			    dbURI = "mongodb://BM_ctlqa:BM_ctlqa_tstJu2020@vlmddmong02.dev.intranet:26000";
	            mongoClient = new MongoClient(new MongoClientURI(dbURI)); 
				DB db = mongoClient.getDB("BMP_BILLING_"+CurrentEnvID);
				   DBCollection tableDetails = db.getCollection("initBillingResponse");
				   BasicDBObject queryDetails = new BasicDBObject();
				   queryDetails.put("bundleOrder.orderNumber", order);
				   DBCursor cursorDetails =tableDetails.find(queryDetails);
				   boolean data=cursorDetails.hasNext();
				   System.out.println("Billing Data Available  "+data);
				   mongoClient.close();
				   System.out.println("DB Closed");
				   if(!data) {
					  fail("Provisioning of Order Failed in given Time, Try Again After Sometime");
				   }		  
				   else
				   {
					   
				   }
				   
	}	
	
	
}
