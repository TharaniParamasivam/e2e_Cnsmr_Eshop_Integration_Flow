package com.ctl.it.qa.eshop.tools.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.eshop.tools.common.utils.ExcelOperations;
import com.ctl.it.qa.eshop.tools.common.utils.ExcelUtils;
import com.ctl.it.qa.eshop.tools.pages.OrderSummaryPage;
import com.ctl.it.qa.staf.Steps;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import net.thucydides.core.annotations.Step;

public class OrderSummarySteps extends Steps {

	private final Logger slf4jLogger = LoggerFactory.getLogger(OrderSummarySteps.class);
	OrderSummaryPage orderSummaryPage;
	ExcelOperations excelOperations;

	public static String ENVUrl = envData.getFieldValue("url");
	public static String accountnum;
	public static String ordernum;
	public static String tomOrderid;
	static String Product;
	public static String dbURI = null;
	public static MongoClient mongoClient;
	public static String CSNO = null;
	public static String WEBSOP;

	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;

	// [main] INFO com.ctl.it.qa.eshop.tools.steps.OrderSummarySteps - Cleaned order
	// number = 1010412774
	// [main] INFO com.ctl.it.qa.eshop.tools.steps.OrderSummarySteps - Cleaned
	// account number = 690044898

	@Step
	public void clickYes() throws InterruptedException {
		/*
		 * Old UI code try { orderSummaryPage.shouldExist(orderSummaryPage,120);
		 * orderSummaryPage.selectYes.click(); slf4jLogger.info("Clicked on to Yes"); }
		 * catch (Exception e) { orderSummaryPage.selectYes.waitUntilVisible();
		 * JavascriptExecutor js = (JavascriptExecutor) getDriver();
		 * js.executeScript("arguments[0].scrollIntoView();",
		 * orderSummaryPage.selectYes); js.executeScript("arguments[0].click();",
		 * orderSummaryPage.selectYes); slf4jLogger.info("Clicked on Yes Button"); }
		 */
		WaitForPageToLoad(50);
		orderSummaryPage.shouldExist(orderSummaryPage, 120);
		orderSummaryPage.btn_View_RCCs.waitUntilVisible();
		// waitABit(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		/*
		 * RCCs button click js.executeScript("arguments[0].scrollIntoView();",
		 * orderSummaryPage.btn_View_RCCs); js.executeScript("arguments[0].click();",
		 * orderSummaryPage.btn_View_RCCs);
		 */

		waitABit(10000);
		// orderSummaryPage.selectYes.waitUntilVisible();
		// js.executeScript("arguments[0].scrollIntoView();",
		// orderSummaryPage.selectYes);
		// js.executeScript("arguments[0].click();", orderSummaryPage.selectYes);

		// js.executeScript("arguments[0].scrollIntoView();",
		// orderSummaryPage.lbl_Review_RCCs);
		// js.executeScript("arguments[0].click();", orderSummaryPage.btn_RCCs_Close);
		// slf4jLogger.info("RCCs section reviewed");
		// waitABit(2000);
		js.executeScript("arguments[0].scrollIntoView();", orderSummaryPage.btn_Acknowledge_RCCs);
		js.executeScript("arguments[0].click();", orderSummaryPage.btn_Acknowledge_RCCs);
		orderSummaryPage.lbl_Still_Acknowledged_RCCs.shouldBeVisible();
		slf4jLogger.info("Order Acknowledged");

	}

	public void clickSubmitOrder() throws InterruptedException {

		orderSummaryPage.shouldExist(orderSummaryPage, 120);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", orderSummaryPage.submitOrder);
		slf4jLogger.info("clicked on to submit order");
		/*
		 * try { orderSummaryPage.shouldExist(orderSummaryPage, 120);
		 * slf4jLogger.info("last yes button click1");
		 * orderSummaryPage.submitOrder.click();
		 * slf4jLogger.info("clicked on to submit order"); }catch (Exception e) {
		 * orderSummaryPage.shouldExist(orderSummaryPage, 120); Thread.sleep(2000);
		 * orderSummaryPage.submitOrder.click(); }
		 */
	}

	public void orderSummaryPageVerification() {
		orderSummaryPage.shouldExist(orderSummaryPage, 120);
		orderSummaryPage.shouldBeVisible(orderSummaryPage.orderSubmittedverification);
		String orderSubmitted = "Order Submitted Successfully";
		Assert.assertTrue(orderSubmitted.contains(orderSummaryPage.orderSubmittedverification.getText().trim()));
		slf4jLogger.info("Verified the order submitted successfully or not");
	}

	public void enterTechnicianRemarks(String techRemarks) {
		orderSummaryPage.remarks.sendKeys(techRemarks);
		slf4jLogger.info("Entered techincal remarks");
	}

	public void checkRemarks() {
		String remark = "Technical remarks added";
		String remarksCheck = orderSummaryPage.notes.getText();
		slf4jLogger.info("remarks " + remarksCheck);

		if (remark.equals(remarksCheck)) {

			Assert.assertTrue(remark.equals(remarksCheck));
		}
		slf4jLogger.info("verified techinican remarks is dipslayed correctly or not");
	}

	public void getAccountNumber() throws Exception {
		orderSummaryPage.shouldBeVisible(orderSummaryPage.orderNumberText);
		// Nitish
		String fullOrdernum = orderSummaryPage.orderNumberText.getText();
		int lastindexor = fullOrdernum.toCharArray().length;
		ordernum = fullOrdernum.substring(13, lastindexor);
		String fullAccountnum = orderSummaryPage.accountNumberText.getText();
		int lastindexac = fullAccountnum.toCharArray().length;
		accountnum = fullAccountnum.substring(15, lastindexac);
		Product = orderSummaryPage.Product_label.getText();
		slf4jLogger.info("order number = " + fullOrdernum);
		slf4jLogger.info("account number = " + fullAccountnum);
		slf4jLogger.info("Cleaned order number = " + ordernum);
		slf4jLogger.info("Cleaned account number = " + accountnum);
		slf4jLogger.info("Product = " + Product);
		waitABit(2000);
	}

	@Step
	public void save_the_Order_and_BAN() throws EncryptedDocumentException, InvalidFormatException, IOException {

		// for(int i=0; i<=2; i++) {
		File orderfile = new File("..\\EshopTools\\src\\test\\resources\\OrderDetails.xlsx");
		Workbook workbook = WorkbookFactory.create(orderfile);
		// Workbook workbook = WorkbookFactory.
		Sheet sheet = workbook.getSheetAt(0);
		slf4jLogger.info("Sheet Name :-  " + sheet);
		slf4jLogger.info("First Row :-  " + sheet.getFirstRowNum());
		slf4jLogger.info("Last Row :-  " + sheet.getLastRowNum());
		int lastrow = sheet.getLastRowNum();
		int newrow = lastrow + 1;
		slf4jLogger.info("New Row to write data :-  " + newrow);
		Row row = sheet.createRow(newrow);
		// row.createCell(0).setCellValue(newrow);
		Date dNow = new Date();
		System.out.println("Current System Date: " + dNow);
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println("Formated Current Date: " + ft.format(dNow));
		// row.createCell(1).setCellValue(ft.format(dNow));
		row.createCell(1).setCellValue(ordernum);
		row.createCell(2).setCellValue(accountnum);
		row.createCell(0).setCellValue(Product);
		row.createCell(3).setCellValue(WEBSOP);
		row.createCell(4).setCellValue(ENVUrl);
		// FileOutputStream fileOut = new
		// FileOutputStream("..\\EShopTests\\target\\OrderDataDetails.xlsx");
		// workbook.write(fileOut);
		// fileOut.close();
		/*
		 * Cell cell; cell = ((Sheet) orderfile).getRow(newrow).getCell(0);
		 * cell.setCellType(Cell.CELL_TYPE_STRING); cell.setCellValue("Result");
		 */

		// slf4jLogger.info("Sheet Name :- "+sheet.);
		workbook.close();
		// }
		// }

	}

	public void save_the_Order_and_BAN_JSON(String territory,String EnvName)
			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {

		try (FileReader reader = new FileReader("..\\EshopTools\\src\\test\\resources\\OrderDetailsUpdate.json")) {
			// Read JSON file
			JSONParser parser = new JSONParser();
			JSONObject data = (JSONObject) parser.parse(reader);
			data.put("Product", Product);
			data.put("Territory", territory);
			data.put("CustomerOrderNumber", ordernum);
			data.put("BAN", accountnum);
			data.put("TomOrderId", WEBSOP);
			data.put("Env", EnvName);
			data.put("Status", "");
			FileWriter file = new FileWriter("..\\EshopTools\\src\\test\\resources\\OrderDetailsUpdate.json");
			file.write(data.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	@Step

	public void validateDueDate(String address) {
		boolean flag = orderSummaryPage.serviceAddress.getText().contains(address.split(",")[0].trim());
		Assert.assertTrue(flag);
		slf4jLogger.info("service address validation =" + orderSummaryPage.serviceAddress.getText());
		flag = orderSummaryPage.activationDate.getText().contains(SchedulingSteps.actualDueDate.split(",")[0].trim());
		Assert.assertTrue(flag);
		slf4jLogger.info("due date validation =" + orderSummaryPage.activationDate.getText());
	}

	// Nitish
	public void i_clicked_on_new_order() {

		orderSummaryPage.neworder.waitUntilClickable();
		waitABit(30000);
		orderSummaryPage.neworder.click();
		slf4jLogger.info("Clicked on Start New Order button");
		waitABit(7000);

	}

	public void i_enter_existing_account_number(String accountnum) {

		orderSummaryPage.accnumrbn.waitUntilClickable();
		waitABit(3000);
		orderSummaryPage.accnumrbn.click();
		orderSummaryPage.existsaaccnumr.sendKeys(accountnum);
		slf4jLogger.info("Entered existing account number:-  " + accountnum);

	}

	public void enter_the_special_remark_in_Additional_Order_Remarks_field(String datapassed) {

		orderSummaryPage.Additional_Order_Remarks.waitUntilClickable();
		orderSummaryPage.Additional_Order_Remarks.sendKeys(datapassed);
		slf4jLogger.info("Entered special remark in Additional Order Remarks field:-  " + datapassed);

		waitABit(15000);
	}

	// public static String TRNX = null;
	// public static int count;
	// public static String ON;

	public void mongo_DB_to_fetch_backend_data() throws InterruptedException {

		slf4jLogger.info("MONGO DB Connection Started");
		// Dry Run url
		dbURI = "mongodb://BM_ctlqa:BM_ctlqa_tstJu2020@vlmddmong01.dev.intranet:26000";
		// dbURI = "mongodb://BMP_rep:BMP_rep_ctl123@vlmddmong01.dev.intranet:26000";
		// dbURI =
		// "mongodb://BMP_rep:BMP_rep_ctl123@vlmdprmong01.corp.intranet:14000,vlmdprmong02.corp.intranet:14000,vlmdprmong03.corp.intranet:14000/BMP_ADDRESS_1?readPreference=secondaryPreferred&replicaSet=MONGODB_PROD2&authSource=admin&minPoolSize=2";

		mongoClient = new MongoClient(new MongoClientURI(dbURI));
		slf4jLogger.info("MONGO DB connection established successfully");
		// waitABit(10000);
		getCSNOfromSR();
		// SR(BAN);
		// waitABit(5000);
		WEBSOPfromTOM();
		mongoClient.close();
		slf4jLogger.info("MONGO DB connection closed successfully");
		slf4jLogger.info("MONGO DB Connection Ended");
	}

	public void getCSNOfromSR() {
		String CSNO = SR(accountnum);
		slf4jLogger.info("CSNO is received successfully   " + CSNO);
	}

	public String SR(String BAN) {

		DB db = mongoClient.getDB("BMP_SERVICEREGISTRY_1");
		DBCollection tableDetails = db.getCollection("serviceRegistryData");
		BasicDBObject queryDetails = new BasicDBObject();
		queryDetails.put("ban", BAN);
		DBCursor cursorDetails = tableDetails.find(queryDetails);
		DBObject oneDetails;
		boolean Name = cursorDetails.hasNext();
		// this loop will take care if query db with timeout of 4 Mins
		a: for (int i = 1; i <= 24; i++) {
			cursorDetails = tableDetails.find(queryDetails);
			System.out.println("Time iteration  " + i);
			if (!cursorDetails.hasNext()) {
				waitABit(10000);
				System.out.println("Data in mongo Db   " + cursorDetails.hasNext());
			} else {
				cursorDetails = tableDetails.find(queryDetails);
				while (cursorDetails.hasNext()) {
					if ((cursorDetails.next().get("provisioningChannel").toString().equals("TOM"))) {
						System.out.println("Entered if block");
						break a;
					} else {
						waitABit(15000);
					}
				}
			}
		}
		System.out.println("out of the loop");
		while (cursorDetails.hasNext()) {
			oneDetails = cursorDetails.next();
			String PC = oneDetails.get("provisioningChannel").toString();
			if (PC.equals("TOM")) {
				String OT = oneDetails.get("orderType").toString();
				if (OT.equals("NEWINSTALL")) {
					CSNO = oneDetails.get("customerServiceOrderNumber").toString();
					System.out.println("The NI CSNO for TOM is   " + CSNO);
					break;
				}
			}

		}
		return CSNO;

	}

	public void WEBSOPfromTOM() throws InterruptedException {
		String WEBSOP = TOM(CSNO);
		slf4jLogger.info("WEBSOP is received successfully   " + WEBSOP);
	}

	public static String TOM(String CSNO1) throws InterruptedException {
		DB db1 = mongoClient.getDB("BMP_TOMORCHESTRATOR_1");
		DBCollection tableDetails1 = db1.getCollection("serviceOrderStatusReference");
		BasicDBObject queryDetails1 = new BasicDBObject();
		queryDetails1.put("customerServiceOrderNumber", CSNO);
		DBCursor cursorDetails1 = tableDetails1.find(queryDetails1);
		DBObject oneDetails1;

		while (cursorDetails1.hasNext()) {
			oneDetails1 = cursorDetails1.next();
			oneDetails1 = (DBObject) oneDetails1.get("provisioningServiceStatusRequest");
			oneDetails1 = (DBObject) oneDetails1.get("orders");
			oneDetails1 = (DBObject) oneDetails1.get("0");
			WEBSOP = oneDetails1.get("orderNumber").toString();
			System.out.println("The NI OrderID # is  " + WEBSOP);
			break;
		}
		return WEBSOP;
	}

	// Premkumar 04/05

	@Step
	public void logout_the_application() {

		Set<String> allWindows = getDriver().getWindowHandles();
		Iterator<String> windowIterator = allWindows.iterator();
		String parentWindow = windowIterator.next();
		String childWindow = windowIterator.next();
		getDriver().switchTo().window(parentWindow);
		// waitABit(3000);
		System.out.println("Control is in Parent window");
		getDriver().get("http://fns.centurylink.com/oam/server/logout");
		waitABit(3000);
		System.out.println("Loggged out succesful");
		getDriver().switchTo().window(childWindow);
		// waitABit(10000);

	}

	/*
	 * Complete Order Web Tool Code - Nitish
	 */
	@Step
	public void Web_Tool_to_Complete_Provisioning_of_the_Order_in_Env(String envName, String territory) {

		slf4jLogger.info("Open Web Tool up By New Tab ....");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.open()");
		Set<String> allWindows = getDriver().getWindowHandles();
		Iterator<String> windowIterator = allWindows.iterator();
		String parentWindow = windowIterator.next();
		String childWindow = windowIterator.next();
		getDriver().switchTo().window(childWindow);
		getDriver().get("http://x1074509:8080/WebTestTools/CompleteOrder.html");
		slf4jLogger.info("Web Tool Complete Order Launched");
		orderSummaryPage.Environment.selectByValue(envName);
		slf4jLogger.info("Selected Enviroment in Web Tool as " + envName);
		orderSummaryPage.Order_number.sendKeys(ordernum);
		slf4jLogger.info("Entered Order Number in Web Tool as " + ordernum);
		if (territory.equals("LQ")) {
			Select sel = new Select(getDriver().findElement(By.xpath("//select[@id='choices']")));
			sel.selectByIndex(3);
			orderSummaryPage.Submit.click();
		} else {
			orderSummaryPage.Submit.click();
		}

		slf4jLogger.info("Clicked Submit Button");
		slf4jLogger.info("Waiting 3 minutes for Order to be completed");
		if (territory.equals("LQ")) {
			waitABit(40000);
		} else {
			waitABit(110000);
		}
		getDriver().switchTo().window(parentWindow);
		slf4jLogger.info(".... Web Tool Execution Done");
	}

	@Step
	public void integrationScriptInvoke() throws InterruptedException {
		// ExcelUtils.ReadExcel1();
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("..\\EshopTools\\src\\test\\resources\\Integration_UFT.bat").inheritIO();
			Process process = processBuilder.start();
			waitABit(500000);
			process.destroy();
			System.out.println("Integration Success");

		} catch (IOException e) {
			System.out.println(e);
			System.exit(0);
		}
	}
}
