package com.jiochat.jiochatbaseclassTest;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.jiochat.baseclass.DriverManager;
import com.jiochat.jiochatpages.HomePage;
import com.jiochat.jiochatpages.LoginPage;
import com.jiochat.jiochatpages.OtpPage;

import utilitescontainer.Log;


public class LoginTest extends BaseClassTest {
	
	@Test(enabled=false)
	public void SelectCountryNChangeCountryName() throws Exception
	{
		Log.info("Login Page is opened");
		new LoginPage().clickCountryAtLogin();
		Log.info("Country list opened");
		new LoginPage().searchCountry("Sweden");
		Log.info("Country searched");
		new LoginPage().clickCountryFromList("Sweden");
		String countryName = new LoginPage().getCountryName();
		Assert.assertEquals(countryName, "Sweden", "Country name is matched");
		Log.info("Login Page is opened");
		new LoginPage().clickCountryAtLogin();
		new LoginPage().searchCountry("India");
		Log.info("Country searched");
		new LoginPage().clickCountryFromList("India");
		String countryName1 = new LoginPage().getCountryName();
		Assert.assertEquals(countryName1, "India", "Country name is matched");
		
	}
	
	
	
	@Test(enabled=false)
	public void verifyCountryCode()
	{
		String countryCode = new LoginPage().getCountryCode();
		Assert.assertEquals(countryCode, "+91","Country code is matched");
	}
	
	@Test(enabled=false)
	public void verifyTermNConditionPage()

	{
		new LoginPage().clickTermNCondition();
		String title = new LoginPage().switchToTermNConditionPage();
		Assert.assertEquals(title, "Terms & Conditions for JioChat");
		
	}
	
	
	@Test(enabled=false)
	public void verifyLoginWithWrongNumber() throws Exception
	{
		new LoginPage().enterWrongPhoneNumber();
		String error = new LoginPage().ErrorwithWrongNumber();
		Assert.assertEquals(error, "The mobile number you entered is incorrect. Please re-enter.");
		new LoginPage().closeTheErrorPopUp();
		new LoginPage().clearLoginNumber();
	}
	
	@Test(enabled=false)
	public void loginWithCorrectNumberButWrongOtp() throws Exception
	{
		new LoginPage().enterCorrectPhoneNumber();
		new OtpPage().enterWrongOtp();
		String message = new OtpPage().clickVerifyOtpButton(false);
		Assert.assertEquals(message, "Your verification code is incorrect. Please enter it again.");
		
	}
	
	@Test
	public void loginWithCorrectNumberButCorrectOtp() throws Exception
	{
		new LoginPage().enterCorrectPhoneNumber();
		new OtpPage().ClearOtp();
		new OtpPage().enterCorrectOtp();
		String message = new OtpPage().clickVerifyOtpButton(true);
		String homePageTitle = new HomePage().verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "JIOCHAT");
	}
	
	
	
	
	

}
