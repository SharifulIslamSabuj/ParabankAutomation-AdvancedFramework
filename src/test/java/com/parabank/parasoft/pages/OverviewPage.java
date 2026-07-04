package com.parabank.parasoft.pages;

import org.openqa.selenium.By;

public class OverviewPage extends BasePage {

    public OverviewPage() {
        super();
    }

    public boolean hasLogOutLink() {
        waitForElementToBeVisible(By.cssSelector("a[href='logout.htm']"));
        return !getElements(By.cssSelector("a[href='logout.htm']")).isEmpty();
    }

    public OpenNewAccountPage clickOpenNewAccountLink() {
        waitForElementToBeClickable(By.cssSelector("a[href='openaccount.htm']"));
        getElement(By.cssSelector("a[href='openaccount.htm']")).click();
        return navigateToPage(OpenNewAccountPage.class);
    }

    public RequestLoanPage clickRequestLoanLink() {
        waitForElementToBeClickable(By.cssSelector("a[href='requestloan.htm']"));
        clickElement(By.cssSelector("a[href='requestloan.htm']"));
        return navigateToPage(RequestLoanPage.class);
    }

    public UpdateProfilePage clickUpdateProfileLink() {
        waitForElementToBeClickable(By.cssSelector("a[href='updateprofile.htm']"));
        clickElement(By.cssSelector("a[href='updateprofile.htm']"));
        return navigateToPage(UpdateProfilePage.class);
    }
}