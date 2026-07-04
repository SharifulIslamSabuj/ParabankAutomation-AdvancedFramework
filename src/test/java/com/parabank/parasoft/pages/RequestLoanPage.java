package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage extends BasePage {

    public RequestLoanPage() {
        super();
    }

    public RequestLoanPage fillLoanAmount(String loanAmount) {
        waitForElementToBeVisible(By.xpath("//input[@id='amount']"));

        getElement(By.xpath("//input[@id='amount']"))
                .sendKeys(loanAmount);

        return this;
    }

    public RequestLoanPage fillDownpayment(String downPaymentAmount) {
        waitForElementToBeVisible(By.xpath("//input[@id='downPayment']"));

        getElement(By.xpath("//input[@id='downPayment']"))
                .sendKeys(downPaymentAmount);

        return this;
    }

    public RequestLoanPage selectAccount(int index) {
        waitForOptionsCountGreaterThan(By.xpath("//select[@id='fromAccountId']/option"), index);

        Select select = new Select(
                getElement(By.xpath("//select[@id='fromAccountId']"))
        );

        select.selectByIndex(index);
        return this;
    }

    public ApprovedLoanPage clickApplyNowButton() {
        waitForElementToBeClickable(By.xpath("//input[@value='Apply Now']"));

        getElement(By.xpath("//input[@value='Apply Now']"))
                .click();

        return navigateToPage(ApprovedLoanPage.class);
    }
}