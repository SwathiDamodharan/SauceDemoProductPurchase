package amazonFlowPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WrapperMethods.PM_Vodafone;

public class AmazonProductList extends PM_Vodafone{

	public AmazonProductList(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Der neue Echo (4. Generation)')]")
	private WebElement verifyProductText;
	
	public AmazonProductPage verifyProductName(String productText) {
		verifyText(verifyProductText, productText);
		click(verifyProductText);
		return new AmazonProductPage();
	}
}
