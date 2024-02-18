package com.TutorialNinja.QA.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	//objects
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginOption;
	
	@FindBy(linkText  = "Register")
	private WebElement registerOption;
	
	@FindBy(xpath   = "//input[@placeholder='Search']")
	private WebElement SearchValidProduct;
	
	@FindBy(xpath   = "//button[@class='btn btn-default btn-lg']")
	private WebElement SerachButton;
	
	public HomePage (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	//Actions
	
	public void Clickonmyaccountdropmenu() {
		myAccountDropMenu.click();
			
	}
	
	public void selectLoginoption() {
		loginOption.click();
			
	}
	
	public void selectRigisterOption(){
		registerOption.click();
			
	}
	
	
	public void enterValidProduct(String EnterProductText) {
		
		SearchValidProduct.sendKeys(EnterProductText);
		
	}

	public void ClickonSerachButton() {
		SerachButton.click();
		
	}


}
