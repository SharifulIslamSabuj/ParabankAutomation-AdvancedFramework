package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.DriverManager;
import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Page {

    protected WebDriverWait wait;

    public Page() {
        this.wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(ParaBankUtil.WAIT_TIME)
        );
    }

    public abstract WebElement getElement(By selector);

    public abstract List<WebElement> getElements(By selector);

    public abstract String getTextFromElement(By selector);

    public abstract void clickElement(By selector);

    public abstract String getPageTitle();

    public abstract void waitForElementToBeVisible(By selector);

    // Page objects use a no-arg constructor and resolve the WebDriver from
    // DriverManager's ThreadLocal, so reflection is used here instead of
    // injecting dependencies through the constructor.
    public <T extends BasePage> T navigateToPage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate to page: " + pageClass.getName(), e);
        }
    }
}