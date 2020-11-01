package amazonFlowPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WrapperMethods.PM_Vodafone;

public class AmazonProductPage extends PM_Vodafone {

	public AmazonProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	/*@FindBy(how=How.XPATH, using="//img[@alt='Anthrazit']")
	private WebElement anthrazitFarbe;
	
	@FindBy(how=How.XPATH, using="//img[@alt='Weiﬂ']")
	private WebElement weissFarbe;
	
	@FindBy(how=How.XPATH, using="//img[@alt='Blaugrau']")
	private WebElement blauGrauFarbe;
	*/	
	
	@FindBy(how=How.XPATH, using="//img[@class='imgSwatch']")
	private List<WebElement> colorList;
	
	public AmazonProductPage selectFarbe(String data) {
		for(WebElement eachColor:colorList) {
			if(eachColor.getAttribute("alt").contains(data)) {
				click(eachColor);
				System.out.println("Product color changed to: "+data);
			}
		}
		return this;
	}
}
