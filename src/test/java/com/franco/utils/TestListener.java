package com.franco.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.franco.base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    private static ExtentReports extent = ReportManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {

        extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest test = extent.createTest(result.getName());
        test.pass("Test ejecutado correctamente");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ScreenshotUtils.takeScreenshot(
                driver,
                result.getName()
        );

        ExtentTest test = extent.createTest(result.getName());
        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();
    }
}