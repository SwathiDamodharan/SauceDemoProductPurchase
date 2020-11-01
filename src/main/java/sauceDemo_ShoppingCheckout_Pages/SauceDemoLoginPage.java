package sauceDemo_ShoppingCheckout_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import WrapperMethods.PM_Vodafone;

public class SauceDemoLoginPage extends PM_Vodafone{

	public SauceDemoLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, using="user-name")
	private WebElement userName;

	public SauceDemoLoginPage typeUserName(String uName) {
		type(userName, uName);
		return this;
	}

	@FindBy(how=How.ID, using="password")
	private WebElement passwordElemenet;

	public SauceDemoLoginPage typePassword(String pwd) {
		type(passwordElemenet, pwd);
		return this;
	}

	@FindBy(how=How.ID, using="login-button")
	private WebElement loginButton;

	@FindBy(how=How.XPATH, using="//button[@class='error-button']/ancestor::h3[contains(text(),'Epic sadface')]")
	private WebElement errorMessage;

	public SauceDemoProdcutPage clickLogin() {
		click(loginButton);
		try {
			if(errorMessage.isDisplayed()==true) {
				System.out.println(errorMessage.getText());
				Assert.fail(errorMessage.getText());
			}}catch(Exception e) {
				System.out.println("Login Successsfull");
			}
		return new SauceDemoProdcutPage();
	}
}
