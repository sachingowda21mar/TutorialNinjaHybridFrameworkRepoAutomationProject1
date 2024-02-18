package com.TutorialNinja.QA.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(linkText   = "HP LP3065")
	private WebElement ValidSearchProduct;
	
	@FindBy(xpath =  "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement NoProductMessage;
	
	
	public SearchPage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//Actions
	
	public boolean DispalyStatusOfValidSearchProduct() {
	boolean displaystatus=	ValidSearchProduct.isDisplayed();
			return displaystatus;
	}
	
	public String DispalyStatusOfNoProductMessage() {
		String NoProducttext=	NoProductMessage.getText();
				return NoProducttext;
		}
}
