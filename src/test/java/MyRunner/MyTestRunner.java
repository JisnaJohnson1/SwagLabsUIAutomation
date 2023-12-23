package MyRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions","AppHooks"},
        plugin = {"pretty"},
        publish = true
)

//public class MyTestRunner {
//}
public class MyTestRunner extends AbstractTestNGCucumberTests {
}

