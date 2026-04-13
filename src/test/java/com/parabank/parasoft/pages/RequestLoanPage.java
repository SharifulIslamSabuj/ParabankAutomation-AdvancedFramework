package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage extends BasePage {

    public RequestLoanPage() {
        super();
    }

    public RequestLoanPage fillLoanAmount(String loanAmount) {
        ParaBankUtil.waitForDomStable();

        getElement(By.xpath("//input[@id='amount']"))
                .sendKeys(loanAmount);

        return this;
    }

    public RequestLoanPage fillDownpayment(String downPaymentAmount) {
        ParaBankUtil.waitForDomStable();

        getElement(By.xpath("//input[@id='downPayment']"))
                .sendKeys(downPaymentAmount);

        return this;
    }

    public RequestLoanPage selectAccount(int index) {
        ParaBankUtil.waitForDomStable();

        Select select = new Select(
                getElement(By.xpath("//select[@id='fromAccountId']"))
        );

        select.selectByIndex(index);
        return this;
    }

    public ApprovedLoanPage clickApplyNowButton() {
        ParaBankUtil.waitForDomStable();

        getElement(By.xpath("//input[@value='Apply Now']"))
                .click();

        return navigateToPage(ApprovedLoanPage.class);
    }
}