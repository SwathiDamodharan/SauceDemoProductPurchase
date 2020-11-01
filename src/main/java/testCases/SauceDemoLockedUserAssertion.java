package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WrapperMethods.PM_Vodafone;
import sauceDemo_ShoppingCheckout_Pages.SauceDemoLoginPage;

public class SauceDemoLockedUserAssertion extends PM_Vodafone {

	@BeforeTest
	public void setData()
	{
		browserName="chrome";
		sUrl="http://www.saucedemo.com/";
		testCaseName="SauceDemoLockedUserAssertion";
		testDescription="To purchase any two product from the product list";
		testNodes="1st set Data";
		category="smoke";
		authors="Swathi";
		dataSheetName="Vodafone_CaseStudies";
		sheetName="Sheet3";
	}
	
	@Test(dataProvider="Vodafone_fetchData")
	public void userCredentialsValidation(String uName, String pwd) {
		
		new SauceDemoLoginPage().typeUserName(uName).typePassword(pwd).clickLogin();
	}
}
