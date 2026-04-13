package com.parabank.parasoft.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // ❌ REMOVED constructor (IMPORTANT for parallel framework)

    private final By username = By.cssSelector("input[name='username']");
    private final By password = By.xpath("//input[@name='password']");
    private final By loginBtn = By.cssSelector("input[value='Log In']");
    private final By registerLink = By.cssSelector("a[href='register.htm']");

    public LoginPage fillUsername(String user) {
        getElement(username).sendKeys(user);
        return this;
    }

    public LoginPage fillPassword(String pass) {
        getElement(password).sendKeys(pass);
        return this;
    }

    public OverviewPage clickLoginButton() {
        getElement(loginBtn).click();
        return navigateToPage(OverviewPage.class);
    }

    public RegisterPage clickRegisterLink() {
        getElement(registerLink).click();
        return navigateToPage(RegisterPage.class);
    }

    public OverviewPage doLogin(String user, String pass) {
        return fillUsername(user)
                .fillPassword(pass)
                .clickLoginButton();
    }
}