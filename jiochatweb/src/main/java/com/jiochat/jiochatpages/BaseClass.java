package com.jiochat.jiochatpages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jiochat.baseclass.Driver;
import com.jiochat.baseclass.DriverManager;
import com.jiochat.enums.ConfigProperties;
import com.jiochat.enums.WaitStrategies;
import com.jiochat.factories.ExplicitWaitStrategies;

import utilitescontainer.ReadPropertyFile;

public class BaseClass {
	
	protected void clickAction(By by, WaitStrategies waitstrategy)
	{
		ExplicitWaitStrategies.performExplicitWait(by, waitstrategy).click();
	}
	
	protected void sendKeyAction(By by , WaitStrategies waitstrategy, String value)
	{
		ExplicitWaitStrategies.performExplicitWait(by, waitstrategy).sendKeys(value);
	}
	
	protected void scrollToAction(By by, WaitStrategies waitstrategy)
	{
		WebElement element = ExplicitWaitStrategies.performExplicitWait(by, waitstrategy);
		Actions actions = new Actions(DriverManager.getDriver());
		actions.moveToElement(element);
		actions.perform();
	}
	
	
	protected void selectFromList(By by,String text, WebElement element)
	{
		List<WebElement> list = element.findElements(by);
		for(WebElement options: list)
		{
			if (options.getText().equals(text))
		    {
				options.click();
		        break;
		    }
		}
	}
	
	protected String getAttributefor(By by, WaitStrategies waitstrategy)
	{
		return ExplicitWaitStrategies.performExplicitWait(by, waitstrategy).getText();
	}
	
	protected void clearText(By by, WaitStrategies waitstrategy)
	{
		ExplicitWaitStrategies.performExplicitWait(by, waitstrategy).clear();
	}
	
	protected void switchToDefaultContent()
	{
		DriverManager.getDriver().switchTo().defaultContent();
	}
	
	protected String switchToWindow(By by, WaitStrategies wait)
	{
		String parentWindow = DriverManager.getDriver().getWindowHandle();
		Set<String> windows= DriverManager.getDriver().getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String childWindow = it.next();
			
			if(!parentWindow.equals(childWindow))
			{
				DriverManager.getDriver().switchTo().window(childWindow);
				String title = getAttributefor(by, wait );
				DriverManager.getDriver().switchTo().window(parentWindow);
				return title;
				
			}
			
			
			
		}
		
		return null;
		
	}
	
	protected String getTitleOfPage()
	{
		String title = DriverManager.getDriver().getTitle();
		return title;
	}
	
	protected void submit(By by, WaitStrategies waitstrategy)
	{
		ExplicitWaitStrategies.performExplicitWait(by, waitstrategy).submit();
	}
	
	protected void navigateBack()
	{
		DriverManager.getDriver().navigate().back();
	}


}
