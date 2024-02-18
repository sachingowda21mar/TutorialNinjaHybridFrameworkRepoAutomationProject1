package com.TutorialNinja.QA.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	//objects
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement Emailadrressfield;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement PasswordFiled;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement EmailPasswordNotMatching;
	
	public LoginPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//Actions
	
	public void EnterEmailAdrress(String EmailText) {
		Emailadrressfield.sendKeys(EmailText);
			
	}
	
	public void EnterPassword(String password) {
		PasswordFiled.sendKeys(password);
			
	}
	public void clickloginbutton() {
		LoginButton.click();
			
	}
	public String VerifyEmailPasswordNotMatchingMessage() {
		String warningText=EmailPasswordNotMatching.getText();
			return warningText;
	}



}
