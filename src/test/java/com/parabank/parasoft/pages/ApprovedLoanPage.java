package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;

public class ApprovedLoanPage extends BasePage {

    public ApprovedLoanPage() {
        super();
    }

    public boolean isApprovedLoanId() {
        ParaBankUtil.waitForDomStable();
        return !getElements(By.id("newAccountId")).isEmpty();
    }
}