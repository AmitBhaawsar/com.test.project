package com.jiochat.jiochatpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.jiochat.baseclass.DriverManager;
import com.jiochat.enums.ConfigProperties;

import com.jiochat.enums.WaitStrategies;

import utilitescontainer.ReadPropertyFile;


public class LoginPage extends BaseClass {
	
	private final By clickCountry = By.xpath("//div[contains(@class,'login-border-bottom')]");
	private final By searchCountry = By.xpath("//input[@placeholder='Search country']");
	private final By selectCountry = By.xpath("//*[@class='modal full-page-modal']/div/ul");
	private final By countriesList = By.tagName("li");
	private final By countryCode = By.xpath("//span[contains(@class,'country-code-number')]");
	private final By enterNumber = By.id("phoneNumber");
	private final By acceptNcontinue = By.xpath("//div[contains(@class,'nav-button')]");
	private final By errorPopUp = By.xpath("//div[contains(@class,'content p-ul')]/div");
	private final By closeErrorPopUp = By.xpath("//*[@id=\"dialog-root\"]/div/div/div[2]/div[2]/div");
	private final By termCondition = By.xpath("//a[contains(@href,'https://jiochat.com/condition/eula.html')]");
	private final By termNConditionHeader = By.xpath("/html/body/div/div/div/h4/b");
	
	public void clickCountryAtLogin()
	{
		clickAction(clickCountry ,WaitStrategies.CLICKABLE);
	}
	
	public void searchCountry(String country) throws Exception
	{
		sendKeyAction(searchCountry,WaitStrategies.PRESENCE, country);
		
	}
	public void clickCountryFromList(String texts) throws Exception
	{
		WebElement element = DriverManager.getDriver().findElement(selectCountry);
		selectFromList(countriesList, texts, element);
	}
	
	public String getCountryName() {
		return getAttributefor(clickCountry, WaitStrategies.VISIBLE);
	}
	
	public String getCountryCode()
	{
		return getAttributefor(countryCode, WaitStrategies.VISIBLE);
	}
	
	public void enterWrongPhoneNumber() throws Exception
	{
		sendKeyAction(enterNumber, WaitStrategies.VISIBLE, ReadPropertyFile.get(ConfigProperties.WRONGMOBILENUMBER));
		clickAction(acceptNcontinue, WaitStrategies.NONE);
	}
	
	public OtpPage enterCorrectPhoneNumber() throws Exception
	{
		sendKeyAction(enterNumber, WaitStrategies.VISIBLE, ReadPropertyFile.get(ConfigProperties.CORRECTMOBILENUMBER));
		Thread.sleep(1000);
		clickAction(acceptNcontinue, WaitStrategies.NONE);
		return new OtpPage();
	}
	
	public String ErrorwithWrongNumber()
	{
		return getAttributefor(errorPopUp, WaitStrategies.VISIBLE);
	}
	
	public void closeTheErrorPopUp()
	{
		clickAction(closeErrorPopUp,WaitStrategies.PRESENCE);
	}
	
	public void clearLoginNumber()
	{
		clearText(enterNumber, WaitStrategies.VISIBLE);
	}
	
	public void clickTermNCondition()
	{
		clickAction(termCondition, WaitStrategies.CLICKABLE);
	}
	
	public String switchToTermNConditionPage()
	{
		return switchToWindow(termNConditionHeader, WaitStrategies.VISIBLE);
	}
	
	public void navigateToLoginPage()
	{
		navigateBack();
	}

}
