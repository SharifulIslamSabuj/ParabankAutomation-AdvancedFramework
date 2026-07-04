package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OpenNewAccountPage extends BasePage {

    public OpenNewAccountPage() {
        super();
    }

    public OpenNewAccountPage selectAccountType(String accountType) {
        ParaBankUtil.waitForDomStable();

        Select select = new Select(
                getElement(By.xpath("//select[@id='type']"))
        );

        select.selectByVisibleText(accountType);
        return this;
    }

    public OpenNewAccountPage selectFirstAvailableAccount() {
        ParaBankUtil.waitForDomStable();

        Select select = new Select(
                getElement(By.id("fromAccountId"))
        );

        List<WebElement> options = select.getOptions();

        if (!options.isEmpty()) {
            select.selectByIndex(0);
        } else {
            throw new RuntimeException("No account options available");
        }

        return this;
    }

    public OpenedAccountPage clickOpenNewAccountButton() {
        ParaBankUtil.waitForDomStable();

        getElement(By.cssSelector("input[value='Open New Account']"))
                .click();

        return navigateToPage(OpenedAccountPage.class);
    }
}