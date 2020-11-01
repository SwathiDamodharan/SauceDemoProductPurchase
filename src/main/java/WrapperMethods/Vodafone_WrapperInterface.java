package WrapperMethods;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

public interface Vodafone_WrapperInterface {

	public void startApp(String browser, String sUrl, boolean bReturns) throws MalformedURLException ;
	
	public void click(WebElement ele);
	
	public void type(WebElement ele, String data) ;
	
	public void hoverOver(WebElement hoverEle, WebElement clickEle);
	
	public boolean verifyText(WebElement ele, String expecttext);
	
	public long takeSnap();
	
	public void closeBrowser();	
	
	public void closeAllBrowsers();
}
