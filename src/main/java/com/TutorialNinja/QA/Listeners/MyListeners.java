package com.TutorialNinja.QA.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TutorialNinja.QA.Utility.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListeners implements ITestListener {

	ExtentReports extentReports;
	ExtentTest extentTest;
	@Override
	public void onStart(ITestContext context) {
		
		extentReports = ExtentReporter.GenerateExtentReport();
	
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		String TestNmae=result.getName();
		 extentTest = extentReports.createTest(TestNmae);
		extentTest.log(Status.INFO,TestNmae+"Started Executing");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String TestNmae=result.getName();
		extentTest.log(Status.PASS,TestNmae+"Got passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestNmae=result.getName();
		
		WebDriver driver = null;
		
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				
				e.printStackTrace();
			} catch (SecurityException e) {
				
				e.printStackTrace();
			}
		
		
		
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String DestinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+TestNmae+".png";
        try {
			FileHandler.copy(srcScreenshot, new File(DestinationScreenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(DestinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,TestNmae+"Got Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String TestNmae=result.getName();
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP,TestNmae+"Got Skipped");
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();//it will execute the extent Report
		
		//Below code is to open the extent report automatically
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
