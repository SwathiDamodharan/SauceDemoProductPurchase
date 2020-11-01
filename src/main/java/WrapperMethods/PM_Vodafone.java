package WrapperMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import Utilities.readExcel_Vodafone;


public class PM_Vodafone extends Vodafone_WrapperDefinitions{
	
	public String browserName, sUrl;
	public String dataSheetName, sheetName;
	
		
	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}
	
	
	@BeforeClass
	public void beforeClass(){		
		startTestModule(testCaseName, testDescription);	
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testNodes);
		test.assignCategory(category);
		test.assignAuthor(authors);
		startApp(browserName, sUrl);		
	}
	
	@AfterSuite
	public void afterSuite(){
		endResult();
	}
	
	@AfterMethod
	public void afterMethod(){
		closeAllBrowsers();
	}

	@DataProvider(name="Vodafone_fetchData")
	public  Object[][] getData(){
		return readExcel_Vodafone.getSheet(dataSheetName, sheetName);		
	}	
}
