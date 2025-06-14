package org.hotel.booking.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://automationintesting.online");
        driver.manage().window().maximize();
    }

    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcomeMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".display-4.fw-bold.mb-4")));
        return welcomeMessageElement.getText();
    }
}
