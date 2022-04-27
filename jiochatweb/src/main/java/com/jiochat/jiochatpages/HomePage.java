package com.jiochat.jiochatpages;

import org.openqa.selenium.By;

import com.jiochat.enums.WaitStrategies;

public class HomePage extends BaseClass {
	
	private final By HomePageHeader = By.xpath("//p[contains(@class, 'header-jiochat')]"); 
	
	public String verifyHomePageTitle()
	{
		return getAttributefor(HomePageHeader, WaitStrategies.VISIBLE);
		
	}

}
