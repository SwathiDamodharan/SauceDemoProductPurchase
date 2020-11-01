package amazonFlowPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WrapperMethods.PM_Vodafone;

public class Amazon_Login_Page extends PM_Vodafone {

	public Amazon_Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//h4[text()='Wählen Sie Ihre Cookie-Einstellungen']")
	private WebElement verifyText;
	
	@FindBy(how=How.ID, using="sp-cc-accept")
	private WebElement acceptCookiesButton;
	
	public Amazon_Login_Page acceptCookies(String text) {
		verifyText(verifyText, text);
		click(acceptCookiesButton);
		return this;
	}
	
	@FindBy(how=How.ID, using="twotabsearchtextbox")
	private WebElement SearchBox;
	
	public Amazon_Login_Page typeSearchBox(String data) {
		type(SearchBox, data);
		return this;
	}
	
	@FindBy(how=How.XPATH, using="//input[@type='submit'][@value=\"Los\"]")
	private WebElement SearchIcon;
	
	public AmazonProductList clickSearchIcon() {
		click(SearchIcon);
		return new AmazonProductList();
	}
}
