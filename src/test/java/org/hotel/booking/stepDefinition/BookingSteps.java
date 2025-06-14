package org.hotel.booking.stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hotel.booking.page.BookingPage;
import org.hotel.booking.page.HomePage;
import org.hotel.booking.util.BookingUtil;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingSteps {
    private WebDriver driver;
    private HomePage homePage;
    private BookingPage bookingPage;

    @Before
    public void setUp(){
        this.driver = new ChromeDriver();
        this.homePage = new HomePage(driver);
        this.bookingPage = new BookingPage(driver);
    }

    @Given("I navigate to the booking page")
    public void i_navigate_to_the_booking_page() {
        homePage.navigateToHomePage();
    }

    @Then("I see the welcome message")
    public void i_see_the_success_message(){
        Assert.assertEquals("Welcome to Shady Meadows B&B", homePage.getWelcomeMessage());
        BookingUtil.scrollPage(driver,0,500,1,500);
    }

    @When("I enter check in and check out date")
    public void i_enter_check_in_and_check_out_date(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        String checkInDate = today.plusDays(2).format(formatter);
        String checkOutDate = today.plusDays(3).format(formatter);

        WebElement checkInField = driver.findElement(By.xpath("//label[@for='checkin']/following-sibling::div//input"));
        WebElement checkOutField = driver.findElement(By.xpath("//label[@for='checkout']/following-sibling::div//input"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", checkInField);
        js.executeScript("arguments[0].value = arguments[1];", checkInField, checkInDate);
        checkInField.sendKeys(Keys.TAB);

        js.executeScript("arguments[0].value = '';", checkOutField);
        js.executeScript("arguments[0].value = arguments[1];", checkOutField, checkOutDate);
        checkOutField.sendKeys(Keys.TAB);
    }

    @And("I click the check availability button")
    public void i_click_the_check_availability_button() throws InterruptedException {
       WebElement checkAvailabilityButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
       checkAvailabilityButton.click();
       Thread.sleep(1000);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0, 500);");
       Thread.sleep(1000);

    }

    @And("I select the double room")
    public void i_select_the_double_room() throws InterruptedException {
        WebElement doubleRoom = driver.findElement(By.xpath("(//a[@class='btn btn-primary'])[1]"));
        doubleRoom.click();
    }

    @When("I click on reserve now button")
    public void i_click_on_reserve_now_button(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement reserveButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("doReservation")));
        for (int i = 0; i < 1; i++) {
            js.executeScript("window.scrollBy(0, 500)");
            try {
                Thread.sleep(500);  // optional delay between scrolls
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        reserveButton.click();
    }

    @When("I enter booking details")
    public void i_enter_booking_details(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Scarlet2");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Johnson1");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("scarlet.ji@gmail.com");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("04892336576");

        js.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100.mb-3")).click();
    }

    @Then("I should see success message {string}")
    public void i_should_see_success_message(String message){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");

        String successMessage = driver.findElement(By.cssSelector(".card-title.fs-4.fw-bold.mb-3")).getText();
        System.out.println("Expected Message: " + message);
        System.out.println("Actual Message: " + successMessage);

        Assert.assertEquals(message, successMessage);
        driver.quit();
    }







}
