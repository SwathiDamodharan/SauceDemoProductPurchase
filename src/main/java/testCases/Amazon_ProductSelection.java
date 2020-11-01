package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WrapperMethods.PM_Vodafone;
import amazonFlowPages.Amazon_Login_Page;

public class Amazon_ProductSelection extends PM_Vodafone {

	@BeforeTest
	public void setData()
	{
		browserName="chrome";
		sUrl="https://www.amazon.de/";
		testCaseName="Amazon_ProductSelection";
		testDescription="Select Der new echo product and change its color";
		testNodes="1st Row Data";
		category="smoke";
		authors="Swathi";
		dataSheetName="Vodafone_CaseStudies";
		sheetName="Sheet1";
	}
	
	@Test(dataProvider="Vodafone_fetchData")
	public void amazon_Product_Selection(String cookiesText, String searchBoxText, String productText, String color) {
		new Amazon_Login_Page().
		acceptCookies(cookiesText).
		typeSearchBox(searchBoxText).
		clickSearchIcon().
		verifyProductName(productText).
		selectFarbe(color);
	}
}
