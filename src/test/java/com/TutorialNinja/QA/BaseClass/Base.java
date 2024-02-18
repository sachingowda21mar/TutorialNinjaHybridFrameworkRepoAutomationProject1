package com.TutorialNinja.QA.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.TutorialNinja.QA.Utility.Utilites;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	//Created a constructor to invoke  this method in child class by using super keyword
	public Base()  {
		
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialNinja\\QA\\Configure\\Configure.Properties");
		
		dataProp = new Properties();
		File datapropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialNinja\\QA\\Testdata\\Testdata.Properties");
		try 
		{
		FileInputStream datafis = new FileInputStream(datapropFile);
		dataProp.load(datafis);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	public WebDriver InitilizeBrowserandOpenApllicationURL(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("safari")) 
		{
			driver = new SafariDriver();
		}
        
		
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilites.Implicit_Wait_Time));//Taking the implicit wait from utility file
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilites.page_Wait_Time));//Taking the page wait from utility file
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
