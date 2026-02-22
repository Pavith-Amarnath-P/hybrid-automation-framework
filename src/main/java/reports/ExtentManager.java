package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import config.FrameworkConstants;

public final class ExtentManager {
    private static ExtentReports extentReports;
    private ExtentManager(){}

    public static ExtentReports getInstance(){
        if (extentReports == null){
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.REPORT_PATH);
            spark.config().setReportName("Automation Report");
            spark.config().setDocumentTitle("Test Execution");
            extentReports = new ExtentReports();
            extentReports.attachReporter(spark);

            extentReports.setSystemInfo("Framework", "Hybrid Automation");
            extentReports.setSystemInfo("Tester", "Pavith");
        }

        return extentReports;
    }
}
