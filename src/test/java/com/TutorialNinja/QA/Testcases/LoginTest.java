package com.TutorialNinja.QA.Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TutorialNinja.QA.BaseClass.Base;
import com.TutorialNinja.QA.PageObjects.AccountPage;
import com.TutorialNinja.QA.PageObjects.HomePage;
import com.TutorialNinja.QA.PageObjects.LoginPage;
import com.TutorialNinja.QA.Utility.Utilites;

public class LoginTest extends Base {
	
	public LoginTest()//it is constructor i am calling the method using super class from base class
	{
		super();
	}
	
	public static WebDriver driver;//initializing the driver at global level
	
	@BeforeMethod//this method will execute before method test case start to execute
   public void StartUp() throws Exception {
		
		//LoadPropertiesFile();//calling configure properties file from the base class which will be used to remove the hardcoding values
		driver = InitilizeBrowserandOpenApllicationURL(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);//Getting the web element from page Object package
		homepage.Clickonmyaccountdropmenu();//calling action methods from pageobjectpakaage
		homepage.selectLoginoption();
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		
	}
	
	
	@AfterMethod //this method will execute after each method test case executed
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority = 1,dataProvider = "supplyTestData")
	public void LoginintotheApplicationWithValidCredential(String Email, String Password)
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.EnterEmailAdrress(Email);
		loginPage.EnterPassword(Password);
		loginPage.clickloginbutton();
		
		
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Email);
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(Password);
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		AccountPage accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.VerifyDispalystatusofEditYourAccountInformationOption(),"edit your account information message is not displaying");
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"edit your account information message is not displaying");
		
		
	}
	
	//Sending the data to the first method using data provider
	/*@DataProvider
	public Object[][] supplyTestdata()
	{
		Object[][] data= {{"sachingowda21mar@gmail.com","Password@123"}};
		return data;
	}*/
	
	//Send the data using excelsheet
	@DataProvider
	public Object[][] supplyTestData()
	{
		Object[][] data = Utilites.getTestDataFromExcelSheet("Sheet1");
		return data;
	}
	
	@Test(priority = 2,dependsOnMethods ={"LoginintotheApplicationWithValidCredential"} )
	public void LoginintotheApplicationWithInvalidCredential() 
	{
        
		LoginPage loginPage=new LoginPage(driver);
		loginPage.EnterEmailAdrress(Utilites.generateEmailwithTimeStamp());
		loginPage.EnterPassword(dataProp.getProperty("InvalidPassword"));
		loginPage.clickloginbutton();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilites.generateEmailwithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("InvalidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String ActualWarningMessage = loginPage.VerifyEmailPasswordNotMatchingMessage();
		
		//String ActualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String ExpectedWarningMessage = dataProp.getProperty("EmailPasswordNomatchWarningMessage");
		
		Assert.assertEquals(ActualWarningMessage, ExpectedWarningMessage,"Expected error message is not matched");
		
		
		
	}
	
	
	
	@Test(priority = 3)
	public void LoginintotheApplicationWithInvalidEmailAndValidPassword () 
	{
        
		LoginPage loginPage=new LoginPage(driver);
		loginPage.EnterEmailAdrress(Utilites.generateEmailwithTimeStamp());
		loginPage.EnterPassword(prop.getProperty("ValidPassword"));
		loginPage.clickloginbutton();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilites.generateEmailwithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("ValidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String ActualWarningMessage = loginPage.VerifyEmailPasswordNotMatchingMessage();
		
		//String ActualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String ExpectedWarningMessage = dataProp.getProperty("EmailPasswordNomatchWarningMessage");
		
		Assert.assertEquals(ActualWarningMessage, ExpectedWarningMessage,"Expected error message is not matched");
		
		
		
	}
	
	@Test(priority = 4)
	public void LoginintotheApplicationWithValidEmailAndInvalidPassword () 
	{
        
		LoginPage loginPage=new LoginPage(driver);
		loginPage.EnterEmailAdrress(prop.getProperty("ValidEmail"));
		loginPage.EnterPassword(dataProp.getProperty("InvalidPassword"));
		loginPage.clickloginbutton();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("ValidEmail"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("InvalidPassword"));
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String ActualWarningMessage = loginPage.VerifyEmailPasswordNotMatchingMessage();
		
		//String ActualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String ExpectedWarningMessage = dataProp.getProperty("EmailPasswordNomatchWarningMessage");
		
		Assert.assertEquals(ActualWarningMessage, ExpectedWarningMessage,"Expected error message is not matched");
		
		
		
	}
	@Test(priority = 5)
	public void LoginintotheApplicationWithoutGivingCredentials() 
	{
        
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickloginbutton();
		
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//String ActualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String ActualWarningMessage = loginPage.VerifyEmailPasswordNotMatchingMessage();
		String ExpectedWarningMessage = dataProp.getProperty("EmailPasswordNomatchWarningMessage");
		
		Assert.assertEquals(ActualWarningMessage, ExpectedWarningMessage,"Expected error message is not matched");
		
		
		
	}
	
	
	
	
		
	

}
