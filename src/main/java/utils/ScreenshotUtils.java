package utils;

import config.FrameworkConstants;
import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ScreenshotUtils {
    private ScreenshotUtils(){}

    public static String captureScreenshot(String testName){
        WebDriver driver = DriverManager.getDriver();
        if (driver == null){
            throw new RuntimeException("Driver is null. Cannot capture screenshot.");
        }

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            Files.createDirectories(Paths.get(FrameworkConstants.SCREENSHOT_PATH));
            String filename = testName + timestamp + ".png";
            String screenshotPath = FrameworkConstants.SCREENSHOT_PATH + filename;
            Path destination = Paths.get(screenshotPath);
            Files.copy(src.toPath(), destination);

            return "../screenshots/" + filename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
