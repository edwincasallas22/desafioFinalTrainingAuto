package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "resources/features/compra.feature", glue = "java/steps")
public class TestRunnerComprar {
}
