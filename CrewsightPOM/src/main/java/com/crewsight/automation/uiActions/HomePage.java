package com.crewsight.automation.uiActions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crewsight.automation.testBase.TestBase;

public class HomePage extends TestBase {
	
	WebDriver crewsight;
	
	@FindBy(id="webpublish_login_user")
	WebElement LoginID;
	
	@FindBy(id="webpublish_login_password")
	WebElement password;
 
	@FindBy(id="webpublish_login_submit_alt")
	WebElement submitlogin;
	
	@FindBy(id="webpublish_login_error")
	WebElement authenticationfailed;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div[2]/form[1]/h5/a")
	WebElement Forgotpasswordlink;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div[2]/form[2]/input")
	WebElement forgotpasworduserid;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div/div[2]/div[1]/div/div/div[2]/form[2]/button")
	WebElement submitforgotpassword;
	
	@FindBy(className="growl-message")
	WebElement getForgotPasswordSucessText;
	
	@FindBy(id="id_img_userimg_header")
	WebElement dashboardUserImage;
	
	@FindBy(xpath="/html/body/div[3]/div/div[2]/div/div/div/div/div[1]/header/div[2]/ul/li/ul/li[1]/a")
	WebElement viewProfile;
	
	@FindBy(xpath="/html/body/div[3]/div/div[2]/div/div/div/div/div[1]/header/div[2]/ul/li/ul/li[2]/div/a")
	WebElement logoutlink;
	
	public HomePage(WebDriver crewsight){
		PageFactory.initElements(crewsight, this);		
	}
	
	public void loginToApplication(String userid,String userpassword){
		LoginID.sendKeys(userid);
		password.sendKeys(userpassword);
		submitlogin.click();
	}
	
	public String getInvalidLoginText(){
		return authenticationfailed.getText();
	}
	
	public void forgotPassword(String forgotpasworduserid){
		Forgotpasswordlink.click();
		this.forgotpasworduserid.clear();
		this.forgotpasworduserid.sendKeys("vroopesh@outlook.com");
		submitforgotpassword.click();		
	}
	
	public String getForgotPasswordSucessText(){
		return getForgotPasswordSucessText.getText();
	}
	
	public void clickOnLogout() throws InterruptedException{
		waitForElement(300, dashboardUserImage);
		dashboardUserImage.click();
		logoutlink.click();
		
		}
	
}
