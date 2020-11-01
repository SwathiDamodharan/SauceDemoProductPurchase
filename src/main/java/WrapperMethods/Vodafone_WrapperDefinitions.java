package WrapperMethods;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Reporter_Vodafone;

public class Vodafone_WrapperDefinitions extends Reporter_Vodafone implements Vodafone_WrapperInterface {

	public static RemoteWebDriver driver;
	

	public void startApp(String browser, String sUrl, boolean bReturns)  {
		try{
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				driver = new ChromeDriver();
			}else {
				System.setProperty("webdriver.gecko.driver", "./driver/geckodriver_32bit.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);
			reportStep("The browser: "+browser+" launched successfully", "PASS");
		}catch(WebDriverException e) {			
			reportStep("The browser: "+browser+" could not be launched", "FAIL");
		}

	}

	public void startApp(String browser, String sUrl) {		
		startApp(browser, sUrl, false);		
	}

	public void type(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data);
			reportStep("The data: "+data+" entered successfully in the field :"+ele, "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The data: "+data+" could not be entered in the field :"+ele,"FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while entering "+data+" in the field :"+ele, "FAIL");
		}		
	}

	public void click(WebElement ele) {
		String text = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ele));			
			text = ele.getText();
			ele.click();
			reportStep("The element "+text+" is clicked", "PASS");
		} catch (InvalidElementStateException e) {
			reportStep("The element: "+text+" could not be clicked", "FAIL");
		} catch (WebDriverException e) {
			reportStep("Unknown exception occured while clicking in the field :", "FAIL");
		} 

	}

	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return number;
	}

	public void hoverOver(WebElement hoverEle, WebElement clickEle) {

		try {
			Actions action=new Actions(driver);
			action.moveToElement(hoverEle).click(clickEle).perform();
			Thread.sleep(2000);
			reportStep("Successfully hovered on the element " +hoverEle+ " and clicked on the element " +clickEle, "PASS");
		} catch (InterruptedException e) {
			reportStep("Exception occurred while performing hover action", "FAIL");
		}
	}

	public boolean verifyText(WebElement ele, String expecttext) {
	 boolean flag=true;
	 String extractText=ele.getText();
		try{
			if(extractText.equals(expecttext) || extractText.equalsIgnoreCase(expecttext) || extractText.contains(expecttext)) {
				reportStep("The text: "+extractText+" matches with the value :"+expecttext,"PASS");
			}
			else {
				reportStep("The text "+extractText+" doesn't matches the actual "+expecttext,"FAIL");
				flag=false;
			}
		}catch (WebDriverException e) {
			reportStep("Unknown exception occured while verifying the Text", "FAIL");
		}
		return flag; 
		
	}
	
	public void closeBrowser() {
		try {
			driver.close();
			reportStep("The browser is closed","PASS", false);
		} catch (Exception e) {
			reportStep("The browser could not be closed","FAIL", false);
		}

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			reportStep("The opened browsers are closed","PASS", false);
		} catch (Exception e) {
			reportStep("Unexpected error occured in Browser","FAIL", false);
		}

	}
}
