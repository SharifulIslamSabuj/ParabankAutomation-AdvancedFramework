package com.parabank.parasoft.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

    private static volatile ExtentReports extent; // volatile required for safe double-checked locking below
    private static final Object lock = new Object();
    private static String reportPath;

    public static ExtentReports getInstance() {

        if (extent == null) {
            synchronized (lock) {
                if (extent == null) {
                    createInstance();
                }
            }
        }

        return extent;
    }

    private static ExtentReports createInstance() {

        String workingDir = System.getProperty("user.dir");

        reportPath = workingDir + "/build/extentReport/Report.html";

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(reportPath);

        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("ParaBank Automation Report");
        sparkReporter.config().setReportName("Advanced Automation Execution Report");
        sparkReporter.config().setEncoding("utf-8");

        extent = new ExtentReports();

        extent.attachReporter(sparkReporter);

        // System metadata surfaced in the ExtentReports dashboard
        extent.setSystemInfo("Project", "ParaBank Automation Framework");
        extent.setSystemInfo("Framework Type", "Advanced POM + TestNG");
        extent.setSystemInfo("Execution Mode", "Parallel Ready");

        return extent;
    }
}