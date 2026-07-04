package com.parabank.parasoft.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By address = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zip = By.id("customer.address.zipCode");
    private final By phone = By.id("customer.phoneNumber");
    private final By ssn = By.id("customer.ssn");
    private final By username = By.id("customer.username");
    private final By password = By.id("customer.password");
    private final By confirmPassword = By.id("repeatedPassword");
    private final By registerBtn = By.cssSelector("input[value='Register']");
    private final By errorMsg = By.cssSelector("span.error");

    public RegisterPage fillFirstName(String value) {
        getElement(firstName).sendKeys(value);
        return this;
    }

    public RegisterPage fillLastName(String value) {
        getElement(lastName).sendKeys(value);
        return this;
    }

    public RegisterPage fillAddress(String value) {
        getElement(address).sendKeys(value);
        return this;
    }

    public RegisterPage fillCity(String value) {
        getElement(city).sendKeys(value);
        return this;
    }

    public RegisterPage fillState(String value) {
        getElement(state).sendKeys(value);
        return this;
    }

    public RegisterPage fillZipCode(String value) {
        getElement(zip).sendKeys(value);
        return this;
    }

    public RegisterPage fillPhone(String value) {
        getElement(phone).sendKeys(value);
        return this;
    }

    public RegisterPage fillSSN(String value) {
        getElement(ssn).sendKeys(value);
        return this;
    }

    public RegisterPage fillUsername(String value) {
        getElement(username).sendKeys(value);
        return this;
    }

    public RegisterPage fillPassword(String value) {
        getElement(password).sendKeys(value);
        return this;
    }

    public RegisterPage fillConfirmPassword(String value) {
        getElement(confirmPassword).sendKeys(value);
        return this;
    }

    public OverviewPage clickRegisterButtonWithSuccess() {
        getElement(registerBtn).click();
        return navigateToPage(OverviewPage.class);
    }

    public RegisterPage clickRegisterButtonWithFail() {
        getElement(registerBtn).click();
        return this;
    }

    public boolean hasErrorMessage(int expectedCount) {
        return getElements(errorMsg).size() >= expectedCount;
    }
}