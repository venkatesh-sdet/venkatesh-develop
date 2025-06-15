package example.baseRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "example/steps",
        tags = "@login",
        monochrome = true,
        plugin = {"pretty","html:target/html-reports.html"}
)

public class testRunner {
}
