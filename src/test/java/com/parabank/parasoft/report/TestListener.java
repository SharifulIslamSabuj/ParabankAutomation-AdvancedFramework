package com.parabank.parasoft.report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.parabank.parasoft.test.BaseTest;
import com.parabank.parasoft.util.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult result) {
        return result.getMethod().getMethodName();
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("TEST SUITE STARTED: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TEST SUITE FINISHED: " + context.getName());
        ReportManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();

        String finalName = (description != null && !description.isEmpty())
                ? testName + " - " + description
                : testName;

        ReportTestManager.startTest(
                finalName,
                result.getInstance().getClass().getSimpleName()
        );

        ReportTestManager.getTest().log(
                Status.INFO,
                "Test Started: " + finalName
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportTestManager.getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = DriverManager.getDriver();

        System.out.println("TEST FAILED: " + getTestMethodName(result));

        if (driver != null) {
            try {
                String base64Screenshot =
                        "data:image/png;base64," +
                                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

                ReportTestManager.getTest().fail(
                        result.getThrowable(),
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build()
                );

            } catch (Exception e) {
                ReportTestManager.getTest().fail("Screenshot capture failed: " + e.getMessage());
            }
        } else {
            ReportTestManager.getTest().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("FAILED WITHIN SUCCESS PERCENTAGE: " + getTestMethodName(result));
    }
}