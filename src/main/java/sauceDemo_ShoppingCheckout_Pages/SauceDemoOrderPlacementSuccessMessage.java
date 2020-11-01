package sauceDemo_ShoppingCheckout_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import WrapperMethods.PM_Vodafone;

public class SauceDemoOrderPlacementSuccessMessage extends PM_Vodafone {

	public SauceDemoOrderPlacementSuccessMessage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="div#checkout_complete_container>h2")
	private WebElement successMessage;
	
	public SauceDemoOrderPlacementSuccessMessage successMessageValidation(String expectSuccessText) {
		if(verifyText(successMessage, expectSuccessText)==false) {
			Assert.fail("Order not placed successfully");
		}
		else {
			System.out.println(successMessage.getText());
		}
		return this;
	}
}
