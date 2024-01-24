package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class css {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nihir\\OneDrive\\Desktop\\gecko\\geckodriver.exe");
		
	
	
		//WebDriver driver = new FirefoxDriver(); 
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.google.com/");
		driver.findElement(By.cssSelector("a.gb_d")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Play']")).click();
		
		
	}

}
