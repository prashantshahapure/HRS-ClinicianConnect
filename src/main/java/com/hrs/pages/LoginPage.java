package com.hrs.pages;

import org.testng.Assert;

import com.hrs.genericpage.MasterPage;

public class LoginPage extends MasterPage{
	
	public LoginPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// verified the LoginPage
	
	public void assertTitleCheck()
	{	
		String expectedTitle = "HRS | ClinicianConnect";
		String actualTitle = driver.getTitle();
		logger.info("Login page Title verified");
		Assert.assertEquals(actualTitle, expectedTitle, "LoginPage is not verified");
	}
	
	//Click email or phone
	public void clickEmailOrPhone()
	{
		click("Email");  // this is the key we have to pass here that is from locators proprties file
		logger.info("Clicked ClickEmailOrPhone");
	}
	
	//Enter username
	public void enterUsername(String username)
	{
		sendData("Email", username);
		logger.info("Entered ClickEmailOrPhone");
	}
	
	//click Password
	public void clickPassword()  
	{
		click("Password");
		logger.info("Clicked Password");
	}
	
	//Enter Password
	public void enterPassword(String password)
	{
		sendData("Password", password);
		logger.info("Entered Password");
	}
	
	//Click LoginButton
	public void clickLoginButton() throws InterruptedException
	{
	
		click("LoginButton");
		logger.info("Clicked LoginButton");
	}

	public void assertLoggedInOrNot()
	{
		//String expectedInvalidMessage = "Username and/or password invalid";
		//String invalidActualLoginMessage = getText("InvalidUsernamePassword");
		
		String expectedTitle = "HRS | ClinicianConnect | loggedin";
		String actualTitle = driver.getTitle();
		logger.info("LoginSuccessfull  Title verifying");
		try
		{
		Assert.assertEquals(actualTitle, expectedTitle, "Login is not successfull");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Loggedinsuccessful verified");
	}
		
		
	
}
