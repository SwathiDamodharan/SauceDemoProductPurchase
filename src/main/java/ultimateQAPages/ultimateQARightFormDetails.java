package ultimateQAPages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import WrapperMethods.PM_Vodafone;

public class ultimateQARightFormDetails extends PM_Vodafone {

	public ultimateQARightFormDetails() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="et_pb_contact_name_1")
	private WebElement rightNameBox;

	public ultimateQARightFormDetails typeRightNameBox(String rName) {
		type(rightNameBox, rName);
		return this;
	}
	
	@FindBy(how=How.ID, using="et_pb_contact_message_1")
	private WebElement rightMessageBox; 

	public ultimateQARightFormDetails typeRightDescriptionBox(String rDescription) {
		type(rightMessageBox, rDescription);
		return this;
	}
	
	@FindBy(how=How.CSS, using="span.et_pb_contact_captcha_question")
	private WebElement captchaText;
	
	@FindBy(how=How.CSS, using="input[class='input et_pb_contact_captcha']")
	private WebElement captchaResult;
	
	public ultimateQARightFormDetails typeCaptchaValue(String captchaCapture) {
		
		String firstText=captchaText.getText().split("\\+")[0].trim();
		int firstNum=Integer.parseInt(firstText);
		String secondText=captchaText.getText().split("\\+")[1].trim();
		int secondNum=Integer.parseInt(secondText);
		int finalCaptchaValue=firstNum+secondNum;
		String finalCaptchaText=String.valueOf(finalCaptchaValue);
		if(captchaCapture.equalsIgnoreCase("Yes")) {
		type(captchaResult, finalCaptchaText);
		}
		return this;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='et_pb_contact_form_1']/div[@class='et_pb_contact']//div/button")
	private WebElement rightsSubmitButton;

	public ultimateQARightFormDetails clickRightSubmitButton() {
		click(rightsSubmitButton);
		return this;
	}		
	
	@FindBy(how=How.XPATH, using="//div[@class='et-pb-contact-message']/p[text()='Success']")
	private WebElement successMessageRightForm;

	@FindBy(how=How.XPATH, using="//div[@class='et_pb_column et_pb_column_1_2 et_pb_column_1  et_pb_css_mix_blend_mode_passthrough et-last-child']"
			+ "//div[@class='et-pb-contact-message']/p[contains(text(),'Please, fill ')]")
	private WebElement failuremessageRightForm;

	@FindBy(how=How.XPATH, using="(//div[@class='et-pb-contact-message'])[2]/ul/li")
	private List<WebElement> failureMessageListRightForm;
	
	
	public ultimateQARightFormDetails verifyRightFormSuccessMessage() {
		try {
			if(successMessageRightForm.isDisplayed()) {
				System.out.println(successMessageRightForm.getText());
			}
		}catch(Exception e) {	
			//Assert.assertEquals(failuremessage.getText(), "Please, fill in the following fields:");
			System.out.println(failuremessageRightForm.getText());
			for(WebElement eachFailureMessageRightForm:failureMessageListRightForm) {
				System.out.println(eachFailureMessageRightForm.getText());
				Assert.fail(eachFailureMessageRightForm.getText());
			}			
		}
		return this;
	}
}
