package listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentManager;
import reports.ExtentTestManager;
import reports.Report;
import utils.ScreenshotUtils;

public class TestListener implements ISuiteListener, ITestListener{
    @Override
    public void onStart(ISuite suite){
        ExtentManager.getInstance();
    }

    @Override
    public void onFinish(ISuite suite){
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result){
        String testName = result.getMethod().getMethodName();

        ExtentTest test = ExtentManager.getInstance().createTest(testName);
        ExtentTestManager.setTest(test);


        Report.info("Test Started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        Report.pass("Test Passed");
        ExtentTestManager.unload();
    }

    @Override
    public void onTestFailure(ITestResult result){
        boolean willRetry = false;

        if (result.getMethod().getRetryAnalyzer(result) != null){
            willRetry = result.getMethod()
                    .getRetryAnalyzer(result)
                    .retry(result);
        }

        if (willRetry){
            Report.info("Test failed, but retrying...");
            return;
        }

        Report.fail("Test Failed");
        Throwable throwable = result.getThrowable();
        if(throwable != null){
            Report.fail(throwable.getMessage());
        }

        String path = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
        Report.screenshot(path);
        ExtentTestManager.unload();
    }

    @Override
    public void onTestSkipped(ITestResult result){
        Report.skip("Test Skipped");
        ExtentTestManager.unload();
    }

}
