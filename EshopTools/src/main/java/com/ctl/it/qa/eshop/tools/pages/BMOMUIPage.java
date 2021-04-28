package com.ctl.it.qa.eshop.tools.pages;

import org.openqa.selenium.support.FindBy;

import com.ctl.it.qa.staf.Page;

import net.serenitybdd.core.pages.WebElementFacade;

public class BMOMUIPage extends Page{
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElementFacade userName;
	
	
	 /** 
	 * Darshan- AC49667
	 * BM UI Header Text Xpath
	 */
	@FindBy(xpath = "//h3[contains(text(),'Blue Marble')]")
	public WebElementFacade blueMarble;
	
	 /** 
	 * Darshan- AC49667
	 * Click on Hamburger Icon
	 */
	
	@FindBy(xpath = "//a[@id='menu-toggle']")  
	public WebElementFacade hamburgerOption;
	
	
	 /** 
	 * Darshan- AC49667
	 * Click on BM OM
	 */
	@FindBy(xpath = "//span[contains(text(),'Blue Marble Order Management')]")
	public WebElementFacade clickBMOM;
	
	 
	/** 
		 * Darshan- AC49667
		 * Click on Manage Jeopardy
		 */
		@FindBy(xpath="//a[contains(text(),'Manage Jeopardy')]")
		public WebElementFacade manageJeopardyText;
	
	@Override
	public WebElementFacade getUniqueElementInPage() {
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

}
