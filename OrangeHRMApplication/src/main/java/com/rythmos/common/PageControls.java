package com.rythmos.common;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class PageControls {
	
	protected WebDriver driver;
	
	public PageControls(WebDriver driver){
		this.driver=driver;
	}
	

	public void loadUrl(String url) {
		driver.get(url);	
	}
	
	public String getCurrentUrl() {
		//System.err.println(getDate()+"- Getting current URL."+" "+driver.toString());
		String tmp = driver.getCurrentUrl();
		//System.err.println(getDate()+"- Current Url returned : "+tmp+" "+driver.toString());
		return tmp;
	}
	
	private Date getDate(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	
	public String getPageTitle() {
		//System.err.println(getDate()+"- Getting Page Title."+" "+driver.toString());
		String tmp = driver.getTitle();
		//System.err.println(getDate()+"- Current Page Title : "+tmp+" "+driver.toString());
		return tmp;
	}
	
	public void closeBrowser() {
		//String tmp = driver.toString();
		//System.err.println(getDate()+"- Closing browser.  Thread ID : "+driver);
		driver.quit();
		//System.err.println(getDate()+"- Browser d.  Thread ID : "+tmp);
		
	}
	
	public WebElement findLocator(By by){
		
		this.driver.findElement(by).isDisplayed();
		this.driver.findElement(by).isEnabled();
		return this.driver.findElement(by);		
	}
	
	public void type(By by,String testdata){
		findLocator(by).sendKeys(testdata);		
	}
	
	public void click(By by){
		findLocator(by).click();
	}
	
	public String getText(By by){
		
		String text=findLocator(by).getText();
		return text;
		
	}
	
	
	
	
/*	public String getText(By by) {
		//System.err.println(getDate()+"- Getting Text from : "+by.toString()+" - "+driver.toString());
		//String tmp = waitForElement(by).getText();
		//System.err.println(getDate()+"- Got Text from : "+by.toString()+" : "+tmp);
		//return tmp;
	}*/
	/*
	public void check(By by) {
		if (!driver.findElement(by).isSelected())
			waitForElement(by).click();
		System.err.println(getDate()+"- Clicked on "+by.toString()+" - "+driver.toString());
	}

	public void uncheck(By by) {
		if (driver.findElement(by).isSelected())
			waitForElement(by).click();
		System.err.println(getDate()+"- Clicked on "+by.toString()+" - "+driver.toString());
	}*/

	

/*	public void pause(int i) {

		try {
			System.err.println(getDate()+"- Pausing Execution for "+i+" MS - "+driver.toString());
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void ReporterTextError(Exception e) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<span style='color: red;font-size: 14px;'><b>" + e + "</b><br></span>");
		System.out.println(e);
	}
	
	public void reportFailureScreenshot(String screenshotFilePath, String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		/*
		 * Reporter.log("<a href=\"" + screenshotFilePath +
		 * "\">ScreenShot<img src=\"file:///" + screenshotFilePath +
		 * "\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
		 */
		Reporter.log("<a href=\"" + screenshotFilePath + "\">"+message+"<br></a>");
		System.err.println("Reporting Failure Screenshot.  FilePath : "+screenshotFilePath);
	}
	
	public String driverScreenshot() {
		System.err.println(getDate()+"- Taking  Driver Screenshot "+" - "+driver.toString());
		String fileName = String.valueOf(System.currentTimeMillis());
		String path = System.getProperty("user.dir") + "/target/surefire-reports/html/Reports/Screenshot/";

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(path + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Failure in taking screenshot.");
			e.printStackTrace();
		}
		System.err.println(getDate()+"-Driver Screenshot Captured "+" - "+driver.toString());
		return path + fileName + ".png";

	}
	
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250);");
		System.out.println("Page is Scrolling down");
	}
	
	public  void scrollToBottom() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 500);");
        
    }
	/*public void waitForPageToLoad(By by, boolean flag) {
		System.err.println(getDate()+" Waiting for Page to Load.  "+by.toString()+" - "+driver.toString());
		if (flag) {
			for (int i = 1; i < 100; i++) {
				try {
					driver.findElement(by).isDisplayed();
					Thread.sleep(10);
				} catch (Exception e) {
					break;
				}
			}
		}
	}*/
	
	public void waitForPageLoad(int i){
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	



}
