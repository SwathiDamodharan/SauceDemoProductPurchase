package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import WrapperMethods.PM_Vodafone;
import ultimateQAPages.ultimateQALeftFormDetails;
import ultimateQAPages.ultimateQARightFormDetails;

public class UlitmateQAFormSubmission extends PM_Vodafone {

	@BeforeTest
	public void setData()
	{
		browserName="chrome";
		sUrl="https://ultimateqa.com/filling-out-forms/";
		testCaseName="UlitmateQAFormSubmission";
		testDescription="To purchase any two product from the product list";
		testNodes="1st set Data";
		category="smoke";
		authors="Swathi";
		dataSheetName="Vodafone_CaseStudies";
		sheetName="Sheet4";
	}
	
	@Test(dataProvider="Vodafone_fetchData")
	public void leftFormSubmission(String lName, String lDescription, String rName, String rDescription, String captchaCapture) {
		new ultimateQALeftFormDetails().
		closePopUpWindow().
		typeLeftNameBox(lName).
		typeLefDescriptionBox(lDescription).
		clickleftSubmitButton();
		new ultimateQARightFormDetails().typeRightNameBox(rName).
		typeRightDescriptionBox(rDescription).
		typeCaptchaValue(captchaCapture).
		clickRightSubmitButton().
		verifyRightFormSuccessMessage();
		new ultimateQALeftFormDetails().verifyLeftFormSuccessMessage();
	}
}
