package runner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },

        features ="src/test/resources/features",
        glue ="steps",
        tags ="@getAllUsers",
        dryRun = false,
        publish = true




)


public class Runner {


}