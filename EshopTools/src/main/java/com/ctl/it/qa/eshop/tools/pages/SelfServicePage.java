package com.ctl.it.qa.eshop.tools.pages;

import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctl.it.qa.staf.Page;
import com.ctl.it.qa.staf.xml.reader.IntDataContainer;

import net.serenitybdd.core.pages.WebElementFacade;

public class SelfServicePage extends Page{

	public final Logger slf4jLogger = LoggerFactory.getLogger(LoginPage.class);
	
	@FindBy(xpath="//input[@id='loginButton']")
	public WebElementFacade signIn;
	
	@FindBy(xpath = "//input[@id='loginForm:username']")
	public WebElementFacade userName;

	@FindBy(xpath = "//input[contains(@id,'loginForm:password')]")
	public WebElementFacade password;

	//@FindBy(xpath = "//input[@name='submit' and @title='Login']")
	@FindBy(xpath = "//input[contains(@id,'loginForm:loginButton')]")
	public WebElementFacade loginBtn;

	@Override
	public WebElementFacade getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return userName;
	}
	
	public static String getEnvironment() {
		String url = envData.getFieldValue("url");
		String env = null;

		if (url.contains("consultingplusa1")) {
			env = "TEST1";
		} else if (url.contains("eshop-e2e.test.intranet")) {
			env = "E2E";
		} else if (url.contains("consultingplusa5")) {
			env = "TEST2";
		}
		return env;
	}

	public void enterCredentials(String userType) {
		IntDataContainer dataContainer = envData.getContainer("MYALoginPage").getContainer(userType);
		userName.sendKeys(dataContainer.getFieldValue("tbx_username_MYA"));		
		password.sendKeys(dataContainer.getFieldValue("tbx_password_MYA"));
		loginBtn.click();
		slf4jLogger.info("Clicked on login button ");

	}
	

}
