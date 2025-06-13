package extend;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static String title = "Automation Report";

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("output/report.html");
            spark.config().setReportName(title);
            spark.config().setDocumentTitle(title);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Platform", "Windows");
        }
        return extent;
    }
}