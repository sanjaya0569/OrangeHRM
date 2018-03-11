package com.rythmos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rythmos.common.PageControls;

public class LogoutPage extends PageControls {
	
	By LOGOUT=By.xpath("//a[text()='Logout']");
	By HOMEPAGE_DISPLAY_CHECK=By.id("welcome");
	
	public LogoutPage(WebDriver driver){
		super(driver);		
	}
	
	public void logout(){
		waitForPageLoad(5000);
		click(HOMEPAGE_DISPLAY_CHECK);
		click(LOGOUT);
	}
}
