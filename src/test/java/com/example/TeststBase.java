package com.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TeststBase {
    protected static ExtentReports extent;
    protected static ExtentTest test;

    public static void setUp() {
        // Specify the location for the extent report
        
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");

        // Create ExtentReports and attach the HTML reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Additional configuration (optional)
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
    }
}