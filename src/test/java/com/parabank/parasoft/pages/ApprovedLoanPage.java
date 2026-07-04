package com.parabank.parasoft.pages;

import org.openqa.selenium.By;

public class ApprovedLoanPage extends BasePage {

    public ApprovedLoanPage() {
        super();
    }

    public boolean isApprovedLoanId() {
        return isElementVisible(By.id("newAccountId"));
    }
}