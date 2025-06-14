package org.hotel.booking.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/booking.feature",
        glue = "org.hotel.booking.stepDefinition",
        plugin = {"pretty", "json:target/cucumber.json"
        }
)
public class BookingTestRunner {
    }
