package indigo_testing.shireburn.com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",

        glue= "indigo_testing/shireburn/com/step_definitions"

)
public class FailedTestRunner {


}
