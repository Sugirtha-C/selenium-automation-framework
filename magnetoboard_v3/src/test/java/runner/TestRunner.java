package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="classpath:features",
					glue="step_definitions")
public class TestRunner extends AbstractTestNGCucumberTests{

}
