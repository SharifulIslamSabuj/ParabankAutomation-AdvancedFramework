package com.parabank.parasoft.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReportTestManager {

    private static ExtentReports extent = ReportManager.getInstance();

    // 🔥 Thread-safe test storage (BEST PRACTICE)
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Start test for current thread
    public static ExtentTest startTest(String testName, String className) {

        ExtentTest test = extent.createTest(testName, className);

        test.assignAuthor("Shariful");
        test.assignCategory(className);

        extentTest.set(test);

        return test;
    }

    // Get current thread's test
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // Log simple message
    public static void logText(String message) {
        getTest().log(Status.INFO, message);
    }

    // Optional cleanup (VERY IMPORTANT for memory safety)
    public static void unload() {
        extentTest.remove();
    }
}