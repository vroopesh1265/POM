package com.crewsight.automation.homePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crewsight.automation.testBase.TestBase;
import com.crewsight.automation.uiActions.HomePage;

public class TC003_VerifyLoginWithDiffrentRecords extends TestBase {
	
	HomePage homepage;
	
	@DataProvider(name="loginData")
	public String[][] getTestData() throws IOException, EncryptedDocumentException, InvalidFormatException{
		String[][] testRecords = getData("crewsighttestdata.xlsx", "LoginTestData");
		return testRecords;
	}
	
	@BeforeTest
	public void startTest(){
		openBrowser(browser);
	}
	
	@Test(dataProvider="loginData")
	public void verifyLoginWithDiffrentRecords(String userid,String userpassword,String runMode) throws InterruptedException{
		if(runMode.equalsIgnoreCase("n"))
		{
			throw new SkipException("User marked it as no run");
		}
		Thread.sleep(5000);
		homepage=new HomePage(crewsight);
		homepage.loginToApplication(userid, userpassword);
		homepage.clickOnLogout();
		TestBase.acceptAlert();
	}
	
	@AfterTest
	public void endTest(){
		crewsight.close();
	}

}
