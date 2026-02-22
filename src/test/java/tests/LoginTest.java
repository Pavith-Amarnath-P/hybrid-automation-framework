package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import reports.Report;


public class LoginTest extends BaseTest {
    @Test
    public void invalidLoginTest(){
        LoginPage page = new LoginPage();
        page.goTo();
        page.login("Pavith", "123456");
        Report.info(page.getErrorMessage());
        Assert.assertTrue(page.isErrorMessageDisplayed());
    }

    @Test
    public void validLoginTest(){
        LoginPage page = new LoginPage();
        page.goTo();
        page.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(page.isErrorMessageDisplayed());
    }

}
