package listeners;

import config.ConfigLoader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int currentRetry = 0;
    private final int maxRetry = ConfigLoader.getInt("retryCount");

    @Override
    public boolean retry(ITestResult result) {
        if (result.getThrowable() instanceof AssertionError){
            return false;
        }

        if (currentRetry < maxRetry){
            currentRetry++;
            return true;
        }

        return false;
    }
}
