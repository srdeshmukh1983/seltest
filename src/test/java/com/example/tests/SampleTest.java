package com.example.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class SampleTest {

	    private WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void sampleTest() {
	        driver.get("https://www.example.com");
	        // Add your Selenium test logic here
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


