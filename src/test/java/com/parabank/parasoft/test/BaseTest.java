package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import com.parabank.parasoft.util.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {

    private ThreadLocal<Page> pg = new ThreadLocal<>();
    private Properties prop;

    public BaseTest() {
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        prop = new Properties();
        try (FileInputStream inputStream = new FileInputStream(path)) {
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void browserSetup() {

        String browserName = prop.getProperty("browserName");

        WebDriver driver;

        if (Objects.equals(browserName, "firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (Objects.equals(browserName, "chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (Objects.equals(browserName, "edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (Objects.equals(browserName, "safari")) {

            driver = new SafariDriver();

        } else if (Objects.equals(browserName, "headlessFirefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);

        } else if (Objects.equals(browserName, "headlessChrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        // 🔥 Store in ThreadLocal
        DriverManager.setDriver(driver);

        driver.manage().window().maximize();
        driver.get(prop.getProperty("baseUrl"));

        // ❗ IMPORTANT FIX: no driver passed
        pg.set(new BasePage());
    }

    @AfterMethod
    public void browserTeardown(ITestResult result) {

        WebDriver driver = DriverManager.getDriver();

        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName(), driver);
        }

        if (driver != null) {
            driver.quit();
        }

        DriverManager.unload();
        pg.remove();
    }

    public Page getPg() {
        return pg.get();
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public WebDriver getWebDriver() {
        return DriverManager.getDriver();
    }

    public void takeScreenshot(String fileName, WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dir = System.getProperty("user.dir") + "/build/screenshots/";
            org.apache.commons.io.FileUtils.copyFile(
                    scrFile,
                    new File(dir + fileName + "_" + System.currentTimeMillis() + ".png")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}