package com.ctl.it.qa.eshop.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.ctl.it.qa.staf.Environment;
//import com.ctl.it.qa.staf.RallyTools;
import com.ctl.it.qa.staf.STAFEnvironment;
//import com.ctl.it.qa.staf.SplunkLogger;
import com.ctl.it.qa.staf.Steps;
import com.ctl.it.qa.staf.TestEnvironment;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@TestEnvironment(Environment.TEST1)
@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty", "json:target/Reports/EShopCucumberReport.json" ,"html:target/Reports/EShopHTMLReport" },
		dryRun=false,tags = { "@HSIPOTS_NI_E2E_Shakeout_Postpaid_LC" }) 
				// A few other tags: @EshopTestScripts @EShopSanity @EShopFunctional @eshopcentral @EShopSatandaloneOrderCompletionSanity

public class RunCukesTest {

	@BeforeClass
	public static void setEnvironment() {
		STAFEnvironment.registerEnvironment(RunCukesTest.class);
		Steps.initialize("EShopLogin.xml");
//		SplunkLogger.cukeTestSplunkBeforeClass();
//		RallyTools.initiateRallyLogin();
	}

	@AfterClass
	public static void test() throws Exception {
//		SplunkLogger.cukeTestSplunkAfterClass(RunCukesTest.class);
//		RallyTools.closeRallyAPI();
	}
}
