package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.LoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.pages.RegisterPage;
import com.parabank.parasoft.util.ParaBankUtil;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test(description = "Register with hardcoded data")
    public void registerShouldSucceedWithHardData() {

        OverviewPage page = getPg()
                .navigateToPage(LoginPage.class)
                .clickRegisterLink()
                .fillFirstName("Shariful")
                .fillLastName("Islam")
                .fillAddress("786/1 Mirpur")
                .fillCity("Dhaka")
                .fillState("Mirpur")
                .fillZipCode("1216")
                .fillPhone("12345643")
                .fillSSN("SSN123")
                .fillUsername("shariful13")
                .fillPassword("shariful13")
                .fillConfirmPassword("shariful13")
                .clickRegisterButtonWithSuccess();

        Assert.assertTrue(page.hasLogOutLink());
    }

    @Test(description = "Register with dynamic lorem data")
    public void registerShouldSucceedWithLoremIpsumData() {

        String username = LoremIpsum.getInstance().getName().replaceAll(" ", "");

        OverviewPage page = getPg()
                .navigateToPage(LoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getTitle(5))
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterButtonWithSuccess();

        Assert.assertTrue(page.hasLogOutLink());
    }

    @DataProvider
    public Object[][] getDataProviderData() {
        return ParaBankUtil.getTestData("Sheet1");
    }

    @Test(dataProvider = "getDataProviderData")
    public void registerDdtShouldSucceedV2(String firstName, String lastName, String address) {

        String username = LoremIpsum.getInstance().getName().replaceAll(" ", "");

        OverviewPage page = getPg()
                .navigateToPage(LoginPage.class)
                .clickRegisterLink()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterButtonWithSuccess();

        Assert.assertTrue(page.hasLogOutLink(), "Register successfully completed.");
    }

    @Test
    public void registerShouldFailWithOutUsername() {

        RegisterPage page = getPg()
                .navigateToPage(LoginPage.class)
                .clickRegisterLink()
                .fillFirstName("sqa")
                .fillLastName("Engineer")
                .fillAddress("435/7 Manhattan USA")
                .fillCity("Dhaka")
                .fillState("Mirpur")
                .fillZipCode("1234")
                .fillPhone("90897654")
                .fillPassword("sqa123")
                .fillConfirmPassword("sqa123")
                .clickRegisterButtonWithFail();

        Assert.assertTrue(page.hasErrorMessage(1));
    }
}