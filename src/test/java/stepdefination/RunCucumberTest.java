package stepdefination;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/cucumberfeatures"},
        glue = "stepdefination", tags = "@FunctionalTest", monochrome = true,
        plugin = {"pretty", "html:target/moneygaming/cucumber/cucumber.html"})

public class RunCucumberTest {

}


