package com.jiochat.jiochatbaseclassTest;


import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.jiochat.baseclass.Driver;
import com.jiochat.extentreport.ExtentTestManager;

public class BaseClassTest {
	
	@BeforeSuite
	public void setUp() throws Exception
	{
		
	}
	

	@BeforeMethod
	public void beforeTestStart(Method method) throws Exception
	{
		Driver.initDriver();
		ExtentTestManager.startTest(method.getName(), "Test case is for " +method.getName() );
	}
	
	@AfterMethod
	public void afterTestEnd()
	{
		ExtentTestManager.endTest();
		Driver.quitDriver();
	}

	
	
	@AfterSuite
	public void tearDown()
	{
		
	}

}
