package base;

import config.ConfigLoader;
import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        DriverFactory.initDriver();
        DriverManager.getDriver().get(ConfigLoader.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
