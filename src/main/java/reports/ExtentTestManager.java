package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {
    private ExtentTestManager(){}

    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    public static void setTest(ExtentTest test){
        TEST.set(test);
    }

    public static ExtentTest getTest(){
        return TEST.get();
    }

    public static void unload(){
        TEST.remove();
    }

}
