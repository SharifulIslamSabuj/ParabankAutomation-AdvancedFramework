package com.parabank.parasoft.report;

import com.aventstack.extentreports.Status;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_RETRY_COUNT = 1;

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount >= MAX_RETRY_COUNT) {
            return false;
        }

        retryCount++;

        String message = "Retrying test '" + result.getMethod().getMethodName()
                + "' (attempt " + (retryCount + 1) + " of " + (MAX_RETRY_COUNT + 1) + ")";

        System.out.println(message);

        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.WARNING, message);
        }

        return true;
    }
}
