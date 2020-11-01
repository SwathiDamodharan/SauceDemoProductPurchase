package ultimateQAPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import WrapperMethods.PM_Vodafone;

public class ultimateQALeftFormDetails extends PM_Vodafone {

	public ultimateQALeftFormDetails()  {
		PageFactory.initElements(driver, this);		
	}

	@FindBy(how=How.XPATH, using="//strong[contains(text(),'COMPLETE SELENIUM')]")
	private WebElement popUpMessage;

	@FindBy(how=How.XPATH, using="//div[@class='thrv_wrapper thrv_icon tcb-icon-display "
			+ "tve_evt_manager_listen tve_et_click tve_ea_thrive_leads_form_close']/child::*")
	private WebElement popUpCloseButton;

	public ultimateQALeftFormDetails closePopUpWindow() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(popUpMessage.isDisplayed()==true) {
			click(popUpCloseButton);
		}
		return this;	
	}

	@FindBy(how=How.ID, using="et_pb_contact_name_0")
	private WebElement leftNameBox;

	public ultimateQALeftFormDetails typeLeftNameBox(String lName) {
		type(leftNameBox, lName);
		return this;
	}

	@FindBy(how=How.ID, using="et_pb_contact_message_0")
	private WebElement leftMessageBox; 

	public ultimateQALeftFormDetails typeLefDescriptionBox(String lDescription) {
		type(leftMessageBox, lDescription);
		return this;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='et_pb_contact_form_0']/div[@class='et_pb_contact']//div")
	private WebElement leftSubmitButton;

	public ultimateQALeftFormDetails clickleftSubmitButton() {
		click(leftSubmitButton);
		return this;
	}
	
	@FindBy(how=How.XPATH, using="//p[text()='Form filled out successfully']")
	private WebElement successMessageLeftForm;

	@FindBy(how=How.XPATH, using="//div[@class='et_pb_column et_pb_column_1_2 et_pb_column_0  "
			+ "et_pb_css_mix_blend_mode_passthrough']//div[@class='et-pb-contact-message']/p[contains(text(),'Please, fill ')]")
	private WebElement failuremessageLeftForm;

	@FindBy(how=How.XPATH, using="(//div[@class='et-pb-contact-message'])[1]/ul/li")
	private List<WebElement> failureMessageListLeftForm;

	public ultimateQALeftFormDetails verifyLeftFormSuccessMessage() {
		try {
			if(successMessageLeftForm.isDisplayed()) {
				System.out.println(successMessageLeftForm.getText());
			}
		}catch(Exception e) {	
			//Assert.assertEquals(failuremessage.getText(), "Please, fill in the following fields:");
			System.out.println(failuremessageLeftForm.getText());
			for(WebElement eachFailureMessageLeftForm:failureMessageListLeftForm) {
				System.out.println(eachFailureMessageLeftForm.getText());
				Assert.fail(eachFailureMessageLeftForm.getText());
			}			
		}
		return this;
	}
	
}
