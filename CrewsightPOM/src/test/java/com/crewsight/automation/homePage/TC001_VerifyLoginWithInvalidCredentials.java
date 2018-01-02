package com.crewsight.automation.homePage;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.crewsight.automation.uiActions.HomePage;
import com.crewsight.automation.testBase.TestBase;


public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
	
	
	HomePage homepage;

	@BeforeTest
	public void startTest(){
		
		openBrowser(browser);
	}
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException{
		homepage =  new HomePage(crewsight);
		homepage.loginToApplication("trimble", "userpassword");
		Thread.sleep(1000);
		Assert.assertEquals(homepage.getInvalidLoginText(), "Login failed.");
		
	}
	@AfterTest
	public void endtest(){
		crewsight.close();
	}
}
