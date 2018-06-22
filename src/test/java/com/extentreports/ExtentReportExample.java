package com.extentreports;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportExample {
  
	@Test
    public void htmlReport() {
		ExtentReports extent=new ExtentReports();
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./extentReport.html");
//		htmlReporter.config().setChartVisibilityOnOpen(true);
//		htmlReporter.config().setDocumentTitle("Cybertek Regression");
//		htmlReporter.config().setReportName("Regression Cycle");
		htmlReporter.loadXMLConfig("./config.xml");
		
		extent.attachReporter(htmlReporter);
		
		ExtentTest test=extent.createTest("Login test", "Positive login test");
		
		test.pass("User id entered successfully");
		test.pass("Password entered successfully");
		test.pass("Click performed on Sign in Button");
		
		ExtentTest test2=extent.createTest("Logout test", "Positive logout test");
		
		test2.log(Status.INFO, "Clikcing on logout link");
		test2.fail("Log Out link was not found");
		
		extent.flush();
  }
}
