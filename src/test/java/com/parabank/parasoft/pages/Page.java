package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Page {

    public abstract WebElement getElement(By selector);

    public abstract List<WebElement> getElements(By selector);

    public abstract String getTextFromElement(By selector);

    public abstract void clickElement(By selector);

    public abstract String getPageTitle();

    public abstract void waitForElementToBeVisible(By selector);

    public abstract void waitForElementToBeClickable(By selector);

    public abstract boolean isElementVisible(By selector);

    public abstract void waitForOptionsCountGreaterThan(By optionsSelector, int index);

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