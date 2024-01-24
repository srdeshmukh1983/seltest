package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.asserts.*;

public class testngtest {

	WebDriver driver;

	@BeforeMethod
	void setUP() {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@AfterMethod
	void teardown() {
		driver.quit();
	}

	@Test(dataProvider = "calc-data")
	void calc(String input, String exp) {

		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(input);
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).submit();
		WebElement result = driver.findElement(By.id("cwos"));
		Assert.assertEquals(result.getText(), exp);
	}

	@Test
	void gettitle() {
		System.out.println("the title of the page is "+driver.getTitle());
	}

	@DataProvider(name="calc-data")
	Object[][] testdata(){
		return new Object[][] {
			{"2 + 3", "5"},
			{"5*5", "25"},
			{"5-4*30", "-115"}
		};
		}
}
