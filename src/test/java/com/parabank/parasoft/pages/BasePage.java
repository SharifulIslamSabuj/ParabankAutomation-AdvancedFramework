package com.parabank.parasoft.pages;

import com.aventstack.extentreports.Status;
import com.parabank.parasoft.report.ReportTestManager;
import com.parabank.parasoft.util.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage extends Page {

    // ❌ REMOVED constructor completely (IMPORTANT FIX)

    @Override
    public WebElement getElement(By selector) {
        try {
            addInfo("Finding element: " + selector);

            WebDriver driver = DriverManager.getDriver();
            WebElement element = driver.findElement(selector);

            addInfo("Element found: " + selector);
            return element;

        } catch (Exception e) {
            addFailInfo("Element NOT found: " + selector);
            throw new RuntimeException("Element not found: " + selector, e);
        }
    }

    @Override
    public List<WebElement> getElements(By selector) {
        try {
            addInfo("Finding elements: " + selector);

            WebDriver driver = DriverManager.getDriver();
            List<WebElement> elements = driver.findElements(selector);

            addInfo("Elements found: " + selector);
            return elements;

        } catch (Exception e) {
            addFailInfo("Elements NOT found: " + selector);
            return new ArrayList<>();
        }
    }

    @Override
    public String getTextFromElement(By selector) {
        return getElement(selector).getText();
    }

    @Override
    public void clickElement(By selector) {
        getElement(selector).click();
        addInfo("Clicked element: " + selector);
    }

    @Override
    public String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    @Override
    public void waitForElementToBeVisible(By selector) {
        try {
            addInfo("Waiting for element: " + selector);

            WebDriverWait wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(10)
            );

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(selector)
            );

            addInfo("Element visible: " + selector);

        } catch (Exception e) {
            addFailInfo("Element NOT visible: " + selector);
            throw new RuntimeException("Wait failed for element: " + selector, e);
        }
    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }

    public void addFailInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.FAIL, message);
        }
    }
}