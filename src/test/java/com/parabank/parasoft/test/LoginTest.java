package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.util.ParaBankUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify login page title")
    public void checkTitle() {

        LoginPage lpage = getPg().navigateToPage(LoginPage.class);

        String title = lpage.getPageTitle();

        Assert.assertEquals(title, ParaBankUtil.TITLE);
    }

    @Test(description = "Login using step-by-step flow")
    public void LoginV1() {

        LoginPage lpage = getPg().navigateToPage(LoginPage.class);

        OverviewPage opage = lpage
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginButton();

        Assert.assertTrue(opage.hasLogOutLink(),
                "Logout link is not displayed. Login failed.");
    }

    @Test(description = "Login using business method")
    public void LoginV2() {

        OverviewPage opage = getPg()
                .navigateToPage(LoginPage.class)
                .doLogin(getUsername(), getPassword());

        Assert.assertTrue(opage.hasLogOutLink(),
                "Logout link is not displayed. Login failed.");
    }
}