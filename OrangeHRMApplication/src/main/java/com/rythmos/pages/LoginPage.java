/**
 * 
 */
package com.rythmos.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.rythmos.common.PageControls;


/**
 * @author Sbudala
 *
 */
public class LoginPage extends PageControls {

	//PageControls pc=null;
	//String uname=null;
	//String password=null;
	By USER_NAME=By.id("txtUsername");
	By PASSWORD=By.id("txtPassword");
	By SUBMIT=By.id("btnLogin");
	By HOMEPAGE_DISPLAY_CHECK=By.id("welcome");

	public LoginPage(WebDriver driver) {	
		super(driver);
	}

	public void LaunchURL(String url){	
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 loadUrl(url);		
		 waitForPageLoad(2000);
	}
	
	public void loginHomePage(String uname,String password){
		type(USER_NAME, uname);
		type(PASSWORD, password);
		click(SUBMIT);
	}
	
	public void isHomePageDisplayed(String expVal)
	{
	 String actVal=findLocator(HOMEPAGE_DISPLAY_CHECK).getText();
	 //System.out.println(actVal);
	 if (expVal.contains(actVal)){
		 Assert.assertTrue(true);
	 }else{
		 Assert.assertTrue(false);
	 }
	}
	
	
	
}
	
