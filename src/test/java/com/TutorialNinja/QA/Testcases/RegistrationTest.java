package com.TutorialNinja.QA.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialNinja.QA.BaseClass.Base;
import com.TutorialNinja.QA.PageObjects.AccountSuccessPage;
import com.TutorialNinja.QA.PageObjects.HomePage;
import com.TutorialNinja.QA.PageObjects.RigisterPage;
import com.TutorialNinja.QA.Utility.Utilites;

public class RegistrationTest extends Base{
	
	public RegistrationTest()//it is constructor i am calling the method using super class
	{
		super();
	}
	
	public static WebDriver driver;
	
	@BeforeMethod//this method will execute before method test case start to execute
	   public void StartUp() throws Exception {
			
		    //LoadPropertiesFile();//calling configure properties file from the base class which will be used to remove the hardcoding values
		    driver = InitilizeBrowserandOpenApllicationURL(prop.getProperty("browserName"));//calling driver from base class
		    HomePage homepage = new HomePage(driver);//Getting the web element from page Object package
			homepage.Clickonmyaccountdropmenu();//calling action methods from pageobjectpakaage
			homepage.selectRigisterOption();
			
			//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		    //driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod //this method will execute after each method test case executed
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority = 1)
	
	public void RegistertotheApplicationByFillingAllMandatoryFields()
	{
		
		RigisterPage registerpage= new RigisterPage(driver);
		registerpage.EnterFisrtname(dataProp.getProperty("input-firstname"));
		registerpage.EnterLastname(dataProp.getProperty("input-lastname"));
		registerpage.EnterEmail(Utilites.generateEmailwithTimeStamp());
		registerpage.EnterTelephonenumber(dataProp.getProperty("input-telephone"));
		registerpage.EnterPassword(dataProp.getProperty("input-password"));
		registerpage.EnterConfirmPassword(dataProp.getProperty("input-confirm"));
		registerpage.ClickOnPrivacyCheckBox();
		registerpage.ClickOnContinueButton();
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("input-firstname"));
		//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("input-lastname"));
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilites.generateEmailwithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("input-telephone"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("input-password"));
		//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataProp.getProperty("input-confirm"));
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.VerifyAccountsuccessmessagedisplayed(),"account not created");

		//Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).isDisplayed(),"account not created");
		
		
		
	}
	
	@Test(priority = 2)
	public void RegistertotheApplicationByFillingAllFields()
	{
		
		RigisterPage registerpage= new RigisterPage(driver);
		registerpage.EnterFisrtname(dataProp.getProperty("input-firstname"));
		registerpage.EnterLastname(dataProp.getProperty("input-lastname"));
		registerpage.EnterEmail(Utilites.generateEmailwithTimeStamp());
		registerpage.EnterTelephonenumber(dataProp.getProperty("input-telephone"));
		registerpage.EnterPassword(dataProp.getProperty("input-password"));
		registerpage.EnterConfirmPassword(dataProp.getProperty("input-confirm"));
		registerpage.ClickOnSubscribeConfirmationButton();
		registerpage.ClickOnPrivacyCheckBox();
		registerpage.ClickOnContinueButton();
		/*driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("input-firstname"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("input-lastname"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilites.generateEmailwithTimeStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("input-telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("input-password"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataProp.getProperty("input-confirm"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();*/
		
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.VerifyAccountsuccessmessagedisplayed(),"account not created");
		//Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).isDisplayed(),"account not created");
		
		
		
	}
	
	@Test(priority = 3)
	public void RegistertotheApplicationByFillingexistingEmailAdrres()
	{
		
		RigisterPage registerpage= new RigisterPage(driver);
		registerpage.EnterFisrtname(dataProp.getProperty("input-firstname"));
		registerpage.EnterLastname(dataProp.getProperty("input-lastname"));
		registerpage.EnterEmail(dataProp.getProperty("ExistingEmail"));
		registerpage.EnterTelephonenumber(dataProp.getProperty("input-telephone"));
		registerpage.EnterPassword(dataProp.getProperty("input-password"));
		registerpage.EnterConfirmPassword(dataProp.getProperty("input-confirm"));
		registerpage.ClickOnSubscribeConfirmationButton();
		registerpage.ClickOnPrivacyCheckBox();
		registerpage.ClickOnContinueButton();
		/*driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(dataProp.getProperty("input-firstname"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(dataProp.getProperty("input-lastname"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataProp.getProperty("ExistingEmail"));
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(dataProp.getProperty("input-telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("input-password"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(dataProp.getProperty("input-confirm"));
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();*/
		
		String actualerrormessage = registerpage.VerifyDuplicateEmailWarningMessage();

		//String actualerrormessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualerrormessage.contains(dataProp.getProperty("AccountExistErrormessage")),"warning message is not displaying for duplicate email adrres");
		
		
		
	}
	
	@Test(priority = 4)
	public void RegistertotheApplicationwithoutfillinganyfield()
	{
		
		
		RigisterPage registerpage= new RigisterPage(driver);
		registerpage.ClickOnContinueButton();
		
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualprivacywarning = registerpage.VerifyPrivacyWarningMessage();

		//String actualprivacywarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualprivacywarning.contains(dataProp.getProperty("PrivacyWarningMessage")),"privacy warning message is not displaying ");
		
		String actualfirstnamewarning = registerpage.VerifyFirstNameWarningMessage();

		//String actualfirstnamewarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertTrue(actualfirstnamewarning.contains(dataProp.getProperty("FirstNameWarningMessage")),"firstname warning message is not displaying ");
		
		
		String actuallastnamewarning = registerpage.VerifyLastNameWarningMessage();
		//String actuallastnamewarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertTrue(actuallastnamewarning.contains(dataProp.getProperty("LastNameWarningMessage")),"lastname warning message is not displaying ");
		
		
		String actualemailwarning = registerpage.VerifyEamilWarningMessage1();
		//String actualemailwarning = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		Assert.assertTrue(actualemailwarning.contains(dataProp.getProperty("EmailWarningMessage")),"email warning message is not displaying ");
		
		
		String actualtelephonewarning = registerpage.VerifyTelephoneWarningMessage1();
		//String actualtelephonewarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		Assert.assertTrue(actualtelephonewarning.contains(dataProp.getProperty("TelephoneWarningMessage")),"telephone warning message is not displaying ");
		
		String actualpasswordwarning = registerpage.VerifyPasswordWarningMessage();
		//String actualpasswordwarning = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		Assert.assertTrue(actualpasswordwarning.contains(dataProp.getProperty("PasswordWarningMessage")),"password warning message is not displaying ");
		
		
		
	}






}
