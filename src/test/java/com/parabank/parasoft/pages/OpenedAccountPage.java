package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;

public class OpenedAccountPage extends BasePage {

    public OpenedAccountPage() {
        super();
    }

    public boolean hasOpenedAccountId() {
        ParaBankUtil.waitForDomStable();
        return !getElements(By.id("newAccountId")).isEmpty();
    }
}