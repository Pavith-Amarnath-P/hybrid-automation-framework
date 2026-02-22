package tests;

import base.BaseTest;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import reports.Report;

public class DummyTest extends BaseTest {
    @Test
    public void openGoogleTest(){
        DriverManager.getDriver().get("https://www.google.com");
        Assert.assertTrue(false);
    }
}
