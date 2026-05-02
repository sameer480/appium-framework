package utils;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static void setDriver(AppiumDriver d) {
        driver.set(d);
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }
}