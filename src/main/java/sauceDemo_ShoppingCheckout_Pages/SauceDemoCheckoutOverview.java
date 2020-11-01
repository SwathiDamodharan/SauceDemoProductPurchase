package sauceDemo_ShoppingCheckout_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WrapperMethods.PM_Vodafone;

public class SauceDemoCheckoutOverview extends PM_Vodafone {
	
	public SauceDemoCheckoutOverview() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="a[class='btn_action cart_button']")
	private WebElement finishButton;
	
	public SauceDemoOrderPlacementSuccessMessage clickFinishButton() {
		click(finishButton);
		return new SauceDemoOrderPlacementSuccessMessage();
	}

}
