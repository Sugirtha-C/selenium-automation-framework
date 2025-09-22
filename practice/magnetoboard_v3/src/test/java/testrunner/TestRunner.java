package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features="classpath:features",
		glue="step_definitions"	,
		plugin= {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

	
}
