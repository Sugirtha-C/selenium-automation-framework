package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;

/*
 * ScreenshotUtil captures screenshots during test execution.
 * It is mainly used for capturing failure evidence
 * and attaching screenshots to reports for debugging.
 */

public class ScreenshotUtil {

    public static String captureScreenshot(String name) {

        WebDriver driver = DriverFactory.getDriver();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = "test-output/screenshots/" + name + ".png";

        try {
            Files.createDirectories(new File("test-output/screenshots/").toPath());
            Files.copy(src.toPath(), new File(path).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}