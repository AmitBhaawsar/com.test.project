package com.jiochat.jiochatpages;

import org.openqa.selenium.By;

import com.jiochat.baseclass.DriverManager;
import com.jiochat.enums.ConfigProperties;
import com.jiochat.enums.WaitStrategies;

import utilitescontainer.ReadPropertyFile;

public class OtpPage extends BaseClass {
	
	private final By otpNumber = By.id("otpNumber");
	private final By resendLink = By.xpath("//p[contains(@text, 'Resend OTP')]");
	private final By verifyOtp = By.xpath("//button[contains(text(),'Verify OTP')]");
	private final By errorMessage = By.xpath("//p[contains(@class, 'thi error-msg')]");
	
	public void enterWrongOtp() throws Exception
	{
		sendKeyAction(otpNumber, WaitStrategies.PRESENCE, ReadPropertyFile.get(ConfigProperties.WRONGOTP));
	}
	public void enterCorrectOtp() throws Exception
	{
		sendKeyAction(otpNumber, WaitStrategies.PRESENCE, ReadPropertyFile.get(ConfigProperties.CORRECTOTP));
	}
	
	public void clickResendOtp()
	{
		clickAction(resendLink, WaitStrategies.CLICKABLE);
	}
	
	public String clickVerifyOtpButton(boolean isValid)
	{
		clickAction(verifyOtp, WaitStrategies.CLICKABLE);
		if(isValid==true)
		{
			 String title =getTitleOfPage();
			 return title;
		}
		else
		{
			String error = getAttributefor(errorMessage, WaitStrategies.VISIBLE);
			return error;
		}
		
	}
	
	public void ClearOtp()
	{
		clearText(otpNumber, WaitStrategies.VISIBLE);
	}

}
