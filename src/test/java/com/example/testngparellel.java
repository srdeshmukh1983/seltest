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
public class testngparellel {
	
	@Test
	void calc1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("sqrt(16)");
		driver.findElement(By.name("q")).submit();
		WebElement result = driver.findElement(By.id("cwos"));
		Assert.assertEquals(result.getText(), "4");
		//driver.close();
		
	}
	
	@Test
     void search() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		driver.findElement(By.name("q")).submit();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().startsWith("selenium"));
		
	}

}
