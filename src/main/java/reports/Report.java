package reports;

import com.aventstack.extentreports.MediaEntityBuilder;

public final class Report {
    private Report(){}

    public static void info(String message){
        ExtentTestManager.getTest().info(message);
    }

    public static void pass(String message){
        ExtentTestManager.getTest().pass(message);
    }

    public static void fail(String message){
        ExtentTestManager.getTest().fail(message);
    }

    public static void skip(String message){
        ExtentTestManager.getTest().skip(message);
    }

    public static void screenshot(String path){
        ExtentTestManager.getTest().fail("Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }
}
