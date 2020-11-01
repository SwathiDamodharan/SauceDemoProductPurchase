package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WrapperMethods.PM_Vodafone;
import ultimateQAPages.ultimateQARightFormDetails;

public class UltimateQACaptchaFormSubmission extends PM_Vodafone {

	
	@BeforeTest
	public void setData()
	{
		browserName="chrome";
		sUrl="https://ultimateqa.com/filling-out-forms/";
		testCaseName="UltimateQACaptchaFormSubmission";
		testDescription="To purchase any two product from the product list";
		testNodes="1st set Data";
		category="smoke";
		authors="Swathi";
		dataSheetName="Vodafone_CaseStudies";
		sheetName="Sheet5";
	}
	
	@Test(dataProvider="Vodafone_fetchData")
	public void rightFormSubmission(String rName, String rDescription, String captchaCapture) {
		
		new ultimateQARightFormDetails().
		typeRightNameBox(rName).
		typeRightDescriptionBox(rDescription).
		typeCaptchaValue(captchaCapture).
		clickRightSubmitButton().
		verifyRightFormSuccessMessage();
	}
}
