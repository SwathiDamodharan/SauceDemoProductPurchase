package sauceDemo_ShoppingCheckout_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WrapperMethods.PM_Vodafone;

public class SauceDemoYourCart extends PM_Vodafone {

	public SauceDemoYourCart() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//a[@class='btn_action checkout_button'][text()='CHECKOUT']")
	private WebElement checkoutButton;
	
	public SauceDemoYourInformation clicCheckoutButton() {
		click(checkoutButton);
		return new SauceDemoYourInformation();
	}
}
