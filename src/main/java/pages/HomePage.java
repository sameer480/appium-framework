package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;

public class HomePage {

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }


    private final String COUNTER = "go-to-counter-screen";
    private final String ECHO = "go-to-echo-screen";
    private final String LANGUAGES = "go-to-languages-screen";
    private final String COUNTRIES = "go-to-countries-list-screen";
    private final String GESTURE = "go-to-gesture-screen";
    private final String TOUCH = "go-to-multi_touch-screen";



    public void clickCounter() {
        driver.findElement(AppiumBy.accessibilityId(COUNTER)).click();
    }

    public void clickEcho() {
        driver.findElement(AppiumBy.accessibilityId(ECHO)).click();
    }

    public void clickLanguages() {
        driver.findElement(AppiumBy.accessibilityId(LANGUAGES)).click();
    }

    public void clickCountries() {
        driver.findElement(AppiumBy.accessibilityId(COUNTRIES)).click();
    }

    public void clickGesture() {
        driver.findElement(AppiumBy.accessibilityId(GESTURE)).click();
    }

    public void clickTouch() {
        driver.findElement(AppiumBy.accessibilityId(TOUCH)).click();
    }
}