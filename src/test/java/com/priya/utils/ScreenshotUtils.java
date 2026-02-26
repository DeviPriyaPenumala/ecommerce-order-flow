package com.priya.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            System.out.println("❌ Driver is NULL. Screenshot not captured.");
            return null;
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + "/target/screenshots/";
        String screenshotPath = screenshotDir + testName + "_" + timestamp + ".png";

        try {
            // Create directory if not exists
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath);

            FileUtils.copyFile(src, dest);

            System.out.println("✅ Screenshot saved at: " + screenshotPath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
