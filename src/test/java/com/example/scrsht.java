package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
public class scrsht {
	//public WebDriver driver;
	protected static ExtentReports extent;
    protected static ExtentTest test;
    ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
	private WebDriver driver;
	
	   @BeforeMethod
	    public void beforeMethod() {
		   System.setProperty("webdriver.gecko.driver","C:\\Users\\Nihir\\OneDrive\\Desktop\\gecko\\geckodriver.exe");
    	driver = new FirefoxDriver();
		 extent = new ExtentReports();
	        extent.attachReporter(spark);

	        // Additional configuration (optional)
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Browser", "Chrome");
	        test = extent.createTest("My first test");
	    }
	
	@Test
	void takescrsht1() {
		 
		driver.get("https://www.txdpsscheduler.com/");
		driver.findElement(By.cssSelector("button.v-size--x-large:nth-child(1) > span:nth-child(1)")).click();
		
		
	 TakesScreenshot scrShot =((TakesScreenshot)driver);
	    //Call getScreenshotAs method to create image file
	    File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
	    //Move image file to new destination
	    
	   
	    Date d = new Date();
	    String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
	    
	    
	    
	    File reportFile = new File("C:\\Users\\Nihir\\OneDrive\\Desktop\\current\\scrshots\\report_" + FileName + ".jpg");
	   
	    
	    try {
			FileHandler.copy(scrFile, reportFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	       test.pass("Test passed");
	
	}
	@Test 
	void gettitle() {
		System.out.println(driver.getCurrentUrl());
		Actions act = new Actions(driver);
		act.doubleClick();
	}
	@Test
	void teardown() {
		driver.close();
		extent.flush();
	}
	
	
}
