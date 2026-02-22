package config;

public final class FrameworkConstants {
    private FrameworkConstants(){}

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String CONFIG_PATH = PROJECT_PATH + "/src/test/resources/config/config.properties";
    public static final String REPORT_PATH = PROJECT_PATH + "/reports/extent-report.html";
    public static final String SCREENSHOT_PATH = PROJECT_PATH + "/screenshots/";
}
