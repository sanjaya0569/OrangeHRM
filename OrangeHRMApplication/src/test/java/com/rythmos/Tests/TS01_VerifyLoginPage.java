package com.rythmos.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.rythmos.common.PageControls;
import com.rythmos.pages.LoginPage;
import com.rythmos.pages.LogoutPage;

public class TS01_VerifyLoginPage {
	
	//LoginPage login=null;
	PageControls page=null;
	WebDriver driver;
	String url="http://opensource.demo.orangehrmlive.com/";
	String uname="Admin";
	String password="admin";
	

	@Test(priority=0)
	public void beforeclass() throws InterruptedException{
		//String url=null;		
		LoginPage login=new LoginPage(driver);
		login.LaunchURL(url);
		login.loginHomePage(uname, password);	
		login.isHomePageDisplayed("Welcome Admin");
		
	}
	@Test(priority=1)
	public void afterClass(){
		LogoutPage logoutFromHomePage=new LogoutPage(driver);  
		logoutFromHomePage.logout();
	}
	
}
