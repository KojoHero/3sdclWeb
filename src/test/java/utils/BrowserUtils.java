package utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    public static void setViewportSize(WebDriver driver, String size) {
        if ("desktop".equals(size)) {
            driver.manage().window().setSize(new Dimension(1920, 1080));
        } else if ("tablet".equals(size)) {
            driver.manage().window().setSize(new Dimension(768, 1024));
        } else if ("mobile".equals(size)) {
            driver.manage().window().setSize(new Dimension(375, 667));
        } else {
            throw new IllegalArgumentException("Invalid viewport size: " + size);
        }
    }
}
