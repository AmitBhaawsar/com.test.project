package com.jiochat.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jiochat.baseclass.DriverManager;
import com.jiochat.constants.ConstantsCollection;
import com.jiochat.enums.WaitStrategies;

public class ExplicitWaitStrategies {
	
	
	public static WebElement performExplicitWait(By by, WaitStrategies waitStrategy)
	{
		WebElement element = null;
		if(waitStrategy == WaitStrategies.CLICKABLE)
		{
			element = new WebDriverWait (DriverManager.getDriver(),Duration.ofSeconds(ConstantsCollection.getExplicitwait())).until(ExpectedConditions.elementToBeClickable(by));
		}
		else if (waitStrategy == WaitStrategies.PRESENCE)
		{
			element = new WebDriverWait (DriverManager.getDriver(),Duration.ofSeconds(ConstantsCollection.getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if( waitStrategy == WaitStrategies.VISIBLE)
		{
			element = new WebDriverWait (DriverManager.getDriver(),Duration.ofSeconds(ConstantsCollection.getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if( waitStrategy == WaitStrategies.NONE)
		{
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
