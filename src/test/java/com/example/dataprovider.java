package com.example;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.asserts.*;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	WebDriver driver;
	
	
	
	@BeforeMethod
	void statup() {
		driver= new ChromeDriver();
		driver.get("https://www.txdpsscheduler.com/");
		
	}
	@DataProvider(name = "dps")
		Object[][] dps(){
		return new Object[][]{
		{"sriram", "deshmukh","09/08/1992","3334","sd@gmail.com", "sd@gmail.com", "75063"},
		{"ram", "deskh","02/01/1982","2234","sd123@gmail.com", "sd123@gmail.com", "75039"},
		{"sam", "mukh","09/07/1998","444","sgd@gmail.com", "sgd@gmail.com", "75055"}
		};
	}
	
	
	
	@Test(dataProvider = "dps")
	void schedule(String fname, String lname, String dob, String ssn, String email,String mailcon, String zipcode ) throws InterruptedException, IOException {
		driver.findElement(By.cssSelector("span.v-btn__content")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/section/div/main/div/section/div[2]/div/div/form/div[2]/div[3]/div[2]/div/div[1]/div/input")).sendKeys(fname);
		  driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/section/div/main/div/section/div[2]/div/div/form/div[2]/div[3]/div[3]/div/div[1]/div/input")).sendKeys(lname);
	      driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys(dob);
	      driver.findElement(By.xpath("//*[@id=\"last4Ssn\"]")).sendKeys(ssn);
	      driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/div/form/div[2]/div[4]/button/span")).click();
	      Thread.sleep(10000);
	      driver.findElement(By.xpath("//span[contains(text(),'New Appointment')]")).click();
	      driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/main/div/div/div[1]/div[1]/button")).click();
	      driver.findElement(By.xpath("//*[@id=\"input-134\"]")).sendKeys(email);
	      driver.findElement(By.xpath("//*[@id=\"input-137\"]")).sendKeys(mailcon);
	      driver.findElement(By.xpath("//*[@id=\"input-160\"]")).sendKeys(zipcode);
	      driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/main/div/section/div[2]/div/form/div/div[2]/div[2]/div/div[2]/button/span/i")).click();
	      Thread.sleep(20000);
	      TakesScreenshot scrShot =((TakesScreenshot)driver);
	    
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
	    driver.findElement(By.xpath("//*[@id=\"app\"]/section/div/div[3]/header[1]/div/div[3]/div/div/button[3]")).click();
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/div[2]/div[1]/button/span")).click();
	}
	

}
