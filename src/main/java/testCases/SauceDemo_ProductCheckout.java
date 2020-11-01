package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WrapperMethods.PM_Vodafone;
import sauceDemo_ShoppingCheckout_Pages.SauceDemoLoginPage;

public class SauceDemo_ProductCheckout extends PM_Vodafone {
	
	@BeforeTest
	public void setData()
	{
		browserName="chrome";
		sUrl="http://www.saucedemo.com/";
		testCaseName="SauceDemo_productPurchase";
		testDescription="To purchase any two product from the product list";
		testNodes="1st set Data";
		category="smoke";
		authors="Swathi";
		dataSheetName="Vodafone_CaseStudies";
		sheetName="Sheet2";
	}
	
	@Test(dataProvider="Vodafone_fetchData")
	public void sauceDemoProductCheckout(String uName, String pwd, String productName1, String productName2, String fName,
			String sName, String zCode, String successText) {
		
		new SauceDemoLoginPage().
		typeUserName(uName).
		typePassword(pwd).
		clickLogin().
		productSelection(productName1, productName2).
		clickShoppingButton().clicCheckoutButton().
		typeFirstName(fName).typeSecondName(sName).
		typePostalCode(zCode).
		clickContinueButton().
		clickFinishButton().
		successMessageValidation(successText);
	}

}
