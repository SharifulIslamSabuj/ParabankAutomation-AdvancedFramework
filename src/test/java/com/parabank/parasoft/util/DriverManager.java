package com.parabank.parasoft.util;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    // Thread-safe WebDriver storage
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Get driver for current thread
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Set driver for current thread
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Remove driver after test execution
    public static void unload() {
        driver.remove();
    }
}
