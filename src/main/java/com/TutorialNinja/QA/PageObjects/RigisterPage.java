package com.TutorialNinja.QA.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RigisterPage {
	WebDriver driver;
	//objects
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement FirstNameField;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement LastNameField;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement EmailField;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement TelephoneField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement PasswordField;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement PasswordConfirmField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement PrivacyCheckBoxField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement SubscribeConfirmationButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement DuplicateEmailWarningMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement PrivacyWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement FirstNameWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement LastNameWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement EamilWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement TelephoneWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement PasswordWarningMessage;
	
	
	public RigisterPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//Actions
	
	public void EnterFisrtname(String Firstnametext) {
		FirstNameField.sendKeys(Firstnametext);
			
	}
	
	public void EnterLastname(String Lastnametext) {
		LastNameField.sendKeys(Lastnametext);
			
	}
	public void EnterEmail(String Emailtext) {
		EmailField.sendKeys(Emailtext);
			
	}
	public void EnterTelephonenumber(String Telephonetext) {
		TelephoneField.sendKeys(Telephonetext);
			
	}
	public void EnterPassword(String Passwordtext) {
		PasswordField.sendKeys(Passwordtext);
			
	}
	
	public void EnterConfirmPassword(String ConfirmPasswordtext) {
		PasswordConfirmField.sendKeys(ConfirmPasswordtext);
			
	}
	
	public void ClickOnPrivacyCheckBox() {
		PrivacyCheckBoxField.click();
			
	}
	
	public void ClickOnContinueButton() {
		ContinueButton.click();
			
	}
	
	public void ClickOnSubscribeConfirmationButton() {
		SubscribeConfirmationButton.click();
			
	}
	
	public String VerifyPrivacyWarningMessage() {
		String PrivacyWarningtext=PrivacyWarningMessage.getText();
		return PrivacyWarningtext;
			
	}
	
	public String VerifyDuplicateEmailWarningMessage() {
		String DuplicateEmailWarningText=DuplicateEmailWarningMessage.getText();
		return DuplicateEmailWarningText;
			
	}
	
	public String VerifyPrivacyWarningMessage1() {
		String PrivacyWarningtext=PrivacyWarningMessage.getText();
		return PrivacyWarningtext;
			
	}
	
	
	public String VerifyFirstNameWarningMessage() {
		String FirstNameWarningtext=FirstNameWarningMessage.getText();
		return FirstNameWarningtext;
			
	}
	
	
	public String VerifyLastNameWarningMessage() {
		String LastNameWarningtext=LastNameWarningMessage.getText();
		return LastNameWarningtext;
			
	}
	
	
	
	public String VerifyEamilWarningMessage1() {
		String EamilWarningtext=EamilWarningMessage.getText();
		return EamilWarningtext;
			
	}
	
	
	public String VerifyTelephoneWarningMessage1() {
		String TelephoneWarningtext=TelephoneWarningMessage.getText();
		return TelephoneWarningtext;
			
	}
	
	public String VerifyPasswordWarningMessage() {
		String PasswordWarningtext=PasswordWarningMessage.getText();
		return PasswordWarningtext;
			
	}
	
	

}
