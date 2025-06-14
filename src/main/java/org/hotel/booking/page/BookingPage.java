package org.hotel.booking.page;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingPage {

    private WebDriver driver;
    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    @When("I fill the booking details")
    public void i_fill_in_the_booking_details(){
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Scarlet");

        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Johnson");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("scarlet.j@gmail.com");

        WebElement mobileNumber = driver.findElement(By.id("mobileNumber"));
        email.sendKeys("0489233656");
    }
}
