package com.extentreports;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentManager;

public class ExtentTester {
    ExtentReports extent;
    ExtentTest test;
	
    @BeforeClass
    public void setUp(){
    	extent=ExtentManager.GetExtent();
    }
    
	@Test(description="Basic search test")
    public void test1() throws IOException {
		test=ExtentManager.createTest("Basic search", 
				                      "As a user I should be able to perform beasic seacrh"
		                              +"So I can see seacrh result");
		test.pass("Launch Application");
		test.log(Status.INFO, "Homepage displayed successfully");	
		test.log(Status.FAIL, "ScreenShot:"+ test.addScreenCaptureFromPath
				("/Users/sunatulloabdullaev/Desktop/error.png"));
		
		extent.flush();
  }
	
}
