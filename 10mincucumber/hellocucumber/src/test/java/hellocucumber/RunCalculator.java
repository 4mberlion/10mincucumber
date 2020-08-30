package hellocucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "summary"
        },
        features = "src\\test\\resources\\hellocucumber\\calculator\\basic_arithmetic.feature",
        glue = "hellocucumber.calculator"
)
public class RunCalculator {
}
