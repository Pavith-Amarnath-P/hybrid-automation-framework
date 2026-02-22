package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public abstract class BasePage {
    protected WebDriver getDriver(){
        return DriverManager.getDriver();
    }

    protected void click(By locator){
        WebElement element = WaitUtils.waitForElementToBeClickable(locator);
        element.click();
    }

    protected void sendKeys(By locator, String text){
        WebElement element = WaitUtils.waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator){
        WebElement element = WaitUtils.waitForElementToBeVisible(locator);
        return element.getText();
    }

    protected boolean isDisplayed(By locator){
        try {
            return WaitUtils.waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    protected void scrollIntoView(By locator){
        WebElement element = WaitUtils.waitForElementToBePresent(locator);
        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].scrollIntoView({block: 'center'});");
        WaitUtils.waitForElementToBeVisible(locator);
    }

    protected String getPageTitle(){
        return getDriver().getTitle();
    }

    protected void goTo(String url){
        getDriver().get(url);
    }
}
