package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String capture(AppiumDriver driver, String testName) {

        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
            Files.createDirectories(Paths.get(folderPath));

            String filePath = folderPath + testName + "_" + timestamp + ".png";
            File srcFile = driver.getScreenshotAs(OutputType.FILE);
            Files.copy(srcFile.toPath(), Paths.get(filePath));

            return filePath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}