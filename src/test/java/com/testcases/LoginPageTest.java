package com.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrs.genericpage.MasterPage;
import com.hrs.pages.LoginPage;

import Util.TestUtil;


public class LoginPageTest {
	
	
LoginPage lp;


	@DataProvider
	public Object[][] getLoginData() throws Exception
	{
		Object data[][] = TestUtil.getTestData("LoginTest");
		return data;
	}


	@Test(dataProvider = "getLoginData")
	public void doLoginTest(String username, String password) throws Exception
	{
		lp = new LoginPage();
		
		lp.assertTitleCheck();// Assertion check page title is checking then only it will go further
		
		lp.clickEmailOrPhone();
		lp.enterUsername(username);
		lp.clickPassword();
		lp.enterPassword(password);
		lp.clickLoginButton();
		lp.assertLoggedInOrNot();
		
	}

	@AfterMethod
	public void takeScreenShotOnFfailure(ITestResult result) throws IOException
	{
		lp.captureScreenShotCapture(result);
	}
	
	@AfterClass
	public static void closeLoginPage()
	{
		MasterPage.driver.close();
	}
	
	
	
}
