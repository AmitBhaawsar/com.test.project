package com.jiochat.baseclass;


import java.util.Objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import com.jiochat.enums.ConfigProperties;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilitescontainer.ReadPropertyFile;

public final class Driver {
	
	private Driver() {
		
	}
	
	public static void initDriver() throws Exception
	{
		if(Objects.isNull(DriverManager.getDriver()))
		WebDriverManager.chromedriver().driverVersion("92.0.4515.131").setup();
		
		DriverManager.setDriver(new ChromeDriver());
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(ReadPropertyFile.get(ConfigProperties.URL));
		
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("localStorage.setItem('environment','preprod')");
		DriverManager.getDriver().navigate().refresh();


	}
	
	public static void quitDriver()
	{
		if(Objects.nonNull(DriverManager.getDriver()))
		{
		DriverManager.getDriver().quit();
		DriverManager.unload();
		}
	}

}
