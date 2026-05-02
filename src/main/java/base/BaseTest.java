package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverManager;

import java.net.URL;

public class BaseTest {

    @BeforeMethod
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("Redmi");
        options.setUdid("ea62dbab"); // your device id
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.expandtesting.practice");
        options.setAppActivity("com.expandtesting.practice.MainActivity");
        AppiumDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.getDriver().quit();
    }
}