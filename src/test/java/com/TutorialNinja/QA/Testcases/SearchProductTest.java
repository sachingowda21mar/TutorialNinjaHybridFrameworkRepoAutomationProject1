package com.TutorialNinja.QA.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialNinja.QA.BaseClass.Base;
import com.TutorialNinja.QA.PageObjects.HomePage;
import com.TutorialNinja.QA.PageObjects.SearchPage;

public class SearchProductTest extends Base {
	
	public SearchProductTest()//it is constructor i am calling the method using super class
	{
		super();
	}
	
   public static WebDriver driver;
	
	@BeforeMethod//this method will execute before method test case start to execute
	   public void StartUp() throws Exception {
			
		//LoadPropertiesFile();//calling configure properties file from the base class which will be used to remove the hardcoding values
		    driver = InitilizeBrowserandOpenApllicationURL(prop.getProperty("browserName"));//calling driver from base class
			
	}
	
	@AfterMethod //this method will execute after each method test case executed
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority = 1)
	public void VerifySearchWithValidProduct()
	{
		HomePage homePage = new HomePage(driver);
		homePage.enterValidProduct(dataProp.getProperty("ValidProduct"));
		homePage.ClickonSerachButton();
		
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("ValidProduct"));
	   //driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	  SearchPage serachPage = new SearchPage(driver);
		Assert.assertTrue(serachPage.DispalyStatusOfValidSearchProduct(),"product not searched");
 
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"product not searched");
		
		
		
	}
	
	@Test(priority = 2)
	public void VerifySearchWithInvalidProduct()
	{
		
		HomePage homePage = new HomePage(driver);
		homePage.enterValidProduct(dataProp.getProperty("InvalidProduct"));
		homePage.ClickonSerachButton();
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(dataProp.getProperty("InvalidProduct"));
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		SearchPage serachPage = new SearchPage(driver);
		String actualSerachMessage = serachPage.DispalyStatusOfNoProductMessage();
		//String actualSerachMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
	   Assert.assertTrue(actualSerachMessage.contains(dataProp.getProperty("NoProductErrorMessage")),"Search product element is displaying");
		
		
		
	}
	
	
	@Test(priority = 3)
	public void VerifySearchWithoutenteranyProduct()
	{
		
		HomePage homePage = new HomePage(driver);
		
		homePage.ClickonSerachButton();
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		
		SearchPage serachPage = new SearchPage(driver);
		String actualSerachMessage = serachPage.DispalyStatusOfNoProductMessage();
		//String actualSerachMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
	   Assert.assertTrue(actualSerachMessage.contains(dataProp.getProperty("NoProductErrorMessage")),"Search product element is displaying");
		
		
		
	}
	

}
