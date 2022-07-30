package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports extentReport;

    public static ExtentReports getReport() {
        if (extentReport == null) {
            return createRport();
        }
        return extentReport;

    }

    public static ExtentReports createRport(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("report\\extentreport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        extentReport.setSystemInfo("Windows","10");
        return extentReport;
    }
}
