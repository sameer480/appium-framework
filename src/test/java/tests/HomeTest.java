package tests;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DriverManager;
import utils.RetryAnalyzer;
import utils.TestListener;


@Listeners(TestListener.class)
    public class HomeTest extends BaseTest {

        @Test(retryAnalyzer = RetryAnalyzer.class)
        public void testAllButtons() {

            AppiumDriver driver = DriverManager.getDriver();

            HomePage home = new HomePage(driver);

            // Click all buttons one by one

            home.clickCounter();
            driver.navigate().back();

            home.clickEcho();
            driver.navigate().back();

            home.clickLanguages();
            driver.navigate().back();

            home.clickCountries();
            driver.navigate().back();

            home.clickGesture();
            driver.navigate().back();

            home.clickTouch();
        }
    }
