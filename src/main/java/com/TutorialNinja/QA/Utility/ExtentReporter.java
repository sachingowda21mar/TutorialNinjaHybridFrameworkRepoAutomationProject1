package com.TutorialNinja.QA.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports GenerateExtentReport() {
		
		ExtentReports extentReports=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialNinja Automation Test Result");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
		Properties configProperties = new Properties();
		File Configpropfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\TutorialNinja\\QA\\Configure\\Configure.Properties");
		try {
			FileInputStream configfis = new FileInputStream(Configpropfile);
			configProperties.load(configfis);
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		
		extentReports.setSystemInfo("Application URL",configProperties.getProperty("url") );
		extentReports.setSystemInfo("BrowserName",configProperties.getProperty("browserName") );
		extentReports.setSystemInfo("EmailName",configProperties.getProperty("ValidEmail") );
        extentReports.setSystemInfo("Password",configProperties.getProperty("ValidPassword") );
        extentReports.setSystemInfo("Operating System",System.getProperty("os.name"));
        extentReports.setSystemInfo("UserName",System.getProperty("user.name"));
        extentReports.setSystemInfo("Java Version",System.getProperty("java.version") );
        
        return extentReports;

	}
	

}
