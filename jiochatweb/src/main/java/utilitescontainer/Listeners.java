package utilitescontainer;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jiochat.baseclass.Driver;
import com.jiochat.baseclass.DriverManager;
import com.jiochat.extentreport.ExtentManager;
import com.jiochat.extentreport.ExtentTestManager;


public class Listeners implements ITestListener, ISuiteListener {



	public void onTestStart(ITestResult result) {
		
		
	}

	


	public void onTestSuccess(ITestResult result) {
//	System.out.println("Test case is passed for: " + result.getMethod().getMethodName());
//	
	ExtentTestManager.getTestM().log(Status.PASS, MarkupHelper.createLabel("Test case is passed for :" + result.getName(),ExtentColor.GREEN)).assignAuthor("Amit Bhawsar").assignCategory("Testing").assignDevice("Oppo");
//	ExtentTestManager.getTestM().pass(MarkupHelper.createLabel("Test case is passed for :" + result.getName(),ExtentColor.GREEN)).assignAuthor("Amit Bhawsar").assignCategory("Testing").assignDevice("Oppo");
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test case is failed for: " + result.getMethod().getMethodName());
		System.out.println("Error occurs at page" + result.getThrowable());
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		String scr = System.getProperty("user.dir")+"\\screenshot\\"+result.getMethod().getMethodName()+"_"+dateFormat.format(new Date())+".jpg";
		
		String screenshot= "data:image/png;base64," + ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
		File screenshot1= ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot1,new File( scr));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
		ExtentTestManager.getTestM().fail("Test Case is Fail", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
		ExtentTestManager.getTestM().info(result.getThrowable());
		}
		catch (Exception e) {
			Log.info("An exception occured while taking screenshot " + e.getCause());
		}

	}

	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTestM().skip("Test Case is skipped for :" + result.getMethod().getMethodName() );
		
	}

	public void onFinish(ITestContext context) {
		
	}

	public void onStart(ISuite suite) {
		ExtentManager.initialReportSetup();
	}

	public void onFinish(ISuite suite) {
		try {
			
			ExtentManager.flushReport();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
