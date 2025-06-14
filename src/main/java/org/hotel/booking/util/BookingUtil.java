package org.hotel.booking.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BookingUtil {
    public static void scrollPage(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void scrollPage(WebDriver driver, int x, int y, int times, int sleepTime) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < times; i++) {
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
