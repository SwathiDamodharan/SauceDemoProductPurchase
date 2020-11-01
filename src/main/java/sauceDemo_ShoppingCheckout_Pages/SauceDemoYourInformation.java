package sauceDemo_ShoppingCheckout_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WrapperMethods.PM_Vodafone;

public class SauceDemoYourInformation extends PM_Vodafone {
	
	public SauceDemoYourInformation() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="first-name")
	private WebElement firstName;
	
	public SauceDemoYourInformation typeFirstName(String fName) {
		type(firstName, fName);
		return this;
	}
	
	@FindBy(how=How.ID, using="last-name")
	private WebElement secondName;
	
	public SauceDemoYourInformation typeSecondName(String sName) {
		type(secondName, sName);
		return this;
	}
	
	@FindBy(how=How.ID, using="postal-code")
	private WebElement postalCode;
	
	public SauceDemoYourInformation typePostalCode(String zipCode) {
		type(postalCode, zipCode);
		return this;
	}
	
	@FindBy(how=How.CSS, using="input[value='CONTINUE']")
	private WebElement continueButton;
	
	public SauceDemoCheckoutOverview clickContinueButton() {
		click(continueButton);
		return new SauceDemoCheckoutOverview();
	}
}
