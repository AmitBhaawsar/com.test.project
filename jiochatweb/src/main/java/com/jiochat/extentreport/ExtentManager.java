package com.jiochat.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static synchronized ExtentReports initialReportSetup()
	{
		if(Objects.isNull(extent))
		{
		extent = new ExtentReports();
//		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		ExtentSparkReporter reporter = new ExtentSparkReporter("ExtendReport.html");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Enviornment", "Production");
		extent.setSystemInfo("Developer","Amit Bhawsar");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Amit Bhawsar");
		reporter.config().setDocumentTitle("Jiochat Testing");
	    reporter.config().setEncoding("utf-8");
	     reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		}
		return extent;
		
	}
	
	public static void flushReport() throws IOException
	{
		if(Objects.nonNull(extent))
		{
		extent.flush();
		}
		Desktop.getDesktop().browse(new File("ExtendReport.html").toURI());
		
	}
}
