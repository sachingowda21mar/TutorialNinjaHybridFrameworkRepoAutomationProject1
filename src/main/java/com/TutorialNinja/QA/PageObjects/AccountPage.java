package com.TutorialNinja.QA.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	//objects
	@FindBy(linkText  = "Edit your account information")
	private WebElement EditYourAccountInformationOption;
	
	
	public AccountPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//Actions
	
	public boolean VerifyDispalystatusofEditYourAccountInformationOption() {
		boolean displayStatus=EditYourAccountInformationOption.isDisplayed();
			return displayStatus;
	}
	

}
