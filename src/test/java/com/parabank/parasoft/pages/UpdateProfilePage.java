package com.parabank.parasoft.pages;

import org.openqa.selenium.By;

public class UpdateProfilePage extends BasePage {

    public UpdateProfilePage() {
        super();
    }

    public UpdateProfilePage fillFirstName(String firstName) {
        getElement(By.id("customer.firstName")).sendKeys(firstName);
        return this;
    }

    public UpdateProfilePage fillLastName(String lastName) {
        getElement(By.id("customer.lastName")).sendKeys(lastName);
        return this;
    }

    public UpdateProfilePage fillAddress(String address) {
        getElement(By.id("customer.address.street")).sendKeys(address);
        return this;
    }

    public UpdateProfilePage fillCity(String city) {
        getElement(By.id("customer.address.city")).sendKeys(city);
        return this;
    }

    public UpdateProfilePage fillState(String state) {
        getElement(By.id("customer.address.state")).sendKeys(state);
        return this;
    }

    public UpdateProfilePage fillZipCode(String zipCode) {
        getElement(By.id("customer.address.zipCode")).sendKeys(zipCode);
        return this;
    }

    public UpdateProfilePage fillPhone(String phone) {
        getElement(By.id("customer.phoneNumber")).sendKeys(phone);
        return this;
    }

    public UpdateProfilePage clickUpdateProfileButton() {
        clickElement(By.cssSelector("input[value='Update Profile']"));
        return this;
    }

    public boolean isResultMessageDisplayed() {
        return !getElements(By.cssSelector("input[value='Update Profile']")).isEmpty();
    }
}