package com.crewsight.automation.homePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crewsight.automation.testBase.TestBase;
import com.crewsight.automation.uiActions.HomePage;

public class TC002_ForgotPassword extends TestBase{
	
	HomePage homepage;
	String forgotpasworduserid="vroopesh@outlook.com";
	
	@BeforeClass
	public void startTest(){
		openBrowser(browser);		
	}
	@Test
	public void forgotPassword() throws InterruptedException{
		homepage= new HomePage(crewsight);
		homepage.forgotPassword(forgotpasworduserid);
		Assert.assertEquals(homepage.getForgotPasswordSucessText(),"Password reset instructions has been sent to your email.");
	} 
    
	@AfterClass 
	public void endTest(){
		crewsight.quit();
		
	}
}
