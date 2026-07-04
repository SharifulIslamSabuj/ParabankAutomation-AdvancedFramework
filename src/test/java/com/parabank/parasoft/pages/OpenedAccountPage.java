package com.parabank.parasoft.pages;

import org.openqa.selenium.By;

public class OpenedAccountPage extends BasePage {

    public OpenedAccountPage() {
        super();
    }

    public boolean hasOpenedAccountId() {
        return isElementVisible(By.id("newAccountId"));
    }
}