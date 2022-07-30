package helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static ExtentReports extentReports = ExtentManager.getReport();
    private static ThreadLocal<ExtentTest> testThread =new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult iTestResult) {
      ExtentTest test = extentReports.createTest(iTestResult.getMethod().getMethodName());
       testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
      testThread.get().log(Status.PASS, MarkupHelper.createLabel("Success", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
    testThread.get().log(Status.FAIL,MarkupHelper.createLabel("Fail",ExtentColor.AMBER));

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        testThread.get().log(Status.SKIP,MarkupHelper.createLabel("Skipped",ExtentColor.BROWN));

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
      if(extentReports!=null){
          extentReports.flush();
      }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }
}
