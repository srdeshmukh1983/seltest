package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.asserts.*;

public class testNGParellelDataprovider {

	@DataProvider(name = "browser", parallel = true)
	Object[][] browser() {
		return new Object[][] { { "selenium" }, { "TestNG" }, { "APITEsting" }

		};
	}

	@Test(dataProvider = "browser")
	void fire(String inputtext) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys(inputtext);
		driver.findElement(By.name("q")).submit();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().startsWith(inputtext));

		System.out.println(inputtext + ":" + Thread.currentThread().getId() + ":" + Thread.currentThread().getName());
	}

}
