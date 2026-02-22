package pages;

import config.Routes;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // ===================== LOCATORS =====================
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton   = By.cssSelector("button.radius");
    private final By errorMessage  = By.id("flash");

    // ===================== ACTION METHODS =====================

    private void enterUsername(String username){
        sendKeys(usernameInput, username);
    }

    private void enterPassword(String password){
        sendKeys(passwordInput, password);
    }

    private void clickLogin(){
        click(loginButton);
    }

    // ===================== BUSINESS METHODS =====================

    public LoginPage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return this;
    }

    public boolean isErrorMessageDisplayed(){
        return isDisplayed(errorMessage);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }

    public boolean isLoginPageLoaded(){
        return isDisplayed(usernameInput);
    }

    public void goTo(){
        this.goTo(Routes.LOGIN_ROUTE);
    }
}