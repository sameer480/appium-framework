package utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class GestureUtils {

    // Tap on element
    public static void tap(WebElement element) {
        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());

        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("mobile: clickGesture", params);
    }

    // Scroll until element visible
    public static void scrollToText(String text) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", 100,
                        "top", 100,
                        "width", 800,
                        "height", 1200,
                        "direction", "down",
                        "percent", 0.8
                )
        );
    }

    // Swipe
    public static void swipe(int left, int top, int width, int height, String direction) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", left,
                        "top", top,
                        "width", width,
                        "height", height,
                        "direction", direction,
                        "percent", 0.75
                )
        );
    }

    // Long Press
    public static void longPress(WebElement element) {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(
                "mobile: longClickGesture",
                Map.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "duration", 2000
                )
        );
    }
}