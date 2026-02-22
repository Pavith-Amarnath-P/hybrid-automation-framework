package driver;

import config.ConfigLoader;
import freemarker.core._ArrayEnumeration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.WaitUtils;

import java.time.Duration;

public class DriverFactory {
    public static void initDriver(){
        String browser = ConfigLoader.get("browser").toLowerCase();
        boolean headless = ConfigLoader.getBoolean("headless");

        WebDriver driver;

        switch (browser){

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless){
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if(headless){
                    edgeOptions.addArguments("--headless=new");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless){
                    firefoxOptions.addArguments("--headless=new");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigLoader.getInt("timeout")));
        driver.manage().window().maximize();

        DriverManager.setDriver(driver);
    }

    public static void quitDriver(){
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
