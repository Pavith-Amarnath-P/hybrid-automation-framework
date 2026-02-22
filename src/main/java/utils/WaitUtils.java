package utils;

import config.ConfigLoader;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {
    private static final long DEFAULT_TIMEOUT;
    static {
        DEFAULT_TIMEOUT = ConfigLoader.getInt("timeout");
    }
    private static WebDriverWait getWait(){
        WebDriver driver = DriverManager.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public static WebElement waitForElementToBeVisible(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator){
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementToDisappear(By locator){
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBePresent(By locator){
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForTitleContains(String titleFraction){
        return getWait().until(ExpectedConditions.titleContains(titleFraction));
    }

    public static boolean waitForUrlContains(String urlFraction){
        return getWait().until(ExpectedConditions.urlContains(urlFraction));
    }
}
