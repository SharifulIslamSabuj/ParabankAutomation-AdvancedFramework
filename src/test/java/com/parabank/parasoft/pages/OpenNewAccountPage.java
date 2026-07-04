package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage {

    public OpenNewAccountPage() {
        super();
    }

    public OpenNewAccountPage selectAccountType(String accountType) {
        waitForElementToBeVisible(By.xpath("//select[@id='type']"));

        Select select = new Select(
                getElement(By.xpath("//select[@id='type']"))
        );

        select.selectByVisibleText(accountType);
        return this;
    }

    public OpenNewAccountPage selectFirstAvailableAccount() {
        waitForOptionsCountGreaterThan(By.cssSelector("#fromAccountId option"), 0);

        Select select = new Select(
                getElement(By.id("fromAccountId"))
        );

        select.selectByIndex(0);

        return this;
    }

    public OpenedAccountPage clickOpenNewAccountButton() {
        waitForElementToBeClickable(By.cssSelector("input[value='Open New Account']"));

        getElement(By.cssSelector("input[value='Open New Account']"))
                .click();

        return navigateToPage(OpenedAccountPage.class);
    }
}