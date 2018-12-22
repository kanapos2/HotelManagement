package csku.hotel;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = {"classpath:hotel/TestRegister.feature",
                "classpath:hotel/TestReserve.feature"}

)

public class UATHotelManagement {
}
