package com.priya.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.priya.base.BaseTest;
import com.priya.utils.ExtentReportManager;
import com.priya.utils.ExtentTestManager;
import com.priya.utils.ScreenshotUtils;

public class TestListener implements ITestListener {
	//WebDriver driver;

    ExtentReports extent = ExtentReportManager.getExtentReport();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.setTest(
            extent.createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        String path = ScreenshotUtils.captureScreenshot(
                driver,
                result.getMethod().getMethodName()
        );

        ExtentTestManager.getTest().fail(result.getThrowable());
        ExtentTestManager.getTest().addScreenCaptureFromPath(path, "Failure Screenshot");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

