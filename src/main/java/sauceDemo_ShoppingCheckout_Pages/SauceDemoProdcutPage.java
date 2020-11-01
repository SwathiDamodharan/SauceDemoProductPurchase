package sauceDemo_ShoppingCheckout_Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import WrapperMethods.PM_Vodafone;

public class SauceDemoProdcutPage extends PM_Vodafone {

	public SauceDemoProdcutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='inventory_item_name']")
	private List<WebElement> productList;
	
	@FindBy(how=How.CSS, using="button[class='btn_primary btn_inventory']")
	private WebElement addToCartButton;
	
	@FindBy(how=How.CSS, using="button[class='inventory_details_back_button']")
	private WebElement backButton;
	
	public SauceDemoProdcutPage productSelection(String productName1, String productName2) {
		for(WebElement singleProduct:productList) {
			if(singleProduct.getText().contains(productName1)) {
				driver.findElementByXPath("//div[@class='inventory_item_name'][contains(text(),'"+productName1+"')]/ancestor::div[@class='inventory_item']/div[@class='pricebar']/button").click();
				
			}
			else if(singleProduct.getText().contains(productName2)) {
				driver.findElementByXPath("//div[@class='inventory_item_name'][contains(text(),'"+productName2+"')]/ancestor::div[@class='inventory_item']/div[@class='pricebar']/button").click();
				
			}
		}
		return this;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='shopping_cart_container']/a/child::*")
	private WebElement shoppingCartIcon;
	
	public SauceDemoYourCart clickShoppingButton() {
		click(shoppingCartIcon);
		return new SauceDemoYourCart();
	}
}
