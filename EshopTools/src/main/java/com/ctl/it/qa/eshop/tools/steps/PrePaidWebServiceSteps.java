package com.ctl.it.qa.eshop.tools.steps;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;
import org.junit.Assert;
import org.slf4j.LoggerFactory;
import com.ctl.it.qa.staf.Steps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

@SuppressWarnings("serial")
public class PrePaidWebServiceSteps extends Steps{
	
	private final org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger(PrePaidWebServiceSteps.class);

	RequestSpecification request;
	Response response;
	File f;
	String s="{\r\n" + 
			"			  \"accNum\": \"PPB11027074\",\r\n" + 
			"			  \"orderNum\": \"1000033448\",\r\n" + 
			"			  \"orderReferenceNumber\": \"string\"\r\n" + 
			"			};";
	
	@Step
	public void execute_service(String url) {
		RestAssured.baseURI = url;
		RestAssured.useRelaxedHTTPSValidation();  // ssl bypass
		request = RestAssured.given();
		request.header("Content-Type","application/json");
		slf4jLogger.info("Connection Established");
	}
	
	@Step
	public void GET_request() {
		
		response = request.get("/bsi/prepaid/fetchPrepaidQuote/ORN-31925439912962410");
        slf4jLogger.info("GET Request Executed");
        slf4jLogger.info("GET Response Body "+response.prettyPrint());
        //slf4jLogger.info("GET Response Body "+response.);
        Assert.assertEquals((response.asString()).contains("PPB11027555"), true);
        Assert.assertEquals((response.asString()).contains("55.5"), true);
        Assert.assertEquals((response.asString()).contains("MODEM"), true);
	}
	
	
	@Step
	public void POST_request() {
		
		request.body(f);
		//request.body(s);
		response = request.post();
		slf4jLogger.info("POST Request Executed");
		slf4jLogger.info("POST Response Body "+response.prettyPrint());
		
	}
	
	@Step
	public void status_code() {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);
		slf4jLogger.info("Status Code Returned  "+statusCode);
		
	}
	
	@Step
	public void status_code(int passedstatuscode) {
		int statusCode = response.getStatusCode();
		slf4jLogger.info("Status Code Returned  "+statusCode);
		Assert.assertEquals(passedstatuscode, statusCode);
		
		
	}

	@Step
	public void Request_From_File() {
		//f = new File("C:\\Users\\SCGUPTA\\Documents\\My Received Files\\PrepaidTaxReq.txt");
		f = new File("C:\\Automation\\Webservice_OrderSubmit1\\Eshop_TST\\EshopTools\\TestData\\CSActivation.txt");

		
		slf4jLogger.info("File Request Executed");
	}	
	
	@Step
	public void input_paramaters_from_file(String fileLocation) throws Exception {
		
		if(fileLocation.contains("PCSR"))
		{
			Object obj = new JSONParser().parse(new FileReader(fileLocation));
			JSONObject jo = (JSONObject) obj;
			JSONObject dataList = (JSONObject) jo.get("serviceRegistryRequest");
			dataList.put("BAN", OrderSummarySteps.accountnum);
			PrintWriter pw = new PrintWriter(fileLocation); 
	        pw.write(jo.toJSONString()); 
	        pw.flush(); 
	        pw.close();
			f = new File(fileLocation);
			slf4jLogger.info("File Request Executed "+fileLocation);
		}
		else
		{
			f = new File(fileLocation);
			slf4jLogger.info("File Request Executed "+fileLocation);
		}
		

	}
	@Step
	public void submit_the_GET_request_with_Parameters(String parameters) {
		if(parameters.contains("ban"))
		{
			String param=parameters.replaceFirst("\\b\\d{9}\\b", OrderSummarySteps.accountnum);
			slf4jLogger.info("GET Request Executed " +param);
			response = request.get(param);
	        slf4jLogger.info("GET Request Executed with Parameters");
	        slf4jLogger.info("GET Response Body with parameters  "+response.prettyPrint());
		}
		else
		{
			response = request.get(parameters);
	        slf4jLogger.info("GET Request Executed with Parameters");
	        slf4jLogger.info("GET Response Body with parameters  "+response.prettyPrint());		
		}

	}
	@Step
	public void validate_the_object_data(String data) {
		System.out.println(data);
		if(data.contains("~")) {
		    String[] newdata= data.split("~");
			int size=newdata.length;
			for(int i=0; i< size; i++){
				 System.out.println(newdata[i]);
				 Assert.assertEquals((response.asString()).contains(newdata[i]), true);
				 //Assert.assertEquals("Validation Performed for Multiple Fields ", newdata[i], response.asString());
				 slf4jLogger.info("Successfully validated this data :  "  +newdata[i]);
			}
		}
		else {
			// Assert.assertEquals("Validation Performed", data, response.asString());
			 Assert.assertEquals((response.asString()).contains(data), true);
			 slf4jLogger.info("Successfully validated this data :  "  +data);
		      }
	}

	
	
}
	

	
	

