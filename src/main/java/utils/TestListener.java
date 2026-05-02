package utils;

import com.aventstack.extentreports.*;
import io.appium.java_client.AppiumDriver;
import org.testng.*;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();


    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().pass("Test Passed ✅");

        try {
            AppiumDriver driver = DriverManager.getDriver();
            String path = ScreenshotUtil.capture(driver, result.getName());
            testThread.get().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testThread.get().fail(result.getThrowable());

        try {
            AppiumDriver driver = DriverManager.getDriver();
            String path = ScreenshotUtil.capture(driver, result.getName());
            testThread.get().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().skip("Test Skipped ⚠️");
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }
}