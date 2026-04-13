package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
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
        ParaBankUtil.waitForDomStable();
        getElement(By.cssSelector("a[href='openaccount.htm']")).click();
        return navigateToPage(OpenNewAccountPage.class);
    }

    public RequestLoanPage clickRequestLoanLink() {
        ParaBankUtil.waitForDomStable();
        clickElement(By.cssSelector("a[href='requestloan.htm']"));
        return navigateToPage(RequestLoanPage.class);
    }

    public UpdateProfilePage clickUpdateProfileLink() {
        ParaBankUtil.waitForDomStable();
        clickElement(By.cssSelector("a[href='updateprofile.htm']"));
        return navigateToPage(UpdateProfilePage.class);
    }
}