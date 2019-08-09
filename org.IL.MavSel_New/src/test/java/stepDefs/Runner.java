package stepDefs;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import testRunnersNew.Utilities123;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "FeatureFiles",
glue= {"testRunnersNew"},
monochrome=true, 
plugin = {"pretty","html:target/cucumber-pretty", "json:target/cucumber-json-report.json"}
)
public class Runner {

}
