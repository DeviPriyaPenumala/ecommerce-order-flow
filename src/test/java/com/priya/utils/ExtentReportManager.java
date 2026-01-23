package com.priya.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {
        if (extent == null) {
            ExtentSparkReporter reporter =
                new ExtentSparkReporter("test-output/ExtentReport.html");

            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("E-Commerce Automation");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}

