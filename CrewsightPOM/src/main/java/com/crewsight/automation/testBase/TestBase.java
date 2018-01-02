package com.crewsight.automation.testBase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crewsight.automation.excelReader.Excel_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	public static WebDriver crewsight;
	static String url="https://iac-thingmagic.pilot.basen.com";
    protected static String browser="chrome";
    Excel_Reader excel;
    public void init(){
    	openBrowser(browser);
     }
    	
    public void openBrowser(String browser)
    {
    	if(browser.equalsIgnoreCase("chrome"))
    	{
    	 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
   		 crewsight = new ChromeDriver();
         preInit();
    	}
    	else if(browser.equalsIgnoreCase("firefox"))
    	{
    	 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
    	 crewsight = new FirefoxDriver();
    	 preInit();
        }
    	else if(browser.equalsIgnoreCase("ie"))
    	{
    	 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
    	 crewsight = new InternetExplorerDriver();
    	 preInit();
    	}
    	else
    	{
    		System.out.println("Plz Provide valid browser parameter");
    	}
    }
	public static void preInit(){
		crewsight.get(url);
    	crewsight.manage().window().maximize();
   	    crewsight.manage().deleteAllCookies();
   	    crewsight.manage().timeouts().implicitlyWait(89, TimeUnit.SECONDS);
    }
    public String[][] getData(String excelName,String sheetName) throws IOException{
    	String path=System.getProperty("user.dir")+"/src/main/java/com/crewsight/automation/data/"+excelName ;
    	excel = new Excel_Reader(path);
    	String[][] data=excel.getDataFromSheet(sheetName,excelName);
		return data;
    }    
    public void waitForElement(int timeOutInSeconds,WebElement element){
    	WebDriverWait wait = new WebDriverWait(crewsight,timeOutInSeconds);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void acceptAlert() throws InterruptedException{
		Alert alert =crewsight.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
    public static void dismissAlert() {
    	Alert alert = crewsight.switchTo().alert();
    	alert.dismiss();
    }
}
